package exercicios;

public class pilhaTeste {
    static int pilha[]={2,3,6,5,3,14,23,54,1,2,4,15,8};
    static int tam= pilha.length;
    static void removerMenorQueK(int k){
	    for(int i=tam-1; i>=0; i--){
		    if(pilha[i]<k){
			    for(int j=i; j<tam-1; j++){
                    pilha[j]= pilha[j+1];
			    }
                tam--;
            }
        }
    }
    public static void main(String[] args) {
        System.out.print("[");
        for(int i=0; i<tam; i++){
            System.out.print(" "+ pilha[i]);
        }
        System.out.println(" ]");

        removerMenorQueK(10);

        System.out.print("\n\n[");
        for(int i=0; i<tam; i++){
            System.out.print(" "+ pilha[i]);
        }
        System.out.println(" ]");
    }
}
