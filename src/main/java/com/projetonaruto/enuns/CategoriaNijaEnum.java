package com.projetonaruto.enuns;

public enum CategoriaNijaEnum {
    NINJANINJUTSU,
    NINJAGENJUTSU,
    NINJATAIJUTSU,
    ;

    public static boolean contains(String palavra){
        for(CategoriaNijaEnum e : CategoriaNijaEnum.values()){
            if(e.name().equalsIgnoreCase(palavra)){
                return true;
            }
        }
        return false;
    }

}