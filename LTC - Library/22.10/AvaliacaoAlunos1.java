import java.util.Scanner;

public class AvaliacaoAlunos1 {
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
                
                // Entrada das notas de Testes Escritos (TE) e Trabalho Prático (TP)
                System.out.print("Nota TE1 (0-20): ");
                int te1 = input.nextInt();
                System.out.print("Nota TE2 (0-20): ");
                int te2 = input.nextInt();
                System.out.print("Nota TP (0-20): ");
                int tp = input.nextInt();
                
                // Cálculo da média de frequência
                double mediaFrequencia = (te1 * 0.25) + (te2 * 0.25) + (tp * 0.50);
                if (mediaFrequencia >= 9.5) {
                    aprovadoFrequencia[i][j] = true;
                    notasFrequencia[i][j] = (int) Math.round(mediaFrequencia);
                    aprovadosFrequencia++;
                } else {
                    reprovadosFrequencia++;
                    System.out.print("Nota de Exame (0-20): ");
                    int exame = input.nextInt();
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