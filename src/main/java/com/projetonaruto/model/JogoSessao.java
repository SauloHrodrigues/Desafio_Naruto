package com.projetonaruto.model;

import com.projetonaruto.exceptions.ChakrasInsuficientesException;
import com.projetonaruto.exceptions.JogadorEmAtaqueException;
import com.projetonaruto.exceptions.JogoInvalidoException;
import java.util.Random;

public class JogoSessao {

    private PersonagemNinja jogador01;
    private PersonagemNinja jogador02;
    private PersonagemNinja ninjaAptoParaDefesa;
    private Jutsu ultimoJutso;
    private boolean defesaPendente;
    private int pontosJogador01;
    private int pontosJogador02;
    private Boolean jogoAtivo = true;

    public JogoSessao(PersonagemNinja jogador01, PersonagemNinja jogador02) {
        this.jogador01 = jogador01;
        this.jogador02 = jogador02;
        this.pontosJogador01 = 0;
        this.pontosJogador02 = 0;
        defesaPendente = false;
        this.jogoAtivo = true;
    }

    public String lancandoJutsu(PersonagemNinja atacante, Jutsu jutsu) {
        validarSessaoAtiva();
        validarAtaquePendente();
        ultimoJutso = jutsu;

        if (atacante == jogador01 && defesaPendente == false) {
            validaChakra(jogador01, jutsu);
            descontaChakra(jogador01, jutsu);
            defesaPendente = true;
            ninjaAptoParaDefesa = jogador02;
            return jogador01.usarJutsu();
        }

        if (atacante == jogador02 && defesaPendente == false) {
            validaChakra(jogador02, jutsu);
            descontaChakra(jogador02, jutsu);
            defesaPendente = true;
            ninjaAptoParaDefesa = jogador01;
            return jogador02.usarJutsu();
        }
        return null;
    }

    public String executarDefesa() {
        validarSessaoAtiva();
        validarDefesaPendente();

        if (ninjaAptoParaDefesa == jogador01) {
            defesaPendente = false;
            if (retornoBooleanoRandomico()) {
                computarPontuacao(jogador01, ultimoJutso.getDano());
                return jogador01.desviar();
            } else {
                computarPontuacao(jogador02, ultimoJutso.getDano());
                computarPontuacao(jogador01, -(ultimoJutso.getDano()));
                return "Defesa do jogador: "+jogador01.getNome()+" realizada, mas mal sucedidada!";
            }
        }

        if (ninjaAptoParaDefesa == jogador02) {
            defesaPendente = false;
            if (retornoBooleanoRandomico()) {
                computarPontuacao(jogador02, ultimoJutso.getDano());
                return jogador02.desviar();
            } else {
                computarPontuacao(jogador02, -(ultimoJutso.getDano()));
                computarPontuacao(jogador01, ultimoJutso.getDano());
                return "Defesa do jogador: "+jogador02.getNome()+" realizada, mas mal sucedidada!";
            }
        }
        return null;
    }

    public void validarDefesaPendente(){
        if(defesaPendente== false){
            throw new JogadorEmAtaqueException("Não há ataque para se defender.");
        }
    }

    public void validarAtaquePendente(){
        if(defesaPendente== true){
            throw new JogadorEmAtaqueException("Jogador em ataque, pendente de defesa.");
        }
    }
    public boolean retornoBooleanoRandomico() {
        Random random = new Random();
        boolean radomico = random.nextBoolean();

        if (radomico) {
            return true;
        } else
            return false;
    }

    public void consumirVidas(PersonagemNinja ninja) {

        if (jogador01 == ninja && retornoBooleanoRandomico()) {
            jogador01.setVida(jogador01.getVida() - 1);
        }

        if (jogador02 == ninja && retornoBooleanoRandomico()) {
            jogador02.setVida(jogador02.getVida() - 1);
        }

        if(jogador02.getVida() <= 0 || jogador01.getVida() <=0){
            fimDaPartida();
        }
    }

    public void validaChakra(PersonagemNinja ninja, Jutsu jutsu) {
        if (ninja.getChakra() < jutsu.getConsumoDeChakra()) {
            throw new ChakrasInsuficientesException("Não há chakra suficientes para usar o" +
                    " jutsu " + jutsu.getNome());
        }
    }

    public void descontaChakra(PersonagemNinja ninja, Jutsu jutsu) {
        if (ninja == jogador01) {
            jogador01.setChakra(jogador01.getChakra() - jutsu.getConsumoDeChakra());
            consumirVidas(jogador01);
        }

        if (ninja == jogador02) {
            jogador02.setChakra(jogador02.getChakra() - jutsu.getConsumoDeChakra());
            consumirVidas(jogador02);
        }
    }

    public void computarPontuacao(PersonagemNinja ninja, int pontos) {
        if (ninja == jogador01) {
            pontosJogador01 += pontos;
        } else {
            pontosJogador02 += pontos;
        }
    }

    public void consumirDefesa() {
        if (!defesaPendente) {
            if (ninjaAptoParaDefesa == jogador01) {
                computarPontuacao(jogador01, ultimoJutso.getDano());
            } else {
                computarPontuacao(jogador02, ultimoJutso.getDano());
            }
        }
    }

    public boolean validarSessaoAtiva() {
        if (jogoAtivo) {
            return true;
        }
        throw new JogoInvalidoException("O lance é impossível. Jogo já fializado.");
    }

    public boolean fimDaPartida() {
        jogoAtivo = false;
        return true;
    }
}