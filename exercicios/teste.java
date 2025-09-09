package exercicios;

public class teste {
    static int array[] = new int[6];
    static int primeiro = 0;
    static int ultimo = 5;

    static int removeMaiorQueDez() {
        int num = -1;
        int n = array.length;
        for (int i = primeiro; i != ultimo; i = (i + 1) % n) {
            if (array[i] > 10) {
                num = array[i];
                for (int j = i; j != (ultimo - 1 + n) % n; j = (j + 1) % n) {
                    array[j] = array[(j + 1) % n];
                }
                ultimo = (ultimo - 1 + n) % n;
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        array[0] = 2;
        array[1] = 8;
        array[2] = 12;
        array[3] = 7;
        array[4] = 54;
        System.out.println("Fila original:");
        for (int i = primeiro; i != ultimo; i = (i + 1) % array.length) {
            System.out.print(array[i] + " ");
        }

        int num= removeMaiorQueDez();
        System.out.println("\n\n"+num);

        System.out.println("\n\nFila após remoção (>10):");
        for (int i = primeiro; i != ultimo; i = (i + 1) % array.length) {
            System.out.print(array[i] + " ");
        }
    }
}




