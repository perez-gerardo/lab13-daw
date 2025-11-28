# Laboratorio 13 - Microservicios con Spring Boot

## 📋 Descripción

Este proyecto implementa una aplicación de microservicios utilizando Spring Boot con Docker, que incluye:

1. **CRUD básico de Productos** (ejemplo inicial del laboratorio)
2. **CRUD de relación Muchos a Muchos** entre Estudiantes y Cursos (ejercicio de aplicación)

## 🛠️ Tecnologías Utilizadas

- **Spring Boot 4.0.0**
- **Java 17**
- **MySQL 8.0**
- **Docker & Docker Compose**
- **Spring Data JPA**
- **HTML/CSS/JavaScript** (Frontend)

## 📁 Estructura del Proyecto

```
lab13-daw/
├── src/
│   └── main/
│       ├── java/com/tecsup/lab13daw/
│       │   ├── model/
│       │   │   ├── Product.java
│       │   │   ├── Student.java
│       │   │   └── Course.java
│       │   ├── repository/
│       │   │   ├── ProductRepository.java
│       │   │   ├── StudentRepository.java
│       │   │   └── CourseRepository.java
│       │   ├── controller/
│       │   │   ├── ProductController.java
│       │   │   ├── StudentController.java
│       │   │   └── CourseController.java
│       │   └── Lab13DawApplication.java
│       └── resources/
│           ├── application.properties
│           └── static/
│               └── index.html
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

## 🚀 Instalación y Ejecución

### Prerrequisitos

- Docker Desktop instalado
- Git (para clonar el repositorio)

### Pasos para ejecutar

1. **Clonar el repositorio:**
   ```bash
   git clone <url-del-repositorio>
   cd lab13-daw
   ```

2. **Construir e iniciar los contenedores:**
   ```bash
   docker-compose up --build -d
   ```

3. **Verificar que los contenedores estén corriendo:**
   ```bash
   docker-compose ps
   ```

4. **Acceder a la aplicación:**
   - Frontend: http://localhost:8080
   - API REST: http://localhost:8080/api

## 📡 Endpoints de la API

### Productos (CRUD Básico)
- `GET /api/products` - Lista todos los productos
- `GET /api/products/{id}` - Obtiene un producto por ID
- `POST /api/products` - Crea un nuevo producto
- `PUT /api/products/{id}` - Actualiza un producto
- `DELETE /api/products/{id}` - Elimina un producto

### Estudiantes (CRUD)
- `GET /api/students` - Lista todos los estudiantes
- `GET /api/students/{id}` - Obtiene un estudiante por ID con sus cursos
- `POST /api/students` - Crea un nuevo estudiante
- `PUT /api/students/{id}` - Actualiza un estudiante
- `DELETE /api/students/{id}` - Elimina un estudiante

### Cursos (CRUD)
- `GET /api/courses` - Lista todos los cursos
- `GET /api/courses/{id}` - Obtiene un curso por ID con sus estudiantes
- `POST /api/courses` - Crea un nuevo curso
- `PUT /api/courses/{id}` - Actualiza un curso
- `DELETE /api/courses/{id}` - Elimina un curso

### Relación Muchos a Muchos
- `POST /api/students/{studentId}/courses/{courseId}` - Asigna un curso a un estudiante
- `DELETE /api/students/{studentId}/courses/{courseId}` - Quita un curso de un estudiante

## 🗄️ Base de Datos

- **Motor:** MySQL 8.0
- **Base de datos:** example_db
- **Usuario:** root
- **Contraseña:** rootpassword
- **Puerto:** 3306

Las tablas se crean automáticamente mediante Hibernate con `spring.jpa.hibernate.ddl-auto=update`.

## 🐳 Docker

El proyecto utiliza Docker Compose para orquestar dos servicios:

1. **db:** Contenedor MySQL 8.0
2. **app:** Aplicación Spring Boot

### Comandos útiles

```bash
# Iniciar contenedores
docker-compose up -d

# Ver logs
docker-compose logs -f app

# Detener contenedores
docker-compose down

# Detener y eliminar volúmenes (borra la base de datos)
docker-compose down -v
```

## 🌐 Despliegue en Render

Para desplegar en Render:

1. Conecta tu repositorio de GitHub a Render
2. Configura como servicio Web
3. Usa el siguiente comando de build:
   ```bash
   mvn clean package -DskipTests
   ```
4. Comando de inicio:
   ```bash
   java -jar target/lab13-daw-0.0.1-SNAPSHOT.jar
   ```
5. Configura las variables de entorno para la base de datos MySQL de Render

## 👤 Autor

- **Estudiante:** [Tu Nombre]
- **Curso:** Desarrollo de Aplicaciones Web 5 - C24
- **Docente:** Coello Palomino, Ricardo

## 📝 Notas

- El frontend está disponible en la ruta raíz (`/`) del servidor
- La API REST está disponible en `/api/*`
- Los endpoints permiten CORS desde cualquier origen para desarrollo

