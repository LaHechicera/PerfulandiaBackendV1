# 🧾 Proyecto: Transformación Digital - Perfulandia SPA

Este repositorio contiene el desarrollo técnico del sistema basado en microservicios para la empresa Perfulandia SPA, como parte de la Evaluación Parcial 2 de la asignatura **Desarrollo Full Stack I**.

## 📦 Descripción General del Proyecto

> 📝 Se esta implementando un nuevo sistema de ventas para la compañia Perfulandia SPA, ya que su antigua sistema comenzo a fallar, presentando problemas de rendimiento y disponibilidad, nosotros al realizar el reemplazo del sistema monolitico vamos a beneficiar a la empresa dandoles un sistema con buena escalabilidad y eficiencia en el tiempo.

## 🧩 Arquitectura de Microservicios

> 📝 Describir cómo está estructurado el sistema en microservicios. Pueden incluir un diagrama (opcional) y explicar brevemente la función de cada servicio.

### Microservicios Desarrollados

- `usuarioservice`: > 📝 Agrega nuevos usuarios.
- `productoservice`: > 📝 Agrega o elimina productos.
- `carritoservice`: > 📝 Crea carritos de compra, en base a la lista de productos en sistema.
- `pedidoservice`: > 📝 Indicar el nombre y función del microservicio adicional implementado.

## 🛠️ Tecnologías Utilizadas

Las herramientas utilizadas para el proyecto fueron:

- Spring Boot
- Maven
- MySQL
- Postman
- GitHub

Y utilizamos como framework:

- IntelliJ IDEA 2025

## 🗄️ Configuración de Bases de Datos

La Base de Datos se realizo con Laragon, el cual nos permitio crear un servidor local el que guardo los datos subidos a los microservicios. La configuracion de las conexiones se realizo mediante el archivo `application.properties` de la siguiente manera:
```
spring.application.name=carritoservice

server.port=8083

spring.datasource.url=jdbc:mysql://localhost:3306/perfulandia_carrito_01v
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
Para cada microservicio contiene un diferente `server.port=8083`, para que asi no hayan errores al momento de dar inicio a los microservisios en simultaneo.


> 📝  y qué tablas y campos definieron para cada microservicio.

## 📮 Endpoints y Pruebas

> 📝 Especificar los principales endpoints disponibles por microservicio (CRUD y llamadas entre servicios).  
> Incluir capturas o descripciones de pruebas realizadas con Postman (mínimo 3 por servicio).

## 🔁 CI/CD (Integración y Entrega Continua)

> 📝 Explicar qué herramienta usaron (GitHub Actions, Vercel, etc.) y qué flujo automatizado implementaron (por ejemplo: `push` → `test` → `deploy`).

## 🧑‍💻 Integrantes del Equipo

> 📝 Indicar nombre completo y rol de cada integrante del equipo.

| Nombre                  | Rol en el proyecto         | Servicio principal trabajado |
|-------------------------|----------------------------|------------------------------|
| Camila González | Backend  | Carrito               |
| Andy Villarroel | Backend  | Pedidos       |

## 📂 Estructura del Repositorio

El repositorio cuenta con 5 carpetas las cuales 4 corresponden a los diferentes microservicios, cada uno con su propio `pom.xml`, carpeta src la cual contiene los archivos principales para que los micro servicios funcionen y puedan conectarse a la base de datos.

A continuacion se observa como se ve el repositorio
```

📦 PerfulandiaBackendV1
├── .idea
├── carritoservice
├── pedidoservice
├── productoservice
├── usuarioservice
└── README.md

```

## 👥 Colaboración en GitHub

Primero que todo se realizo la creación del repositorio en GitHub y se crearon las ramas `main` que contribuyo principalmete a los Pull Request, las ramas `Andy-Villarroel` (PedidoService) y `Camila-Gonzalez` (CarritoService) las cuales trabajaron en los microservicios correspondientes.

Como equipo consideramos que la mejor manera de trabajar colaborativamente fue la comunicacion, los que nos ayudo a coordinar commits frecuentemente cada vez que se realizaba avance en cualquier microservicio.

> 📝 Explicar cómo se organizó el trabajo en ramas (`main`, `develop`, `usuario-service`, etc.), frecuencia de commits y cómo se coordinaron como equipo.

## 📈 Lecciones Aprendidas

Fue un trabajo bastante arduo, con varias complicaciones en el camino, tales como tratar de hacer el trabajo en GitHub ya que de vez en cuando se tenian problemas al realizar un `git pull`, o al tratar de hacer que los microservicios se conecten de manera correcta. Realizar este trabajo nos ayudo a comprender la cantidad de tiempo que demora el hacer microservicios que se comuniquen entre si y lograr que lo hagan de la manera correcta, lo que nos da un vistazo de como funcionan y como podemos verlos dia a dia con las diferentes apliaciones que utilizamos cotidianamente.

---
