package com.example.curso.boot.domains;

import java.time.Month;

public enum MES {
    JANEIRO(Month.JANUARY),
    FEVEREIRO(Month.FEBRUARY),
    MARCO(Month.MARCH),
    ABRIL(Month.APRIL),
    MAIO(Month.MAY),
    JUNHO(Month.JUNE),
    JULHO(Month.JULY),
    AGOSTO(Month.AUGUST),
    SETEMBRO(Month.SEPTEMBER),
    OUTUBRO(Month.OCTOBER),
    NOVEMBRO(Month.NOVEMBER),
    DEZEMBRO(Month.DECEMBER);

    private final Month descricao;

    MES(Month descricao) {
        this.descricao = descricao;
    }

    public Month getDescricao() {
        return descricao;
    }
}
