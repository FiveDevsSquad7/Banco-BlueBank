<h1 align="center">
<img src="https://i.imgur.com/iQXVg0O.png" title="Logo da equipe" />
</h1>

---

<p align="center">
  <a href="#-sobre-o-projeto">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-iniciando">Iniciando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-funcionalidades">Funcionalidades</a>
</p>

## 👨🏻‍💻 Sobre o projeto

- <p style="color: red;">Banco BlueBank é projeto final referente ao de treinamento com BACK-END em Java ofertado pelo Banco Pan cuja Parceria da Gama Academy!</p>

Para ver a **api**, clique aqui: [BlueBank api](https://docbleubankdev6.netlify.app/)</br>

### 💻 Desenvolvedores
- [Carlos Betiol](https://www.linkedin.com/in/carlosbetiol/)
- [Cassiano Augusto](https://www.linkedin.com/in/cassiano-augusto-b89b6124/)
- [Jonas William](https://www.linkedin.com/in/jonas-william-a882971a4/)
- [Richardson Bruno](https://www.linkedin.com/in/richardson-bruno-889b7944/)
- [Taisis Marinelo](https://www.linkedin.com/in/taisis-marinelo/)
- [Weslley Lima](https://www.linkedin.com/in/weslley-lima-6844122b/)

---

## 🚀 Tecnologias

Tecnologias, Framework e Metodologias utilizadas:

- [Java 11](https://www.oracle.com/)
- [Versionamento de Código com Git e GitHub](https://www.atlassian.com/br/git/tutorials/what-is-git)
- [Metodologia Agile](https://www.totvs.com/blog/negocios/metodologia-agil/)
- [Design Pattern DTO -Data Transfer Objects-](https://www.baeldung.com/java-dto-pattern)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Boot: Spring Data](https://spring.io/projects/spring-data)
- [Spring Boot: Spring Security OAuth](https://spring.io/projects/spring-security-oauth)
- [Autenticação com JWT](https://jwt.io/)
- [Estratégia de Paginação](https://blog.rocketseat.com.br/paginacao-react-router/)
- [MAVEN](https://maven.apache.org/)
- [Swagger](https://swagger.io/)
- [MySQL](https://www.mysql.com/)
- [Modelo relacional](https://www.devmedia.com.br/tecnicas-de-mapeamento-objeto-relacional-revista-sql-magazine-40/6980)
- [AWS](https://aws.amazon.com/pt/)
- [AWS Lambda](https://aws.amazon.com/pt/lambda/)
- [AWS ApiGateway](https://aws.amazon.com/pt/api-gateway/)

---

## ✔️ Definições das Entidades e DTO

- ###  Agencia
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

### AgenciaOutputDTO
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

### Conta
- _Entidade entitulada Conta_
- Type: `object`
- <i id="#/definitions/Conta">path: #/definitions/Conta</i>
- **_Properties_**
    - <b id="#/definitions/Conta/properties/agencia">agencia</b>
        - _Campo referente OBJETO AGENCIA_
        - <i id="#/definitions/Conta/properties/agencia">path: #/definitions/Conta/properties/agencia</i>
        - &#36;ref: [#/definitions/Agencia] (#/definitions/Agencia)
    - <b id="#/definitions/Conta/properties/correntista">correntista</b>
        - _Campo referente OBJETO CORRENTISTA_
        - <i id="#/definitions/Conta/properties/correntista">path: #/definitions/Conta/properties/correntista</i>
        - &#36;ref: [#/definitions/Correntista] (#/definitions/Correntista)
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

### ContaOutputDTO
- Type: `object`
- <i id="#/definitions/ContaOutputDTO">path: #/definitions/ContaOutputDTO</i>
- **_Properties_**
    - <b id="#/definitions/ContaOutputDTO/properties/agencia">agencia</b>
        - <i id="#/definitions/ContaOutputDTO/properties/agencia">path: #/definitions/ContaOutputDTO/properties/agencia</i>
        - &#36;ref: [#/definitions/AgenciaOutputDTO] (#/definitions/AgenciaOutputDTO)
    - <b id="#/definitions/ContaOutputDTO/properties/correntista">correntista</b>
        - <i id="#/definitions/ContaOutputDTO/properties/correntista">path: #/definitions/ContaOutputDTO/properties/correntista</i>
        - &#36;ref: [#/definitions/CorrentistaOutputDTO] (#/definitions/CorrentistaOutputDTO)
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

### ContatoCliente
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

### Correntista
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
            - &#36;ref: [#/definitions/ContatoCliente] (#/definitions/ContatoCliente)
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
            - &#36;ref: [#/definitions/Endereco] (#/definitions/Endereco)
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

### CorrentistaOutputDTO
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

### Endereco
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

### Movimentacao
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

<p>
Diagramação.
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center" src="https://i.imgur.com/XpeYJBj.png" style="max-width:100%;">
  </a>
</p>

---
        
## ⚙️ Funcionalidades

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
                                                                                                                                                                                | int32                                   | paged                                 | query                               | false                                     | boolean                               | sort.sorted                           | query                               | false                                     | boolean                               | sort.unsorted                         | query                               | false                                     | boolean                               | unpaged                               | query                               | false                                     | boolean                               | Retorna a lista de Agencias                   | #/definitions/Page« Agencia»                  | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor           | false                          | agencia-controller          | Insere uma nova agencia      | Insere nova agencia              | salvarUsingPOST                  | application/json                | */*                             | body                                 | agencia                                | agencia                                       | true                                       | #/definitions/ Agencia                        | Retornar SUCESSO após criação                  | #/definitions/ Agencia                         | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor            | false                           | agencia-controller              | Pesquisa Agencia pelo código gerado no Banco de Dados | Busca Agencias pelo ID Base de Dados | buscarUsingGET                       | */*                                 | id                                         | path                                     | id                                                | true                                           | integer                                    | int64                                        | Retorna a lista de agencias                        | #/definitions/ Agencia                             | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor                | false                               | agencia-controller              | Faz atualização global do Agencia específico pelo ID | Atualiza agencia via ID              | atualizarUsingPUT                    | application/json                    | */*                                 | body                                     | agencia                                    | agencia                                           | true                                           | #/definitions/ Agencia                            | id                                         | path                                     | id                                                | true                                           | integer                                    | int64                                        | Retornar SUCESSO após atualização                  | #/definitions/ Agencia                             | Retornar SUCESSO após criação                      | #/definitions/ Agencia                             | Retornar SUCESSO SEM ALTERAR CONTEÚDO              | #/definitions/ Agencia                             | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor                | false                               | agencia-controller                 | Exclui Agencia exclisivo por meio do ID passado! | Exclui agencia via ID                   | removerUsingDELETE                      | */*                                    | id                                            | path                                        | id                                                   | true                                              | integer                                       | int64                                           | Retornar SUCESSO após EXCLUSÃO                        | Retornar SUCESSO DE RECEBIMENTO, PORÉM A REQUISIÇÃO não pode atuar NO MOMENTO | Retornar SUCESSO SEM ALTERAR CONTEÚDO                 | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso   | O servidor não conseguiu encontrar o URL solicitado   | Ocorreu um erro interno do servidor                   | false                                  | conta-controller         | Busca todas as Contas na Base de Dados | Busca todas as Contas na Base de Dados | listarUsingGET_1              | */*                          | offset                              | query                             | false                                   | integer                             | int64                                 | pageNumber                          | query                             | false                                   | integer                             | int32                                 | pageSize                            | query                             | false                                   | integer                             | int32                                 | paged                               | query                             | false                                   | boolean                             | sort.sorted                         | query                             | false                                   | boolean                             | sort.unsorted                       | query                             | false                                   | boolean                             | unpaged                             | query                             | false                                   | boolean                             | Retorna a lista de Contas                   | #/definitions/Page«ContaOutputDTO»          | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor         | false                        | conta-controller          | Insere uma nova Conta      | Insere nova Conta              | salvarUsingPOST_1              | application/json              | */*                           | body                               | conta                                | conta                                       | true                                     | #/definitions/Conta                         | Retornar SUCESSO após criação                | #/definitions/ContaOutputDTO                 | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor          | false                         | conta-controller              | Pesquisa Contas pelo código gerado no Banco de Dados | Busca Conta pelo ID Base de Dados  | buscarUsingGET_1                   | */*                               | id                                       | path                                   | id                                              | true                                         | integer                                  | int64                                      | Retorna a lista de contas                        | #/definitions/ContaOutputDTO                     | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor              | false                             | conta-controller              | Faz atualização global das Contas pelo específico ID | Atualiza Conta via ID              | atualizarUsingPUT_1                | application/json                  | */*                               | body                                   | conta                                    | conta                                           | true                                         | #/definitions/Conta                             | id                                       | path                                   | id                                              | true                                         | integer                                  | int64                                      | Retornar SUCESSO após atualização                | #/definitions/ContaOutputDTO                     | Retornar SUCESSO após criação                    | #/definitions/ContaOutputDTO                     | Retornar SUCESSO SEM ALTERAR CONTEÚDO            | #/definitions/ContaOutputDTO                     | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor              | false                             | conta-controller                 | Exclui Conta exclisivo por meio do ID passado! | Exclui Conta via ID                   | removerUsingDELETE_1                  | */*                                  | id                                          | path                                      | id                                                 | true                                            | integer                                     | int64                                         | Retornar SUCESSO após EXCLUSÃO                      | Retornar SUCESSO DE RECEBIMENTO, PORÉM A REQUISIÇÃO não pode atuar NO MOMENTO | Retornar SUCESSO SEM ALTERAR CONTEÚDO               | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor                 | false                                | conta-controller                                                | Busca todas as transações efetuadas e retorna o extrato          | Busca todas as transações efetuadas e retorna o extrato              | extratoUsingGET                                                      | */*                                                                 | dataFinal                                                                  | path                                                                     | dataFinal                                                                         | true                                                                           | string                                                                     | dataInicial                                                                | path                                                                     | dataInicial                                                                       | true                                                                           | string                                                                     | id                                                                         | path                                                                     | id                                                                                | true                                                                           | integer                                                                    | int64                                                                        | offset                                                                     | query                                                                    | false                                                                          | integer                                                                    | int64                                                                        | pageNumber                                                                 | query                                                                    | false                                                                          | integer                                                                    | int32                                                                        | pageSize                                                                   | query                                                                    | false                                                                          | integer                                                                    | int32                                                                        | paged                                                                      | query                                                                    | false                                                                          | boolean                                                                    | sort.sorted                                                                | query                                                                    | false                                                                          | boolean                                                                    | sort.unsorted                                                              | query                                                                    | false                                                                          | boolean                                                                    | unpaged                                                                    | query                                                                    | false                                                                          | boolean                                                                    | Retorna o extrato da conta                                                         | #/definitions/Page«Movimentacao»                                                   | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado                 | Você não tem AUTENTICAÇAO para acessar este recurso                                | O servidor não conseguiu encontrar o URL solicitado                                | Ocorreu um erro interno do servidor                                                | false                                                               | conta-controller                           | Busca o saldo de uma conta ao final de um determinado dia | saldoUsingGET                                   | */*                                            | data                                                  | path                                                | data                                                         | true                                                      | string                                                | id                                                    | path                                                | id                                                           | true                                                      | integer                                               | int64                                                   | Retorna o saldo                                               | #/definitions/SaldoOutput                                     | Você não tem permissão para acessar, desde que não esteja logado | Você não tem permissão para acessar este recurso              | O servidor não conseguiu encontrar o URL solicitado           | Foi gerada uma exceção                                        | false                                          | correntista-controller         | Busca todos Correntistas na Base de Dados | Busca todos Correntistas na Base de Dados | listarUsingGET_2                    | */*                                | offset                                    | query                                   | false                                         | integer                                   | int64                                       | pageNumber                                | query                                   | false                                         | integer                                   | int32                                       | pageSize                                  | query                                   | false                                         | integer                                   | int32                                       | paged                                     | query                                   | false                                         | boolean                                   | sort.sorted                               | query                                   | false                                         | boolean                                   | sort.unsorted                             | query                                   | false                                         | boolean                                   | unpaged                                   | query                                   | false                                         | boolean                                   | Retorna a lista de Correntistas                   | #/definitions/Page«Correntista»                   | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor               | false                              | correntista-controller          | Insere uma novo Correntista      | Insere nova Correntista              | salvarUsingPOST_2                    | application/json                    | */*                                 | body                                     | correntista                                | correntista                                       | true                                           | #/definitions/Correntista                         | Retornar SUCESSO após criação                      | #/definitions/Correntista                          | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso | O servidor não conseguiu encontrar o URL solicitado | Ocorreu um erro interno do servidor                | false                               | correntista-controller              | Pesquisa Correntista pelo código gerado no Banco de Dados | Busca Correntista pelo ID Base de Dados  | buscarUsingGET_2                         | */*                                     | id                                             | path                                         | id                                                    | true                                               | integer                                        | int64                                            | Retorna a lista de pessoa                              | #/definitions/Correntista                              | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso    | O servidor não conseguiu encontrar o URL solicitado    | Ocorreu um erro interno do servidor                    | false                                   | correntista-controller              | Faz atualização global do Correntista específico pelo ID | atualizarUsingPUT_2                      | application/json                        | */*                                     | body                                         | correntista                                    | correntista                                           | true                                               | #/definitions/Correntista                             | id                                             | path                                         | id                                                    | true                                               | integer                                        | int64                                            | Retornar SUCESSO após atualização                      | #/definitions/Correntista                              | Created                                                | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso    | O servidor não conseguiu encontrar o URL solicitado    | Ocorreu um erro interno do servidor                    | false                                   | correntista-controller                 | Exclui Correntista exclisivo por meio do ID passado! | removerUsingDELETE_2                        | */*                                        | id                                                | path                                            | id                                                       | true                                                  | integer                                           | int64                                               | Retornar SUCESSO após exclusão                            | No Content                                                | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso       | O servidor não conseguiu encontrar o URL solicitado       | Ocorreu um erro interno do servidor                       | false                                      | correntista-controller                       | Busca todos os Todos os Contatos relacionados Correntistas na Base de Dadosmeio do ID passado! | listarContatosUsingGET                            | */*                                              | id                                                      | path                                                  | id                                                             | true                                                        | integer                                                 | int64                                                     | Retornar SUCESSO após exclusão                                  | array                                                           | #/definitions/ContatoCliente                                          | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso             | O servidor não conseguiu encontrar o URL solicitado             | Ocorreu um erro interno do servidor                             | false                                            | correntista-controller                        | Insere um novo Contato                         | adicionarContatoUsingPOST                          | application/json                                  | */*                                               | body                                                   | contato                                                  | contato                                                         | true                                                         | #/definitions/ContatoCliente                                    | id                                                       | path                                                   | id                                                              | true                                                         | integer                                                  | int64                                                      | Retorna a contato                                                | array                                                            | #/definitions/ContatoCliente                                           | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso              | O servidor não conseguiu encontrar o URL solicitado              | Ocorreu um erro interno do servidor                              | false                                             | correntista-controller                                      | Exclui Contato do Correntista exclisivo por meio do ID passado! | removerContatoUsingDELETE                                        | */*                                                             | contatoId                                                              | path                                                                 | contatoId                                                                     | true                                                                       | integer                                                                | int64                                                                    | id                                                                     | path                                                                 | id                                                                            | true                                                                       | integer                                                                | int64                                                                    | Retornar SUCESSO após EXCLUSÃO                                                 | Retornar SUCESSO DE RECEBIMENTO, PORÉM A REQUISIÇÃO não pode atuar NO MOMENTO  | Retornar SUCESSO SEM ALTERAR CONTEÚDO                                          | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado             | Você não tem AUTENTICAÇAO para acessar este recurso                            | O servidor não conseguiu encontrar o URL solicitado                            | Ocorreu um erro interno do servidor                                            | false                                                           | correntista-controller                        | Busca todos os Todos os Endereços relacionados Correntistas na Base de Dadosmeio do ID passado! | listarEnderecosUsingGET                            | */*                                               | id                                                       | path                                                   | id                                                              | true                                                         | integer                                                  | int64                                                      | Retornar SUCESSO após exclusão                                   | array                                                            | #/definitions/Endereco                                                 | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso              | O servidor não conseguiu encontrar o URL solicitado              | Ocorreu um erro interno do servidor                              | false                                             | correntista-controller                         | Insere um novo Endereço                         | adicionarEnderecoUsingPOST                          | application/json                                   | */*                                                | body                                                    | endereco                                                  | endereco                                                         | true                                                          | #/definitions/Endereco                                           | id                                                        | path                                                    | id                                                               | true                                                          | integer                                                   | int64                                                       | Retorna a lista de endereço                                       | array                                                             | #/definitions/Endereco                                                  | Created                                                           | array                                                             | #/definitions/Endereco                                                  | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado | Você não tem AUTENTICAÇAO para acessar este recurso               | O servidor não conseguiu encontrar o URL solicitado               | Ocorreu um erro interno do servidor                               | false                                              | correntista-controller                                        | Exclui Endereço do Correntista exclisivo por meio do ID passado! | removerEnderecoUsingDELETE                                         | */*                                                               | enderecoId                                                               | path                                                                   | enderecoId                                                                      | true                                                                         | integer                                                                  | int64                                                                      | id                                                                       | path                                                                   | id                                                                              | true                                                                         | integer                                                                  | int64                                                                      | Retornar SUCESSO após exclusão                                                   | No Content                                                                       | Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado               | Você não tem AUTENTICAÇAO para acessar este recurso                              | O servidor não conseguiu encontrar o URL solicitado                              | Ocorreu um erro interno do servidor                                              | false                                                             | movimentacao-controller                   | Cria uma nova Movimentacao de deposito     | depositarUsingPOST                             | application/json                              | */*                                           | body                                               | movimentacaoInput                                    | movimentacaoInput                                           | true                                                     | #/definitions/MovimentacaoInput                             | Retornar SUCESSO após criação                                | #/definitions/Movimentacao                                   | Created                                                      | #/definitions/Movimentacao                                   | Você não tem permissão para acessar, desde que não esteja logado | Você não tem permissão para acessar este recurso             | O servidor não conseguiu encontrar o URL solicitado          | Foi gerada uma exceção                                       | false                                         | movimentacao-controller                | Cria uma nova Movimentacao de saque     | sacarUsingPOST                              | application/json                           | */*                                        | body                                            | movimentacaoInput                                 | movimentacaoInput                                        | true                                                  | #/definitions/MovimentacaoInput                          | Retornar SUCESSO após criação                             | #/definitions/Movimentacao                                | Created                                                   | #/definitions/Movimentacao                                | Você não tem permissão para acessar, desde que não esteja logado | Você não tem permissão para acessar este recurso          | O servidor não conseguiu encontrar o URL solicitado       | Foi gerada uma exceção                                    | false                                      | movimentacao-controller                        | Cria uma nova Movimentacao de transferencia     | salvarUsingPOST_3                                   | application/json                                   | */*                                                | body                                                    | movimentacao                                              | movimentacao                                                     | true                                                          | #/definitions/Movimentacao                                       | Retornar SUCESSO após criação                                     | #/definitions/Movimentacao                                        | Created                                                           | #/definitions/Movimentacao                                        | Você não tem permissão para acessar, desde que não esteja logado  | Você não tem permissão para acessar este recurso                  | O servidor não conseguiu encontrar o URL solicitado               | Foi gerada uma exceção                                            | false                                              | movimentacao-controller              | Busca movimentacao por id             | buscarUsingGET_3                          | */*                                      | id                                              | path                                          | id                                                     | true                                                | integer                                         | int64                                             | Retorna um recurso de movimentacoes específico          | #/definitions/Movimentacao                              | Você não tem permissão para acessar, desde que não esteja logado | Você não tem permissão para acessar este recurso        | O servidor não conseguiu encontrar o URL solicitado     | Foi gerada uma exceção                                  | false                                    | object                    | string                                       | Campo referente nome juridico da Agencia            | string                                            | date-time                                           | Campo referente data da criação                          | integer                                 | int64                                     | Campo ID                                       | string                                    | Campo referente nome fantasia da Agencia         |  Agencia                   | Entidade entitulada Agencia      | object                            | string                                               | integer                                         | int64                                             | string                                            | AgenciaOutputDTO                   | object                 | tipoConta                    | Campo referente OBJETO AGENCIA                   | #/definitions/ Agencia                    | Campo referente OBJETO CORRENTISTA                   | #/definitions/Correntista                     | string                                         | date-time                                        | integer                                       | int64                                           | Campo ID                                             | string                                      | Campo referente tipo de conta no momento do cadastro a ser cadastrado | Conta                   | Entidade entitulada Conta     | object                          | #/definitions/AgenciaOutputDTO                     | #/definitions/CorrentistaOutputDTO                     | string                                                  | date-time                                                 | string                                            | integer                                                | int64                                                    | string                                                         | string                                               | ContaOutputDTO                   | object                          | email                                 | infoRecado                            | telefone                              | string                                                  | date-time                                                 | Campo referente data de criação                                | string                                           | Campo referente e-mail                                  | integer                                       | int64                                           | Campo referente ID                                   | string                                                | Campo referente Informações para recados                     | string                                              | Campo referente ao telefone                                | ContatoCliente                   | Entidade entitulada ContatoCliente     | object                       | nome                               | tipoPessoa                         | string                                       | Campo CNPJ                                          | array                                            | Campo Objeto Contato relacionado Correntista            | #/definitions/ContatoCliente                           | string                                      |  Campo CPF                                         | string                                               | date-time                                              | Campo da data ao criar Correntista                          | string                                                 |  Campo E-mail para notificar movimentação                     | array                                             | Campo Endereço do correntista                            | #/definitions/Endereco                                  | integer                                    | int64                                        | Campo ID                                          | string                                       | Campo Nome da pessoa                                | string                                     | Campo RG                                          | string                                      | string                                             | Campo Tipo de Pessoa: Fisica ou Juridica                  | Correntista                   | Entidade entitulada Correntista     | object                                | string                                                | string                                               | integer                                             | int64                                                 | string                                                | string                                              | CorrentistaOutputDTO                   | object                    | bairro                          | cep                             | cidade                          | estado                          | logradouro                      | numero                          | string                                      | Campo bairro                                       | string                                   | Campo CEP                                       | string                                      | Campo cidade                                       | string                                           | Campo complemento referente cadastro do endereço        | string                                            | date-time                                           | Campo referente data da criação                          | string                                      | Campo estado                                       | integer                                 | int64                                     | Campo referente ID                             | string                                          | Campo logradouro                                       | string                                      | Campo número                                       | Endereco                   | Entidade entitulada Endereco     | object                        | string                                                 | date-time                                                | Campo referente data de criação                               | string                                             | Campo referente descrição                                 | integer                                     | int64                                         | Campo referente ID                                 | integer                                                     | int64                                                         | Campo referente número da Conta Crédito                            | integer                                                    | int64                                                        | Campo referente número da Conta Debito                            | number                                         | Campo referente valor                                 | Movimentacao                   | Entidade entitulada Movimentacao     | object                             | string                                                  | integer                                                   | int64                                                       | number                                              | MovimentacaoInput                   | object                    | integer                                     | int64                                         | integer                                         | int32                                             | integer                                       | int32                                           | boolean                                    | #/definitions/Sort                        | boolean                                      | Pageable                   | object                          | array                                              | #/definitions/ Agencia                                   | boolean                                          | boolean                                          | boolean                                         | integer                                           | int32                                               | integer                                                     | int32                                                         | #/definitions/Pageable                              | integer                                         | int32                                             | #/definitions/Sort                              | integer                                                  | int64                                                      | integer                                               | int32                                                   | Page« Agencia»                   | object                                | array                                                    | #/definitions/ContaOutputDTO                                   | boolean                                                | boolean                                                | boolean                                               | integer                                                 | int32                                                     | integer                                                           | int32                                                               | #/definitions/Pageable                                    | integer                                               | int32                                                   | #/definitions/Sort                                    | integer                                                        | int64                                                            | integer                                                     | int32                                                         | Page«ContaOutputDTO»                   | object                             | array                                                 | #/definitions/Correntista                                   | boolean                                             | boolean                                             | boolean                                            | integer                                              | int32                                                  | integer                                                        | int32                                                            | #/definitions/Pageable                                 | integer                                            | int32                                                | #/definitions/Sort                                 | integer                                                     | int64                                                         | integer                                                  | int32                                                      | Page«Correntista»                   | object                              | array                                                  | #/definitions/Movimentacao                                   | boolean                                              | boolean                                              | boolean                                             | integer                                               | int32                                                   | integer                                                         | int32                                                             | #/definitions/Pageable                                  | integer                                             | int32                                                 | #/definitions/Sort                                  | integer                                                      | int64                                                          | integer                                                   | int32                                                       | Page«Movimentacao»                   | object                       | string                                       | date-time                                      | integer                                             | int64                                                 | number                                        | SaldoOutput                   | object                | boolean                                | boolean                                 | boolean                                   | Sort                   |
## TABELA DE ENDPOINT

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

## 💻 Iniciando

1️⃣

<p>
Obter acesso cuja API externa de Segurança cuja estratégia aplicada foi para separar as responsabilidades, assim segue a imagem:

Com a autorização realizada cujo Token, o sistema permite realizar algumas operações:

{
"access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MzkyMTMxOTIsInVzZXJfbmFtZSI6IjE4IiwiYXV0aG9yaXRpZXMiOlsiQURNSU4iXSwianRpIjoiMDg5MDg3ODAtMTAxNi00ZWU5LTk1MmMtYWI2NjA5ODk5OWMzIiwiY2xpZW50X2lkIjoiYmx1ZWJhbmstYXBwIiwic2NvcGUiOlsiUkVBRCIsIldSSVRFIl19.c6z4aMdNWMhcu5wRoFrTJ87Ur5M3uSF5c-RlMKsML32uWVeVGa0WAu-G4siyvwp7NufVwSf90tbA83mGQmLtc_Pig8vxpAwhIb1QRriFiQ_d0ZrljpnudSQAiyT4rgLn77jwvKwb1Yfu1j4E1BonsrSUINp2S6a2Uu3nzABVJ18DAaSaFupNGjtPylNPD5ZspNz0fnqsq2WXzKpbNnSv8gWiuvu1Tyx1nwoTg3KQJtUMFClJjQ5j_-G5s7Te02nVbtn_QaZ-aJcj4FntGNMkVwVWejgOARSCyhgkKT4mPn2IifNOkEzlnFLbOq9O59NKUntkex-aMB5hVX2YqOTqeA",
"token_type": "bearer",
"expires_in": 43199,
"scope": "READ WRITE",
"jti": "08908780-1016-4ee9-952c-ab66098999c3"
}
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center"  src="https://i.imgur.com/m3bxpLm.jpg" style="max-width:100%;">
  </a>
</p>

2️⃣ 
<p>
Inserindo um Correntista, porém será usado o Swagger:
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center"  src="https://i.imgur.com/orX9XjB.png" style="max-width:100%;">
  </a>
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center" src="https://i.imgur.com/hGHMZm9.png" style="max-width:100%;">
  </a>
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center"  src="https://i.imgur.com/eZSabGL.png" style="max-width:100%;">
  </a>
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center"  src="https://i.imgur.com/6WWERN3.png" style="max-width:100%;">
  </a>
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center" src="https://i.imgur.com/ntj5m78.png" style="max-width:100%;">
  </a>
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center"  src="https://i.imgur.com/u6WDwg9.png" style="max-width:100%;">
  </a>
</p>

3️⃣

<p>
Inserindo uma Conta:
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center" src="https://i.imgur.com/rwRYsgB.png" style="max-width:100%;">
  </a>
</p>

<p>
Retorno:
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center" src="https://i.imgur.com/aomXZta.png" style="max-width:100%;">
  </a>
</p>

<p>
Por meio da Conta n° 18, cujo acesso seria ao funcionário, logo se pode realizar algumas requisições, por exemplo buscar 
todos Correntistas na Base de Dados.
Conforme a imagem abaixo, a API contém a Estratégia de Paginação, já que tal tecnica melhora a performace! Assim, 
a medida que a há aumento de dados, a API contém a responsabilidade para tratar tais dados, e não ficando a incumbência APENAS Squad do Front.
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center" src="https://i.imgur.com/nazmHj5.png" style="max-width:100%;">
  </a>
</p>

<p>
Retorno:
</p>

<p align="center">
  <a href="https://docbleubankdev6.netlify.app/">
    <img align="center" src="https://i.imgur.com/yIIyPE0.png" style="max-width:100%;">
  </a>
</p>


4️⃣



