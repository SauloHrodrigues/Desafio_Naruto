package com.projetonaruto.model;

import com.projetonaruto.interfaces.Ninja;
import javax.naming.Name;

public class NinjaDeTaijutsu extends Personagem implements Ninja {
    public NinjaDeTaijutsu(String nome, int idade, String aldeia, String jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um golpe de Taijutsu";
    }

    @Override
    public String desviar() {
        return "O personagem está desviando de um ataque usando sua habilidade em Taijutsu.";
    }
}