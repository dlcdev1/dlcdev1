package com.example.curso.boot.web.controller;

public enum MESSAGES {
    ATUALIZADO("Atualizado"),
    CADASTRADO("Cadastrado");

    private String message;

    MESSAGES(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
