package com.projetonaruto.enuns;

public enum CategoriaJutsuEnum {
    NINJUTSU,
    GENJUTSU,
    TAIJUTSU,
    ;

    public static CategoriaJutsuEnum fromString(String value) {
        try {
            return CategoriaJutsuEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Jutsu inválido: " + value);
        }
    }
}