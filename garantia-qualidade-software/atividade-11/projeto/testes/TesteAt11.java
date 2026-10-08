import src.ProcessadorPagamento;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class TesteAt11 {
    private static int total;
    private static void verificar(boolean condicao, String descricao) {
        total++;
        if (!condicao) throw new AssertionError(descricao);
    }
    private static String capturar(Object objeto, String tipo, double valor, String cartao)
            throws Exception {
        PrintStream anterior = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (PrintStream saida = new PrintStream(bytes, true, StandardCharsets.UTF_8)) {
            System.setOut(saida);
            objeto.getClass().getMethod("processar", String.class, double.class, String.class)
                .invoke(objeto, tipo, valor, cartao);
        } finally {
            System.setOut(anterior);
        }
        return bytes.toString(StandardCharsets.UTF_8);
    }
    public static void main(String[] args) throws Exception {
        String senha = UUID.randomUUID().toString();
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        PBEKeySpec spec = new PBEKeySpec(senha.toCharArray(), salt, 600_000, 256);
        byte[] hash = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
            .generateSecret(spec).getEncoded();
        spec.clearPassword();
        String salt64 = Base64.getEncoder().encodeToString(salt);
        String hash64 = Base64.getEncoder().encodeToString(hash);
        ProcessadorPagamento novo = ProcessadorPagamento.criarComCredencial(salt64, hash64);
        verificar(novo.validarSenha(new String(senha.toCharArray())), "Senha por conteudo");
        verificar(!novo.validarSenha(senha + "x"), "Senha incorreta");
        verificar(!novo.validarSenha(null), "Senha nula");
        verificar(!novo.validarSenha(""), "Senha vazia");
        String[][] invalidas = {{null, hash64}, {salt64, null}, {"!", hash64},
            {"", hash64}, {salt64, ""}};
        for (String[] par : invalidas) {
            boolean rejeitou = false;
            try { ProcessadorPagamento.criarComCredencial(par[0], par[1]); }
            catch (IllegalArgumentException e) { rejeitou = true; }
            verificar(rejeitou, "Configuracao invalida rejeitada");
        }
        int[] quantidades = {-1, 0, 1, 9, 10, 49, 50, 99, 100, 101};
        double[] esperado = {0, 0, 10, 90, 90, 441, 400, 792, 700, 707};
        for (int i = 0; i < quantidades.length; i++) {
            verificar(Math.abs(novo.calcularDesconto(quantidades[i], 10) - esperado[i]) < 0.00001,
                "Fronteira de desconto: " + quantidades[i]);
        }
        String cartao = "1234567890123456";
        verificar(capturar(novo, "credito", 100, cartao).contains("Total com taxa: R$ 105.0"),
            "Credito 5%");
        verificar(capturar(novo, "debito", 100, cartao).contains("Total com taxa: R$ 102.0"),
            "Debito 2%");
        verificar(capturar(novo, "pix", 100, cartao).equals("Processando PIX de R$ 100.0\n"),
            "PIX sem taxa");
        try (URLClassLoader loader = new URLClassLoader(
                new java.net.URL[] {Path.of(args[0]).toUri().toURL()}, null)) {
            Class<?> classeOriginal = loader.loadClass("src.ProcessadorPagamento");
            Object antigo = classeOriginal.getConstructor().newInstance();
            String[] tipos = {null, "", "credito", "debito", "pix", "outro"};
            double[] valores = {-1, 0, 0.01, 100, Double.NaN,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
            String[] cartoes = {null, "", "123", cartao};
            for (String tipo : tipos) for (double valor : valores) for (String c : cartoes) {
                verificar(capturar(antigo, tipo, valor, c).equals(capturar(novo, tipo, valor, c)),
                    "Regressao de pagamento: " + tipo + "/" + valor + "/" + c);
            }
            for (int q : quantidades) for (double preco : new double[] {0, 0.1, 10, -1}) {
                double original = (double) classeOriginal.getMethod("calcularDesconto",
                    int.class, double.class).invoke(antigo, q, preco);
                verificar(Double.compare(original, novo.calcularDesconto(q, preco)) == 0,
                    "Regressao de desconto");
            }
        }
        System.out.println("APROVADO: " + total + " verificacoes.");
        System.out.println("Inclui 168 pagamentos, 40 descontos por regressao, 10 fronteiras,");
        System.out.println("3 taxas, 4 senhas e 5 configuracoes invalidas.");
        System.out.println("Credenciais de teste aleatorias, geradas em memoria e nao persistidas.");
    }
}
