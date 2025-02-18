// Inunciado:
// Efetuar o cálculo da quantidade de litros de combustivel gasto numa viagem, utilizando um automóvel que faz 12 Km/l. Para obter o cálculo, o utilizador deve informar o tempo gasto na viagem e a velocidade média. Assim, será possível obter a distância percorrida com a fórmula:
// DISTANCIA = TEMPO * VELOCIDADE
// Tendo o valor da distância, basta calcular a quantidade de litros de combustível utilizada na viagem com a formula:
// LITROS_USADOS = DISTANCIA / 12
// O programa deve apresentar os valores da velocidade média, tempo gasto, a distância percorrida e a quantidade de litros utilizada na viagem.
// Nota: trabalhe com valores reais.


import java.util.Scanner;


public class ConsumoCombustivel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Solicitar tempo gasto na viagem (em horas)
        System.out.print("Informe o tempo gasto na viagem (em horas): ");
        double tempo = input.nextDouble();

        // Solicitar a velocidade média (em km/h)
        System.out.print("Informe a velocidade média (em km/h): ");
        double velocidadeMedia = input.nextDouble();

        // Calcular a distância percorrida
        double distancia = tempo * velocidadeMedia;

        // Calcular a quantidade de litros usados (consumo é de 12 km/l)
        double litrosUsados = distancia / 12;

        // Exibir os resultados
        System.out.println("\n--- Resultados da Viagem ---");
        System.out.printf("Velocidade Média: %.2f km/h%n", velocidadeMedia);
        System.out.printf("Tempo Gasto: %.2f horas%n", tempo);
        System.out.printf("Distância Percorrida: %.2f km%n", distancia);
        System.out.printf("Quantidade de Litros Utilizados: %.2f litros%n", litrosUsados);
        
        input.close();
    }
}
