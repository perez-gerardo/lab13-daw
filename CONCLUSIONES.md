# Conclusiones del Laboratorio 13 - Microservicios

## 5 Conclusiones del Laboratorio

### 1. **Arquitectura de Microservicios y Contenedores**
La implementación de microservicios con Docker permite una separación clara de responsabilidades y facilita el despliegue independiente de cada servicio. Docker Compose simplifica la orquestación de múltiples contenedores (aplicación Spring Boot y base de datos MySQL), creando una red interna que permite la comunicación entre servicios de manera eficiente y aislada del entorno host.

### 2. **Ventajas de la Persistencia con Volúmenes Docker**
El uso de volúmenes en Docker garantiza la persistencia de datos de la base de datos MySQL, evitando la pérdida de información al reiniciar o eliminar contenedores. Esto es fundamental para aplicaciones en producción, ya que los datos críticos se mantienen seguros independientemente del ciclo de vida de los contenedores.

### 3. **Relaciones Muchos a Muchos en JPA/Hibernate**
La implementación de relaciones muchos a muchos entre entidades (Estudiantes y Cursos) demuestra la potencia de JPA/Hibernate para gestionar relaciones complejas. La tabla intermedia `student_course` se crea automáticamente, y los métodos `addCourse()` y `removeCourse()` facilitan la gestión bidireccional de la relación, manteniendo la consistencia de datos.

### 4. **Comunicación entre Servicios en Red Docker**
La comunicación entre la aplicación Spring Boot y MySQL se realiza a través de la red interna de Docker usando los nombres de servicio como hostnames (por ejemplo, `db:3306`). Esto elimina la necesidad de configurar IPs estáticas y hace que la aplicación sea más portable y fácil de desplegar en diferentes entornos.

### 5. **Frontend y Backend Desacoplados**
El desarrollo de un frontend HTML/JavaScript que consume una API REST permite una arquitectura desacoplada donde el frontend y backend pueden evolucionar independientemente. Esto facilita el mantenimiento, permite múltiples clientes (web, móvil, etc.) y mejora la escalabilidad de la aplicación.

