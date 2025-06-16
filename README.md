# Clean Architecture Quarkus

Este repositório é um monorepo em Maven contendo dois módulos:

- **core**: módulo Java 17 sem dependências. Possui os pacotes base `com.github.murilorpaula.core`.
- **infrastructure**: módulo que depende do `core` e utiliza Quarkus com JPA e driver Postgres.

## Requisitos
- Java 17+
- Maven 3.9+ instalado. (Opcionalmente pode-se utilizar o wrapper `./mvnw`.)

## Como compilar

Execute na raiz do projeto:

```bash
mvn clean install
```

As versões do Quarkus são gerenciadas por meio do BOM importado no `pom.xml` da raiz, portanto não é necessário definir versão nas dependências.

Isso compilará os dois módulos. O módulo `infrastructure` gera um aplicativo Quarkus que pode ser executado com:

```bash
cd infrastructure
mvn quarkus:dev
```

## Banco de dados com Docker Compose

Utilize o `docker-compose.yml` na raiz do projeto para subir um container Postgres:

```bash
docker compose up -d
```

O banco ficará disponível em `localhost:5432` com usuário `postgres` e senha `postgres`. Para parar e remover o container utilize:

```bash
docker compose down
```

## Estrutura de diretórios

```
├── core
│   └── src/main/java/com/github/murilorpaula/core
└── infrastructure
    └── src/main/java/com/github/murilorpaula/infrastructure
```

## Migrations com Flyway

O módulo `infrastructure` utiliza o Flyway para gerenciar as migrações do banco
de dados. As scripts SQL ficam em `infrastructure/src/main/resources/db/migration`.
Ao iniciar a aplicação as migrações são executadas automaticamente.

## Documentação com Swagger

As rotas expostas pela aplicação podem ser exploradas através do Swagger UI em
`/swagger`. A especificação OpenAPI é servida em `/q/openapi`.
Para que a interface esteja disponível mesmo em ambientes de produção, a
propriedade `quarkus.swagger-ui.always-include=true` está configurada em
`application.properties`.
