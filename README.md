# Banco BlueBank

## Projeto Final

Desenvolvedores:
Carlos Augusto Betiol Ramos
Cassiano Augusto da Silva
JONAS WILLIAM DE LIMA SANTOS
Taisis Marinelo
Weslley Lima
Richardson Andrade

## BlueBank

### Objetivo:

    Criar microserviço com Amazon API Gateway usando
    com dados relacional MySQL.

    Abaixo maiores detalhoes

---
### Tecnologia utilizadas:
    - Java 11
    - Serverless Framework
    - AWS Lambda
    - AWS MySQL
    - AWS ApiGateway

---

### Funcinalidades

    1. Agencia 
        - Listar todas Agencias
        - Gravar Agencia 
        - Buscar Agencia exclusiva por id de identificação
        - Atualizar Agencia pelo id
        - Deleta Agencia pelo id
    2. Conta
        - Listar todas Contas
        - Gravar Conta
        - Buscar Conta exclusiva por id de identificação
        - Atualizar Conta pelo id
        - Deleta Conta pelo id
    3. Correntista
        - Listar todas Correntistas
        - Gravar Correntista
        - Buscar Correntista exclusiva por id de identificação
        - Atualizar Correntista pelo id
        - Deleta Correntista pelo id
        - Buscar Contato de Correntista exclusivo por id de identificação
        - Gravar Contato de Correntista pelo id
        - Deleta Contato de Correntista pelo id
        - Buscar Endereço de Correntista exclusiva por id de identificação
        - Gravar Endereço de Correntista pelo id
    4. Movimentacao
        - Listar todas Movimentacao
        - Gravar Movimentacao
        - Buscar Movimentacao exclusiva por id de identificação
        - Atualizar Movimentacao pelo id
        - Deleta Movimentacao pelo id

### TABELA DE ENDPOINT

HTTP METHOD | ENDPOINT | NO PARAMETERS & BODY | FUNÇÃO
 --------|-----|---|---|
GET | /agencias | NÃO & NÃO | Listar todas Agencias retorno Response Body
POST | /agencias | SIM & SIM | Gravar Agencia Response Body
GET | /agencias/{id} | SIM & SIM  | Buscar Agencia exclusiva por id de identificação (PATH)
PUT | /agencias/{id} | SIM & SIM | Atualizar Agencia pelo id por id de identificação (PATH)
DELETE | /agencias/{id} | SIM & NÃO | Deleta Agencia pelo id por id de identificação (PATH)
GET | /contas | NÃO & NÃO | Listar todas Contas Response Body
POST | /contas | SIM & SIM | Gravar Conta Response Body
GET | /contas/{id} | SIM & SIM| Buscar Conta exclusiva por id de identificação (PATH)
PUT | /contas/{id} |  SIM & SIM | Atualizar Conta pelo id por id de identificação (PATH)
DELETE | /contas/{id} | SIM & NÃO |  Deleta Conta pelo id por id de identificação (PATH)
GET | /correntistas| NÃO & NÃO | Listar todas Correntistas Response Body
POST | /correntistas | SIM & SIM | Gravar Correntista Response Body
GET | /correntistas/{id} | SIM & SIM  | Buscar Correntista exclusiva por id de identificação (PATH)
PUT | /correntistas/{id} |  SIM & SIM | Atualizar Correntista pelo id por id de identificação (PATH)
DELETE | /correntistas/{id} | SIM & NÃO |  Deleta Correntista pelo id por id de identificação (PATH)
GET | /correntistas/{id}/contatos | SIM & SIM  | Buscar Contato de Correntista exclusivo por id de identificação (PATH)
POST | /correntistas/{id}/contatos | SIM & SIM | Gravar Contato de Correntista exclusivo por id de identificação (PATH)
DELETE | /correntistas/{id}/contatos/{contatoId} | SIM & NÃO |  Deleta Contato de Correntista exclusivo por id de identificação (PATH)
GET |/correntistas/{id}/enderecos | SIM & SIM  | Buscar Endereços de Correntista exclusivo por id de identificação (PATH)
POST | /correntistas/{id}/enderecos | SIM & SIM | Gravar Endereço de Correntista exclusivo por id de identificação (PATH)
DELETE | /correntistas/{id}/enderecos/{enderecoId} | SIM & NÃO |  Deleta Endereço de Correntista exclusivo por id de identificação (PATH)
GET | /movimentacoes | NÃO & NÃO | Listar todas Movimentações retorno no Response Body
POST | /movimentacoes | SIM & SIM | Gravar Movimentações retorno no Response Body
GET | /movimentacoes/{id} | SIM & SIM  | Buscar Movimentação exclusiva por id de identificação (PATH)
PUT | /movimentacoes/{id} | SIM & SIM | Atualizar Movimentação pelo id por id de identificação (PATH)
DELETE | /movimentacoes/{id} | SIM & NÃO | Deleta Movimentação pelo id por id de identificação (PATH)


---

## Criar um projeto com aws-lambda

Com o comando abaixo vai ser criado um projeto padrão para criar a lambda
com framework Serverless Framework (https://www.serverless.com/)

 ~~~bash
  $ serverless create --template aws-java-maven --name nomedoseuservico
 ~~~

Após a implementação, configuração das credencias e região da AWS para fazer o
deploy basta:

~~~bash
$ serverless deploy
~~~

Para testar sua lambda localmente:

~~~bash
$ serverless invoke local -f nomedasuafuncao 
~~~
