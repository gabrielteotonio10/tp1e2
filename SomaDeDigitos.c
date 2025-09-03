#include <stdio.h>    
#include <stdlib.h>   
#include <string.h>  
#include <ctype.h> 
#include <stdbool.h>  

// Esta função lê uma linha de texto da entrada padrão (teclado)
void pegandoNumero(char num[]){
    fgets(num, 50, stdin);
    num[strcspn(num, "\n")] = 0;
}

// Esta função calcula a soma dos dígitos de um número inteiro.
int somaDigitos(int numero){
    int soma = 0;
    while (numero != 0)
    {
        // Pega o último dígito do número (usando o resto da divisão por 10) e o adiciona à soma.
        soma += numero % 10;
        // Remove o último dígito do número (dividindo por 10).
        numero /= 10;
    }
    return soma;
}

// Esta função verifica se uma string é composta apenas por dígitos.
bool ehDigito(char palavra[]){
    bool eh = true;
    for(int i = 0; i < strlen(palavra); i++){
        if((!isdigit(palavra[i]))){
            eh = false;
            i = strlen(palavra);
        }
    }
    return eh;
}

// Função principal do programa.
int main(){
    char numero[50];
    
    // Lê a primeira entrada do usuário.
    pegandoNumero(numero);
    
    // a entrada do usuário não for a string "FIM".
    while(strcmp(numero, "FIM") != 0){
        if(ehDigito(numero)){
            int numConver = atoi(numero);
            int soma = somaDigitos(numConver);
            printf("%i\n", soma);
        }
        else{

            printf("%s\n", numero);
        }
        // Lê a próxima entrada para a próxima iteração do laço.
        pegandoNumero(numero);
    }
    
    return 0;
}