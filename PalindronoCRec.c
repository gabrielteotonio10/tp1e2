#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

char normalChar(char c) {
    switch(tolower(c)) {
        //Vogais com acento agudo, circunflexo, til e cecidilha
        case 0xC3: return 0; // marca de acento, ignora
        case 0xA1: case 0xA0: case 0xA3: case 0xA2: case 0xA4: return 'a'; // á à ã â ä
        case 0xA9: case 0xA8: case 0xAA: case 0xAB: return 'e'; // é è ê ë
        case 0xAD: case 0xAC: case 0xAE: case 0xAF: return 'i'; // í ì î ï
        case 0xB3: case 0xB2: case 0xB5: case 0xB4: case 0xB6: return 'o'; // ó ò õ ô ö
        case 0xBA: case 0xB9: case 0xBB: case 0xBC: return 'u'; // ú ù û ü
        case 0xA7: return 'c'; // ç
        default: return c; //Se não for acentuado, retorna igual
    }//Fim do switch
}//Fim da função normalChar

bool recursao(char palavra[], int tam, int i){
    if(i<tam){
        //Confere se o primeiro caracter é igual ao último, subtraindo a cada rec
        if(normalChar(palavra[i])!=normalChar(palavra[tam])){
            return false;
        }//Fim do if
        else return recursao(palavra, tam-1, i+1);
    }//Fim do if
    return true;
}//Fim da função recursao

int main() {
    char palavra[1000];
    fgets(palavra, sizeof(palavra), stdin);
    //Removendo \n do fim da String
    palavra[strcspn(palavra, "\n")] = '\0';
    while (strcmp(palavra,"FIM")!=0)
    {
        //Chama a funções recursiva "recursao" atribuindo seu resultado a variável "teste"
        bool teste= recursao(palavra, (strlen(palavra)-1), 0);
        if(teste) printf("SIM\n");
        else printf("NAO\n");
        //Captura uma nova String
        fgets(palavra, sizeof(palavra), stdin);
        //Removendo \n do fim da String
        palavra[strcspn(palavra, "\n")] = '\0';
    }//Fim do while
}//Fim da main
