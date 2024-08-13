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
git clone <url-del-repositorio>
cd <nombre-del-repositorio>
