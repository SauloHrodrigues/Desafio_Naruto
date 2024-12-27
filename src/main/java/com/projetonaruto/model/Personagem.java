package com.projetonaruto.model;

import java.util.ArrayList;
import java.util.List;

public class Personagem {

    private Long id;
    private String nome;
    private int idade;
    private String aldeia;
    private List<String> jutsus = new ArrayList<>();
    private int chakra;

    public Personagem(String nome, int idade, String aldeia, String jutsus, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus.add(jutsus);
        this.chakra = chakra;
    }

    public boolean adicionarJutsu(String jutsu){
        try {
            jutsus.add(jutsu);
        }catch (RuntimeException e){
            return false;
        }
        return true;
    }

    public boolean aumentarChakra(int chakra){
        this.chakra += chakra;
        return true;
    }

    @Override
    public String toString() {
        return "Personagem{" + " - " +
                "id: "+ id + " - " +
                "nome: '" + nome + " - " +
                ", idade: " + idade + " - " +
                ", aldeia: '" + aldeia + " - " +
                ", jutsus: " + jutsus + " - " +
                ", chakra: " + chakra +
                "}";
    }
}
