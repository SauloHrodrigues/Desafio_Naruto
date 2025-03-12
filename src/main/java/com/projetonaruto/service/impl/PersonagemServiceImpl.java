package com.projetonaruto.service.impl;

import com.projetonaruto.dto.AumentarChakraDto;
import com.projetonaruto.dto.NovoJutsuDto;
import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.exceptions.JutsuInvalidoException;
import com.projetonaruto.exceptions.PersonagemJaCadastradoException;
import com.projetonaruto.exceptions.PersonagemNaoCadastradoExcepition;
import com.projetonaruto.exceptions.PersonagemNaoENinjaException;
import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.PersonagemNinja;
import com.projetonaruto.service.PersonagemServiceInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonagemServiceImpl implements PersonagemServiceInterface {

    private Map<String, Personagem> personagensMap = new HashMap<>();
    private int vidasParaNinjas = 2;
    public PersonagemServiceImpl() {
    }

    @Override
    public Personagem novoPersonagem(NovoPersonagemDto dto) {
        validaDto(dto);

        switch (dto.categoriaNinja().toUpperCase()) {
            case "NINJATAIJUTSU":
                PersonagemNinja taijutsu = new NinjaTaijutsu(dto.nome(), dto.idade(), dto.aldeia(), vidasParaNinjas,
                        CategoriaNijaEnum.NINJATAIJUTSU);
                personagensMap.put(taijutsu.getNome().toUpperCase(), taijutsu);
                return taijutsu;

            case "NINJANINJUTSU":
                PersonagemNinja ninjutsu = new NinjaNinjutsu(
                        dto.nome(), dto.idade(), dto.aldeia(), vidasParaNinjas, CategoriaNijaEnum.NINJANINJUTSU);
                personagensMap.put(ninjutsu.getNome().toUpperCase(), ninjutsu);
                return ninjutsu;

            case "NINJAGENJUTSU":
                NinjaGenjutsu genjutsu = new NinjaGenjutsu(
                        dto.nome(), dto.idade(), dto.aldeia(), vidasParaNinjas, CategoriaNijaEnum.NINJAGENJUTSU);
                personagensMap.put(genjutsu.getNome().toUpperCase(), genjutsu);
                return genjutsu;

            default:
                Personagem personagem = new Personagem(dto.nome(), dto.idade(), dto.aldeia());
                personagensMap.put(personagem.getNome().toUpperCase(), personagem);
                return personagem;
        }
    }

    @Override
    public List<Personagem> buscar() {
        List<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(personagensMap.values());

        return todosPersonagens;
    }

    @Override
    public String usarJutsu(String nomeDoPersonagem) {
        PersonagemNinja ninja = pesquisarNinjas(nomeDoPersonagem);
        return ninja.usarJutsu();
    }

    @Override
    public String desviar(String nomeDoPersonagem) {
        PersonagemNinja ninja = pesquisarNinjas(nomeDoPersonagem);
        return ninja.desviar();
    }

    @Override
    public Personagem adicionarJutsu(String nome, NovoJutsuDto dto) {
        PersonagemNinja ninja = pesquisarNinjas(nome);
        ninja.adicionarJutsu(new Jutsu(dto.nome(), dto.dano(), dto.consumoDeChakra()));
        return ninja;
    }

    @Override
    public Personagem aumentarChakra(String nome, AumentarChakraDto dto) {
        PersonagemNinja ninja = pesquisarNinjas(nome);
        return ninja;
    }

    @Override
    public boolean excluir(String nome) {
        Personagem personagem = pesquisarPersonagem(nome);
        personagensMap.remove(personagem.getNome().toUpperCase());
        return true;
    }

    public PersonagemNinja pesquisarNinjas(String nome) {
        Personagem personagem = pesquisarPersonagem(nome);

        if (personagem instanceof PersonagemNinja) {
            PersonagemNinja ninja = (PersonagemNinja) personagem;
            return ninja;
        } else {
            throw new PersonagemNaoENinjaException("O personagem " +
                    nome.toUpperCase() + " não é ninja. Assim, não tem permissão para lutar.");
        }
    }

    public Personagem pesquisarPersonagem(String nome) {
        Personagem personagemBuscado = personagensMap.get(nome.toUpperCase());

        if (personagemBuscado != null) {
            return personagemBuscado;
        } else {
            throw new PersonagemNaoCadastradoExcepition("O Personagem " + nome +
                    " não está cadastrado no sistema.");
        }
    }

    protected void validaDto(NovoPersonagemDto dto) {

        if (personagensMap.containsKey(dto.nome().toUpperCase())) {
            throw new PersonagemJaCadastradoException("Personagem já cadastrado.");
        }

        if (dto.categoriaNinja() == null) {
            throw new JutsuInvalidoException("ATENÇÃO!!! Caso personagem não seja ninja," +
                    " Por favor, enviar a vaiável, categoriaNinja, vazia(\"\") no dto.");
        }

        if (CategoriaNijaEnum.contains(dto.categoriaNinja().toUpperCase()) || dto.categoriaNinja().isEmpty()) {

        } else {
            throw new JutsuInvalidoException("O ninja " + dto.categoriaNinja().toUpperCase()
                    + " não pertence ao rol cadastrado no sistema");
        }
    }
}