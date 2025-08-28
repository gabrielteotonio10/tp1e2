
import java.util.Random;
import java.util.Scanner;

public class AlteracaoAleatoria {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String palavra;
        // Cria um gerador de números pseudoaleatórios
        Random gerador = new Random();
        gerador.setSeed(4);
        // Lê a primeira linha da entrada
        palavra = scanner.nextLine();
        // Loop principal que continua enquanto a palavra de entrada não for "FIM"
        while(!(palavra.length() == 3 && palavra.charAt(0) == 'F' 
                && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')){ 
            // Gera duas letras aleatórias com base nos próximos números inteiros do gerador
            char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            // Loop para percorrer cada caractere da palavra original
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra1) {
                    System.out.print(letra2);
                }// Fim do if
                else {
                    System.out.print(palavra.charAt(i));
                }// Fim do else
            }// Fim do for
            System.out.println();
            // Lê a próxima linha de entrada
            palavra = scanner.nextLine();
        }// Fim do while principal
        scanner.close();
    }// Fim da main
}