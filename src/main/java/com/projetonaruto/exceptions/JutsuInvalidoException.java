package com.projetonaruto.exceptions;

public class JutsuInvalidoException extends RuntimeException{
    public JutsuInvalidoException(String mensagem){
        super(mensagem);
    }
}