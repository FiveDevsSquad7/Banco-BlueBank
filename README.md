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
    - Spring Boot: Spring Data & Spring Security
    - MAVEN
    - Swagger
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

## Esquema JSON Documentação Swagger

# Definições

- #  Agencia
- _Entidade entitulada Agencia_
- Type: `object`
- <i id="#/definitions/ Agencia">path: #/definitions/ Agencia</i>
- **_Properties_**
    - <b id="#/definitions/ Agencia/properties/agencia">agencia</b>
        - _Campo referente nome juridico da Agencia_
        - Type: `string`
        - <i id="#/definitions/ Agencia/properties/agencia">path: #/definitions/ Agencia/properties/agencia</i>
    - <b id="#/definitions/ Agencia/properties/dataCadastro">dataCadastro</b>
        - _Campo referente data da criação_
        - Type: `string`
        - <i id="#/definitions/ Agencia/properties/dataCadastro">path: #/definitions/ Agencia/properties/dataCadastro</i>
        - String format must be a "date-time"
    - <b id="#/definitions/ Agencia/properties/id">id</b>
        - _Campo ID_
        - Type: `integer`
        - <i id="#/definitions/ Agencia/properties/id">path: #/definitions/ Agencia/properties/id</i>
    - <b id="#/definitions/ Agencia/properties/nome">nome</b>
        - _Campo referente nome fantasia da Agencia_
        - Type: `string`
        - <i id="#/definitions/ Agencia/properties/nome">path: #/definitions/ Agencia/properties/nome</i>

# AgenciaOutputDTO
- Type: `object`
- <i id="#/definitions/AgenciaOutputDTO">path: #/definitions/AgenciaOutputDTO</i>
- **_Properties_**
    - <b id="#/definitions/AgenciaOutputDTO/properties/agencia">agencia</b>
        - Type: `string`
        - <i id="#/definitions/AgenciaOutputDTO/properties/agencia">path: #/definitions/AgenciaOutputDTO/properties/agencia</i>
    - <b id="#/definitions/AgenciaOutputDTO/properties/id">id</b>
        - Type: `integer`
        - <i id="#/definitions/AgenciaOutputDTO/properties/id">path: #/definitions/AgenciaOutputDTO/properties/id</i>
    - <b id="#/definitions/AgenciaOutputDTO/properties/nome">nome</b>
        - Type: `string`
        - <i id="#/definitions/AgenciaOutputDTO/properties/nome">path: #/definitions/AgenciaOutputDTO/properties/nome</i>

# Conta
- _Entidade entitulada Conta_
- Type: `object`
- <i id="#/definitions/Conta">path: #/definitions/Conta</i>
- **_Properties_**
    - <b id="#/definitions/Conta/properties/agencia">agencia</b>
        - _Campo referente OBJETO AGENCIA_
        - <i id="#/definitions/Conta/properties/agencia">path: #/definitions/Conta/properties/agencia</i>
        - &#36;ref: [#/definitions/ Agencia](#/definitions/ Agencia)
    - <b id="#/definitions/Conta/properties/correntista">correntista</b>
        - _Campo referente OBJETO CORRENTISTA_
        - <i id="#/definitions/Conta/properties/correntista">path: #/definitions/Conta/properties/correntista</i>
        - &#36;ref: [#/definitions/Correntista](#/definitions/Correntista)
    - <b id="#/definitions/Conta/properties/dataCadastro">dataCadastro</b>
        - Type: `string`
        - <i id="#/definitions/Conta/properties/dataCadastro">path: #/definitions/Conta/properties/dataCadastro</i>
        - String format must be a "date-time"
    - <b id="#/definitions/Conta/properties/numeroConta">numeroConta</b>
        - _Campo ID_
        - Type: `integer`
        - <i id="#/definitions/Conta/properties/numeroConta">path: #/definitions/Conta/properties/numeroConta</i>
    - <b id="#/definitions/Conta/properties/tipoConta">tipoConta</b> `required`
        - _Campo referente tipo de conta no momento do cadastro a ser cadastrado_
        - Type: `string`
        - <i id="#/definitions/Conta/properties/tipoConta">path: #/definitions/Conta/properties/tipoConta</i>

