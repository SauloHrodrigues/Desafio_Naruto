package com.projetonaruto.model;

import com.projetonaruto.interfaces.Ninja;

public class NinjaDeNinjutsu extends Personagem implements Ninja {
    public NinjaDeNinjutsu(String nome, int idade, String aldeia, String jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de Ninjutsu.";
    }

    @Override
    public String desviar() {
        return "O personagem está desviando de um ataque usando sua habilidade em Ninjutsu.";
    }
}