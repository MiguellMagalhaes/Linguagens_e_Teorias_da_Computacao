// Inunciado
// Escreva um programa que leia 3 números inteiros e imprima no ecrã os valores em ordem decrescente

import java.util.Scanner;

public class s {
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
        int maior, meio, menor;

        // Verificar a ordem dos números
        if (numero1 >= numero2 && numero1 >= numero3) {
            maior = numero1;
            if (numero2 >= numero3) {
                meio = numero2;
                menor = numero3;
            } else {
                meio = numero3;
                menor = numero2;
            }
        } else if (numero2 >= numero1 && numero2 >= numero3) {
            maior = numero2;
            if (numero1 >= numero3) {
                meio = numero1;
                menor = numero3;
            } else {
                meio = numero3;
                menor = numero1;
            }
        } else {
            maior = numero3;
            if (numero1 >= numero2) {
                meio = numero1;
                menor = numero2;
            } else {
                meio = numero2;
                menor = numero1;
            }
        }

        // Imprimir os números em ordem decrescente
        System.out.println("Os números em ordem decrescente são: " + maior + ", " + meio + ", " + menor);

        // Fechar o Scanner
        scanner.close();
    }
}



