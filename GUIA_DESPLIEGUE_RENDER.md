# 🚀 Guía Completa: Desplegar en Render

## 📋 Paso 1: Subir el Proyecto a GitHub

### 1.1. Crear repositorio en GitHub
1. Ve a https://github.com
2. Haz clic en el botón "+" (arriba a la derecha) → "New repository"
3. Nombre: `lab13-daw` (o el que prefieras)
4. Hazlo **Público** o **Privado** (según prefieras)
5. **NO** marques "Add a README file" (ya tienes uno)
6. Haz clic en "Create repository"

### 1.2. Subir el código desde tu computadora
Abre PowerShell o Terminal en la carpeta del proyecto y ejecuta:

```bash
# Inicializar git (si no lo has hecho)
git init

# Agregar todos los archivos
git add .

# Hacer commit
git commit -m "Laboratorio 13 - Microservicios completado"

# Conectar con GitHub (reemplaza TU_USUARIO con tu usuario de GitHub)
git remote add origin https://github.com/TU_USUARIO/lab13-daw.git

# Subir el código
git branch -M main
git push -u origin main
```

**Nota:** Si te pide autenticación, usa un Personal Access Token de GitHub.

---

## 📋 Paso 2: Desplegar en Render

### 2.1. Crear Web Service en Render
1. En la pantalla que tienes abierta, haz clic en **"New Web Service →"**
   - (Es la segunda opción, "Web Services")

### 2.2. Conectar con GitHub
1. Render te pedirá conectar con GitHub
2. Haz clic en "Connect GitHub" o "Connect account"
3. Autoriza a Render para acceder a tus repositorios
4. Selecciona tu repositorio: `lab13-daw`

### 2.3. Configurar el Servicio

**Configuración básica:**
- **Name:** `lab13-daw` (o el nombre que prefieras)
- **Region:** Elige la más cercana (ej: "Oregon (US West)")
- **Branch:** `main` (o `master` si usas esa rama)

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
- Elige "Free" (si tienes cuenta gratuita) o "Starter" ($7/mes)

### 2.4. Configurar Variables de Entorno

En la sección "Environment Variables", agrega:

```
SPRING_DATASOURCE_URL=jdbc:mysql://TU_HOST_MYSQL:3306/TU_DATABASE
SPRING_DATASOURCE_USERNAME=TU_USUARIO
SPRING_DATASOURCE_PASSWORD=TU_PASSWORD
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```

**⚠️ IMPORTANTE:** Render NO tiene MySQL nativo, solo Postgres. Tienes 3 opciones:

#### Opción A: Usar MySQL externo (más fácil)
- Usa un servicio como **PlanetScale**, **Aiven**, o **Railway** para MySQL
- O usa tu MySQL local si tienes IP pública

#### Opción B: Adaptar a Postgres (recomendado para Render)
- Cambiar dependencia de MySQL a Postgres
- Cambiar configuración de base de datos

#### Opción C: Usar Postgres de Render (más fácil para Render)
- Crear un servicio Postgres en Render
- Adaptar el código para usar Postgres

---

## 📋 Paso 3: Crear Base de Datos en Render

### 3.1. Crear Postgres (si eliges Opción C)
1. En Render, haz clic en "New" → "Postgres"
2. Configura:
   - **Name:** `lab13-db`
   - **Database:** `lab13_db`
   - **User:** Se crea automáticamente
   - **Password:** Se genera automáticamente
3. Copia las credenciales (las necesitarás para las variables de entorno)

### 3.2. Adaptar el código para Postgres (si eliges Opción C)

Necesitarás cambiar:
1. **pom.xml:** Cambiar dependencia de MySQL a Postgres
2. **application.properties:** Cambiar URL de conexión

---

## 📋 Paso 4: Desplegar

1. Haz clic en "Create Web Service"
2. Render comenzará a construir y desplegar tu aplicación
3. Espera 5-10 minutos
4. Cuando termine, tendrás una URL como: `https://lab13-daw.onrender.com`

---

## 🎯 Configuración Rápida (Resumen)

### Si usas MySQL externo:
```
SPRING_DATASOURCE_URL=jdbc:mysql://host:3306/database
SPRING_DATASOURCE_USERNAME=usuario
SPRING_DATASOURCE_PASSWORD=password
```

### Si usas Postgres de Render:
```
SPRING_DATASOURCE_URL=jdbc:postgresql://host:5432/database
SPRING_DATASOURCE_USERNAME=usuario
SPRING_DATASOURCE_PASSWORD=password
```

---

## ⚠️ Notas Importantes

1. **Render Free tier:** Se "duerme" después de 15 minutos de inactividad. La primera petición puede tardar 30-60 segundos en despertar.

2. **Base de datos:** Render solo ofrece Postgres gratis. Para MySQL necesitas servicio externo.

3. **Puerto:** Render asigna el puerto automáticamente. No necesitas configurar `server.port` en variables de entorno.

4. **Logs:** Puedes ver los logs en tiempo real en el dashboard de Render.

---

## 🆘 Si tienes problemas

1. **Error de build:** Revisa los logs en Render
2. **Error de conexión a BD:** Verifica las variables de entorno
3. **Aplicación no inicia:** Revisa el "Start Command"

