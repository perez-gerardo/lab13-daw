# 📮 Guía Rápida: Cómo Usar Postman

## 📥 Paso 1: Descargar Postman

1. Ve a: **https://www.postman.com/downloads/**
2. Haz clic en "Download the Desktop App"
3. Descarga la versión para Windows
4. Instala el archivo descargado

---

## 🚀 Paso 2: Abrir Postman

1. Abre Postman (se abrirá en tu navegador o como aplicación)
2. Si te pide crear cuenta, puedes hacerlo o usar "Skip" (saltar)

---

## 📦 Paso 3: Importar la Colección (FÁCIL)

1. En Postman, haz clic en **"Import"** (botón arriba a la izquierda)
2. Selecciona el archivo: **`Laboratorio13.postman_collection.json`**
3. ¡Listo! Ya tienes todos los endpoints listos para usar

---

## 🎯 Paso 4: Usar los Endpoints

### Opción A: Usar la Colección Importada
1. En el panel izquierdo, verás la carpeta "Laboratorio 13 - Microservicios"
2. Expande las carpetas: "Products", "Students", "Courses", "Relación Muchos a Muchos"
3. Haz clic en cualquier request (ej: "POST - Crear estudiante")
4. Haz clic en **"Send"** (botón azul)
5. Verás la respuesta abajo

### Opción B: Crear Request Manual

#### Para GET (listar):
1. Clic en **"New"** → **"HTTP Request"**
2. Selecciona **GET** en el dropdown
3. Escribe: `http://localhost:8080/api/products`
4. Clic en **"Send"**

#### Para POST (crear):
1. Clic en **"New"** → **"HTTP Request"**
2. Selecciona **POST** en el dropdown
3. Escribe: `http://localhost:8080/api/students`
4. Ve a la pestaña **"Body"**
5. Selecciona **"raw"**
6. En el dropdown de la derecha, selecciona **"JSON"**
7. Pega este JSON:
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
8. Clic en **"Send"**

---

## 📸 Paso 5: Tomar Capturas para tu Documento

1. Después de hacer "Send", verás la respuesta en la parte inferior
2. Asegúrate de que el formato esté en **"JSON"** (no "Text")
3. Haz clic derecho en la respuesta → **"Copy"** o toma captura de pantalla
4. Para capturas, incluye:
   - La URL completa
   - El método (GET, POST, etc.)
   - El Body (si es POST)
   - La respuesta JSON

---

## 🎯 Endpoints Más Importantes para Capturar

### 1. Crear Producto (Parte A)
- POST `http://localhost:8080/api/products`
- Body:
```json
{
  "name": "Laptop",
  "warehouse": "Main",
  "quantity": 10,
  "price": 999.99
}
```

### 2. Crear Estudiante (Parte B)
- POST `http://localhost:8080/api/students`
- Body:
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```

### 3. Crear Curso (Parte B)
- POST `http://localhost:8080/api/courses`
- Body:
```json
{
  "name": "Matemáticas",
  "code": "MAT101",
  "credits": 3
}
```

### 4. Asignar Curso a Estudiante ⭐ (MUY IMPORTANTE)
- POST `http://localhost:8080/api/students/1/courses/1`
- Sin body (vacío)
- **Esta es la relación muchos a muchos**

### 5. Ver Estudiante con Cursos ⭐ (MUY IMPORTANTE)
- GET `http://localhost:8080/api/students/1`
- Debe mostrar el estudiante con sus cursos asignados

---

## 💡 Tips

- **Cambiar IDs:** Si creaste un estudiante con ID 2, cambia `/students/1` por `/students/2`
- **Ver JSON bonito:** En la respuesta, haz clic en "Pretty" para verlo formateado
- **Guardar:** Postman guarda automáticamente tus requests

---

## 🔄 Alternativa: Thunder Client (si no quieres descargar Postman)

1. Abre VS Code
2. Ve a Extensions (Ctrl+Shift+X)
3. Busca "Thunder Client"
4. Instala
5. Clic en el ícono de rayo en la barra lateral
6. Funciona igual que Postman pero dentro de VS Code

