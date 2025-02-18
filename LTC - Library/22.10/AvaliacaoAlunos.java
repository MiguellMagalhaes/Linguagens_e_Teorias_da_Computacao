// Enunciado da Atividade 1 da Unidade Curricular de Linguagens e Teoria da Computação:
//
//
// Elaborar um algoritmo para obter as classificações finais de 10 alunos das UCs de um
// determinado curso. As UCs são: AN, PI, BD, LTC e RC.
// O aluno só é aprovado à UC se obter classificação maior ou igual a 9,5 na frequência, caso
// contrário, deverá efetuar exame de recurso e deverá obter classificação maior ou igual a 9,5.
// Para a classificação da frequência o aluno realiza dois testes escritos (TE) a valer 25% cada TE e
// um trabalho prático (TP) a valer 50%. A média dos TE e TP deverá ser maior ou igual a 9,5 para
// o aluno ser aprovado. Caso o aluno seja sujeito a exame, a classificação final é calculada do
// seguinte modo: exame vale 50% e o TP (feito anteriormente) 50%, e para o aluno ser aprovado
// deverá obter classificação maior ou igual a 9,5.
//
// Deverá apresentar no final o seguinte:
//
// • notas dos alunos a todas as UCs;
// • se o aluno foi aprovado em frequência ou em exame;
// • a média de cada UC;
// • a média do aluno;
// • a média geral do curso (média aritmética)
// • quantidade de alunos aprovados em frequência;
// • quantidade de alunos reprovados em frequência;
// • quantidade de alunos aprovados em exame;
// • quantidade de alunos reprovados em exame;
// • quantidade de alunos aprovados (frequência + exame)
// • quantidade de alunos reprovados (frequência + exame)
// • quantidade de alunos aprovados com nota maior ou igual a 18 valores (frequência +
// exame)
//
// NOTA; prever que não existem notas negativas nem acima de 20 valores. A nota final terá de
// ser um número inteiro.
//
// Trabalho realizador por:
// -> Miguel Magalhães
//  Nº2021103166
//  ISPGAYA


import java.util.Scanner;


public class AvaliacaoAlunos {

