package com.mycompany.trabalhogenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Deposito<T extends Produto> {

    private List<T> itens = new ArrayList<>(); // Usa List sem tipo!

    public void adicionarItem(T item) {
        this.itens.add(item);
    }

    public Optional<T> obterItem(int index) {
        if (index >= 0 && index < this.itens.size()) {
            return Optional.of(this.itens.get(index));
        }
        return Optional.empty();
    }

    public Optional<T> buscarPorNome(String nome) {
        for (T item : this.itens) {
            if (item.getNome().equals(nome)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<T> retirarItem(int index) {

        if (index < 0 || index >= itens.size()) {
            return Optional.empty();
        }

        return Optional.of(itens.remove(index));
    }

    public int getQuantidade() {
        return itens.size();
    }
}
