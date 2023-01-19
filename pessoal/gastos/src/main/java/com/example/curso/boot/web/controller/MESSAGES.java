package com.example.curso.boot.web.controller;

public enum MESSAGES {
    ATUALIZADO("Atualizado"),
    CADASTRADO("Cadastrado"),
    SUCCESS("success"),
    FAIL("fail"),
    NOTHING("nothing");



    private String message;

    MESSAGES(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
