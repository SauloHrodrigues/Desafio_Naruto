package com.projetonaruto.interfaces;

import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.Personagem;

public interface Ninja {

    public String usarJutsu();
    public void usarJutsu(String nomeJutsu, Personagem inimigo);

    public  String desviar();

    public void desviar(int danoRecebido);

    public void adicionarJutsu(Jutsu jutsu);
}