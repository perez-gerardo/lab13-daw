# 📮 Ejemplos para Probar en Postman

## ✅ Lo que el Laboratorio Pide

### Parte A (Requerimientos Básicos):
- ✅ CRUD de **Product** (ya está hecho)

### Parte B (Ejercicio de Aplicación):
- ✅ **CRUD de relación Muchos a Muchos** (Students ↔ Courses) ← **ESTO ES LO QUE PEDÍA**
- ✅ Frontend y Backend

**Conclusión:** Lo que hicimos (Students y Courses) está **CORRECTO** ✅

---

## 🧪 Ejemplos para Probar en Postman

### 1. **CRUD de PRODUCTOS** (Parte A del Laboratorio)

#### 1.1. Crear un Producto
- **Método:** `POST`
- **URL:** `http://localhost:8080/api/products`
- **Headers:**
  - `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "name": "Laptop",
  "warehouse": "Main",
  "quantity": 10,
  "price": 999.99
}
```
- **Respuesta esperada:** Producto creado con ID

#### 1.2. Listar Todos los Productos
- **Método:** `GET`
- **URL:** `http://localhost:8080/api/products`
- **Respuesta esperada:** Array de productos

#### 1.3. Obtener un Producto por ID
- **Método:** `GET`
- **URL:** `http://localhost:8080/api/products/1`
- **Respuesta esperada:** Un producto

---

### 2. **CRUD de ESTUDIANTES** (Parte B - Ejercicio de Aplicación)

#### 2.1. Crear un Estudiante
- **Método:** `POST`
- **URL:** `http://localhost:8080/api/students`
- **Headers:**
  - `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
- **Respuesta esperada:** Estudiante creado con ID

#### 2.2. Listar Todos los Estudiantes
- **Método:** `GET`
- **URL:** `http://localhost:8080/api/students`
- **Respuesta esperada:** Array de estudiantes

#### 2.3. Obtener un Estudiante por ID (con sus cursos)
- **Método:** `GET`
- **URL:** `http://localhost:8080/api/students/1`
- **Respuesta esperada:** Estudiante con array de cursos asignados

---

### 3. **CRUD de CURSOS** (Parte B - Ejercicio de Aplicación)

#### 3.1. Crear un Curso
- **Método:** `POST`
- **URL:** `http://localhost:8080/api/courses`
- **Headers:**
  - `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "name": "Matemáticas",
  "code": "MAT101",
  "credits": 3
}
```
- **Respuesta esperada:** Curso creado con ID

#### 3.2. Listar Todos los Cursos
- **Método:** `GET`
- **URL:** `http://localhost:8080/api/courses`
- **Respuesta esperada:** Array de cursos

---

### 4. **RELACIÓN MUCHOS A MUCHOS** ⭐ (Lo más importante del ejercicio)

#### 4.1. Asignar un Curso a un Estudiante
- **Método:** `POST`
- **URL:** `http://localhost:8080/api/students/1/courses/1`
  - Reemplaza `1` con el ID del estudiante
  - Reemplaza `1` con el ID del curso
- **Headers:** No necesarios (es un POST sin body)
- **Body:** Vacío (no enviar nada)
- **Respuesta esperada:** Estudiante actualizado con el curso asignado
```json
{
  "id": 1,
  "name": "Juan Pérez",
  "email": "juan@example.com",
  "courses": [
    {
      "id": 1,
      "name": "Matemáticas",
      "code": "MAT101",
      "credits": 3
    }
  ]
}
```

#### 4.2. Ver Estudiante con Cursos Asignados
- **Método:** `GET`
- **URL:** `http://localhost:8080/api/students/1`
- **Respuesta esperada:** Estudiante con todos sus cursos

#### 4.3. Quitar un Curso de un Estudiante
- **Método:** `DELETE`
- **URL:** `http://localhost:8080/api/students/1/courses/1`
- **Respuesta esperada:** Estudiante sin ese curso

---

## 📋 Orden Recomendado para Probar

### Paso 1: Crear Datos Base
1. Crear un estudiante (POST /api/students)
2. Crear otro estudiante (POST /api/students)
3. Crear un curso (POST /api/courses)
4. Crear otro curso (POST /api/courses)

### Paso 2: Probar la Relación Muchos a Muchos
5. Asignar curso 1 al estudiante 1 (POST /api/students/1/courses/1)
6. Asignar curso 2 al estudiante 1 (POST /api/students/1/courses/2)
7. Ver estudiante 1 con sus cursos (GET /api/students/1) ← **MUESTRA LA RELACIÓN**

### Paso 3: Verificar en Base de Datos
8. Conectarse a MySQL y ejecutar: `SELECT * FROM student_course;`

---

## 🎯 Capturas Mínimas para tu Documento

1. ✅ POST /api/products (crear producto)
2. ✅ GET /api/products (listar productos)
3. ✅ POST /api/students (crear estudiante)
4. ✅ POST /api/courses (crear curso)
5. ✅ POST /api/students/1/courses/1 (asignar curso) ← **MUY IMPORTANTE**
6. ✅ GET /api/students/1 (ver estudiante con cursos) ← **MUESTRA LA RELACIÓN**
7. ✅ SELECT * FROM student_course (tabla intermedia)

---

## 💡 Tips para Postman

1. **Crear una Collection:**
   - Crea una colección llamada "Laboratorio 13"
   - Organiza las requests por carpetas: "Products", "Students", "Courses", "Relaciones"

2. **Guardar Variables:**
   - Crea una variable `base_url` = `http://localhost:8080`
   - Usa `{{base_url}}/api/products` en lugar de escribir la URL completa

3. **Ver la Respuesta:**
   - Asegúrate de que el formato esté en "JSON" (no "Text")
   - Usa "Pretty" para ver el JSON formateado

