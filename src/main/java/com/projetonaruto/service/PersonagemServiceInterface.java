package com.projetonaruto.service;

import com.projetonaruto.dto.AumentarChakraDto;
import com.projetonaruto.dto.NovoJutsuDto;
import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.model.Personagem;
import java.util.List;
import java.util.Map;

public interface PersonagemServiceInterface {

    public Personagem novoPersonagem(NovoPersonagemDto novoPersonagem);

    public List<Map<String, ?>> buscar();

    public String usarJutsu(String nomeDoPersonagem);

    public String desviar(String nomeDoPersonagem);

    public Personagem adicionarJutsu(String nome, NovoJutsuDto dto);

    public Personagem aumentarChakra(String nome, AumentarChakraDto dto);

    public boolean excluir(String nome);
}