# ContaOutputDTO
- Type: `object`
- <i id="#/definitions/ContaOutputDTO">path: #/definitions/ContaOutputDTO</i>
- **_Properties_**
    - <b id="#/definitions/ContaOutputDTO/properties/agencia">agencia</b>
        - <i id="#/definitions/ContaOutputDTO/properties/agencia">path: #/definitions/ContaOutputDTO/properties/agencia</i>
        - &#36;ref: [#/definitions/AgenciaOutputDTO](#/definitions/AgenciaOutputDTO)
    - <b id="#/definitions/ContaOutputDTO/properties/correntista">correntista</b>
        - <i id="#/definitions/ContaOutputDTO/properties/correntista">path: #/definitions/ContaOutputDTO/properties/correntista</i>
        - &#36;ref: [#/definitions/CorrentistaOutputDTO](#/definitions/CorrentistaOutputDTO)
    - <b id="#/definitions/ContaOutputDTO/properties/dataCadastro">dataCadastro</b>
        - Type: `string`
        - <i id="#/definitions/ContaOutputDTO/properties/dataCadastro">path: #/definitions/ContaOutputDTO/properties/dataCadastro</i>
        - String format must be a "date-time"
    - <b id="#/definitions/ContaOutputDTO/properties/digito">digito</b>
        - Type: `string`
        - <i id="#/definitions/ContaOutputDTO/properties/digito">path: #/definitions/ContaOutputDTO/properties/digito</i>
    - <b id="#/definitions/ContaOutputDTO/properties/numeroConta">numeroConta</b>
        - Type: `integer`
        - <i id="#/definitions/ContaOutputDTO/properties/numeroConta">path: #/definitions/ContaOutputDTO/properties/numeroConta</i>
    - <b id="#/definitions/ContaOutputDTO/properties/numeroContaCompleta">numeroContaCompleta</b>
        - Type: `string`
        - <i id="#/definitions/ContaOutputDTO/properties/numeroContaCompleta">path: #/definitions/ContaOutputDTO/properties/numeroContaCompleta</i>
    - <b id="#/definitions/ContaOutputDTO/properties/tipoConta">tipoConta</b>
        - Type: `string`
        - <i id="#/definitions/ContaOutputDTO/properties/tipoConta">path: #/definitions/ContaOutputDTO/properties/tipoConta</i>

# ContatoCliente
- _Entidade entitulada ContatoCliente_
- Type: `object`
- <i id="#/definitions/ContatoCliente">path: #/definitions/ContatoCliente</i>
- **_Properties_**
    - <b id="#/definitions/ContatoCliente/properties/dataCadastro">dataCadastro</b>
        - _Campo referente data de criação_
        - Type: `string`
        - <i id="#/definitions/ContatoCliente/properties/dataCadastro">path: #/definitions/ContatoCliente/properties/dataCadastro</i>
        - String format must be a "date-time"
    - <b id="#/definitions/ContatoCliente/properties/email">email</b> `required`
        - _Campo referente e-mail_
        - Type: `string`
        - <i id="#/definitions/ContatoCliente/properties/email">path: #/definitions/ContatoCliente/properties/email</i>
    - <b id="#/definitions/ContatoCliente/properties/id">id</b>
        - _Campo referente ID_
        - Type: `integer`
        - <i id="#/definitions/ContatoCliente/properties/id">path: #/definitions/ContatoCliente/properties/id</i>
    - <b id="#/definitions/ContatoCliente/properties/infoRecado">infoRecado</b> `required`
        - _Campo referente Informações para recados_
        - Type: `string`
        - <i id="#/definitions/ContatoCliente/properties/infoRecado">path: #/definitions/ContatoCliente/properties/infoRecado</i>
    - <b id="#/definitions/ContatoCliente/properties/telefone">telefone</b> `required`
        - _Campo referente ao telefone_
        - Type: `string`
        - <i id="#/definitions/ContatoCliente/properties/telefone">path: #/definitions/ContatoCliente/properties/telefone</i>

