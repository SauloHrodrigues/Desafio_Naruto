package com.projetonaruto.service.impl;

import com.projetonaruto.exceptions.PersonagemNaoNinjaException;
import com.projetonaruto.model.JogoSessao;
import com.projetonaruto.model.PersonagensNinjas;
import com.projetonaruto.service.IJogarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JogarServiceImpl implements IJogarService {

    private boolean jogando = false;
    private PersonagensNinjas jogador01;
    private PersonagensNinjas jogador02;

    @Autowired
    private PersonagemServiceImpl personagemService;
        private JogoSessao jogo;
    @Override
    public String novoJogo(String ninja, String oponente) {
        jogador01 = personagemService.pesquisarNinjas(ninja);
        jogador02 = personagemService.pesquisarNinjas(oponente);
        jogo = new JogoSessao(jogador01, jogador02);
        return "Iniciada a batalha entre: "+jogador01.getNome().toUpperCase() +
                " X "+ jogador02.getNome().toUpperCase();
    }

   @Override
    public String usarJutsu(String nomeDoNinja, String nomeDoJutsu) {
        if(jogador01.getNome().equalsIgnoreCase(nomeDoNinja)){
            return jogo.usarJutsu(jogador01, nomeDoJutsu);
        }

        if( jogador02.getNome().equalsIgnoreCase(nomeDoNinja)){
            return jogo.usarJutsu(jogador02, nomeDoJutsu);
        }

        throw new PersonagemNaoNinjaException("O personagem "+ nomeDoNinja.toUpperCase()+
                " não é um ninja.");
    }

    @Override
    public String desviar(String ninja) {
        return null;
    }
}
