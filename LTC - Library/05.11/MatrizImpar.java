/* Trabalho realizado por:
 -> Miguel Magalhães
 -> Nº: 2021103166
 -> ISPGAYA
*/

/* Inunciado:
Preencha uma matriz 5x5 de números inteiros e mostre no ecrã apenas os elementos cuja soma da linha e da coluna resultem num número ímpar.
*/

import java.util.Scanner;

public class MatrizImpar {

    public static void main(String[] args) {
        // Declaração da matriz 5x5
        int[][] matriz = new int[5][5];
        Scanner scanner = new Scanner(System.in);

        // Preenchimento da matriz pelo utilizador
        System.out.println("Digite os elementos da matriz 5x5:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Exibir os elementos cuja soma de linha e coluna é ímpar
        System.out.println("\nElementos cuja soma da linha e coluna é ímpar:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Verificar se a soma de índices é ímpar
                if ((i + j) % 2 != 0) {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println(); // Quebra de linha para visualização
        }

        scanner.close(); // Fechar o scanner
    }
}

/* Trabalho realizado por:
 -> Miguel Magalhães
 -> Nº: 2021103166
 -> ISPGAYA
*/