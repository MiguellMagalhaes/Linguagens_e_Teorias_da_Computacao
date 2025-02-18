/* Enunciado:

Escreva um programa que leia o nome e a idade de 20 pessoas e mostre, após inserir os dados, a idade média do grupo e o nome 
das pessoas com idade acima da média.

*/

import java.util.Scanner;

public class GrupoIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Número total de pessoas
        final int TOTAL_PESSOAS = 20;
        
        // Arrays para armazenar nomes e idades
        String[] nomes = new String[TOTAL_PESSOAS];
        int[] idades = new int[TOTAL_PESSOAS];
        
        // Variável para somar todas as idades e depois calcular a média
        int somaIdades = 0;
        
        // Leitura dos nomes e idades das 20 pessoas
        for (int i = 0; i < TOTAL_PESSOAS; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
            
            System.out.print("Digite a idade de " + nomes[i] + ": ");
            idades[i] = scanner.nextInt();
            scanner.nextLine();  // Limpeza do buffer de entrada
            
            // Adiciona a idade ao total para cálculo da média
            somaIdades += idades[i];
        }
        
        // Cálculo da idade média do grupo
        double mediaIdade = (double) somaIdades / TOTAL_PESSOAS;
        
        // Exibição da idade média
        System.out.printf("\nA idade média do grupo é: %.2f anos\n", mediaIdade);
        
        // Identificação e exibição dos nomes das pessoas com idade acima da média
        System.out.println("Pessoas com idade acima da média:");
        for (int i = 0; i < TOTAL_PESSOAS; i++) {
            if (idades[i] > mediaIdade) {
                System.out.println("- " + nomes[i] + " (" + idades[i] + " anos)");
            }
        }
        
        // Fechamento do scanner
        scanner.close();
    }
}

/* Trabalho realizado por:
-> Miguel Magalhães;
-> Nº:2021103166-> ISPGAYA
*/