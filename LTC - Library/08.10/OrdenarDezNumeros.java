// Inunciado
// Escreva um programa que leia 10 números inteiros e imprima no ecrã os valores em ordem crescente

import java.util.Scanner;

public class OrdenarDezNumeros {
    public static void main(String[] args) {
        // Criar um array para armazenar os 10 números
        int[] numeros = new int[10];
        Scanner scanner = new Scanner(System.in);

        // Ler os 10 números inteiros
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Ordenar os números em ordem crescente usando o método de ordenação bubble sort
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Troca os números
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Imprimir os números em ordem crescente
        System.out.println("Os números em ordem crescente são:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // Fechar o Scanner
        scanner.close();
    }
}



