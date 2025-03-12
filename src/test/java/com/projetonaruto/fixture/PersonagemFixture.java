package com.projetonaruto.fixture;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.PersonagemNinja;
import java.util.ArrayList;
import java.util.List;

public class PersonagemFixture {

    public static Personagem personagemComum(String nome) {
        return new Personagem(
                nome,
                21,
                "Campinas"
        );
    }

    public static PersonagemNinja ninjaNinjutsu(String nome) {
        return new NinjaNinjutsu(
                nome,
                21,
                "Campinas",
                10,
                CategoriaNijaEnum.NINJANINJUTSU
        );
    }

    public static PersonagemNinja ninjaGenjutsu(String nome) {
        return new NinjaGenjutsu(
                nome,
                21,
                "Campinas",
                10,
                CategoriaNijaEnum.NINJAGENJUTSU
        );
    }

    public static PersonagemNinja ninjaTaijutsu(String nome) {
        return new NinjaTaijutsu(
                nome,
                21,
                "Campinas",
                10,
                CategoriaNijaEnum.NINJATAIJUTSU
        );
    }

    public static PersonagemNinja ninjaComJutsu(String nome, String nomeJutsu) {
        PersonagemNinja ninja = new NinjaTaijutsu(
                nome,
                21,
                "Campinas",
                10,
                CategoriaNijaEnum.NINJATAIJUTSU
        );

        if (nomeJutsu.toUpperCase().equals("SOCO")){
            ninja.adicionarJutsu(JutsuFixture.jutsuSocoFixture());
        } else {
            ninja.adicionarJutsu(JutsuFixture.jutsuChuteFixture());
        }
        return ninja;
    }

    public static List<Personagem> personagensLista() {
        List<Personagem> personagemList = new ArrayList<>();
        personagemList.add(ninjaGenjutsu("Genjutsu"));
        personagemList.add(ninjaNinjutsu("Ninjutsu"));
        personagemList.add(ninjaTaijutsu("Taijutsu"));
        personagemList.add(personagemComum("Personagem Comum"));

        return personagemList;
    }
}