package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaGenjutsu extends PersonagensNinjas {


    public NinjaGenjutsu(String nomeNinja, int idade, String aldeia, int vida, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, vida, ninja);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de NinjaGenjutsu.";
    }


    @Override
    public String desviar() {
        return "o personagem está desviando de um ataque usando sua habilidade em NinjaGenjutsu";
    }

}