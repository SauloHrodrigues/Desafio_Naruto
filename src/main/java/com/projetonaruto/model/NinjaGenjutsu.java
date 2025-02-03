package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.exceptions.ChakrasInsuficientesException;
import com.projetonaruto.interfaces.Ninja;
import java.util.Map;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaGenjutsu extends Personagem implements Ninja {

    public NinjaGenjutsu(){
        super();

    }
    public NinjaGenjutsu(String nomeNinja, int idade, String aldeia, int vida, CategoriaNijaEnum ninja) {
        super(nomeNinja, idade, aldeia, vida, ninja);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de NinjaGenjutsu.";
    }

    @Override
    public void usarJutsu(String nomeJutsu, Personagem inimigo) {
        Jutsu jutsu = getJutsus().get(nomeJutsu);
        if (jutsu == null) {
            System.out.println(getNome() + " tentou usar " + nomeJutsu + "," +
                    " mas ele não conhece esse jutsu!");
            return;
        }


        if (getChakra() < jutsu.getConsumoDeChakra()) {
            throw new ChakrasInsuficientesException("Não há chakra suficientes para usar o" +
                    " jutsu "+ nomeJutsu);
        }

        // Reduz o chakra e causa dano
        setChakra(getChakra() - jutsu.getConsumoDeChakra());
        System.out.println(getNome() + " usa o jutsu " + nomeJutsu + " causando " +
                jutsu.getDano() + " de dano!");
//        inimigo.desviar(jutsu.getDano());
    }

    @Override
    public String desviar() {
        return "o personagem está desviando de um ataque usando sua habilidade em NinjaGenjutsu";
    }

    @Override
    public void desviar(int danoRecebido) {

        Random random = new Random();
        boolean desviou = random.nextBoolean();

        if (desviou) {
            desviar();
        } else {
            setVida(getVida() - danoRecebido);
            System.out.println(getNome() + " não conseguiu desviar e perdeu " + danoRecebido + " de vida!");
        }
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

    public int getVida(){
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }
}