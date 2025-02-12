package com.projetonaruto.exceptions;

public class JogoInvalidoException extends RuntimeException{
    public JogoInvalidoException(String mensagem){
        super(mensagem);
    }
}