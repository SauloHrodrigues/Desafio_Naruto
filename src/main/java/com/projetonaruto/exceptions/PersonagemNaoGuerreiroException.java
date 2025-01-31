package com.projetonaruto.exceptions;

public class PersonagemNaoGuerreiroException extends RuntimeException{
    public PersonagemNaoGuerreiroException(String mensagem){
        super(mensagem);
    }
}