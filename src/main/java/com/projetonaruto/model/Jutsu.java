package com.projetonaruto.model;

public class Jutsu {

    private String nome;
    private int dano;
    private int consumoDeChakra;

    public Jutsu(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }

    public void setConsumoDeChakra(int consumoDeChakra) {
        this.consumoDeChakra = consumoDeChakra;
    }
}