# 🚀 Pasos para GitHub y Render (Orden Correcto)

## 📋 Paso 1: Crear Repositorio en GitHub

### 1.1. Ve a GitHub
1. Abre tu navegador y ve a: **https://github.com**
2. Inicia sesión en tu cuenta

### 1.2. Crear Nuevo Repositorio
1. Haz clic en el botón **"+"** (arriba a la derecha) → **"New repository"**
2. Completa el formulario:
   - **Repository name:** `lab13-daw` (o el nombre que prefieras)
   - **Description:** "Laboratorio 13 - Microservicios Spring Boot"
   - **Visibility:** Elige **Public** o **Private** (según prefieras)
   - **⚠️ IMPORTANTE:** NO marques "Add a README file" (ya tienes uno)
   - **⚠️ IMPORTANTE:** NO marques "Add .gitignore" (ya tienes uno)
   - **⚠️ IMPORTANTE:** NO marques "Choose a license"
3. Haz clic en **"Create repository"**

### 1.3. Copiar la URL del Repositorio
Después de crear el repositorio, GitHub te mostrará una página con instrucciones. **Copia la URL** que aparece, será algo como:
```
https://github.com/TU_USUARIO/lab13-daw.git
```

---

## 📋 Paso 2: Subir el Código a GitHub

### 2.1. Abrir Terminal en la Carpeta del Proyecto
Abre PowerShell o Terminal en: `C:\Users\AGUSTIN\lab13-daw`

### 2.2. Ejecutar estos Comandos (uno por uno):

```bash
# Inicializar git (si no está inicializado)
git init

# Agregar todos los archivos
git add .

# Hacer commit
git commit -m "Laboratorio 13 - Microservicios completado"

# Conectar con GitHub (REEMPLAZA TU_USUARIO con tu usuario de GitHub)
git remote add origin https://github.com/TU_USUARIO/lab13-daw.git

# Cambiar a rama main
git branch -M main

# Subir el código
git push -u origin main
```

**⚠️ Nota:** Si te pide autenticación:
- Usa un **Personal Access Token** de GitHub (no tu contraseña)
- Para crear uno: GitHub → Settings → Developer settings → Personal access tokens → Generate new token

---

## 📋 Paso 3: Desplegar en Render

### 3.1. Crear Web Service
1. En Render, haz clic en **"New Web Service →"** (la segunda opción)
2. Render te pedirá conectar con GitHub
3. Haz clic en **"Connect GitHub"** o **"Connect account"**
4. Autoriza a Render para acceder a tus repositorios
5. Selecciona tu repositorio: **`lab13-daw`**

### 3.2. Configurar el Servicio

**Configuración básica:**
- **Name:** `lab13-daw`
- **Region:** Elige la más cercana (ej: "Oregon (US West)")
- **Branch:** `main`

**Build & Deploy:**
- **Build Command:** 
  ```bash
  mvn clean package -DskipTests
  ```
- **Start Command:**
  ```bash
  java -jar target/lab13-daw-0.0.1-SNAPSHOT.jar
  ```

**Instance Type:**
- Elige **"Free"** (si tienes cuenta gratuita)

### 3.3. Variables de Entorno

**⚠️ IMPORTANTE:** Render NO tiene MySQL gratis, solo Postgres. Tienes 2 opciones:

#### Opción A: Usar MySQL Externo (más fácil, no cambias código)
- Usa un servicio como **PlanetScale** (gratis) o **Railway** para MySQL
- O usa tu MySQL local si tienes IP pública

#### Opción B: Usar Postgres de Render (recomendado)
1. En Render, crea un servicio **Postgres** primero
2. Copia las credenciales que te da Render
3. Agrega estas variables de entorno en tu Web Service:
   ```
   SPRING_DATASOURCE_URL=jdbc:postgresql://host:5432/database
   SPRING_DATASOURCE_USERNAME=usuario
   SPRING_DATASOURCE_PASSWORD=password
   SPRING_JPA_HIBERNATE_DDL_AUTO=update
   ```

### 3.4. Desplegar
1. Haz clic en **"Create Web Service"**
2. Render comenzará a construir y desplegar
3. Espera 5-10 minutos
4. Cuando termine, tendrás una URL como: `https://lab13-daw.onrender.com`

---

## 🎯 Resumen Rápido

1. ✅ Crear repositorio en GitHub
2. ✅ Subir código a GitHub
3. ✅ Conectar GitHub con Render
4. ✅ Configurar Web Service en Render
5. ✅ Desplegar

---

## 🆘 Si tienes problemas

- **Error al subir a GitHub:** Verifica que tengas un Personal Access Token
- **Error en Render:** Revisa los logs en el dashboard de Render
- **Error de base de datos:** Verifica las variables de entorno

