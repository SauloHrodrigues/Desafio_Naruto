package com.projetonaruto.service.impl;

import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.service.IJogarService;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JogarServiceImpl implements IJogarService {
//
//    private Map<String, NinjaGenjutsu> desafiante = new HashMap<>();
//    private Map<String, NinjaNinjutsu> desafiado = new HashMap<>();
//    private Map<String, NinjaTaijutsu> taijutsu = new HashMap<>();
//
//    @Autowired
//    private PersonagemServiceImpl persService;
//
//    public String novoJogo(String desafiante, String desafiado){
//        Personagem lDesafiante = persService.pesquisarPersonagem(desafiante);
//        Personagem lDesafiado = persService.pesquisarPersonagem(desafiado);
//
//
//
//
//
//        return "Jogo iniciado: ";
//    }
//
//
//
//    public String usarJutsu(String ninja, String oponente, String jutsu) {
//
//
//        return "";
//    }
//
//
//
//    protected void criaJogador(String nomeDoNinja, String posicao){
//        Personagem ninja = persService.pesquisarPersonagem(nomeDoNinja);
//
//        if (ninja instanceof NinjaTaijutsu) {
//            taijutsu.put(posicao,(NinjaTaijutsu) ninja);
//        }
//
//        if (ninja instanceof NinjaNinjutsu) {
//            ninjutsu.put(posicao,(NinjaNinjutsu) ninja);
//
//        }
//
//        if (ninja instanceof NinjaGenjutsu) {
//            genjutsu.put(posicao, (NinjaGenjutsu) ninja);
//
//        }
//    }

}
