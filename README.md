Activesec - Microservice App
============================

El presente proyecto tiene por objetivo ilustrar una aplicación con una Arquitectura Orientada a Microservicios.
La misma fue desarrollada con el siguiente stack tecnológico:
* Java 11
* Maven
* Quarkus Framework
* Apache Kafka
* Postgresql

## Iniciar la Aplicación

La aplicación está compuesta de dos componentes que interactuan entre sí por medio Kafka.
La interación con Kafka es por medio de MicroProfile Reactive Messaging.

Se puede iniciar los componentes en modo desarrollo con los siguientes comandos.

Desde una terminal ejecutar:

```bash
mvn -f productor quarkus:dev
```

y en otra terminal:

```bash
mvn -f procesador quarkus:dev
```

_NOTA_: Quarkus Dev Services inicia un Kafka broker de forma automática.

Luego en un browser abrir `http://localhost:8080/quotes.html`.

El mismo envía requests de stocks y recibe las respuestas desde el procesador por medio de Kafka.

En otro browser abrir `http://localhost:8081/stock` desde donde se visualiza todos los procesados y almacenados en Postgresql.

## Ejecutar la aplicación en Docker

Para ejecutar la aplicación en Docker primero se debe proceder a la compilación del proyecto:

```bash
mvn clean package
```

Luego ejecutar:

```bash
docker-compose up -d
```

De esta forma se creará un cluster de Kafka con un solo nodo, una base de datos Postgresql y las dos aplicaciones.

## Ejecutar en Modo Nativo

Para el modo nativo tiene que tener instalado GRAALVM.

Compilar el proyecto en modo nativo:

```bash
mvn clean package -Dnative
```

Ejecutar desde la consola:

```bash
export QUARKUS_MODE=native
docker-compose up --build
```