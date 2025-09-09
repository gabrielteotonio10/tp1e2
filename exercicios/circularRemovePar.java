package exercicios;

public class circularRemovePar {
    static int fila[]={7,3,6,5,8,3,1};
    static int n= fila.length;
    static int primeiro= 0;
    static int ultimo= n;
    static int removoRetorna(){
        int par= -1;
        if (primeiro == ultimo) return par;
        for(int i=primeiro; i!=ultimo; i=((i+1)%n)){
            if(fila[i]%2==0) {
                par= fila[i];
                int j = i;
                while ( j != (ultimo - 1 + n) % n) {
                    fila[j] = fila[(j + 1) % n];
                    j = (j + 1) % n;
                }
                ultimo = (ultimo - 1 +n) % n;
                return par;
            }    
        }
        return par;
    }
    public static void main(String[] args) {
        for(int i=primeiro; i<ultimo; i++){
            System.out.println(fila[i]);
        }
        System.out.println("\n\n");
        int num= removoRetorna();   
        System.out.println(num);
        System.out.println("\n\n");
        for(int i=primeiro; i<ultimo; i++){
            System.out.println(fila[i]);
        }
        System.out.println("\n\n");
    }
}
