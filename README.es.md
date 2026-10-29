# JPA country and product mappings

[English](README.md) · [Más proyectos](https://github.com/navalcode)

## Resumen

Dos módulos formativos conectan campos Java con columnas SQL. `Ejercicio1` enlaza `Pais.nombre` con `country.name`; `Ejercicio2` enlaza nombre/precio de producto y texto más largo de imagen/descripción. Los constructores y accesos de lectura permiten utilizar esos mappings sin reflexión.

## Ejecutar y examinar

Requiere JDK 17 y conserva Maven 3.8.2/Spring Boot 2.5.5. Desde la raíz, en una shell Unix:

```sh
cd Ejercicio1
sh ./mvnw verify
cd ../Ejercicio2
sh ./mvnw verify
```

Cada módulo pasa tres pruebas locales: el arranque original y dos contratos JPA/base de datos. Países persiste con `PaisRepository`, limpia el contexto, vuelve a leer con JPA y comprueba la columna SQL renombrada. Productos hace lo mismo con texto superior a 255 caracteres y columnas `name`/`price`. Las inserciones SQL directas comprueban que la propia base rechaza un nombre nulo.

Lee `CountryMappingTest` / `ProductMappingTest`, los modelos y los recursos SQL existentes. Los tests de contrato usan H2 aislado y desactivan la carga SQL original dentro de su slice; los tests de contexto siguen ejercitando el arranque original. Estos modelos no exponen controlador HTTP o interfaz gráfica.

## Validación

El 29 de octubre de 2026 pasan seis tests y ambos builds `verify` con JDK 17/macOS. Son resultados locales [con su alcance registrado](docs/verification.json). Se mantienen herramientas, módulos y paquetes originales. [Decisiones de diseño](DESIGN.md): ruta de lectura y frontera de pruebas. Esta revisión no acredita CI alojada ni compatibilidad con bases de producción.
