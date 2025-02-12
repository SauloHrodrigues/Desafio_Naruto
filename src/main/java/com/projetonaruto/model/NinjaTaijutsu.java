package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaTaijutsu extends PersonagemNinja {

    public NinjaTaijutsu(String nomeNinja, int idade, String aldeia, int vida, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, vida, ninja);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de NinjaTaijutsu.";
    }

    @Override
    public String desviar() {
        return "O personagem está desviando de um ataque usando sua habilidade em NinjaTaijutsu.";
    }
}