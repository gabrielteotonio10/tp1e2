#include <stdio.h>
#include <string.h> // Para a funcao strlen() e strcspn()

// Define um tamanho máximo para a linha de entrada
#define MAX_LINHA 1001

int contarMaiusculas(char *str) {
    int contador = 0;
    int i = 0;

    // Itera por cada caractere da string ate encontrar o final (caractere '\0')
    while (str[i] != '\0') {
        // Verifica se o caractere esta no intervalo ASCII de 'A' a 'Z'
        if (str[i] >= 'A' && str[i] <= 'Z') {
            contador++;
        }
        i++;
    }

    return contador;
}

int main() {
    char linha[MAX_LINHA];

    // Le a entrada padrao linha por linha ate o final do arquivo (EOF)
    while (fgets(linha, MAX_LINHA, stdin) != NULL) {
        // Remove a quebra de linha ('\n') que fgets adiciona no final da string.
        // strcspn retorna o indice do primeiro '\n' ou '\0' encontrado.
        linha[strcspn(linha, "\n")] = '\0';
        
        // Verifica se a linha não está vazia após a remoção da quebra de linha
        if (linha[0] != '\0') {
            int maiusculas = contarMaiusculas(linha);
            printf("%d\n", maiusculas);
        }
    }
    
    return 0;
}