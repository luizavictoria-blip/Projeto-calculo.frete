package br.com.frete;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FreteService service = new FreteService(new CalculadoraFrete());
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println("=== CALCULADORA DE FRETE ===");
        System.out.print("Digite o valor da compra (ex.: 150.00): ");

        String entrada = scanner.nextLine();
        try {
            BigDecimal compra = new BigDecimal(entrada.trim().replace(",", "."));
            ResumoFrete resumo = service.calcularResumo(compra);
            System.out.println("Valor da compra: " + moeda.format(resumo.valorCompra()));
            System.out.println("Frete: " + moeda.format(resumo.valorFrete()));
            System.out.println("Total: " + moeda.format(resumo.valorTotal()));
        } catch (NumberFormatException e) {
            System.out.println("Erro: digite um valor numérico válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
