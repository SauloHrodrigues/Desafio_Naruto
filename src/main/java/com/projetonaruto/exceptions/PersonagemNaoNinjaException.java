package com.projetonaruto.exceptions;

public class PersonagemNaoNinjaException extends RuntimeException{
    public PersonagemNaoNinjaException(String mensagem){
        super(mensagem);
    }
}