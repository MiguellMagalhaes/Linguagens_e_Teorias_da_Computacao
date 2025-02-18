// Enunciado.
//
// Escreva um programa que leia três valores para os lados de um triangulo (variáveis A, B e C).
// Verificar se cada lado é menor que a soma dos outros dois lados.
// Se sim, e se A==B e se B==C for verdade, o triângulo é Equilátero;
// Se não, verificar se A==B ou se A==C ou se B==C, e, sendo verdade, o triângulo é Isósceles;
// Caso contrário, o triângulo será Escaleno.
// Caso os lados fornecidos não caracterizarem um triângulo, mostrar uma mensagem a informar que não é triângulo.
//



import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos lados do triângulo
        System.out.print("Digite o valor do lado A: ");
        double A = scanner.nextDouble();
        System.out.print("Digite o valor do lado B: ");
        double B = scanner.nextDouble();
        System.out.print("Digite o valor do lado C: ");
        double C = scanner.nextDouble();

        // Verifica se os valores formam um triângulo
        if (A < B + C && B < A + C && C < A + B) {
            // Verifica se o triângulo é Equilátero
            if (A == B && B == C) {
                System.out.println("O triângulo é Equilátero.");
            }
            // Verifica se o triângulo é Isósceles
            else if (A == B || A == C || B == C) {
                System.out.println("O triângulo é Isósceles.");
            }
            // Se não for nem Equilátero nem Isósceles, é Escaleno
            else {
                System.out.println("O triângulo é Escaleno.");
            }
        } else {
            // Caso os lados não formem um triângulo
            System.out.println("Os valores fornecidos não formam um triângulo.");
        }

        scanner.close();
    }
}
