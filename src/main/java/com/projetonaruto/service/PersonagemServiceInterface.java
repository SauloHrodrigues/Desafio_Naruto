package com.projetonaruto.service;

import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.model.Personagem;
import java.util.Map;

public interface PersonagemServiceInterface {

    public Personagem novoPersonagem(NovoPersonagemDto novoPersonagem);

    public Map<String, Personagem> buscar();

    public String usarJutsu(String nomeDoPersonagem);

    public String desviar(String nomeDoPersonagem);

}
