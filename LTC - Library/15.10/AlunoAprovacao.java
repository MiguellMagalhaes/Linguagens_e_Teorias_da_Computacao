//Enunciado:
//
//Escreva um programa que leia quatro notas escolares de um aluno e apresentar uma mensagem que o aluno foi aprovado (se o valor da média das notas for maior ou igual a 10).
//Se o valor da média for menor que 10, o aluno vai a recuperação. Solicitar a nota de recuperação, somar com o valor da média e obter a nova média.
//Se a nova média for maior ou igual a 10, apresentar uma mensagem a informar que o aluno foi aprovado na recuperação.
//Se o aluno não foi aprovado, apresentar uma mensagem informando esta condição.
//Apresentar junto com as mensagens o valor da média do aluna.
//

import java.util.Scanner;

public class AlunoAprovacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Lê as quatro notas do aluno
        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        
        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        
        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();
        
        System.out.print("Digite a quarta nota: ");
        double nota4 = scanner.nextDouble();
        
        // Calcula a média
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        
        // Verifica se o aluno foi aprovado
        if (media >= 10) {
            System.out.printf("Aprovado! Sua média é: %.2f\n", media);
        } else {
            System.out.printf("Recuperação. Sua média é: %.2f\n", media);
            
            // Solicita a nota de recuperação
            System.out.print("Digite a nota de recuperação: ");
            double notaRecuperacao = scanner.nextDouble();
            
            // Calcula a nova média
            double novaMedia = (media + notaRecuperacao) / 2;
            
            // Verifica se o aluno foi aprovado na recuperação
            if (novaMedia >= 10) {
                System.out.printf("Aprovado na recuperação! Sua nova média é: %.2f\n", novaMedia);
            } else {
                System.out.printf("Reprovado! Sua média final é: %.2f\n", novaMedia);
            }
        }
        
        scanner.close();
    }
}