    // Função auxiliar para validar as notas
    public static int obterNotaValida(Scanner input, String tipoNota) {
        int nota = -1;
        boolean notaValida = false;

        // Loop até o utilizador fornecer uma nota válida
        while (!notaValida) {
            System.out.print("Nota " + tipoNota + " (0-20): ");
            if (input.hasNextInt()) {
                nota = input.nextInt();
                if (nota >= 0 && nota <= 20) {
                    notaValida = true; // Saímos do loop quando a nota for válida
                } else {
                    System.out.println("Nota inválida! Insira um valor entre 0 e 20.");
                }
            } else {
                // Se o valor inserido não for um número, limpar o buffer e avisa o utilizador
                System.out.println("Entrada inválida! Por favor, insira um número.");
                input.next(); // Limpa a entrada inválida
            }
        }
        return nota;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int NUM_ALUNOS = 10;
        final int NUM_UCS = 5;
        String[] ucs = {"AN", "PI", "BD", "LTC", "RC"};
        
        int[][] notasFrequencia = new int[NUM_ALUNOS][NUM_UCS]; // Armazena as notas finais da frequência para cada aluno e UC
        int[][] notasExame = new int[NUM_ALUNOS][NUM_UCS];      // Armazena as notas de exame se necessário
        boolean[][] aprovadoFrequencia = new boolean[NUM_ALUNOS][NUM_UCS]; // Se o aluno foi aprovado na frequência
        boolean[][] aprovadoFinal = new boolean[NUM_ALUNOS][NUM_UCS];      // Se o aluno foi aprovado (freq ou exame)
        int[] somaNotasPorUC = new int[NUM_UCS]; // Soma das notas por UC
        int[] somaNotasPorAluno = new int[NUM_ALUNOS]; // Soma das notas de cada aluno
        
        // Contadores de aprovações/reprovações
        int aprovadosFrequencia = 0;
        int reprovadosFrequencia = 0;
        int aprovadosExame = 0;
        int reprovadosExame = 0;
        int aprovadosComDistincao = 0; // Aprovados com nota >= 18
        
        // Entrada de dados e cálculos
        for (int i = 0; i < NUM_ALUNOS; i++) {
            System.out.println("Aluno " + (i + 1) + ":");
            for (int j = 0; j < NUM_UCS; j++) {
                System.out.println("UC: " + ucs[j]);
                
                // Entrada das notas de Testes Escritos (TE) e Trabalho Prático (TP) com validação
                int te1 = obterNotaValida(input, "TE1");
                int te2 = obterNotaValida(input, "TE2");
                int tp = obterNotaValida(input, "TP");
                
                // Cálculo da média de frequência
                double mediaFrequencia = (te1 * 0.25) + (te2 * 0.25) + (tp * 0.50);
                if (mediaFrequencia >= 9.5) {
                    aprovadoFrequencia[i][j] = true;
                    notasFrequencia[i][j] = (int) Math.round(mediaFrequencia);
                    aprovadosFrequencia++;
                } else {
                    reprovadosFrequencia++;
                    int exame = obterNotaValida(input, "Exame");
                    double mediaExame = (exame * 0.50) + (tp * 0.50);
                    if (mediaExame >= 9.5) {
                        aprovadoFinal[i][j] = true;
                        notasExame[i][j] = (int) Math.round(mediaExame);
                        aprovadosExame++;
                    } else {
                        reprovadosExame++;
                        aprovadoFinal[i][j] = false;
                    }
                }
                
                // Guardar a nota final (aprovado em frequência ou exame)
                if (aprovadoFrequencia[i][j]) {
                    aprovadoFinal[i][j] = true;
                    notasFrequencia[i][j] = (int) Math.round(mediaFrequencia);
                }

                // Soma das notas por UC e por aluno
                somaNotasPorUC[j] += aprovadoFrequencia[i][j] ? notasFrequencia[i][j] : notasExame[i][j];
                somaNotasPorAluno[i] += aprovadoFrequencia[i][j] ? notasFrequencia[i][j] : notasExame[i][j];
                
                // Contar aprovações com nota >= 18
                if ((aprovadoFrequencia[i][j] && notasFrequencia[i][j] >= 18) || (aprovadoFinal[i][j] && notasExame[i][j] >= 18)) {
                    aprovadosComDistincao++;
                }
            }
        }
        
        // Cálculo das médias e resultados
        System.out.println("\n--- Resultados Finais ---");
        for (int i = 0; i < NUM_ALUNOS; i++) {
            System.out.println("Aluno " + (i + 1) + ":");
            double mediaAluno = somaNotasPorAluno[i] / (double) NUM_UCS;
            System.out.printf("Média final do aluno: %.2f\n", mediaAluno);
        }
        
        for (int j = 0; j < NUM_UCS; j++) {
            double mediaUC = somaNotasPorUC[j] / (double) NUM_ALUNOS;
            System.out.printf("Média da UC %s: %.2f\n", ucs[j], mediaUC);
        }

        double mediaGeralCurso = 0;
        for (int i = 0; i < NUM_ALUNOS; i++) {
            mediaGeralCurso += somaNotasPorAluno[i];
        }
        mediaGeralCurso /= (NUM_ALUNOS * NUM_UCS);
        System.out.printf("Média geral do curso: %.2f\n", mediaGeralCurso);

        // Exibir contagens finais
        System.out.println("Alunos aprovados em frequência: " + aprovadosFrequencia);
        System.out.println("Alunos reprovados em frequência: " + reprovadosFrequencia);
        System.out.println("Alunos aprovados em exame: " + aprovadosExame);
        System.out.println("Alunos reprovados em exame: " + reprovadosExame);
        System.out.println("Total de alunos aprovados: " + (aprovadosFrequencia + aprovadosExame));
        System.out.println("Total de alunos reprovados: " + (reprovadosFrequencia + reprovadosExame));
        System.out.println("Alunos aprovados com nota maior ou igual a 18: " + aprovadosComDistincao);
    }
}



// Trabalho realizador por:
// ->Miguel Magalhães
//  Nº2021103166
//  ISPGAYA