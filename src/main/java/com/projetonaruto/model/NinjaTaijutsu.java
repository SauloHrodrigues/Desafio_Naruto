package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaJutsuEnum;
import com.projetonaruto.interfaces.Ninja;


public class NinjaTaijutsu extends Personagem implements Ninja {
    public NinjaTaijutsu(String nome, int idade, String aldeia, CategoriaJutsuEnum jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um golpe de NinjaTaijutsu";
    }

    @Override
    public String desviar() {
        return "O personagem está desviando de um ataque usando sua habilidade em NinjaTaijutsu.";
    }
}