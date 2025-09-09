public class FilaCircular {
    private int[] fila;
    private int tamanho;
    private int inicio; 
    private int fim;   
    private int quantidade;    

    public FilaCircular(int capacidade) {
        tamanho = capacidade;
        fila = new int[tamanho];
        inicio = 0;
        fim = -1;
        quantidade = 0;
    }

    public boolean enfileirar(int valor) {
        if (isFull()) {
            System.out.println("Fila cheia!");
            return false;
        }
        fim = (fim + 1) % tamanho;
        fila[fim] = valor;
        quantidade++;
        return true;
    }

    public Integer desenfileirar() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return null;
        }
        int valor = fila[inicio];
        inicio = (inicio + 1) % tamanho;
        quantidade--;
        return valor;
    }

    public Integer primeiroFila() {
        return isEmpty() ? null : fila[inicio];
    }

    public boolean isEmpty() {
        return quantidade == 0;
    }

    public boolean isFull() {
        return quantidade == tamanho;
    }

    public void print() {
        System.out.print("Fila: ");
        for (int i = 0; i < quantidade; i++) {
            int index = (inicio + i) % tamanho;
            System.out.print(fila[index] + " ");
        }
        System.out.println();
    }

    // Teste
    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(5);

        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        fila.enfileirar(40);
        fila.enfileirar(50);

        fila.print(); // 10 20 30 40 50

        fila.desenfileirar();
        fila.desenfileirar();

        fila.print(); // 30 40 50

        fila.enfileirar(60);
        fila.enfileirar(70);

        fila.print(); // 30 40 50 60 70 (reaproveitou o espaço)
    }
}
