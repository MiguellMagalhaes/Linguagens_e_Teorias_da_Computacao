package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in); // Scanner utilizado para entrada de dados do utilizador.
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato padrão para leitura de datas.

    public static String lerString(String mensagem) {
        // Exibe uma mensagem e lê uma string introduzida pelo utilizador.
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int lerInt(String mensagem) {
        // Tenta ler e retornar um valor inteiro introduzido pelo utilizador.
        // Repetirá enquanto o valor não for válido.
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Mensagem de erro caso o valor introduzido não seja um número inteiro válido.
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
    }

    public static double lerDouble(String mensagem) {
        // Tenta ler e retornar um valor decimal introduzido pelo utilizador.
        // Repetirá enquanto o valor não for válido.
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Mensagem de erro caso o valor introduzido não seja um número decimal válido.
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
    }

    public static LocalDate lerData(String mensagem) {
        // Tenta ler e retornar uma data no formato dd/MM/yyyy.
        // Repetirá enquanto o formato introduzido não for válido.
        while (true) {
            try {
                System.out.print(mensagem);
                return LocalDate.parse(scanner.nextLine(), dateFormatter);
            } catch (DateTimeParseException e) {
                // Mensagem de erro caso o formato da data introduzida não seja válido.
                System.out.println("Formato de data inválido. Utilize o formato dd/MM/yyyy.");
            }
        }
    }

    public static void fecharScanner() {
        // Fecha o scanner para liberar recursos após o uso.
        scanner.close();
    }
}
