# JPA country and product mappings

[Español](README.es.md) · [More work](https://github.com/navalcode)

## Overview

Two small coursework modules connect Java fields to SQL columns. `Ejercicio1` maps `Pais.nombre` to `country.name`; `Ejercicio2` maps product name/price and longer image/description text. Constructors and read access make those original field mappings usable without reflection.

## Run and inspect

Requires JDK 17 and the original Maven 3.8.2/Spring Boot 2.5.5 pins. From the repository root, in a Unix shell:

```sh
cd Ejercicio1
sh ./mvnw verify
cd ../Ejercicio2
sh ./mvnw verify
```

Each module passes three local tests: its original context smoke test and two JPA/database contract tests. The country test persists through `PaisRepository`, clears the persistence context, reads through JPA and checks the renamed native SQL column. The product test does the same with text longer than 255 characters and the mapped `name`/`price` columns. Direct SQL inserts verify that the database itself rejects a null name.

Read `CountryMappingTest` / `ProductMappingTest`, the two model classes and the existing SQL resources. Contract tests use isolated H2 data and disable the original SQL seed within their test slice; the context smoke tests still exercise the original bootstrap. The models expose no HTTP controller or graphical UI.

## Validation

On 29 October 2026, JDK 17/macOS passed all six tests and both `verify` builds. These are local results, [recorded with their scope](docs/verification.json). The source keeps its original toolchain and module/package naming. [Design decisions](DESIGN.md) explain the reading path and test boundary. Hosted CI and production database compatibility were not established by this review.

## Resumen

La versión española completa explica los mismos contratos, comandos y límites: [README.es.md](README.es.md).
