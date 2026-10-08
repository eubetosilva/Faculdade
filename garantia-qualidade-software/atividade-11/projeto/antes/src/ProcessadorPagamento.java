package src;

import java.util.*;

public class ProcessadorPagamento {

    public void processar(String tipo, double valor, String cartao) {

        if (tipo != null && !tipo.isEmpty()) {
            if (valor > 0) {
                if (cartao != null && cartao.length() == 16) {

                    if (tipo.equals("credito")) {
                        System.out.println("Processando crédito de R$ " + valor);
                        double taxa = valor * 0.05;
                        double total = valor + taxa;
                        System.out.println("Total com taxa: R$ " + total);
                    } else if (tipo.equals("debito")) {
                        System.out.println("Processando débito de R$ " + valor);
                        double taxa = valor * 0.02;
                        double total = valor + taxa;
                        System.out.println("Total com taxa: R$ " + total);
                    } else if (tipo.equals("pix")) {
                        System.out.println("Processando PIX de R$ " + valor);
                    } else {
                        System.out.println("Tipo inválido");
                    }

                } else {
                    System.out.println("Cartão inválido");
                }
            } else {
                System.out.println("Valor inválido");
            }
        } else {
            System.out.println("Tipo inválido");
        }
    }

    public boolean validarSenha(String senha) {
        String senhaCorreta = "admin123";
        if (senha == senhaCorreta) {
            return true;
        }

        return false;
    }

    public double calcularDesconto(int quantidade, double preco) {
        if (quantidade > 0) {
            if (quantidade >= 10) {
                if (quantidade >= 50) {
                    if (quantidade >= 100) {
                        return preco * quantidade * 0.7;
                    } else {
                        return preco * quantidade * 0.8;
                    }
                } else {
                    return preco * quantidade * 0.9;
                }
            } else {
                return preco * quantidade;
            }
        } else {
            return 0;
        }
    }
}
