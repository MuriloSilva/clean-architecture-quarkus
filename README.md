# Clean Architecture Quarkus

Este repositório é um monorepo em Maven contendo dois módulos:

- **core**: módulo Java 17 sem dependências. Possui os pacotes base `com.github.murilorpaula.core`.
- **infrastructure**: módulo que depende do `core` e utiliza Quarkus com JPA e driver Postgres.

## Requisitos
- Java 17+
- Maven 3.9+

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
