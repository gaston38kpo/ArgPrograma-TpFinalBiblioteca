# Biblioteca AP

## Descripción
Este proyecto es una aplicación web para gestionar una biblioteca. Permite registrar, consultar, modificar y eliminar libros, autores y editoriales.

## Tecnologías

- Spring Boot 3.1.5
- Spring Web
- MySQL Driver
- Lombok

## Requisitos

- Java 17
- Maven

## Instalación

1. Clonar el repositorio: `git clone https://github.com/gaston38kpo/ArgPrograma-TpFinalBiblioteca.git`
2. Crear una base de datos MySQL llamada `biblioteca-ap`
3. Modificar el archivo `application.properties` con las credenciales de la base de datos
4. Iniciar la aplicación
5. Acceder a la aplicación en `http://localhost:8080`



## Endpoints

| Endpoint                      | Metodo      | Descripción                                                    | Body                       |
|-------------------------------|-------------|----------------------------------------------------------------|----------------------------|
|                               |
| `/books/`                     | GET         | Lista todos los libros.                                        |                            |
| `/books/find?id={id}`         | GET         | Permite obtener un libro específico por su identificador.      |                            |
| `/books/findByTitle`      | POST        | Permite obtener un libro específico por su titulo.             | `{ "title": <title> }`     |
| `/books/save`                 | POST        | Registra un nuevo libro.                                       | `Ver ejemplo 1`            |
| `/books/update?=id{id}`       | PUT         | Actualiza un libro ya existente.                               | `Ver ejemplo 2`            |
| `/books/delete?=id{id}`       | DELETE      | Elimina de forma logica un libro.                              |                            |
| `/books/restore?=id{id}`      | PATCH | Restaura un libro previamente eliminado                        |                            | 
|                               |
| `/authors/`                   | GET         | Lista de todos los autores.                                    |                            |
| `/authors/find?id={id}`       | GET         | Permite obtener un autor específico por su identificador.      |                            |
| `/authors/findByName`         | POST        | Permite obtener un autor específico por su nombre.             | `{ "name": <name to get> }` |
| `/authors/save`               | POST        | Registra un nuevo autor.                                         | `{ "name": <name> }` |
| `/authors/update?=id{id}`     | PUT         | Renombra un autor ya existente.                                | `{ "name": <new name> }`   |
| `/authors/delete?=id{id}`     | DELETE      | Elimina de forma logica un autor.                              |                            |
| `/authors/restore?=id{id}`    | PATCH | Restaura un autor previamente eliminado                        |                            |
|                               |
| `/editorials/`                | GET         | Lista de todas las editoriales.                                |                            |
| `/editorials/find?id={id}`    | GET         | Permite obtener una editorial específica por su identificador. |                            |
| `/editorials/findByName`      | POST        | Permite obtener una editorial específica por su nombre.        | `{ "name": <name to get> }` |
| `/editorials/save`            | POST        | Registra una nueva editorial.                                    | `{ "name": <name> }` |
| `/editorials/update?=id{id}`  | PUT         | Renombra una editorial ya existente.                           | `{ "name": <new name> }`   |
| `/editorials/delete?=id{id}`  | DELETE      | Elimina de forma logica una editorial.                         |                            |
| `/editorials/restore?=id{id}` | PATCH | Restaura una editorial previamente eliminada                   |                            | 



| Ejemplo 1 |
|-------------|
```
[POST] "/books/save" 
BODY:
{
    "isbn": 444,
    "title": "Libro de Prueba",
    "year": 2010,
    "copies": 12,
    "borrowedCopies": 3,
    "remainingCopies": 9,
    "isEnabled": true,
    "authorList": [
        {
            "id": 3,
            "name": "Autor de Prueba",
            "isEnabled": true
        }
    ],
    "editorial": {
        "id": 2,
        "name": "Editorial de Prueba",
        "isEnabled": true
    }
}
```
| Ejemplo 2 |
|--------------|
```
[PATCH] "/books/update?=id{id}"
BODY:
{
    "isbn": 1234,
    "title": "Libro Editado",
    "year": 2001,
    "copies": 212,
    "borrowedCopies": 62,
    "remainingCopies": 125,
    "authorList": [
        {
            "id": 3,
            "name": "Autor Editado",
            "isEnabled": true
        },
        {
            "id": 4,
            "name": "Autor Editado 2",
            "isEnabled": true
        }
    ],
    "editorial": {
        "id": 2,
        "name": "Editorial Editada",
        "isEnabled": true
    }
}

```


