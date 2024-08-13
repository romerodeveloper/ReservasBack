# Documentación de Instalación y Prueba de Endpoints

## Introducción

Este documento proporciona una guía completa para la instalación, configuración y prueba de los endpoints del controlador `ReservaController` en un proyecto Java Spring Boot. El proyecto está configurado para conectarse a una base de datos PostgreSQL mediante PgAdmin4 y utiliza Lombok para simplificar el código y OpenAI para la documentación. También se cubre el uso de Postman para realizar pruebas exhaustivas de los endpoints.

## Requisitos

Antes de comenzar, asegúrate de tener instalados los siguientes requisitos:

- **Java JDK**: Versión 17 o superior recomendada.
- **Maven**: Para la gestión de dependencias y construcción del proyecto.
- **PgAdmin4**: Para gestionar la base de datos PostgreSQL.
- **Postman**: Para realizar pruebas de los endpoints.
- **Lombok**: Para generar automáticamente el código boilerplate (como getters, setters, etc.).

## Instalación y Configuración

### 1. Clonar el Repositorio

Clona el repositorio del proyecto desde tu fuente de control de versiones:

```bash
git clone <[url-del-repositorio](https://github.com/romerodeveloper/ReservasBack.git)>
```
### 2. Configurar el Entorno
Asegúrate de tener Java JDK y Maven instalados en tu máquina. Verifica la instalación con los siguientes comandos:

### 3. Configurar la Base de Datos
Configura PostgreSQL de acuerdo a las propiedas descritas en el archivo application.properties
El programa utilizo hibernate y el sistema ORM por lo tanto creara las tablas automaticamente, sin embargo se cargara la base de datos en los recursos para disponer de los datos de prueba guardados.
El archivo es de tipo Plain solo se debe copiar y ejecutar como una query contiene los datos y se ejecutaran como INSERT

### 4. Pruebas de Endpoints

### 1. Usar Postman

1. **Iniciar Postman** y crear una nueva colección para tu API.
2. **Añadir Peticiones**: Configura las siguientes peticiones según los endpoints definidos en `ReservaController`.

    #### a. Agenda una reserva
    - **Método**: POST
    - **URL**: `http://localhost:8080/reservas`
    - **Body (JSON)**:
    ```json
    {
        "fecha": "2024-08-15T12:00:00",
        "estado": "PENDIENTE",
        "idPersona": 1,
        "idServicio": 2
    }
    ```

    #### b. Actualiza una reserva
    - **Método**: PUT
    - **URL**: `http://localhost:8080/reservas`
    - **Body (JSON)**:
    ```json
    {
        "id": 1,
        "fecha": "2024-08-16T15:00:00",
        "estado": "CONFIRMADA",
        "idServicio": 3
    }
    ```

    #### c. Elimina una reserva
    - **Método**: DELETE
    - **URL**: `http://localhost:8080/reservas/{id}`
    - **Path Variable**: `id` (ID de la reserva a eliminar)

    #### d. Lista de reservas
    - **Método**: GET
    - **URL**: `http://localhost:8080/reservas`

### 2. Probar los Endpoints

- Realiza las solicitudes desde Postman y verifica las respuestas para asegurar que los endpoints funcionen como se espera.
- Valida que las reservas se crean, actualizan, eliminan y listan correctamente en tu base de datos.

## Explicación del Controlador y Servicio

### Controlador `ReservaController`

El controlador `ReservaController` expone varios endpoints para manejar reservas:

- **POST /reservas**: Agenda una nueva reserva. Acepta un objeto JSON con la información de la reserva y devuelve los detalles de la reserva creada.
- **PUT /reservas**: Actualiza una reserva existente. Acepta un objeto JSON con los detalles actualizados y devuelve la reserva actualizada.
- **DELETE /reservas/{id}**: Elimina una reserva. Cambia el estado de la reserva a CANCELADA sin devolver mensajes.
- **GET /reservas**: Lista todas las reservas, excluyendo aquellas que están en estado CANCELADA. Devuelve una lista de objetos JSON con los detalles de las reservas.

### Servicio `ReservaService`

El servicio `ReservaService` contiene la lógica de negocio para gestionar reservas:

- **`agendar(DatosAgendarReserva datos)`**: Crea una nueva reserva utilizando los datos proporcionados. Valida la entrada y guarda la reserva en la base de datos.
- **`actualizar(DatosActualizacionReserva datos)`**: Actualiza una reserva existente con los nuevos datos proporcionados. Valida los datos y guarda los cambios en la base de datos.
- **`listar()`**: Recupera todas las reservas que no están en estado CANCELADA y las devuelve en una lista.
- **`eliminar(Long id)`**: Marca una reserva como CANCELADA sin eliminarla físicamente de la base de datos.

### DTOs y Seguridad de Datos

El uso de DTOs (`DatosAgendarReserva`, `DatosActualizacionReserva`, `DatosDetalleReserva`) ayuda a:

- **Separar la lógica de negocio** de la capa de presentación, garantizando que solo los datos necesarios sean expuestos a través de los endpoints.
- **Validar la entrada y salida de datos**, mejorando la seguridad y la integridad de los datos al evitar la exposición de detalles internos y controlar los datos que se envían y reciben.
