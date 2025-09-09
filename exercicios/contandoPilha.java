package exercicios;

public class contandoPilha {
    static int contaElementos(int x, int pilha[]){
        int cout=0;
        int n= pilha.length-1;
        for(int i=n; i>=0; i--){
            if(pilha[i]==x){
                cout++;
            }
        }
        return cout;
    }
    public static void main(String[] args) {
        int pilha[]= {2,4,1,2,5,3,4,2,6,4,2,1,1,2,2};
        int x= contaElementos(2, pilha);
        System.out.println(x);
    }
}
