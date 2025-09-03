import java.util.Scanner;

public class TesteVerificarAnagrama {
    private static final Scanner scanner = new Scanner(System.in);
    // Método para converter um caractere maiúsculo em minúsculo manualmente
    static char converteMinusculo(char c){
        // Se o caractere estiver entre 'A' e 'Z', converte-o
        if(c>='A' && c<='Z') {
            c= (char) (c + 32);
        }
        return c;
    }

    // Método para testar se duas strings são um palíndromo uma da outra (ignorando maiúsculas/minúsculas)
    static boolean testeAnagrama(String palavra){
        String aux= palavra;
        int x= 0;
        for(int i=0; palavra.charAt(i)!=' '; i++){
            for(int j= palavra.length(); palavra.charAt(j-1)!=' '; j--){
                if(converteMinusculo(palavra.charAt(i)) == converteMinusculo(aux.charAt(j))){
                    x++;
                }
                if(x<1) return false;
            }
        }
        return true;
    }
    // Ponto de entrada do programa
    public static void main(String[] args) {
        String palavra;
        palavra= scanner.nextLine();
        while (palavra.charAt(0)!='F' && palavra.charAt(1)!='I' && palavra.charAt(2)!='M'){
            if(palavra.length()%2!=0){
                if(testeAnagrama(palavra)){
                    System.out.println("SIM");
                }
                else System.out.println("NÃO");
            }
            else System.out.println("NÃO");
            palavra= scanner.nextLine();
        }
        scanner.close();
    }
}
