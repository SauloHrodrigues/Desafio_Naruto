package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.exceptions.ChakrasInsuficientesException;
import com.projetonaruto.interfaces.Ninja;
import java.util.Map;
import java.util.Random;

public class PersonagensNinjas extends Personagem implements Ninja{
    public PersonagensNinjas(String nomeNinja, int idade, String aldeia, int vida, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, vida, ninja);
    }

    @Override
    public String usarJutsu() {
        return null;
    }

    @Override
    public void usarJutsu(Jutsu jutsu, PersonagensNinjas inimigo) {

         if (getChakra() < jutsu.getConsumoDeChakra()) {
            throw new ChakrasInsuficientesException("Não há chakra suficientes para usar o" +
                    " jutsu "+ jutsu.getNome());
        }

        setChakra(getChakra() - jutsu.getConsumoDeChakra());
         inimigo.desviar(jutsu.getDano());
    }

    @Override
    public String desviar() {
        return null;
    }

    @Override
    public String desviar(int danoRecebido) {
        Random random = new Random();
        boolean desviou = random.nextBoolean();

        if (desviou) {
            return desviar();
        } else {
            setVida(getVida() - danoRecebido);
            return getNome() + " não conseguiu desviar e perdeu " + danoRecebido + " de vida!";
        }
    }

     public void adicionarJutsu(Jutsu jutsu) {
        jutsus.put(jutsu.getNome(),jutsu);
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

    public int getVida(){
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "PersonagensNinjas{" +
                "chakra=" + chakra +
                "} " ;
    }
}
