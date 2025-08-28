
import java.util.Scanner;

public class StringInvertida{
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        String palavra;
        // Lê a primeira palavra 
        palavra = scanner.nextLine();
        // Inicia um laço que continua enquanto a palavra não for "FIM"
        while(!(palavra.length() == 3 && palavra.charAt(0) == 'F' 
                && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')){
            String palavraInvertida = "";
            int tam = palavra.length();
            while(tam > 0){
                palavraInvertida += palavra.charAt(tam-1);
                tam--;
            }// Fim do while de adição dos últimos caractere (tam-1) na string invertida
            System.out.println(palavraInvertida);
            // Lê a próxima palavra para a próxima iteração do laço
            palavra = scanner.nextLine();
        }// Fim do while principal
        scanner.close();
    }// Fim da main
}