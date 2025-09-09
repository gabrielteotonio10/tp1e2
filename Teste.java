import java.util.Scanner;

public class Teste{
    private static final Scanner scanner = new Scanner(System.in);

    static int mood(int x, int n){
        return x%n;
    }
    static void swap(int menor, int i, int numeros[]){
        int aux= numeros[menor];
        numeros[menor]= numeros[i];
        numeros[i]= aux;
    }
    public static void main(String[] args) {
        String entrada = scanner.nextLine();

        int m = 0, n = 0;        
        boolean teste = false;   

        for (int i = 0; i < entrada.length(); i++) {
                char c = entrada.charAt(i);

            if (!teste && c != ' ') {
                    m = m * 10 + (c - '0');
            } else if (!teste && c == ' ') {
                    teste = true;
            } else if (teste && c != ' ') {
                    n = n * 10 + (c - '0');
            }
        }

        int numeros[]= new int [m];
        for(int i=0; i<m; i++){
            numeros[i]= scanner.nextInt();
        }
        
        for (int i=0; i<(m-1); i++){
            int menor= i;
            for(int j=(i+1); j<m; j++){
                if(mood(numeros[menor], n)>mood(numeros[j], menor)){
                    menor= i;
                }
            }
            swap(menor, i, numeros);
        }

        for(int i=0; i<m; i++){
            System.out.println(numeros[i]);
        }

    }

}