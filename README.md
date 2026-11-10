# Trabalho III - Generics

Projeto desenvolvido para demonstrar o uso de Generics em Java em um sistema
simples de depósitos de produtos.

## Requisitos

- JDK 24 ou superior;
- Apache Maven instalado e configurado no `PATH`.

A versão do Java está configurada no arquivo `pom.xml` por meio de
`maven.compiler.release`.

## Estrutura da solução

- `Produto`: superclasse dos produtos;
- `Eletronico`, `Alimento` e `Vestuario`: tipos específicos de produtos;
- `Deposito<T extends Produto>`: depósito genérico que aceita somente produtos;
- `OperacoesDeposito`: operações genéricas de busca, transferência e listagem;
- `Main`: demonstração da utilização dos três tipos de depósitos.

## Conceitos demonstrados

- Classes genéricas com tipo limitado (`T extends Produto`);
- Segurança de tipos em tempo de compilação;
- Uso de `Optional<T>` para obter e retirar itens;
- Método genérico `buscarPorNome`;
- Wildcards e regra PECS na transferência:
  `Deposito<? extends T>` e `Deposito<? super T>`;
- Wildcard não limitado em `listarConteudo(Deposito<?> deposito)`.

O código abaixo não compila propositalmente, pois um alimento não pode ser
adicionado a um depósito de eletrônicos:

```java
depositoDeEletronicos.adicionarItem(new Alimento("Maçã"));
```

## Como compilar

Na pasta raiz do projeto, execute:

```bash
mvn clean package
```

## Como executar

Após a compilação, execute:

```bash
java -cp target/classes com.mycompany.trabalhogenerics.Main
```

## Resultado esperado

O programa demonstra:

- busca de um produto existente;
- tratamento de produto não encontrado;
- transferência de um eletrônico para um depósito geral;
- listagem dos depósitos de eletrônicos, alimentos e vestuário;
- ausência de casts explícitos na retirada dos itens.
