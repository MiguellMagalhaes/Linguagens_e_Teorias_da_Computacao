/* Inunciado:

Leia 20 elementos num vetor A e construa o vetor B com elementos de A, mas invertidos, ou seja, o primeiro elemento de A passa a ser o último elemento de B, e assim por diante.
Mostre os 2 vetores, o maior elemento do vetor A e o menor elemento do vetor B.Leia 20 elementos num vetor A e construa o vetor B com elementos de A, mas invertidos, ou seja, o primeiro elemento de A passa a ser o último elemento de B, e assim por diante.
Mostre os 2 vetores, o maior elemento do vetor A e o menor elemento do vetor B.

*/




import java.util.Scanner;


public class VetorInverso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaração e inicialização dos vetores A e B
        int[] vetorA = new int[20];
        int[] vetorB = new int[20];

        // Leitura dos elementos para o vetor A
        System.out.println("Digite 20 elementos para o vetor A:");
        for (int i = 0; i < vetorA.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vetorA[i] = scanner.nextInt();
        }

        // Construção do vetor B invertendo os elementos de A
        for (int i = 0; i < vetorA.length; i++) {
            vetorB[i] = vetorA[vetorA.length - 1 - i];
        }

        // Exibir os vetores A e B
        System.out.print("\nVetor A: ");
        for (int i : vetorA) {
            System.out.print(i + " ");
        }

        System.out.print("\nVetor B (invertido): ");
        for (int i : vetorB) {
            System.out.print(i + " ");
        }

        // Encontrar o maior elemento em vetor A
        int maxA = vetorA[0];
        for (int i = 1; i < vetorA.length; i++) {
            if (vetorA[i] > maxA) {
                maxA = vetorA[i];
            }
        }

        // Encontrar o menor elemento em vetor B
        int minB = vetorB[0];
        for (int i = 1; i < vetorB.length; i++) {
            if (vetorB[i] < minB) {
                minB = vetorB[i];
            }
        }

        // Exibir o maior elemento de A e o menor elemento de B
        System.out.println("\n\nMaior elemento do vetor A: " + maxA);
        System.out.println("Menor elemento do vetor B: " + minB);

        scanner.close();
    }
}