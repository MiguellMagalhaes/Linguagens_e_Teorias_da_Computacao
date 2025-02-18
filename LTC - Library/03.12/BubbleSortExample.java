// Início do código: Implementação de Bubble Sort
// Trabalho realizado por:
// - Miguel Magalhães;
// - Nº2021103166;
// ISPGAYA

// Inunciado: Ordenar os valores solicitados pelo utilizador:
// [84, 23, 9, 5, 11, 3, 50, 7, 2, 73] com Bubble Sort
// Mostrar somente os valores do vetor ordenados.

public class BubbleSortExample {

    public static void main(String[] args) {
        // Declaração de um vetor com os valores fornecidos no enunciado
        int[] valores = {84, 23, 9, 5, 11, 3, 50, 7, 2, 73};

        // Exibição do vetor original
        System.out.println("Vetor original:");
        for (int valor : valores) {
            System.out.print(valor + " "); // Mostra os valores do vetor original
        }
        System.out.println(); // Linha em branco para melhor formatação

        // Chamada ao método que implementa o Bubble Sort
        bubbleSort(valores);

        // Exibição do vetor ordenado
        System.out.println("\nVetor ordenado:");
        for (int valor : valores) {
            System.out.print(valor + " "); // Mostra os valores do vetor ordenado
        }

        // Informação sobre o trabalho realizado
        System.out.println("\n\nTrabalho realizado por:");
        System.out.println("- Miguel Magalhães;");
        System.out.println("- Nº2021103166;");
        System.out.println("ISPGAYA");
    }

    // Método que implementa o algoritmo Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length; // Tamanho do vetor
        boolean trocado; // Variável para verificar se houve trocas durante a iteração

        // Loop externo que controla as passagens
        for (int i = 0; i < n - 1; i++) {
            trocado = false; // Inicializa como falso no início de cada passagem

            // Loop interno para comparar pares adjacentes
            for (int j = 0; j < n - 1 - i; j++) {
                // Verifica se os elementos estão fora de ordem
                if (array[j] > array[j + 1]) {
                    // Troca os elementos
                    int temp = array[j]; // Armazena o valor de array[j] em uma variável temporária
                    array[j] = array[j + 1]; // Move o elemento menor para a posição anterior
                    array[j + 1] = temp; // Coloca o elemento maior na posição seguinte
                    trocado = true; // Marca que houve uma troca
                }
            }

            // Se nenhuma troca foi feita, o vetor já está ordenado
            if (!trocado) break;
        }
    }
}