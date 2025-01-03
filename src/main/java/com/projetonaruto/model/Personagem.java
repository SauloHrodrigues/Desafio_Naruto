package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaJutsuEnum;
import java.util.ArrayList;
import java.util.List;


public class Personagem  {

    private String nome;
    private int idade;
    private String aldeia;
    private List<CategoriaJutsuEnum> jutsuses = new ArrayList<>();
    private int chakra;

    public Personagem(String nome, int idade, String aldeia, CategoriaJutsuEnum jutsus, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsuses.add(jutsus);
        this.chakra = chakra;
    }

    public boolean adicionarJutsu(CategoriaJutsuEnum categoriaJutsuEnum){
        try {
            jutsuses.add(categoriaJutsuEnum);
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
                "nome: '" + nome + " - " +
                ", idade: " + idade + " - " +
                ", aldeia: '" + aldeia + " - " +
                ", jutsuses: " + jutsuses + " - " +
                ", chakra: " + chakra +
                "}";
    }
}
