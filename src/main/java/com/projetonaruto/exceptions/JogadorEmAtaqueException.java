package com.projetonaruto.exceptions;

public class JogadorEmAtaqueException extends RuntimeException{
    public JogadorEmAtaqueException(String mensagem){
        super(mensagem);
    }
}