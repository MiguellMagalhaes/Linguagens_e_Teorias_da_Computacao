// Enunciado
//
// Escrever um programa declaramdo três variáveis do tipo inteiro (a,b e c)
// Ler um valor maior que zero para cada variável (se o valor digitado não for válido, mostrar uma mensagem e ler novamente o valor).class . {
// Mostrar o menor valor lido multiplicado pelo maior e o maior valor dividido pelo menor.
//

import java.util.Scanner;

public class CalculoValores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = lerValorPositivo(scanner, "a");
        int b = lerValorPositivo(scanner, "b");
        int c = lerValorPositivo(scanner, "c");

        int maior = Math.max(a, Math.max(b, c));
        int menor = Math.min(a, Math.min(b, c));

        // Mostrar o menor valor multiplicado pelo maior
        System.out.println("Menor valor multiplicado pelo maior: " + (menor * maior));

        // Mostrar o maior valor dividido pelo menor (verificar se o menor valor não é 0 para evitar divisão por zero)
        if (menor != 0) {
            System.out.println("Maior valor dividido pelo menor: " + ((double) maior / menor));
        } else {
            System.out.println("Divisão por zero não é permitida.");
        }

        scanner.close();
    }

    // Método para ler valores maiores que zero
    private static int lerValorPositivo(Scanner scanner, String variavel) {
        int valor;
        do {
            System.out.print("Digite um valor maior que zero para " + variavel + ": ");
            valor = scanner.nextInt();
            if (valor <= 0) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        } while (valor <= 0);
        return valor;
    }
}

