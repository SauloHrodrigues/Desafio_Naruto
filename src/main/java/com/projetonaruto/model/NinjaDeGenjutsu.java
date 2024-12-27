package com.projetonaruto.model;

import com.projetonaruto.interfaces.Ninja;

public class NinjaDeGenjutsu  extends Personagem implements Ninja{

    public NinjaDeGenjutsu(String nome, int idade, String aldeia, String jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de Genjutsu.";
    }

    @Override
    public String desviar() {
        return "o personagem está desviando de um ataque usando sua habilidade em Genjutsu";
    }
}