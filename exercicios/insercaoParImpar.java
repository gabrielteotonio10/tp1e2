package exercicios;

public class insercaoParImpar {
    static int t[]={-2,-6,4,3,2,-3,4,-45,34};
    static int n= t.length;
    public static void main(String[] args) {
        for (int i=1; i<n; i++){
            int j= i-1;
            int aux= t[i];
            while(j>=0 && t[j]<0 && aux>0){
                t[j+1]= t[j];
                j--;
            }
            t[j+1]= aux;
        }
        System.out.print("[");
        for(int i=0; i<n; i++){
            System.out.print(" "+ t[i]);
        }
        System.out.println(" ]");
    }
}






