# Correntista
- _Entidade entitulada Correntista_
- Type: `object`
- <i id="#/definitions/Correntista">path: #/definitions/Correntista</i>
- **_Properties_**
    - <b id="#/definitions/Correntista/properties/cnpj">cnpj</b>
        - _Campo CNPJ_
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/cnpj">path: #/definitions/Correntista/properties/cnpj</i>
    - <b id="#/definitions/Correntista/properties/contatos">contatos</b>
        - _Campo Objeto Contato relacionado Correntista_
        - Type: `array`
        - <i id="#/definitions/Correntista/properties/contatos">path: #/definitions/Correntista/properties/contatos</i>
            - **_Items_**
            - <i id="#/definitions/Correntista/properties/contatos/items">path: #/definitions/Correntista/properties/contatos/items</i>
            - &#36;ref: [#/definitions/ContatoCliente](#/definitions/ContatoCliente)
    - <b id="#/definitions/Correntista/properties/cpf">cpf</b>
        - _ Campo CPF_
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/cpf">path: #/definitions/Correntista/properties/cpf</i>
    - <b id="#/definitions/Correntista/properties/dataCadastro">dataCadastro</b>
        - _Campo da data ao criar Correntista_
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/dataCadastro">path: #/definitions/Correntista/properties/dataCadastro</i>
        - String format must be a "date-time"
    - <b id="#/definitions/Correntista/properties/emailValidacao">emailValidacao</b>
        - _ Campo E-mail para notificar movimentação_
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/emailValidacao">path: #/definitions/Correntista/properties/emailValidacao</i>
    - <b id="#/definitions/Correntista/properties/enderecos">enderecos</b>
        - _Campo Endereço do correntista_
        - Type: `array`
        - <i id="#/definitions/Correntista/properties/enderecos">path: #/definitions/Correntista/properties/enderecos</i>
            - **_Items_**
            - <i id="#/definitions/Correntista/properties/enderecos/items">path: #/definitions/Correntista/properties/enderecos/items</i>
            - &#36;ref: [#/definitions/Endereco](#/definitions/Endereco)
    - <b id="#/definitions/Correntista/properties/id">id</b>
        - _Campo ID_
        - Type: `integer`
        - <i id="#/definitions/Correntista/properties/id">path: #/definitions/Correntista/properties/id</i>
    - <b id="#/definitions/Correntista/properties/nome">nome</b> `required`
        - _Campo Nome da pessoa_
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/nome">path: #/definitions/Correntista/properties/nome</i>
    - <b id="#/definitions/Correntista/properties/rg">rg</b>
        - _Campo RG_
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/rg">path: #/definitions/Correntista/properties/rg</i>
    - <b id="#/definitions/Correntista/properties/sms">sms</b>
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/sms">path: #/definitions/Correntista/properties/sms</i>
    - <b id="#/definitions/Correntista/properties/tipoPessoa">tipoPessoa</b> `required`
        - _Campo Tipo de Pessoa: Fisica ou Juridica_
        - Type: `string`
        - <i id="#/definitions/Correntista/properties/tipoPessoa">path: #/definitions/Correntista/properties/tipoPessoa</i>

# CorrentistaOutputDTO
- Type: `object`
- <i id="#/definitions/CorrentistaOutputDTO">path: #/definitions/CorrentistaOutputDTO</i>
- **_Properties_**
    - <b id="#/definitions/CorrentistaOutputDTO/properties/cnpj">cnpj</b>
        - Type: `string`
        - <i id="#/definitions/CorrentistaOutputDTO/properties/cnpj">path: #/definitions/CorrentistaOutputDTO/properties/cnpj</i>
    - <b id="#/definitions/CorrentistaOutputDTO/properties/cpf">cpf</b>
        - Type: `string`
        - <i id="#/definitions/CorrentistaOutputDTO/properties/cpf">path: #/definitions/CorrentistaOutputDTO/properties/cpf</i>
    - <b id="#/definitions/CorrentistaOutputDTO/properties/id">id</b>
        - Type: `integer`
        - <i id="#/definitions/CorrentistaOutputDTO/properties/id">path: #/definitions/CorrentistaOutputDTO/properties/id</i>
    - <b id="#/definitions/CorrentistaOutputDTO/properties/nome">nome</b>
        - Type: `string`
        - <i id="#/definitions/CorrentistaOutputDTO/properties/nome">path: #/definitions/CorrentistaOutputDTO/properties/nome</i>
    - <b id="#/definitions/CorrentistaOutputDTO/properties/rg">rg</b>
        - Type: `string`
        - <i id="#/definitions/CorrentistaOutputDTO/properties/rg">path: #/definitions/CorrentistaOutputDTO/properties/rg</i>

