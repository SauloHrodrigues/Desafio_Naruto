package com.projetonaruto.model;

import com.projetonaruto.exceptions.JutsuInvalidoException;

public class JogoSessao {

    private PersonagensNinjas jogador01;
    private PersonagensNinjas jogador02;
    private Boolean jogoAtivo = false;

    public JogoSessao(PersonagensNinjas jogador01, PersonagensNinjas jogador02) {
        this.jogador01 = jogador01;
        this.jogador02 = jogador02;
        this.jogoAtivo = true;
    }

    public String usarJutsu(PersonagensNinjas ninja, String nomeDoJutso){
       Jutsu jutsu= validaJutsu(ninja, nomeDoJutso);

       if(ninja.getNome().toUpperCase() == jogador01.getNome().toUpperCase()){
           jogador01.usarJutsu(jutsu, jogador02);
           return jogador01.usarJutsu();
       } else {
           jogador02.usarJutsu(jutsu, jogador01);
           return jogador02.usarJutsu();
       }
    }

    private Jutsu validaJutsu(PersonagensNinjas ninja, String nomeDoJutsu){
        if(ninja.getJutsus().containsKey(nomeDoJutsu)){
            return ninja.getJutsus().get(nomeDoJutsu);
        } else {
            throw new JutsuInvalidoException("O ninja "+ninja.getNome() + " não tem o jutso "+
                    nomeDoJutsu);
        }
    }

    private void validaJogo(){
        if(jogador01.getVida()<=0){
            fimDaPartida();
        }

        if(jogador02.getVida()<=0) {
            fimDaPartida();
        }
    }

    private void fimDaPartida(){
        System.out.println("Partida finalizada!");
        jogoAtivo = false;
    }
}