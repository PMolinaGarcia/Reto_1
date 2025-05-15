# Reto_1

## 🧠 CrossReference: Analizador de Identificadores en Java

Bienvenido a **CrossReference**, un proyecto Java que analiza archivos fuente y extrae los identificadores válidos, ignorando palabras reservadas y números como primer carácter. Los identificadores válidos se almacenan en un árbol binario y se listan indicando en qué líneas aparecen 🌳.

Si se quisiera cambiar el archivo que se analiza, habría que modificar el contenido de "archivo" o añadir un archivo nuevo y 
modificar el makefile para que la ejecución se realice con el nombre de dicho nuevo archivo 📄.
---

## 🚀 ¿Cómo usarlo?

### 🔧 Requisitos
- Java 8 o superior
- Make (Linux/macOS o Windows con WSL/Git Bash)

### ⚙️ Comandos disponibles

| Comando | Descripción |
|--------|-------------|
| `make compilar` | Compila el código fuente. |
| `make limpiar`  | Elimina binarios y el JAR. |
| `make jar`      | Compila y empaqueta en `crossref.jar`. |
| `make javadoc`  | Genera la documentación en `/docs`. |
| `make ejecutar` | Ejecuta el programa desde `Principal`. |
| `make runfile`  | Ejecuta usando `entrada.txt` como entrada. |

---

## 🧪 Ejemplo de Uso

```bash
make jar
java -jar crossref.jar entrada.txt


