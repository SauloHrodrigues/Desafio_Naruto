package com.projetonaruto.service;

import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.exceptions.JutsuInexistenteExcepition;
import com.projetonaruto.exceptions.PersonagemNaoCadastradoExcepition;
import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.NinjaTaijutsu;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NarutoService implements SenviceInterface{

//    private List<Personagem> personagens = new ArrayList<>();
    Map<String, Personagem> personagensMap = new HashMap<>();
    @Override
    public Personagem novoPersonagem(NovoPersonagemDto personagemDto) {

        if(personagemDto.categoriaJutsu() == null || personagemDto.categoriaJutsu() == ""){
            Personagem personagem = new Personagem();
            return criarPesonagem(personagem, personagemDto);
        }

        if(personagemDto.categoriaJutsu().equalsIgnoreCase("nijaTaijutsu")){
            Personagem personagem = new NinjaTaijutsu();
            personagem.adicionarJutsu("TAIJUTSU");
            return criarPesonagem(personagem, personagemDto);
        }

        if(personagemDto.categoriaJutsu().equalsIgnoreCase("NinjaGenjutsu")){
            Personagem personagem = new NinjaGenjutsu();
            personagem.adicionarJutsu("GENJUTSU");
            return criarPesonagem(personagem, personagemDto);
        }

        if(personagemDto.categoriaJutsu().equalsIgnoreCase("NinjaNinjutsu")){
            Personagem personagem = new NinjaNinjutsu();
            personagem.adicionarJutsu("NINJUTSU");
            return criarPesonagem(personagem, personagemDto);
        }

       throw new JutsuInexistenteExcepition("A categoria de jutsu '" + personagemDto.categoriaJutsu()
       + "', não existe. ");
    }

    @Override
    public Map<String, Personagem> buscar() {
        return personagensMap;
    }

    @Override
    public String usarJutsu(String nomeDoPersonagem){
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);
            return("O personagem encontrado foi: " + personagem +
                    "e "+ personagem.usarJutsu());
    }

    @Override
    public String desviar(String nomeDoPersonagem){
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);
        return("O personagem encontrado foi: " + personagem +
                "e "+ personagem.desviar());
    }

    private  Personagem pesquisarPersonagem(String nome){
        Personagem personagemBuscado = personagensMap.get(nome.toUpperCase());

        if (personagemBuscado != null) {
            return personagemBuscado;
        } else {
            throw new PersonagemNaoCadastradoExcepition("O Personagem "+ nome + " não está cadastrado.");
        }
    }

    private Personagem criarPesonagem(Personagem personagem, NovoPersonagemDto personagemDto){

        if (personagensMap.containsKey(personagem.getNome())) {
            System.out.println("Personagem com o nome '" + personagem.getNome() + "' já existe e não será adicionado.");
        } else {
            personagem.setNome(personagemDto.nome());
            personagem.setIdade(personagemDto.idade());
            personagem.setAldeia(personagemDto.aldeia());
            personagem.setChakra(personagemDto.chakra());

            personagensMap.put(personagem.getNome().toUpperCase(), personagem);
        }
        return personagem;
    }
}