// Inunciado
// Escreva um programa que leia 3 números inteiros e imprima no ecrã os valores em ordem crescente

import java.util.Scanner;

public class OrdenarTresNumeros {
    public static void main(String[] args) {
        // Criar objeto Scanner para leitura dos números
        Scanner scanner = new Scanner(System.in);

        // Ler os três números inteiros
        System.out.print("Digite o primeiro número: ");
        int numero1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int numero2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int numero3 = scanner.nextInt();

        // Variáveis auxiliares para a ordenação
        int menor, meio, maior;

        // Verificar a ordem dos números
        if (numero1 <= numero2 && numero1 <= numero3) {
            menor = numero1;
            if (numero2 <= numero3) {
                meio = numero2;
                maior = numero3;
            } else {
                meio = numero3;
                maior = numero2;
            }
        } else if (numero2 <= numero1 && numero2 <= numero3) {
            menor = numero2;
            if (numero1 <= numero3) {
                meio = numero1;
                maior = numero3;
            } else {
                meio = numero3;
                maior = numero1;
            }
        } else {
            menor = numero3;
            if (numero1 <= numero2) {
                meio = numero1;
                maior = numero2;
            } else {
                meio = numero2;
                maior = numero1;
            }
        }

        // Imprimir os números em ordem crescente
        System.out.println("Os números em ordem crescente são: " + menor + ", " + meio + ", " + maior);

        // Fechar o Scanner
        scanner.close();
    }
}


