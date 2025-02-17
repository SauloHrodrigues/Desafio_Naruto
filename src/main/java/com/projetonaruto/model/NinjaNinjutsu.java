package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;

public class NinjaNinjutsu extends PersonagemNinja {

    public NinjaNinjutsu(String nomeNinja, int idade, String aldeia, int vida, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, vida, ninja);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de NinjaNinjutsu.";
    }

    @Override
    public String desviar() {
        return "O personagem está desviando de um ataque usando sua habilidade em NinjaNinjutsu.";
    }
}