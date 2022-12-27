package com.example.curso.boot.domains;

public enum MES {
    JANEIRO("JAN", "Janeiro"),
    FEVEREIRO("FEV", "Fevereiro"),
    MARCO("MAR", "Março"),
    ABRIL("ABR", "Abril"),
    MAIO("MAI", "Maio"),
    JUNHO("JUN", "Junho"),
    JULHO("JUL", "Julho"),
    AGOSTO("AGO", "Aagosto"),
    SETEMBRO("SET", "Setembro"),
    OUTUBRO("OUT", "Outubro"),
    NOVEMBRO("NOV", "Novembro"),
    DEZEMBRO("DEZ", "Dezembro");
    private String sigla;
    private String descricao;

    MES(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}
