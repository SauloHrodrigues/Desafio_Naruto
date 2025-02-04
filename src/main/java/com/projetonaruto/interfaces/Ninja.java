package com.projetonaruto.interfaces;

import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.PersonagensNinjas;

public interface Ninja {

    public String usarJutsu();
    public void usarJutsu(Jutsu jutsu, PersonagensNinjas inimigo);

    public  String desviar();

    public String desviar(int danoRecebido);


}