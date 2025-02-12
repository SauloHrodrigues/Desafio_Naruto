package com.projetonaruto.exceptions;

public class JogadorForaDaVezException extends RuntimeException{
    public JogadorForaDaVezException(String mensagem){
        super(mensagem);
    }
}