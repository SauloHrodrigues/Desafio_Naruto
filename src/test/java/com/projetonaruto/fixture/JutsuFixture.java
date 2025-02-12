package com.projetonaruto.fixture;

import com.projetonaruto.model.Jutsu;

public class JutsuFixture {

    public static Jutsu jutsuSocoFixture(){
        return new Jutsu(
                "SOCO",
                10,
                10
        );
    }
    public static Jutsu jutsuChuteFixture(){
        return new Jutsu(
                "CHUTE",
                15,
                20
        );
    }
}
