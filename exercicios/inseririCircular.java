package exercicios;

public class inseririCircular {
    static int fila[] = new int[7];
    static int n = fila.length;
    static int primeiro = 1;
    static int ultimo = 5;

    static void removePar() {
        for(int i=primeiro; i!=ultimo; i= (i+1)%n){
            if(fila[i]%2==0){
                for(int j=i; j!=(ultimo-1+n)%n; j= (j+1)%n){
                    fila[j]= fila[((j+1)%n)];
                }
                ultimo= (ultimo-1+n)%n;
                i= (i-1+n)%n;
            }
        }
    }

    public static void main(String[] args) {
        fila[1]= 1;
        fila[2]= 22;
        fila[3]= 5;
        fila[4]= 2;

        for (int i = primeiro; i != ultimo; i = ((i + 1) % n)) {
            System.out.println(fila[i]);
        }

        System.out.println("\n\n");

        removePar();

        for (int i = primeiro; i != ultimo; i = ((i + 1) % n)) {
            System.out.println(fila[i]);
        }

    }

}
