# 📮 Guía Paso a Paso: Postman (Versión Simple)

## 🎯 Si NO ves el botón "Import", haz esto:

### Paso 1: Cerrar el Chat
1. Si ves el chat del AI, ciérralo o ignóralo
2. Busca en la parte superior izquierda un botón que diga **"Workspaces"** o **"Home"**
3. Haz clic ahí

### Paso 2: Crear Request Manual (MÁS FÁCIL)

#### Para Probar GET (Listar Productos):
1. Haz clic en **"New"** (botón naranja arriba a la izquierda)
2. Selecciona **"HTTP Request"**
3. En el dropdown de métodos, selecciona **"GET"**
4. En la barra de URL, escribe: `http://localhost:8080/api/products`
5. Haz clic en **"Send"** (botón azul a la derecha)
6. Verás la respuesta abajo

#### Para Probar POST (Crear Estudiante):
1. Haz clic en **"New"** → **"HTTP Request"**
2. Selecciona **"POST"** en el dropdown
3. Escribe la URL: `http://localhost:8080/api/students`
4. Ve a la pestaña **"Body"** (debajo de la URL)
5. Selecciona **"raw"** (radio button)
6. En el dropdown de la derecha (que dice "Text"), cámbialo a **"JSON"**
7. Pega este código:
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
8. Haz clic en **"Send"**
9. Verás la respuesta con el estudiante creado

---

## 📋 Requests que DEBES Probar (en orden)

### 1. Crear un Estudiante
- **Método:** POST
- **URL:** `http://localhost:8080/api/students`
- **Body (JSON):**
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
- **Captura:** Toma captura de la respuesta (debe mostrar el estudiante con ID)

### 2. Crear un Curso
- **Método:** POST
- **URL:** `http://localhost:8080/api/courses`
- **Body (JSON):**
```json
{
  "name": "Matemáticas",
  "code": "MAT101",
  "credits": 3
}
```
- **Captura:** Toma captura de la respuesta

### 3. Asignar Curso a Estudiante ⭐ (MUY IMPORTANTE)
- **Método:** POST
- **URL:** `http://localhost:8080/api/students/1/courses/1`
  - (Si tu estudiante tiene ID 2, cambia a `/students/2/courses/1`)
- **Body:** NO pongas nada (déjalo vacío)
- **Captura:** Toma captura de la respuesta (debe mostrar el estudiante con el curso asignado)

### 4. Ver Estudiante con Cursos ⭐ (MUY IMPORTANTE)
- **Método:** GET
- **URL:** `http://localhost:8080/api/students/1`
- **Captura:** Toma captura de la respuesta (debe mostrar el estudiante con array de cursos)

### 5. Crear un Producto (Parte A del Laboratorio)
- **Método:** POST
- **URL:** `http://localhost:8080/api/products`
- **Body (JSON):**
```json
{
  "name": "Laptop",
  "warehouse": "Main",
  "quantity": 10,
  "price": 999.99
}
```

---

## 🖼️ Cómo Tomar Capturas

1. Después de hacer "Send", verás la respuesta en la parte inferior
2. Asegúrate de que veas:
   - La URL completa arriba
   - El método (GET/POST)
   - El Body (si es POST)
   - La respuesta JSON abajo
3. Toma captura de pantalla de TODO eso

---

## 💡 Si Postman te Confunde

**Alternativa más fácil:** Usa Thunder Client en VS Code
1. Abre VS Code
2. Presiona `Ctrl+Shift+X` (Extensions)
3. Busca "Thunder Client"
4. Instala
5. Clic en el ícono de rayo ⚡ en la barra lateral
6. Es más simple que Postman

