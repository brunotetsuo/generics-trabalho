package com.mycompany.trabalhogenerics;

public class Main {
    public static void main(String[] args) {
        Deposito<Eletronico> depositoDeEletronicos = new Deposito<>();
        Deposito<Alimento> depositoDeAlimentos = new Deposito<>();
        Deposito<Vestuario> depositoDeVestuarios = new Deposito<>();

        depositoDeEletronicos.adicionarItem(new Eletronico("Notebook"));
        depositoDeEletronicos.adicionarItem(new Eletronico("Relógio"));
        depositoDeEletronicos.adicionarItem(new Eletronico("Celular"));

        // O erro acontece aqui! Um alimento foi adicionado por engano.
        // Erro no momento de compilação devido ao tipo Alimento. Se remover o comentário abaixo o codigo não compila.
        // depositoDeEletronicos.adicionarItem(new Alimento("Maçã"));

        // Busca pelo item por nome
        depositoDeEletronicos.buscarPorNome("Relógio")
                .ifPresent(item ->
                        System.out.println("Item encontrado: " + item.getNome())
                );

        // Aqui não vai encontrar porque não tem item com o nome de Mouse
        depositoDeEletronicos.buscarPorNome("Mouse")
                .ifPresentOrElse(item ->
                        System.out.println("Item encontrado: " + item.getNome())
                , () -> System.out.println("Item não encontrado"));

        Deposito<Produto> depositoGeral = new Deposito<>();

        // Aqui esta trasferindo um produto no indice zero da lista de eletronicos para a lista geral.
        // Ele retorna true se deu certo a transferencia e false para quando der algum erro.
        boolean transferiu = OperacoesDeposito.transferir(
                depositoDeEletronicos,
                depositoGeral,
                0
        );

        System.out.println("Transferência realizada: " + transferiu);

        depositoGeral.obterItem(0)
                .ifPresent(produto ->
                        System.out.println("Produto transferido : " + produto.getNome())
                );

        System.out.println();

        depositoDeAlimentos.adicionarItem(new Alimento("Maçã"));
        depositoDeAlimentos.adicionarItem(new Alimento("Arroz"));

        depositoDeVestuarios.adicionarItem(new Vestuario("Camiseta"));

        // Listagem dos produtos na lista de eletronicos
        System.out.println("Listagem de Eletronicos");
        OperacoesDeposito.listarConteudo(depositoDeEletronicos);

        System.out.println();

        // Listagem dos produtos na lista de alimentos
        // Usamos o mesmo metodo que foi usado na listagem de eletronicos.
        System.out.println("Listagem de Alimentos");
        OperacoesDeposito.listarConteudo(depositoDeAlimentos);

        System.out.println();

        // Listagem dos produtos na lista de vestuarios
        // Usamos o mesmo metodo que foi usado na listagem de eletronicos e alimentos.
        System.out.println("Listagem de Vestuarios");
        OperacoesDeposito.listarConteudo(depositoDeVestuarios);
    }
}