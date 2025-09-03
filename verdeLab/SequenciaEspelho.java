package verdeLab;

import java.util.Scanner;

public class SequenciaEspelho {

    private static final Scanner scanner = new Scanner(System.in);

    // Converte um número inteiro para uma string (array de caracteres)
    static char[] intParaChar(int num) {
        if (num == 0) {
            char[] zero = {'0'};
            return zero;
        }

        // Determina o número de dígitos
        int temp = num;
        int digitos = 0;
        if (num < 0) {
            num = -num;
        }
        while (temp != 0) {
            temp /= 10;
            digitos++;
        }

        char[] resultado = new char[digitos];
        int i = digitos - 1;
        while (num > 0) {
            resultado[i] = (char)('0' + (num % 10));
            num /= 10;
            i--;
        }
        return resultado;
    }

    public static void main(String[] args) {
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            int espaco = -1;

            // Encontra a posição do espaço para separar os dois números
            for (int i = 0; i < linha.length(); i++) {
                if (linha.charAt(i) == ' ') {
                    espaco = i;
                    break;
                }
            }

            // Extrai as strings dos números
            String numStr1 = "";
            for (int i = 0; i < espaco; i++) {
                numStr1 += linha.charAt(i);
            }
            
            String numStr2 = "";
            for (int i = espaco + 1; i < linha.length(); i++) {
                numStr2 += linha.charAt(i);
            }

            // Converte as strings para inteiros manualmente (sem Integer.parseInt)
            int inicio = 0;
            for (int i = 0; i < numStr1.length(); i++) {
                inicio = inicio * 10 + (numStr1.charAt(i) - '0');
            }

            int fim = 0;
            for (int i = 0; i < numStr2.length(); i++) {
                fim = fim * 10 + (numStr2.charAt(i) - '0');
            }

            // Constrói a sequência principal
            String sequencia = "";
            for (int i = inicio; i <= fim; i++) {
                char[] numChars = intParaChar(i);
                for (int j = 0; j < numChars.length; j++) {
                    sequencia += numChars[j];
                }
            }

            // Constrói a sequência espelho invertida
            String espelho = "";
            for (int i = sequencia.length() - 1; i >= 0; i--) {
                espelho += sequencia.charAt(i);
            }

            // Imprime o resultado final
            System.out.println(sequencia + espelho);
        }
        scanner.close();
    }
}