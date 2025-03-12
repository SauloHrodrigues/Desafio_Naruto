package com.projetonaruto.exceptions;

public class PersonagemNaoENinjaException extends RuntimeException{
    public PersonagemNaoENinjaException(String mensagem){
        super(mensagem);
    }
}