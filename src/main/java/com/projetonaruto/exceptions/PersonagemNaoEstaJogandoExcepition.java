package com.projetonaruto.exceptions;

public class PersonagemNaoEstaJogandoExcepition extends RuntimeException{
    public PersonagemNaoEstaJogandoExcepition(String mensagem){
        super(mensagem);
    }
}