
import java.util.Scanner;

public class PalindronoJava {
    private static final Scanner scanner = new Scanner(System.in);

    static char normalChar(char c){
        switch (c) {
        // Vogais com acento agudo, circunflexo, til e cedilha (usando Unicode pois o verde não aceita sem Unicode)
        case '\u00E1': case '\u00E0': case '\u00E3': case '\u00E2': case '\u00E4': return 'a';
        case '\u00E9': case '\u00E8': case '\u00EA': case '\u00EB': return 'e';
        case '\u00ED': case '\u00EC': case '\u00EE': case '\u00EF': return 'i';
        case '\u00F3': case '\u00F2': case '\u00F5': case '\u00F4': case '\u00F6': return 'o';
        case '\u00FA': case '\u00F9': case '\u00FB': case '\u00FC': return 'u';
        case '\u00E7': return 'c';
        case '\u00C1': case '\u00C0': case '\u00C3': case '\u00C2': case '\u00C4': return 'A';
        case '\u00C9': case '\u00C8': case '\u00CA': case '\u00CB': return 'E';
        case '\u00CD': case '\u00CC': case '\u00CE': case '\u00CF': return 'I';
        case '\u00D3': case '\u00D2': case '\u00D5': case '\u00D4': case '\u00D6': return 'O';
        case '\u00DA': case '\u00D9': case '\u00DB': case '\u00DC': return 'U';
        case '\u00C7': return 'C';
        default: return c; // se não for acentuado, retorna igual
        }//Fim do switch
    }//Fim da função normalChar
    public static void main(String[] args) {
        String palavra;
        //Lê a primeira palavra
        palavra = scanner.nextLine();
        while (!(palavra.length() == 3 && palavra.charAt(0) == 'F' 
                && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            int tam = palavra.length() - 1;
            int i = 0;
            boolean teste = true;
            while(i < tam) {
                if (normalChar(palavra.charAt(i)) != normalChar(palavra.charAt(tam))) {
                    teste = false;
                    i=tam;
                }//Fim do if
                i++;
                tam--;
            }//Fim do while
            if(teste) System.out.println("SIM");
            else System.out.println("NAO");
            //Lê a próxima palavra
            palavra = scanner.nextLine();
        }//Fim do while principal
        scanner.close();
    }//Fim da main
}
