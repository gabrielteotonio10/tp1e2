package exercicios;

public class l {
    static int array[] = { 3, 1, 7, -1, - 3, - 4, 44, -65, 34, -2, -43, 1, 6, 4 };

    static void insercaoDiretaNegativos() {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int aux = array[i];
            int j = i - 1;
            while (j >= 0 && (array[j] > aux || array[j]<0) && aux >= 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
    }

    public static void main(String[] args) {
        System.out.println("Antes:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        insercaoDiretaNegativos();

        System.out.println("\n\nDepois:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
