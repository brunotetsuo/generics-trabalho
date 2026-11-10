package com.mycompany.trabalhogenerics;

import java.util.Optional;

public class OperacoesDeposito {

    public static <T extends Produto> boolean transferir(
            Deposito<? extends T> origem,
            Deposito<? super T> destino,
            int index) {

        Optional<? extends T> item = origem.retirarItem(index);

        if (item.isEmpty()) {
            return false;
        }

        destino.adicionarItem(item.get());
        return true;
    }

    public static void listarConteudo(Deposito<?> deposito) {

        for (int i = 0; i < deposito.getQuantidade(); i++) {

            deposito.obterItem(i)
                    .ifPresent(produto ->
                            System.out.println(produto.getNome())
                    );
        }
    }
}
