package exercicios;

public class moveCircularK {
    static int fila[]={3,5,2,3,12,43,22,12};
    static int n= fila.length;
    static int primeiro= 0;
    static int ultimo= n;

    static void move(int k){
        primeiro= (primeiro-k+n)%n;
        ultimo= (ultimo-k+n)%n;
    }
    public static void main(String[] args) {
        for(int i=primeiro; i!=ultimo; i=((i+1)%n)){
            System.out.println(fila[i]);
        }

        System.out.println("\n\n");

        move(2);  

        for(int i=primeiro; i!=ultimo; i=((i+1)%n)){
            System.out.println(fila[i]);
        }

    }
}
