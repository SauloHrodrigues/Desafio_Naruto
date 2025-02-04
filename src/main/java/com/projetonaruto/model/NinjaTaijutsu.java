package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.exceptions.ChakrasInsuficientesException;
import com.projetonaruto.interfaces.Ninja;
import java.util.Map;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaTaijutsu extends PersonagensNinjas {


    public NinjaTaijutsu(String nomeNinja, int idade, String aldeia, int vida, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, vida, ninja);
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
