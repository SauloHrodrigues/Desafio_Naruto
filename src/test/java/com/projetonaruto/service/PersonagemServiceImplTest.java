package com.projetonaruto.service;

import com.projetonaruto.dto.NovoJutsuDto;
import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.fixture.PersonagemDtoFixture;
import com.projetonaruto.fixture.PersonagemFixture;
import com.projetonaruto.model.Jutsu;
import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.PersonagemNinja;
import com.projetonaruto.service.impl.PersonagemServiceImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonagemServiceImplTest {

    @InjectMocks
    private PersonagemServiceImpl service;

    @Mock
    Map<String, Personagem> personagemMap;

    @Mock
    PersonagemNinja ninja;

    private Personagem personagem;

    @Mock
    Jutsu jutsu;

    @Mock
    NovoJutsuDto novoJutsuDto;

    NovoPersonagemDto personagemDto;
    NovoPersonagemDto ninja01Dto;
    NovoPersonagemDto ninja02Dto;
    NovoPersonagemDto ninja03Dto;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ninja = PersonagemFixture.ninjaNinjutsu("ninjutsu");
        personagemDto = PersonagemDtoFixture.novoPersonagemDto("Personagem Comum");
        ninja01Dto = PersonagemDtoFixture.novoPersonagemNinjaDto("Ninjutsu", "NINJANINJUTSU");
        ninja02Dto = PersonagemDtoFixture.novoPersonagemNinjaDto("Genjutsu", "NINJAGENJUTSU");
        ninja03Dto = PersonagemDtoFixture.novoPersonagemNinjaDto("Taijutsu", "NINJATAIJUTSU");

    }

    @Test
    void deveCriarUmNovoPersonagemComCategoriaVazia() {

        Personagem personagemRetornado = service.novoPersonagem(personagemDto);

        assertTrue(personagemRetornado instanceof Personagem);
        assertEquals(personagemRetornado.getNome(), personagemDto.nome());
        assertEquals(personagemRetornado.getIdade(), personagemDto.idade());
        assertEquals(personagemRetornado.getIdade(), personagemDto.idade());
        assertEquals(personagemRetornado.getAldeia(), personagemDto.aldeia());
    }

    @Test
    void deveCriarUmNovoPersonagemComCategoriaNijaNinjutsu() {
        NovoPersonagemDto dto = PersonagemDtoFixture.novoPersonagemNinjaDto("Ninja", "ninjaNinjutsu");
        Personagem personagemRetornado = service.novoPersonagem(dto);

        assertTrue(personagemRetornado instanceof NinjaNinjutsu);
        assertEquals(personagemRetornado.getNome(), "Ninja");
        assertEquals(personagemRetornado.getAldeia(), dto.aldeia());
        assertEquals(personagemRetornado.getIdade(), dto.idade());
    }

    @Test
    void deveCriarUmNovoPersonagemComCategoriaNinjaGenjutsu() {
        NovoPersonagemDto dto = PersonagemDtoFixture.novoPersonagemNinjaDto("Ninja de Genjutsu", "ninjaGenjutsu");
        Personagem personagemRetornado = service.novoPersonagem(dto);

        assertTrue(personagemRetornado instanceof NinjaGenjutsu);
        assertEquals(personagemRetornado.getNome(), "Ninja de Genjutsu");
        assertEquals(personagemRetornado.getAldeia(), dto.aldeia());
        assertEquals(personagemRetornado.getIdade(), dto.idade());
    }

    @Test
    void deveCriarUmNovoPersonagemComCategoriaNinjaTaijutsuDto() {
        NovoPersonagemDto dto = PersonagemDtoFixture.novoPersonagemNinjaDto("Ninja de Taijutsu", "ninjaTaijutsu");
        Personagem personagemRetornado = service.novoPersonagem(dto);

        assertTrue(personagemRetornado instanceof NinjaTaijutsu);
        assertEquals(personagemRetornado.getNome(), "Ninja de Taijutsu");
        assertEquals(personagemRetornado.getAldeia(), dto.aldeia());
        assertEquals(personagemRetornado.getIdade(), dto.idade());
    }

    @Test
    void deveRetornaTodosOsPersonagens() {
        Personagem personagem = PersonagemFixture.personagemComum("personagem Comum");
        PersonagemNinja ninja01 = PersonagemFixture.ninjaGenjutsu("Genjutsu");
        PersonagemNinja ninja02 = PersonagemFixture.ninjaNinjutsu("ninjutsu");
        PersonagemNinja ninja03 = PersonagemFixture.ninjaTaijutsu("Taijutsu");

        when(personagemMap.values()).thenReturn(Arrays.asList(
                personagem, ninja01, ninja02, ninja03
        ));

        List<Personagem> resposta = service.buscar();

        assertEquals(4, resposta.size());
        assertTrue(resposta.contains(personagem));
        assertTrue(resposta.contains(ninja01));
        assertTrue(resposta.contains(ninja02));
        assertTrue(resposta.contains(ninja03));
    }

    @Test
    void deveUsarJutsuParaNinjaNinjutsu() {
        personagem = PersonagemFixture.ninjaNinjutsu("TESTE");
        PersonagemNinja ninja = (PersonagemNinja) personagem;

        when(personagemMap.get("teste".toUpperCase())).thenReturn(personagem);
        when(service.pesquisarNinjas("teste".toUpperCase())).thenReturn(ninja);
        when(service.pesquisarPersonagem("teste".toUpperCase())).thenReturn(personagem);

        String resposta = service.usarJutsu("TESTE");

        assertEquals("O personagem está usando um jutsu de NinjaNinjutsu.", resposta);
    }

    @Test
    void deveUsarJutsuParaNinjaGenjutsu() {
        personagem = PersonagemFixture.ninjaGenjutsu("TESTE");
        PersonagemNinja ninja = (PersonagemNinja) personagem;

        when(personagemMap.get("teste".toUpperCase())).thenReturn(personagem);
        when(service.pesquisarNinjas("teste".toUpperCase())).thenReturn(ninja);
        when(service.pesquisarPersonagem("teste".toUpperCase())).thenReturn(personagem);

        String resposta = service.usarJutsu("TESTE");
        ;

        assertEquals("O personagem está usando um jutsu de NinjaGenjutsu.", resposta);
    }

    @Test
    void deveUsarJutsuParaNinjaTaijutsu() {
        personagem = PersonagemFixture.ninjaTaijutsu("teste");

        when(personagemMap.get(ArgumentMatchers.anyString())).thenReturn(personagem);
        when(service.pesquisarPersonagem(ArgumentMatchers.anyString())).thenReturn(personagem);
        when(service.pesquisarNinjas(ArgumentMatchers.anyString())).thenReturn((PersonagemNinja) personagem);//

        NinjaTaijutsu resposta = (NinjaTaijutsu) service.pesquisarNinjas("test");

        assertEquals("O personagem está usando um jutsu de NinjaTaijutsu.", resposta.usarJutsu());
    }

    @Test
    void deveDesviarUsandoNinjaNinjutsu() {
        personagem = PersonagemFixture.ninjaNinjutsu("TESTE");
        PersonagemNinja ninja = (PersonagemNinja) personagem;

        when(personagemMap.get("teste".toUpperCase())).thenReturn(personagem);
        when(service.pesquisarNinjas("teste".toUpperCase())).thenReturn(ninja);
        when(service.pesquisarPersonagem("teste".toUpperCase())).thenReturn(personagem);

        String resposta = service.desviar("TESTE");

        assertEquals("O personagem está desviando de um ataque usando sua habilidade em NinjaNinjutsu.",
                resposta);
    }
 @Test
    void deveDesviarUsandoNinjaGenjutsu() {
        personagem = PersonagemFixture.ninjaGenjutsu("TESTE");
        PersonagemNinja ninja = (PersonagemNinja) personagem;

        when(personagemMap.get("teste".toUpperCase())).thenReturn(personagem);
        when(service.pesquisarNinjas("teste".toUpperCase())).thenReturn(ninja);
        when(service.pesquisarPersonagem("teste".toUpperCase())).thenReturn(personagem);

        String resposta = service.desviar("TESTE");

        assertEquals("O personagem está desviando de um ataque usando sua habilidade em NinjaGenjutsu.",
                resposta);
    }
 @Test
    void deveDesviarUsandoNinjaTaijutsu() {
        personagem = PersonagemFixture.ninjaTaijutsu("TESTE");
        PersonagemNinja ninja = (PersonagemNinja) personagem;

        when(personagemMap.get("teste".toUpperCase())).thenReturn(personagem);
        when(service.pesquisarNinjas("teste".toUpperCase())).thenReturn(ninja);
        when(service.pesquisarPersonagem("teste".toUpperCase())).thenReturn(personagem);

        String resposta = service.desviar("TESTE");

        assertEquals("O personagem está desviando de um ataque usando sua habilidade em NinjaTaijutsu.",
                resposta);
    }



}