
# Franchise API

API REST desarrollada con Spring Boot para la gestión de franquicias, sucursales y productos.

## Tecnologías utilizadas

* Java 21
* Spring Boot 3
* Spring Data JPA
* PostgreSQL 17
* Docker y Docker Compose
* Maven
* Swagger / OpenAPI

## Requisitos previos

Antes de ejecutar el proyecto, asegúrese de tener instalado:

* Java 21
* Docker Desktop
* Git

## Clonar el repositorio

```bash
git clone https://github.com/usuario/franchise-api.git
cd franchise-api
```

## Ejecución con Docker

La forma recomendada de ejecutar el proyecto es utilizando Docker Compose.

Construir y levantar los servicios:

```bash
docker compose up --build -d
```

Verificar que los contenedores estén en ejecución:

```bash
docker ps
```

La API estará disponible en:

```text
http://localhost:8080
```

La base de datos PostgreSQL estará disponible en:

```text
localhost:5433
```

Credenciales de la base de datos:

| Parámetro     | Valor        |
| ------------- | ------------ |
| Base de datos | franchise_db |
| Usuario       | postgres     |
| Contraseña    | postgres     |

## Ejecución local

Levantar la base de datos:

```bash
docker compose up -d postgres
```

Ejecutar la aplicación:

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Linux o macOS:

```bash
./mvnw spring-boot:run
```

## Documentación de la API

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

## Endpoints

### Franquicias

| Método | Endpoint                                  | Descripción                                      |
| ------ | ----------------------------------------- | ------------------------------------------------ |
| POST   | `/api/franchises`                         | Crear una franquicia                             |
| PATCH  | `/api/franchises/{franchiseId}`           | Actualizar el nombre de una franquicia           |
| GET    | `/api/franchises/{franchiseId}/top-stock` | Obtener el producto con mayor stock por sucursal |

### Sucursales

| Método | Endpoint                                            | Descripción                          |
| ------ | --------------------------------------------------- | ------------------------------------ |
| POST   | `/api/franchises/{franchiseId}/branches`            | Crear una sucursal                   |
| PATCH  | `/api/franchises/{franchiseId}/branches/{branchId}` | Actualizar el nombre de una sucursal |

### Productos

| Método | Endpoint                                              | Descripción                         |
| ------ | ----------------------------------------------------- | ----------------------------------- |
| POST   | `/api/branches/{branchId}/products`                   | Crear un producto                   |
| PATCH  | `/api/branches/{branchId}/products/{productId}`       | Actualizar el nombre de un producto |
| PATCH  | `/api/branches/{branchId}/products/{productId}/stock` | Actualizar el stock de un producto  |
| DELETE | `/api/branches/{branchId}/products/{productId}`       | Eliminar un producto                |

## Arquitectura del proyecto

```text
src/main/java
├── controller
├── dto
├── entity
├── repository
├── service
├── config
└── DemoApplication.java
```

## Modelo de datos

* Una franquicia puede tener múltiples sucursales.
* Una sucursal pertenece a una única franquicia.
* Una sucursal puede tener múltiples productos.
* Un producto pertenece a una única sucursal.

## Construcción del proyecto

Generar el archivo JAR:

```bash
./mvnw clean package
```

El archivo generado estará disponible en:

```text
target/
```
