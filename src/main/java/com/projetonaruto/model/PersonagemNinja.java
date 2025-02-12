package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.interfaces.Ninja;
import java.util.Map;

public class PersonagemNinja extends Personagem implements Ninja {
    public PersonagemNinja(String nomeNinja, int idade, String aldeia, int vida, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, vida, ninja);
    }

    @Override
    public String usarJutsu() {
        return null;
    }

    @Override
    public void usarJutsu(Jutsu jutsu, PersonagemNinja inimigo) {
    }

    @Override
    public String desviar() {
        return null;
    }

    @Override
    public String desviar(int danoRecebido) {
        return null;
    }

    public void adicionarJutsu(Jutsu jutsu) {
        jutsus.put(jutsu.getNome().toUpperCase(), jutsu);
    }

    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}