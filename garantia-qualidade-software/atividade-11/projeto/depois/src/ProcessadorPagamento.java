package src;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/** Processa pagamentos e descontos e verifica uma credencial fornecida externamente. */
public class ProcessadorPagamento {

    private static final double TAXA_CREDITO = 0.05;
    private static final double TAXA_DEBITO = 0.02;
    private static final int TAMANHO_CARTAO = 16;
    private static final int LIMITE_DESCONTO_10 = 10;
    private static final int LIMITE_DESCONTO_20 = 50;
    private static final int LIMITE_DESCONTO_30 = 100;
    private static final double FATOR_DESCONTO_10 = 0.9;
    private static final double FATOR_DESCONTO_20 = 0.8;
    private static final double FATOR_DESCONTO_30 = 0.7;
    private static final int ITERACOES_PBKDF2 = 600_000;
    private static final int TAMANHO_HASH_BITS = 256;
    private static final int TAMANHO_HASH_BYTES = 32;
    private static final int MINIMO_SALT_BYTES = 16;
    private static final String ALGORITMO_SENHA = "PBKDF2WithHmacSHA256";

    private final byte[] salt;
    private final byte[] hashEsperado;

    private ProcessadorPagamento(byte[] salt, byte[] hashEsperado) {
        this.salt = salt.clone();
        this.hashEsperado = hashEsperado.clone();
    }

    /**
     * Cria o processador a partir de hash e salt persistidos pelo cadastro.
     *
     * @param saltBase64 salt aleatorio de pelo menos 16 bytes, codificado em Base64
     * @param hashBase64 hash de 32 bytes, codificado em Base64
     * @return processador configurado
     * @throws IllegalArgumentException se os dados estiverem ausentes, malformados ou invalidos
     */
    public static ProcessadorPagamento criarComCredencial(String saltBase64, String hashBase64) {
        if (saltBase64 == null || hashBase64 == null) {
            throw new IllegalArgumentException("Salt e hash devem ser configurados");
        }
        byte[] saltConfigurado;
        byte[] hashConfigurado;
        try {
            saltConfigurado = Base64.getDecoder().decode(saltBase64);
            hashConfigurado = Base64.getDecoder().decode(hashBase64);
        } catch (IllegalArgumentException erro) {
            throw new IllegalArgumentException("Credencial Base64 invalida", erro);
        }
        if (saltConfigurado.length < MINIMO_SALT_BYTES
                || hashConfigurado.length != TAMANHO_HASH_BYTES) {
            throw new IllegalArgumentException("Tamanho de salt ou hash invalido");
        }
        return new ProcessadorPagamento(saltConfigurado, hashConfigurado);
    }

    /**
     * Processa um pagamento, preservando as mensagens e as regras do exercicio original.
     *
     * <p>Por compatibilidade com o enunciado, o cartao de 16 caracteres tambem e exigido
     * para PIX. Esta e uma limitacao didatica, nao uma regra de um sistema real de PIX.
     *
     * @param tipo tipo de pagamento: credito, debito ou pix
     * @param valor valor da transacao
     * @param cartao identificador de cartao com 16 caracteres
     */
    public void processar(String tipo, double valor, String cartao) {
        if (tipo == null || tipo.isEmpty()) {
            System.out.println("Tipo inválido");
            return;
        }
        if (!(valor > 0)) {
            System.out.println("Valor inválido");
            return;
        }
        if (cartao == null || cartao.length() != TAMANHO_CARTAO) {
            System.out.println("Cartão inválido");
            return;
        }
        processarTipo(tipo, valor);
    }

    private void processarTipo(String tipo, double valor) {
        switch (tipo) {
            case "credito":
                processarComTaxa("crédito", valor, TAXA_CREDITO);
                break;
            case "debito":
                processarComTaxa("débito", valor, TAXA_DEBITO);
                break;
            case "pix":
                System.out.println("Processando PIX de R$ " + valor);
                break;
            default:
                System.out.println("Tipo inválido");
                break;
        }
    }

    private void processarComTaxa(String descricao, double valor, double taxa) {
        System.out.println("Processando " + descricao + " de R$ " + valor);
        double total = valor + valor * taxa;
        System.out.println("Total com taxa: R$ " + total);
    }

    /**
     * Verifica a senha por derivacao PBKDF2 e comparacao dos bytes do hash.
     *
     * @param senha senha informada pelo chamador
     * @return true quando a credencial coincide; false para senha nula ou incorreta
     * @throws IllegalStateException se o algoritmo de derivacao nao estiver disponivel
     */
    public boolean validarSenha(String senha) {
        if (senha == null) {
            return false;
        }
        char[] caracteres = senha.toCharArray();
        PBEKeySpec especificacao = new PBEKeySpec(
                caracteres, salt, ITERACOES_PBKDF2, TAMANHO_HASH_BITS);
        try {
            SecretKeyFactory fabrica = SecretKeyFactory.getInstance(ALGORITMO_SENHA);
            byte[] hashInformado = fabrica.generateSecret(especificacao).getEncoded();
            try {
                return MessageDigest.isEqual(hashEsperado, hashInformado);
            } finally {
                Arrays.fill(hashInformado, (byte) 0);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException erro) {
            throw new IllegalStateException("Falha ao verificar credencial", erro);
        } finally {
            especificacao.clearPassword();
            Arrays.fill(caracteres, '\0');
        }
    }

    /**
     * Calcula o total com desconto progressivo de acordo com a quantidade.
     *
     * @param quantidade quantidade de itens
     * @param preco preco unitario
     * @return zero para quantidade nao positiva; total com o desconto aplicavel nos demais casos
     */
    public double calcularDesconto(int quantidade, double preco) {
        if (quantidade <= 0) {
            return 0;
        }
        if (quantidade >= LIMITE_DESCONTO_30) {
            return preco * quantidade * FATOR_DESCONTO_30;
        }
        if (quantidade >= LIMITE_DESCONTO_20) {
            return preco * quantidade * FATOR_DESCONTO_20;
        }
        if (quantidade >= LIMITE_DESCONTO_10) {
            return preco * quantidade * FATOR_DESCONTO_10;
        }
        return preco * quantidade;
    }
}
