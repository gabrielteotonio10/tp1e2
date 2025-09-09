package exercicios;

public class somaCircular {
    static int fila[]={2,2,2,2,2,2,2,2,2,2};
    static int n= fila.length;
    static int primeiro= 0;
    static int ultimo= n;
    static int removoRetorna(){
        int soma= 0;
        for(int i=primeiro; i!=ultimo; i= ((i+1)%n)){
            soma+= fila[i];
        }
        return soma;
    }
    public static void main(String[] args) {
        for(int i=primeiro; i!=ultimo; i=((i+1)%n)){
            System.out.println(fila[i]);
        }

        System.out.println("\n\n");

        int sum= removoRetorna();  

        System.out.println(sum);

    }
}
