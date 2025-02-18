//Enunciado
//
//Escreva um programa que leia um número inteiro (variável a usar, por exemplo, CODIGO).
//Verificar se o código é igual a 1, igual a 2 ou igual a 3. Caso não seja, apresentar a mensagem "Código inválido".
//Ao ser verificado o código e constatado que é um valor válido, o programa deve verificar cada código em separado para determinar o seu valor por extenso, ou seja, apresentar a mensagem "um", "dois" ou "três".
//

import java.util.Scanner;

public class VerificaCodigo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o número inteiro CODIGO
        System.out.print("Insira o código (1, 2 ou 3): ");
        int CODIGO = scanner.nextInt();

        // Verifica se o código é 1, 2 ou 3
        switch (CODIGO) {
            case 1:
                System.out.println("um");
                break;
            case 2:
                System.out.println("dois");
                break;
            case 3:
                System.out.println("três");
                break;
            default:
                System.out.println("Código inválido");
                break;
        }

        scanner.close();
    }
}
