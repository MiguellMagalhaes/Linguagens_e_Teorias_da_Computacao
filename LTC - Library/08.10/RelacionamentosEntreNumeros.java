// Inunciado
// Escrever um programa que leia dois números inteiros e mostre todos os relacionamentos de ordem existentes entre eles.
// Os relacionamentos possíveis são:
// Igual, Não igual, Maior, Menor, Maior ou igual, Menor ou igual.

import java.util.Scanner;


public class RelacionamentosEntreNumeros {
    public static void main(String[] args) {
        // Criar objeto Scanner para leitura dos números
        Scanner scanner = new Scanner(System.in);

        // Ler os dois números inteiros
        System.out.print("Digite o primeiro número: ");
        int numero1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int numero2 = scanner.nextInt();

        // Verificar e mostrar os relacionamentos entre os números
        if (numero1 == numero2) {
            System.out.println("Os números são iguais.");
        } else {
            System.out.println("Os números são diferentes.");
        }

        if (numero1 != numero2) {
            System.out.println("Os números são não iguais.");
        }

        if (numero1 > numero2) {
            System.out.println("O primeiro número é maior que o segundo.");
        }

        if (numero1 < numero2) {
            System.out.println("O primeiro número é menor que o segundo.");
        }

        if (numero1 >= numero2) {
            System.out.println("O primeiro número é maior ou igual ao segundo.");
        }

        if (numero1 <= numero2) {
            System.out.println("O primeiro número é menor ou igual ao segundo.");
        }

        // Fechar o Scanner
        scanner.close();
    }
}
