#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>

// Verifica se a string contém apenas dígitos e um único ponto opcional,
bool ehNumero(char palavra[], int tam){
    bool teste = true;
    int contador= 0;
    for(int i=0; i<tam; i++){
        // Se o caractere não for um dígito E não for um ponto, não é um número
        if((!isdigit(palavra[i]) && palavra[i] != '.' && palavra[i] != ',') || contador==2){
            teste = false;
            i = tam;
        }// Fim do if
        if(palavra[i] == '.' || palavra[i] == ','){
            contador++;
        }
    }// Fim do for
    return teste;
}// Fim da função ehNumero

// Verifica se a string é composta apenas por vogais
bool ehVogal(char palavra[], int tam){
    bool teste = true;
    for(int i=0; i<tam; i++){
        char letra = tolower(palavra[i]);
        // Se a letra não for uma vogal, a string não é feita só de vogais
        if(letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra !='u')
        {
            teste = false;
            i = tam;
        }// Fim doif
    }// Fim do for
    return teste;
}// Fim do ehVogal

// Verifica se a string é composta apenas por consoantes
bool ehConsoante(char palavra[], int tam){
    bool teste = true;
    for(int i=0; i<tam; i++){
        char letra = tolower(palavra[i]); // Converte para minúscula para a verificação.
        // Se a letra for uma vogal, a string não é feita só de consoantes
        if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra=='.' || letra==',')
        {
            teste = false;
            i = tam;
        }// Fim do if
    }// Fim do for
    return teste;
}// Fim da função ehConsoante

// Verifica se a string não contém um ponto, indicando que é um número inteiro
bool ehInteiro(char palavra[], int tam){
    bool teste = true;
    for(int i=0; i<tam; i++){
        if(palavra[i] == '.'||palavra[i] == ','){
            teste = false;
            i = tam;
        }// Fim do if
    }// Fim do for
    return teste;
}// Fim da função ehInteiro

// Verifica se a string contém pelo menos um ponto, indicando que é um número real
bool ehReal(char palavra[], int tam){
    bool teste = false;
    for(int i=0; i<tam; i++){
        if(palavra[i] == '.'||palavra[i] == ','){
            teste = true;
            i = tam;
        }// Fim do if
    }// Fim do for
    return teste;
}// Fim da função ehReal

int main() {
    char palavra[1000];
    // Lê a primeira linha de entrada.
    fgets(palavra, sizeof(palavra), stdin);
    palavra[strcspn(palavra, "\n")] = '\0';

    while (strcmp(palavra, "FIM") != 0) {
        bool teste;
        int tam = strlen(palavra);

        // Verifica se a string é um número
        bool numero = ehNumero(palavra, tam);

        // Se a string não for um número, ela pode ser uma palavra (vogal/consoante)
        if(!numero){
            teste = ehVogal(palavra, tam);
            if(teste) printf("SIM NAO ");
            else{
                teste = ehConsoante(palavra, tam);
                if(teste) printf("NAO SIM ");
            }//Fim do else
            // Se não for nem vogal nem consoante
            if(!teste) printf("NAO NAO ");
        }//Fim do if
        else printf("NAO NAO ");

        // Se a string for um número, verifica se é inteiro ou real
        if(numero){
            teste = ehInteiro(palavra, tam);
            if(teste) printf("SIM SIM\n");
            else{
                teste = ehReal(palavra, tam);
                if(teste) printf("NAO SIM\n");
            }// Fim do if
        } else {
             // Caso a string não seja um número
            printf("NAO NAO\n");
        }// Fim do else
        // Lê a próxima linha de entrada
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strcspn(palavra, "\n")] = '\0';
    }// Fim do while
}// Fim da main
