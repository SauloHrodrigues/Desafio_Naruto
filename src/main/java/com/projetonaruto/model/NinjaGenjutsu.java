package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.interfaces.Ninja;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaGenjutsu extends Personagem implements Ninja {

    public NinjaGenjutsu(){
        super();

    }
    public NinjaGenjutsu(String nomeNinja, int idade, String aldeia, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, ninja);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de NinjaGenjutsu.";
    }

    @Override
    public String desviar() {
        return "o personagem está desviando de um ataque usando sua habilidade em NinjaGenjutsu";
    }

    @Override
    public void adicionarJutsu(Jutsu jutsu) {
        adicionarJutso(jutsu);
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


    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

}