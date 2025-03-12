package com.projetonaruto.exceptions;

public class PersonagemJaCadastradoException extends RuntimeException{
    public PersonagemJaCadastradoException(String mensagem){
        super(mensagem);
    }
}