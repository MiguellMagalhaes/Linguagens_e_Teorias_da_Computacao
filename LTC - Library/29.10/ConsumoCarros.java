/* Enunciado:

Construir um algoritmo que leia um vetor para armazenar os modelos de cinco carros (exemplo: CLIO, GOLF, VECTRA, etc). Leia outro vetor com o consumo desses carros, isto é, quantos Km cada um desses carros faz com 1 litro de combustível.
Calcule e mostre:
a) O modelo do carro mais económico.
b) Quantos litros de combustível cada um dos carros registados consome para percorrer uma distância de 1000 Km.

*/

import java.util.Scanner;

public class ConsumoCarros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constantes e variáveis
        final int TOTAL_CARROS = 5;
        final int DISTANCIA = 1000;
        
        // Vetores para armazenar modelos de carros e o consumo de cada um
        String[] modelos = new String[TOTAL_CARROS];
        double[] consumos = new double[TOTAL_CARROS];
        
        // Leitura dos modelos e dos consumos dos carros
        for (int i = 0; i < TOTAL_CARROS; i++) {
            System.out.print("Digite o modelo do carro " + (i + 1) + ": ");
            modelos[i] = scanner.nextLine();
            
            System.out.print("Digite o consumo do " + modelos[i] + " (Km por litro): ");
            consumos[i] = scanner.nextDouble();
            scanner.nextLine();  // Limpeza do buffer de entrada
        }
        
        // Identificação do carro mais económico
        int indiceEconomico = 0;
        for (int i = 1; i < TOTAL_CARROS; i++) {
            if (consumos[i] > consumos[indiceEconomico]) {
                indiceEconomico = i;
            }
        }
        
        // Exibição do modelo do carro mais económico
        System.out.println("\nO carro mais económico é o " + modelos[indiceEconomico] +
                           " com consumo de " + consumos[indiceEconomico] + " Km por litro.");
        
        // Cálculo e exibição dos litros consumidos para percorrer 1000 Km
        System.out.println("\nConsumo de combustível para percorrer " + DISTANCIA + " Km:");
        for (int i = 0; i < TOTAL_CARROS; i++) {
            double litrosNecessarios = DISTANCIA / consumos[i];
            System.out.printf("- %s: %.2f litros\n", modelos[i], litrosNecessarios);
        }
        
        // Fechamento do scanner
        scanner.close();
    }
}

/* Trabalho realizado por:
-> Miguel Magalhães;
-> Nº:2021103166-> ISPGAYA
*/