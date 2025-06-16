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

Isso compilará os dois módulos. O módulo `infrastructure` gera um aplicativo Quarkus que pode ser executado com:

```bash
cd infrastructure
mvn quarkus:dev
```

## Estrutura de diretórios

```
├── core
│   └── src/main/java/com/github/murilorpaula/core
└── infrastructure
    └── src/main/java/com/github/murilorpaula/infrastructure
```
