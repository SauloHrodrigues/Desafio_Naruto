package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import java.util.HashMap;
import java.util.Map;

public class Personagem  {

    private String nome;
    private int idade;
    private String aldeia;
    protected Map<String, Jutsu> jutsus;
    protected int chakra;
    private CategoriaNijaEnum ninja;

    public Personagem(){

    }

    public Personagem(String nome, int idade, String aldeia) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
    }

    public Personagem(String nomeNinja, int idade, String aldeia, CategoriaNijaEnum ninja) {
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


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public CategoriaNijaEnum getNinja() {
        return ninja;
    }

    protected void adicionarJutso(Jutsu jutsu){
        jutsus.put(jutsu.getNome(), jutsu);
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