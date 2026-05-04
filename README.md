# 🗄️ Ejercicio9 [ConexionOracleMaven] — Funciones de Agregado y Agrupamiento

Este proyecto Java gestionado con Maven se conecta a una base de datos Oracle para realizar consultas estadísticas avanzadas sobre la tabla `empleado`. Utiliza funciones de agregado de SQL para obtener métricas sobre los salarios de la plantilla.

## 📋 Descripción del Proyecto
El propósito de esta aplicación es demostrar el uso de funciones estadísticas en JDBC. El programa ejecuta dos tipos de análisis:
1.  **Agrupamiento (Group By)**: Cuenta cuántos empleados existen por cada rango de salario, ordenándolos de mayor a menor.
2.  **Cálculo de Media (AVG)**: Calcula el salario promedio de toda la tabla, redondeando el resultado a dos decimales directamente en el servidor.

## 🎯 Funcionalidades del Menú
Al ejecutarse, el programa realiza automáticamente las siguientes operaciones:
*   **Conexión a Oracle**: Se enlaza con el servidor mediante las credenciales de `db.properties`.
*   **Conteo por Salario**: Ejecuta una consulta con `COUNT(*)` y `GROUP BY` para mostrar la frecuencia de cada salario.
*   **Cálculo de Promedio**: Utiliza `ROUND(AVG(SALARIO),2)` para obtener la media aritmética de los sueldos.
*   **Presentación de Datos**: Muestra los resultados formateados en la consola de comandos.

## 🏗️ Estructura del Proyecto
El proyecto mantiene la organización modular estándar de Maven:

```text
Ejercicio9 [ConexionOracleMaven]/
│
├── 📁 src/
│   └── 📁 main/
│       ├── 📁 java/
│       │   └── 📁 org/example/
│       │       ├── ☕ DBConfig.java        # Proveedor de configuración JDBC
│       │       └── ☕ Main.java            # Lógica de agregación y estadísticas
│       └── 📁 resources/
│           └── 📄 db.properties           # Credenciales de acceso externas
│
├── 📁 target/                             # Binarios generados por Maven
├── 📄 pom.xml                             # Dependencias (OJDBC11)
└── 📄 README.md                           # Documentación del proyecto
```

## 📄 Formato del Archivo de Entrada
El archivo `src/main/resources/db.properties` debe contener tus datos de acceso:
```properties
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.user=tu_usuario
db.password=tu_contraseña
```

## 🚀 Compilación y Ejecución
### Requisitos
*   Java JDK 17 o superior.
*   Maven 3.8+.
*   Oracle Database con datos cargados en la tabla `empleado`.

### Comandos
```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## 🔧 Características Técnicas Implementadas
*   **Agrupamiento SQL**: Uso de `GROUP BY` y `ORDER BY DESC` para organizar la información.
*   **Funciones Matemáticas**: Aplicación de `AVG` (promedio) y `ROUND` (redondeo) a nivel de consulta.
*   **ResultSet Dinámico**: Extracción de datos calculados mediante alias y nombres de columna de agregado.
*   **Gestión de Recursos**: Uso de `try-with-resources` para el cierre automático de objetos `Connection`, `Statement` y `ResultSet`.

## 🎮 Ejemplo de Uso Visual

**Salida esperada en Consola:**
```bash
Conexión establecida con Oracle.
3500.0 --> 2
2800.0 --> 1
2355.15 --> 1
Media de salarios: 3038.79
```

---
**Autor:** Judith Olmedo Andrés  
*Ejercicio 9 - Estadísticas y Funciones de Agregado en Oracle JDBC*