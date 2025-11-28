# 📸 Capturas Requeridas para el Laboratorio 13

## ✅ Lista de Capturas que Debes Adjuntar en tu Documento

### 1. **Captura de Contenedores Docker Corriendo** ⭐ OBLIGATORIA
**Qué capturar:**
- Abre Docker Desktop o ejecuta en terminal: `docker-compose ps`
- Debe mostrar ambos contenedores corriendo:
  - `mysql-db` (estado: healthy)
  - `spring-boot-app` (estado: Up)

**Comando para capturar:**
```bash
docker-compose ps
```

---

### 2. **Captura del Frontend (HTML) Funcionando** ⭐ OBLIGATORIA
**Qué capturar:**
- Abre tu navegador en: **http://localhost:8080/**
- Debe mostrar la interfaz completa del CRUD de Estudiantes y Cursos
- Captura toda la pantalla mostrando:
  - Formularios de creación
  - Listas de estudiantes y cursos
  - Sección de asignación de cursos

**URL:** http://localhost:8080/

---

### 3. **Capturas de Pruebas de Endpoints (Postman/Thunder Client/Navegador)** ⭐ OBLIGATORIA

#### 3.1. GET /api/products - Listar productos
- Método: GET
- URL: http://localhost:8080/api/products
- Captura la respuesta JSON

#### 3.2. POST /api/products - Crear producto
- Método: POST
- URL: http://localhost:8080/api/products
- Body (JSON):
```json
{
  "name": "Laptop",
  "warehouse": "Main",
  "quantity": 10,
  "price": 999.99
}
```
- Captura la respuesta con el producto creado

#### 3.3. GET /api/students - Listar estudiantes
- Método: GET
- URL: http://localhost:8080/api/students
- Captura la respuesta JSON

#### 3.4. POST /api/students - Crear estudiante
- Método: POST
- URL: http://localhost:8080/api/students
- Body (JSON):
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
- Captura la respuesta

#### 3.5. POST /api/courses - Crear curso
- Método: POST
- URL: http://localhost:8080/api/courses
- Body (JSON):
```json
{
  "name": "Matemáticas",
  "code": "MAT101",
  "credits": 3
}
```
- Captura la respuesta

#### 3.6. POST /api/students/{id}/courses/{id} - Asignar curso a estudiante (RELACIÓN MUCHOS A MUCHOS)
- Método: POST
- URL: http://localhost:8080/api/students/1/courses/1
- Captura la respuesta mostrando el estudiante con sus cursos

#### 3.7. GET /api/students/{id} - Ver estudiante con cursos asignados
- Método: GET
- URL: http://localhost:8080/api/students/1
- Captura la respuesta JSON mostrando la relación muchos a muchos

---

### 4. **Captura de Base de Datos MySQL** ⭐ OBLIGATORIA
**Qué capturar:**
- Conéctate a MySQL desde terminal o cliente MySQL
- Ejecuta: `SHOW TABLES;` - Debe mostrar: `products`, `students`, `courses`, `student_course`
- Ejecuta: `SELECT * FROM student_course;` - Muestra la tabla intermedia de la relación muchos a muchos
- Ejecuta: `SELECT * FROM students;` y `SELECT * FROM courses;`

**Comando para conectarse:**
```bash
docker exec -it mysql-db mysql -u root -prootpassword example_db
```

**O desde terminal:**
```bash
mysql -h 127.0.0.1 -P 3306 -u root -prootpassword example_db
```

---

### 5. **Captura de Estructura del Proyecto** ⭐ OPCIONAL pero recomendada
**Qué capturar:**
- Muestra la estructura de carpetas del proyecto en tu IDE
- Debe verse:
  - `src/main/java/com/tecsup/lab13daw/model/` (con Student.java, Course.java, Product.java)
  - `src/main/java/com/tecsup/lab13daw/controller/`
  - `src/main/java/com/tecsup/lab13daw/repository/`
  - `src/main/resources/static/index.html`
  - `docker-compose.yml`
  - `Dockerfile`

---

### 6. **Captura de GitHub** ⭐ OBLIGATORIA (Ejercicio de aplicación)
**Qué capturar:**
- URL del repositorio en GitHub
- Captura de la página principal del repositorio
- Muestra que el código está subido

---

### 7. **Captura de Render Desplegado** ⭐ OBLIGATORIA (Ejercicio de aplicación)
**Qué capturar:**
- URL de la aplicación desplegada en Render
- Captura de la aplicación funcionando en producción
- Muestra el frontend accesible desde la URL de Render

---

## 📋 Resumen de Capturas Mínimas Requeridas

### Parte A (Requerimientos del Laboratorio):
1. ✅ Contenedores Docker corriendo
2. ✅ Pruebas de endpoints de Product (GET, POST)
3. ✅ Base de datos MySQL mostrando tablas

### Parte B (Ejercicio de Aplicación):
4. ✅ Frontend HTML funcionando (http://localhost:8080/)
5. ✅ Pruebas de endpoints de Students y Courses
6. ✅ Prueba de relación muchos a muchos (asignar curso a estudiante)
7. ✅ Base de datos mostrando tabla `student_course`
8. ✅ Repositorio en GitHub
9. ✅ Aplicación desplegada en Render

### Conclusiones:
10. ✅ 5 conclusiones (ya están en el archivo CONCLUSIONES.md)

---

## 🎯 Orden Sugerido para las Capturas en tu Documento

1. **Introducción** - Estructura del proyecto
2. **Docker** - Contenedores corriendo
3. **Endpoints Product** - Pruebas CRUD básico
4. **Base de Datos** - Tablas creadas
5. **Frontend** - Interfaz HTML funcionando
6. **Endpoints Students/Courses** - Pruebas CRUD
7. **Relación Muchos a Muchos** - Asignación de cursos
8. **Base de Datos** - Tabla intermedia `student_course`
9. **GitHub** - Repositorio
10. **Render** - Despliegue en producción
11. **Conclusiones** - 5 conclusiones

