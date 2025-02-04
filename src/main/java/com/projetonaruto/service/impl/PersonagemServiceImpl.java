package com.projetonaruto.service.impl;

import com.projetonaruto.dto.AumentarChakraDto;
import com.projetonaruto.dto.NovoJutsuDto;
import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.exceptions.JutsuInvalidoException;
import com.projetonaruto.exceptions.PersonagemJaCadastradoException;
import com.projetonaruto.exceptions.PersonagemNaoCadastradoExcepition;
import com.projetonaruto.exceptions.PersonagemNaoGuerreiroException;
import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.PersonagensNinjas;
import com.projetonaruto.service.PersonagemServiceInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonagemServiceImpl implements PersonagemServiceInterface {

    private Map<String, Personagem> personagensMap = new HashMap<>();
    private Map<String, PersonagensNinjas> ninjaMap = new HashMap<>();

    @Override
    public Personagem novoPersonagem(NovoPersonagemDto dto) {
        validaDto(dto);

        switch (dto.categoriaNinja().toUpperCase()) {
            case "NINJATAIJUTSU":

                PersonagensNinjas taijutsu = new NinjaTaijutsu(dto.nome(), dto.idade(), dto.aldeia(), dto.vida(),
                        CategoriaNijaEnum.NINJATAIJUTSU);
                ninjaMap.put(taijutsu.getNome().toUpperCase(),taijutsu);
                return taijutsu;

            case "NINJANINJUTSU":
                PersonagensNinjas ninjutsu = new NinjaNinjutsu(
                        dto.nome(), dto.idade(), dto.aldeia(), dto.vida(), CategoriaNijaEnum.NINJANINJUTSU);
                ninjaMap.put(ninjutsu.getNome().toUpperCase(),ninjutsu);
                return ninjutsu;

            case "NINJAGENJUTSU":
                NinjaGenjutsu genjutsu = new NinjaGenjutsu(
                        dto.nome(), dto.idade(), dto.aldeia(), dto.vida(), CategoriaNijaEnum.NINJAGENJUTSU);
                ninjaMap.put(genjutsu.getNome().toUpperCase(), genjutsu);
                return genjutsu;

            default:
                Personagem personagem = new Personagem(dto.nome(), dto.idade(), dto.aldeia());
                personagensMap.put(personagem.getNome().toUpperCase(), personagem);
                return personagem;
        }

    }

    @Override
    public List<Map<String, ?>> buscar() {
        List<Map<String, ?>> personagens = new ArrayList<>();
        personagens.add(personagensMap);
        personagens.add(ninjaMap);

        return personagens;
    }

    @Override
    public String usarJutsu(String nomeDoPersonagem) {
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);
        if(personagem instanceof PersonagensNinjas) {
            PersonagensNinjas ninja = (PersonagensNinjas) personagem;
            return ninja.usarJutsu();
        }

        throw new PersonagemNaoGuerreiroException(
                "O personagem " + nomeDoPersonagem + " não consta como ninja no sistem. " +
                        "Assim, não poder ser-lhe adicionado um Jutsu!");

    }

    @Override
    public String desviar(String nomeDoPersonagem) {
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);

        if(personagem instanceof PersonagensNinjas) {
            PersonagensNinjas ninja = (PersonagensNinjas) personagem;
            return ninja.desviar();
        }
        throw new PersonagemNaoGuerreiroException(
                "O personagem " + nomeDoPersonagem + " não é ninja, não podendo usar a função desviar.");
    }

    @Override
    public Personagem adicionarJutsu(String nome, NovoJutsuDto dto) {
        Personagem personagem = pesquisarPersonagem(nome);

        if(personagem instanceof PersonagensNinjas){
            PersonagensNinjas ninja = (PersonagensNinjas) personagem;
            ninja.adicionarJutsu(new Jutsu(dto.nome(), dto.dano(), dto.consumoDeChakra()));
            return ninja;
        } else

        throw new PersonagemNaoGuerreiroException(
                "O personagem " + nome + " não consta como ninja no sistem. " +
                        "Assim, não podendo receber um jutso.");
    }

    @Override
    public Personagem aumentarChakra(String nome, AumentarChakraDto dto) {
        Personagem personagem = pesquisarPersonagem(nome);

        if(personagem instanceof PersonagensNinjas){
            PersonagensNinjas ninja = (PersonagensNinjas) personagem;
            ninja.setChakra(dto.quantidadeDeChakra());
            return ninja;
        }

        throw new PersonagemNaoGuerreiroException(
                "O personagem " + nome + " não consta como ninja no sistem. " +
                        "Assim, não pode receber Chakras.");
    }

    @Override
    public boolean excluir(String nome){
        Personagem personagem = pesquisarPersonagem(nome);
        personagensMap.remove(personagem.getNome().toUpperCase());
        return true;
    }

    protected Personagem pesquisarPersonagem(String nome) {
        Personagem personagemBuscado = personagensMap.get(nome.toUpperCase());
        PersonagensNinjas ninja = ninjaMap.get(nome.toUpperCase());

        if (personagemBuscado != null) {
            return personagemBuscado;
        } else if(ninja != null) {
            return ninja;
        }else{
            throw new PersonagemNaoCadastradoExcepition("O Personagem " + nome + " não está cadastrado.");
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