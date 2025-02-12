package com.projetonaruto.service;

import com.projetonaruto.enuns.CategoriaNijaEnum;
import com.projetonaruto.fixture.JutsuFixture;
import com.projetonaruto.fixture.PersonagemDtoFixture;
import com.projetonaruto.fixture.PersonagemFixture;
import com.projetonaruto.model.JogoSessao;
import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.PersonagemNinja;
import com.projetonaruto.service.impl.JogarServiceImpl;
import com.projetonaruto.service.impl.PersonagemServiceImpl;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JogarServiceImplTest {

    @InjectMocks
    private JogarServiceImpl jogarService;

    @Mock
    PersonagemServiceImpl personagemService;

    @Mock
    private JogoSessao jogo;

    private PersonagemNinja jogador01;

    private PersonagemNinja jogador02;

    private Jutsu jutsuSoco;
    private Jutsu jutsuChute;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        jogador01 = PersonagemFixture.ninjaComJutsu("ninja01","soco");
        jogador02 = PersonagemFixture.ninjaComJutsu("ninja02","chute");
        jutsuSoco = JutsuFixture.jutsuSocoFixture();
        jutsuChute = JutsuFixture.jutsuChuteFixture();
    }

    @Test
    void deveCriarUmNovoJogo() {
        Mockito.when(personagemService.pesquisarNinjas("ninja01")).thenReturn(jogador01);
        Mockito.when(personagemService.pesquisarNinjas("ninja02")).thenReturn(jogador02);
        String resultado = jogarService.novoJogo("ninja01", "ninja02");

        assertEquals("Iniciada a batalha entre: "+jogador01.getNome().toUpperCase()+
                " X "+jogador02.getNome().toUpperCase(),resultado);

        Mockito.verify(personagemService).pesquisarNinjas("ninja01");
        Mockito.verify(personagemService).pesquisarNinjas("ninja02");
    }

}