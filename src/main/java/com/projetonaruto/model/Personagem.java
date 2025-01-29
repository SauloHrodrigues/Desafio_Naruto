package com.projetonaruto.model;

import java.util.HashMap;
import java.util.Map;

public class Personagem  {

    private String nome;
    private int idade;
    private String aldeia;
    protected Map<String, Jutsu> jutsus;
    protected int chakra;
    private boolean ninja = false;

    public Personagem(String nome, int idade, String aldeia) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
    }

    public Personagem(String nomeNinja, int idade, String aldeia, boolean ninja) {
        this.nome = nomeNinja;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus = new HashMap<>();
        this.chakra = 100;
        this.ninja = ninja;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getAldeia() {
        return aldeia;
    }

    public boolean isNinja() {
        return ninja;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome= " + nome +
                ", idade= " + idade +
                ", aldeia= " + aldeia +
                " chakra= " + chakra +
                ", jutsus=" + jutsus +
        '}';
    }
}