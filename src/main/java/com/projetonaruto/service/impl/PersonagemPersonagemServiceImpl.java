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
import com.projetonaruto.service.PersonagemServiceInterface;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonagemPersonagemServiceImpl implements PersonagemServiceInterface {

    private Map<String, Personagem> personagensMap = new HashMap<>();
    private Map<String, String> mapeamento = new HashMap<>();

    @Override
    public Personagem novoPersonagem(NovoPersonagemDto dto) {

        validaDto(dto);

        switch (dto.categoriaNinja().toUpperCase()) {
            case "NINJATAIJUTSU":

                NinjaTaijutsu taijutsu = new NinjaTaijutsu(dto.nome(), dto.idade(), dto.aldeia(),
                        CategoriaNijaEnum.NINJATAIJUTSU);
                personagensMap.put(taijutsu.getNome().toUpperCase(), taijutsu);
                mapeamento.put(taijutsu.getNome(), "NINJATAIJUTSU");
                return taijutsu;

            case "NINJANINJUTSU":
                NinjaNinjutsu ninjutsu = new NinjaNinjutsu(
                        dto.nome(), dto.idade(), dto.aldeia(), CategoriaNijaEnum.NINJANINJUTSU);
                personagensMap.put(ninjutsu.getNome().toUpperCase(), ninjutsu);
                mapeamento.put(ninjutsu.getNome(), "NINJANINJUTSU");
                return ninjutsu;

            case "NINJAGENJUTSU":
                NinjaGenjutsu genjutsu = new NinjaGenjutsu(
                        dto.nome(), dto.idade(), dto.aldeia(), CategoriaNijaEnum.NINJAGENJUTSU);
                personagensMap.put(genjutsu.getNome().toUpperCase(), genjutsu);
                mapeamento.put(genjutsu.getNome(), "NINJAGENJUTSU");
                return genjutsu;

            default:
                Personagem personagem = new Personagem(dto.nome(), dto.idade(), dto.aldeia());
                personagensMap.put(personagem.getNome().toUpperCase(), personagem);
                return personagem;
        }
    }

    @Override
    public Map<String, Personagem> buscar() {
        return personagensMap;
    }

    @Override
    public String usarJutsu(String nomeDoPersonagem) {
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);
        String mensagem = "O personagem não é ninja. Não tem jutsu.";

        if (personagem instanceof NinjaTaijutsu) {
            NinjaTaijutsu ninjutsu = (NinjaTaijutsu) personagem;
            mensagem = ninjutsu.usarJutsu();
        }

        if (personagem instanceof NinjaNinjutsu) {
            NinjaNinjutsu ninjutsu = (NinjaNinjutsu) personagem;
            mensagem = ninjutsu.usarJutsu();
        }

        if (personagem instanceof NinjaGenjutsu) {
            NinjaGenjutsu ninjaGenjutsu = (NinjaGenjutsu) personagem;
            mensagem = ninjaGenjutsu.usarJutsu();
        }
        return mensagem;
    }

    @Override
    public String desviar(String nomeDoPersonagem) {
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);
        String mensagem = "O personagem não é ninja.";

        if (personagem instanceof NinjaTaijutsu) {
            NinjaTaijutsu ninjutsu = (NinjaTaijutsu) personagem;
            mensagem = ninjutsu.desviar();
        }

        if (personagem instanceof NinjaNinjutsu) {
            NinjaNinjutsu ninjutsu = (NinjaNinjutsu) personagem;
            mensagem = ninjutsu.desviar();
        }

        if (personagem instanceof NinjaGenjutsu) {
            NinjaGenjutsu ninjaGenjutsu = (NinjaGenjutsu) personagem;
            mensagem = ninjaGenjutsu.desviar();
        }
        return mensagem;
    }

    @Override
    public Personagem adicionarJutsu(String nome, NovoJutsuDto dto) {
        Personagem personagem = pesquisarPersonagem(nome);

        switch (getInstancia(personagem)) {
            case "NINJATAIJUTSU":
                NinjaTaijutsu taijutsu = (NinjaTaijutsu) personagem;
                taijutsu.adicionarJutsu(new Jutsu(dto.nome(), dto.dano()));
                return personagem;

            case "NINJANINJUTSU":
                NinjaNinjutsu ninjutsu = (NinjaNinjutsu) personagem;
                ninjutsu.adicionarJutsu(new Jutsu(dto.nome(), dto.dano()));
                return personagem;

            case "NINJAGENJUTSU":
                NinjaGenjutsu genjutsu = (NinjaGenjutsu) personagem;
                genjutsu.adicionarJutsu(new Jutsu(dto.nome(), dto.dano()));
                return personagem;
        }
        throw new PersonagemNaoGuerreiroException(
                "O personagem " + nome + " não é ninja, não podendo receber um jutso.");
    }

    @Override
    public Personagem aumentarChakra(String nome, AumentarChakraDto dto) {
        Personagem personagem = pesquisarPersonagem(nome);

        switch (getInstancia(personagem)) {
            case "NINJATAIJUTSU":
                NinjaTaijutsu taijutsu = (NinjaTaijutsu) personagem;
                taijutsu.setChakra(dto.quantidadeDeChakra());
                return personagem;

            case "NINJANINJUTSU":
                NinjaNinjutsu ninjutsu = (NinjaNinjutsu) personagem;
                ninjutsu.setChakra(dto.quantidadeDeChakra());
                return personagem;

            case "NINJAGENJUTSU":
                NinjaGenjutsu genjutsu = (NinjaGenjutsu) personagem;
                genjutsu.setChakra(dto.quantidadeDeChakra());
                return personagem;
        }
        throw new PersonagemNaoGuerreiroException(
                "O personagem " + nome + " não é ninja, não podendo receber Chakras.");
    }

    @Override
    public boolean excluir(String nome){
        Personagem personagem = pesquisarPersonagem(nome);
        personagensMap.remove(personagem.getNome().toUpperCase());
        return true;
    }

    protected Personagem pesquisarPersonagem(String nome) {
        Personagem personagemBuscado = personagensMap.get(nome.toUpperCase());

        if (personagemBuscado != null) {
            return personagemBuscado;
        } else {
            throw new PersonagemNaoCadastradoExcepition("O Personagem " + nome + " não está cadastrado.");
        }
    }

    protected void validaDto(NovoPersonagemDto dto) {

        if (personagensMap.containsKey(dto.nome().toUpperCase())) {
            throw new PersonagemJaCadastradoException("Personagem já cadastrado.");
        }
        System.out.println("Valor =" + dto.categoriaNinja());

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

    protected String getInstancia(Personagem personagem) {

        if (personagem instanceof NinjaTaijutsu) {
            return "NINJATAIJUTSU";
        }

        if (personagem instanceof NinjaNinjutsu) {
            return "NINJANINJUTSU";
        }

        if (personagem instanceof NinjaGenjutsu) {
            return "NINJAGENJUTSU";
        }
        return "PERSONAGEM NÃO NINJA";
    }
}