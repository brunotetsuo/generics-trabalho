package com.mycompany.trabalhogenerics;

public abstract class Produto {

    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Produto: " + nome;
    }
}
