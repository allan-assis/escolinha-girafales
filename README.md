# Que milagre você por aqui!

Essa é a segunda atividade do teste da L2. A primeira atividade pode ser encontrada [clicando aqui](https://github.com/allan-assis/teste-api-l2).

## Sobre o projeto:

Criado no *initializr* usando *Spring Boot* v3.5.0, *Java* 17, *H2*. Fiz o desenvolvimento no *VSCode* e os testes da API com o *Postman*.

## Como executar:

No terminal, basta executar:

```bash
mvn clean install; mvn spring-boot:run;
```

## Acesso da API:

Deixei uma collection pronta nos arquivos, basta importar o `API Escolinha.postman_collection` no *Postman* (ou no *Insomnia*).

## Sobre a Persistência:

Para acessar o console do banco, basta acessar:

```bash
http://localhost:8080/h2-console
```

### Dados de acesso:

* JDBC URL: `jdbc:h2:mem:escola`
* User Name: `girafales`
* Password : `florinda`

---

> Só estive errado uma vez na vida, quando julguei que o código estava errado.
