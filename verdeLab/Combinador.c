#include <stdio.h>
#include <string.h> // Para a funcao strlen()
#include <stdlib.h> // Para a funcao malloc()

// Define um tamanho maximo para a linha de entrada
#define MAX_LINHA 1001

char* combinar(char* str1, char* str2) {
    int len1 = 0;
    while(str1[len1] != '\0') {
        len1++;
    }

    int len2 = 0;
    while(str2[len2] != '\0') {
        len2++;
    }
    
    // Calcula o tamanho total da string resultante
    int total_len = len1 + len2;
    // Aloca memoria para a nova string (+1 para o caractere nulo)
    char* resultado = (char*) malloc(sizeof(char) * (total_len + 1));
    if (resultado == NULL) {
        return NULL;
    }

    int i = 0, j = 0, k = 0;

    // Alterna os caracteres enquanto ambas as strings tiverem caracteres
    while (i < len1 && j < len2) {
        resultado[k++] = str1[i++];
        resultado[k++] = str2[j++];
    }

    // Copia os caracteres restantes da primeira string, se houver
    while (i < len1) {
        resultado[k++] = str1[i++];
    }

    // Copia os caracteres restantes da segunda string, se houver
    while (j < len2) {
        resultado[k++] = str2[j++];
    }

    // Adiciona o terminador nulo para que seja uma string valida em C
    resultado[total_len] = '\0';
    
    return resultado;
}

int main() {
    char linha[MAX_LINHA];

    // Loop para ler a entrada padrao linha por linha ate o final do arquivo
    while (fgets(linha, MAX_LINHA, stdin) != NULL) {
        // Remover a quebra de linha que o fgets adiciona
        linha[strcspn(linha, "\n")] = '\0';
        
        // Encontrar a posicao do espaco para separar as duas strings
        int pos_espaco = -1;
        for (int i = 0; i < strlen(linha); i++) {
            if (linha[i] == ' ') {
                pos_espaco = i;
                break;
            }
        }
        
        // Se um espaco foi encontrado, separa as strings
        if (pos_espaco != -1) {
            // Cria a primeira string, terminando-a no espaco
            char str1[pos_espaco + 1];
            strncpy(str1, linha, pos_espaco);
            str1[pos_espaco] = '\0';

            // Cria a segunda string, comecando depois do espaco
            char str2[MAX_LINHA - pos_espaco];
            int k = 0;
            for (int i = pos_espaco + 1; i < strlen(linha); i++) {
                str2[k++] = linha[i];
            }
            str2[k] = '\0';

            char* resultado = combinar(str1, str2);
            if (resultado != NULL) {
                printf("%s\n", resultado);
                free(resultado); // Libera a memoria alocada
            }
        }
    }
    
    return 0;
}