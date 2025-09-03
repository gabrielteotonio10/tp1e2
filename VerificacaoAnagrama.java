import java.util.Scanner;

public class VerificacaoAnagrama {
    // Scanner para ler as entradas do usuário
    private static final Scanner scanner = new Scanner(System.in);

    // Converte caractere maiúsculo em minúsculo  
    static char converteMinusculo(char c){
        if(c >= 'A' && c <= 'Z') {      
            c = (char) (c + 32);        
        }
        return c;                       
    }

    // Verifica se duas palavras (separadas por " - ") são anagramas
    static boolean testeAnagrama(String linha){
        // Procurar a posição do hífen "-"
        int posHifen = -1;
        for(int i=0; i<linha.length(); i++){
            if(linha.charAt(i) == '-') { 
                posHifen = i;            
                break;                   
            }
        }

        // Contador de letras da primeira palavra
        int[] cont1 = new int[26];      
        for(int i=0; i<posHifen-1; i++){ // percorre até antes do espaço que vem antes do '-'
            char c = converteMinusculo(linha.charAt(i));
            if(c >= 'a' && c <= 'z'){    
                cont1[c - 'a']++;        // incrementa a posição correspondente
            }
        }

        // Contador de letras da segunda palavra
        int[] cont2 = new int[26];
        for(int i=posHifen+2; i<linha.length(); i++){ // percorre depois do espaço após o '-'
            char c = converteMinusculo(linha.charAt(i));
            if(c >= 'a' && c <= 'z'){
                cont2[c - 'a']++;
            }
        }

        // Compara as frequências das duas palavras
        for(int i=0; i<26; i++){
            if(cont1[i] != cont2[i]){   
                return false;           
            }
        }
        return true;                  
    }

    public static void main(String[] args) {
        String linha = scanner.nextLine();   // lê a primeira linha de entrada

        // Continua até encontrar "FIM"
        while(!(linha.charAt(0)=='F' && linha.charAt(1)=='I' && linha.charAt(2)=='M')){
            if(testeAnagrama(linha)){        // verifica se é anagrama
                System.out.println("SIM");
            } else {
                System.out.println("NÃO");
            }
            linha = scanner.nextLine();      // lê a próxima linha
        }
        scanner.close();                     // fecha o scanner
    }
}
