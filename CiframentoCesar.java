
import java.util.Scanner;

class CifraCesar {
    private String texto; // Armazena o texto a ser cifrado

    // Construtor: inicializa o texto como vazio
    public CifraCesar() {
        texto = "";
    }

    // Define o texto a ser cifrado
    public void setTexto(String texto) {
        this.texto = texto;
    }

    // Retorna o texto armazenado
    public String getTexto() {
        return texto;
    }

    // Aplica a cifra de César 
    public void aplicarCifra() {
        StringBuilder resultado = new StringBuilder(); 

        // Percorre cada caractere do texto
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i); // Pega o caractere atual

            // Se o caractere estiver na faixa de ASCII 
            if (c >= 32 && c <= 126) {
                int pos = c - 32;               
                int novaPos = (pos + 3) % 95;   
                c = (char) (32 + novaPos);     
            }

            resultado.append(c); // Adiciona o caractere cifrado à string final
        }//Fim do for

        // Imprime o texto cifrado
        System.out.println(resultado.toString());
    }//Fim do método aplicarCifra
}//Fim da classe CifraCesar

// Classe principal para executar o programa
public class CiframentoCesar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8"); 
        CifraCesar cifra = new CifraCesar();// Cria objeto da cifra de César

        // Loop de entrada de dados
        while (true) {
            String linha = scanner.nextLine();            
            if (linha.equalsIgnoreCase("FIM")) {           
                break;
            }

            cifra.setTexto(linha);                         
            cifra.aplicarCifra();                          
        }//Fim do while

        scanner.close();                                 
    }//Fim da main
}//Fim da classe MainCesar
