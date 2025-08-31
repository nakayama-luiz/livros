package com.example.orliv.domain.enums;

import lombok.Getter;


@Getter
public enum Language {
    PT("Português"),
    EN("Inglês"),
    DE("Alemão"),
    FR("Francês"),
    JA("Japonês"),
    ZH("Chinês"),
    ES("Espanhol"),
    IT("Italiano"),
    RU("Russo"),
    AR("Árabe");

    private final String nome;

    Language(String nome) {
        this.nome = nome;
    }

}
