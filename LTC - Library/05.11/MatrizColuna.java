/* Trabalho realizado por:
 -> Miguel Magalhães
 -> Nº: 2021103166
 -> ISPGAYA
*/

/* Inunciado:
Preencha uma matriz 5x5 de números inteiros e mostre no ecrã os dados contidos numa coluna a ser informada pelo utilizador.
*/

import java.util.Scanner;

public class MatrizColuna {

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

        // Solicitar ao utilizador o número da coluna a ser exibida
        int coluna;
        do {
            System.out.print("\nDigite o número da coluna que deseja exibir (0 a 4): ");
            coluna = scanner.nextInt();
            if (coluna < 0 || coluna > 4) {
                System.out.println("Coluna inválida! Por favor, insira um número entre 0 e 4.");
            }
        } while (coluna < 0 || coluna > 4);

        // Exibir os elementos da coluna especificada
        System.out.println("\nElementos da coluna " + coluna + ":");
        for (int i = 0; i < 5; i++) {
            System.out.println(matriz[i][coluna]);
        }

        scanner.close(); // Fechar o scanner
    }
}

/* Trabalho realizado por:
 -> Miguel Magalhães
 -> Nº: 2021103166
 -> ISPGAYA
*/