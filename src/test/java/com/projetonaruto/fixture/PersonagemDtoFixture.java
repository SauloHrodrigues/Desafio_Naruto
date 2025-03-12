package com.projetonaruto.fixture;

import com.projetonaruto.dto.NovoPersonagemDto;

public class PersonagemDtoFixture {

    public static NovoPersonagemDto novoPersonagemDto(String nome) {
        return new NovoPersonagemDto(
                nome,
                "",
                21,
                "São Paulo"
        );
    }

    public static NovoPersonagemDto novoPersonagemNinjaDto(String nome, String ninja) {
        return new NovoPersonagemDto(
                nome,
                ninja,
                21,
                "São Paulo"
        );
    }
}