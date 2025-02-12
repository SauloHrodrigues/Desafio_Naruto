package com.projetonaruto.interfaces;

import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.PersonagemNinja;

public interface Ninja {

    public String usarJutsu();

    public void usarJutsu(Jutsu jutsu, PersonagemNinja inimigo);

    public  String desviar();

    public String desviar(int danoRecebido);

}