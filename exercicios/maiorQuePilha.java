package exercicios;
public class maiorQuePilha {
    static int removerMaiorQueK(int k, int pilha[]){
        int n= pilha.length-1;
        for(int i= n; i>=0; i--){
            if(pilha[i]>k){
                int x= pilha[i];
                for(int j= i; j<n-1; j++){
                    pilha[j]=pilha[j+1];
                }
                return x;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int pilha[]= {2,12,3,12,65,11,2,3,55,2,7,5,12,1};
        int x= removerMaiorQueK(15, pilha);
        System.out.println(x + "\n\n");
        for(int i=pilha.length-1; i>=0;i--){
            System.out.println(pilha[i]);
        }
    }   
}
