import java.util.Scanner;

public class Sortsort {
    // Cria um Scanner para ler a entrada do usuário
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean verificacao = true; // Controle do loop principal

        // Loop principal para processar múltiplos casos de teste
        // O loop só continua se houver próxima linha
        while (verificacao && scanner.hasNextLine()) {
            // Lê a linha com os valores de m (quantidade de números) e n (módulo)
            String entrada = scanner.nextLine().trim();

            // Pula linhas vazias
            if (entrada.isEmpty()) continue;

            int m = 0, n = 0;        // Variáveis para armazenar m e n
            boolean teste = false;   // Indica se já encontramos o espaço separando m e n

            // Loop para extrair os valores de m e n da string manualmente
            for (int i = 0; i < entrada.length(); i++) {
                char c = entrada.charAt(i);

                if (!teste && c != ' ') {
                    // Monta o valor de m antes do espaço
                    m = m * 10 + (c - '0');
                } else if (!teste && c == ' ') {
                    // Encontrou espaço, agora começaremos a ler n
                    teste = true;
                } else if (teste && c != ' ') {
                    // Monta o valor de n após o espaço
                    n = n * 10 + (c - '0');
                }
            }

            // Lê os m números que serão ordenados
            int[] array = new int[m];
            for (int i = 0; i < m; i++) {
                if (scanner.hasNextInt()) {
                    array[i] = scanner.nextInt();
                }
            }
            // Consome a quebra de linha após os números
            if (scanner.hasNextLine()) scanner.nextLine();

            // Insertion sort adaptado para as regras do exercício
            for (int i = 1; i < m; i++) {
                int key = array[i];   // Elemento a ser inserido na posição correta
                int j = i - 1;

                // Calcula o módulo de key (ajusta negativos)
                int keyMod = key % n;
                if (keyMod < 0) keyMod += n;

                // Move elementos que precisam ser "empurrados" para a direita
                while (j >= 0) {
                    int jMod = array[j] % n;
                    if (jMod < 0) jMod += n;

                    boolean trocar = false; // Indica se devemos mover array[j]

                    // Primeiro critério: módulo crescente
                    if (jMod > keyMod) {
                        trocar = true;
                    } 
                    // Segundo critério: desempates quando módulo é igual
                    else if (jMod == keyMod) {
                        boolean keyOdd = key % 2 != 0; // key é ímpar?
                        boolean jOdd = array[j] % 2 != 0; // array[j] é ímpar?

                        if (keyOdd && !jOdd) {
                            // Ímpar antes de par
                            trocar = true;
                        } else if (keyOdd && jOdd && key > array[j]) {
                            // Dois ímpares: maior primeiro
                            trocar = true;
                        } else if (!keyOdd && !jOdd && key < array[j]) {
                            // Dois pares: menor primeiro
                            trocar = true;
                        }
                    }

                    // Se precisa trocar, move array[j] uma posição à frente
                    if (trocar) {
                        array[j + 1] = array[j];
                        j--;
                    } else {
                        break; // Achou a posição correta
                    }
                }

                // Insere o key na posição correta
                array[j + 1] = key;
            }

            // Impressão do caso de teste: primeiro m e n
            System.out.println(m + " " + n);
                        // Caso de parada: m=0 e n=0 indica que devemos encerrar
            if (m == 0 && n == 0) verificacao= false;

            // Em seguida, imprime os números ordenados
            for (int i = 0; i < m; i++) {
                System.out.println(array[i]);
            }
        }

        // Fecha o Scanner ao final do programa
        scanner.close();
    }
}