# Endereco
- _Entidade entitulada Endereco_
- Type: `object`
- <i id="#/definitions/Endereco">path: #/definitions/Endereco</i>
- **_Properties_**
    - <b id="#/definitions/Endereco/properties/bairro">bairro</b> `required`
        - _Campo bairro_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/bairro">path: #/definitions/Endereco/properties/bairro</i>
    - <b id="#/definitions/Endereco/properties/cep">cep</b> `required`
        - _Campo CEP_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/cep">path: #/definitions/Endereco/properties/cep</i>
    - <b id="#/definitions/Endereco/properties/cidade">cidade</b> `required`
        - _Campo cidade_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/cidade">path: #/definitions/Endereco/properties/cidade</i>
    - <b id="#/definitions/Endereco/properties/complemento">complemento</b>
        - _Campo complemento referente cadastro do endereço_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/complemento">path: #/definitions/Endereco/properties/complemento</i>
    - <b id="#/definitions/Endereco/properties/dataCadastro">dataCadastro</b>
        - _Campo referente data da criação_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/dataCadastro">path: #/definitions/Endereco/properties/dataCadastro</i>
        - String format must be a "date-time"
    - <b id="#/definitions/Endereco/properties/estado">estado</b> `required`
        - _Campo estado_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/estado">path: #/definitions/Endereco/properties/estado</i>
    - <b id="#/definitions/Endereco/properties/id">id</b>
        - _Campo referente ID_
        - Type: `integer`
        - <i id="#/definitions/Endereco/properties/id">path: #/definitions/Endereco/properties/id</i>
    - <b id="#/definitions/Endereco/properties/logradouro">logradouro</b> `required`
        - _Campo logradouro_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/logradouro">path: #/definitions/Endereco/properties/logradouro</i>
    - <b id="#/definitions/Endereco/properties/numero">numero</b> `required`
        - _Campo número_
        - Type: `string`
        - <i id="#/definitions/Endereco/properties/numero">path: #/definitions/Endereco/properties/numero</i>

# Movimentacao
- _Entidade entitulada Movimentacao_
- Type: `object`
- <i id="#/definitions/Movimentacao">path: #/definitions/Movimentacao</i>
- **_Properties_**
    - <b id="#/definitions/Movimentacao/properties/dataMovimento">dataMovimento</b>
        - _Campo referente data de criação_
        - Type: `string`
        - <i id="#/definitions/Movimentacao/properties/dataMovimento">path: #/definitions/Movimentacao/properties/dataMovimento</i>
        - String format must be a "date-time"
    - <b id="#/definitions/Movimentacao/properties/descricao">descricao</b>
        - _Campo referente descrição_
        - Type: `string`
        - <i id="#/definitions/Movimentacao/properties/descricao">path: #/definitions/Movimentacao/properties/descricao</i>
    - <b id="#/definitions/Movimentacao/properties/id">id</b>
        - _Campo referente ID_
        - Type: `integer`
        - <i id="#/definitions/Movimentacao/properties/id">path: #/definitions/Movimentacao/properties/id</i>
    - <b id="#/definitions/Movimentacao/properties/numeroContaCredito">numeroContaCredito</b>
        - _Campo referente número da Conta Crédito_
        - Type: `integer`
        - <i id="#/definitions/Movimentacao/properties/numeroContaCredito">path: #/definitions/Movimentacao/properties/numeroContaCredito</i>
    - <b id="#/definitions/Movimentacao/properties/numeroContaDebito">numeroContaDebito</b>
        - _Campo referente número da Conta Debito_
        - Type: `integer`
        - <i id="#/definitions/Movimentacao/properties/numeroContaDebito">path: #/definitions/Movimentacao/properties/numeroContaDebito</i>
    - <b id="#/definitions/Movimentacao/properties/valor">valor</b>
        - _Campo referente valor_
        - Type: `number`
        - <i id="#/definitions/Movimentacao/properties/valor">path: #/definitions/Movimentacao/properties/valor</i>
        
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
