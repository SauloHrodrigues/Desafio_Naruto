package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaJutsuEnum;
import com.projetonaruto.interfaces.Ninja;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaTaijutsu extends Personagem implements Ninja {

    public NinjaTaijutsu(String nomeNinja, int idade, String aldeia, boolean ninja) {
        super(nomeNinja, idade, aldeia, ninja);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um golpe de NinjaTaijutsu";
    }

    @Override
    public String desviar() {
        return "O personagem está desviando de um ataque usando sua habilidade em NinjaTaijutsu.";
    }

    public Map<String, Jutsu> getMapJutsus() {
        return jutsus;
    }

    public void setMapJutsus(Map<String, Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    public int getPChakra() {
        return chakra;
    }


    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }

    public void setJutsus(Map<String, Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }
}
