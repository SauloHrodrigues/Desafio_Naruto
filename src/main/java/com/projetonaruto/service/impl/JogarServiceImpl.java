package com.projetonaruto.service.impl;

import com.projetonaruto.exceptions.JutsuInvalidoException;
import com.projetonaruto.exceptions.PersonagemNaoEstaJogandoExcepition;
import com.projetonaruto.model.JogoSessao;
import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.PersonagemNinja;
import com.projetonaruto.service.IJogarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JogarServiceImpl implements IJogarService {

    private PersonagemNinja jogador01;
    private PersonagemNinja jogador02;
    private JogoSessao jogo;

    @Autowired
    private PersonagemServiceImpl personagemService;

    @Override
    public String novoJogo(String ninja, String oponente) {
        jogador01 = personagemService.pesquisarNinjas(ninja);
        jogador02 = personagemService.pesquisarNinjas(oponente);
        jogo = new JogoSessao(jogador01, jogador02);
        return "Iniciada a batalha entre: " + jogador01.getNome().toUpperCase() +
                " X " + jogador02.getNome().toUpperCase();
    }

    @Override
    public String usarJutsu(String nomeDoNinja, String nomeDoJutsu) {
        PersonagemNinja ninja = retornaJogador(nomeDoNinja);
        Jutsu jutsu = validaJutso(ninja, nomeDoJutsu);
        return jogo.lancandoJutsu(ninja, jutsu);
    }

    @Override
    public String desviar() {
        return jogo.executarDefesa();
    }


    public Jutsu validaJutso(PersonagemNinja ninja, String jutsu) {
        if (ninja.getJutsus().containsKey(jutsu.toUpperCase())) {
            return ninja.getJutsus().get(jutsu.toUpperCase());
        }
        throw new JutsuInvalidoException("Jutsu inválido.");
    }

    public PersonagemNinja retornaJogador(String nome) {
        Personagem ninja = personagemService.pesquisarNinjas(nome);

        if (jogador01.getNome().equalsIgnoreCase(ninja.getNome())) {
            return jogador01;
        }
        if (jogador02.getNome().equalsIgnoreCase(ninja.getNome())) {
            return jogador02;
        }
        throw new PersonagemNaoEstaJogandoExcepition("O personagem: " +
                nome.toUpperCase() + " não esta jogando.");
    }
}