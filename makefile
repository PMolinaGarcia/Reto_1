# Nombre del archivo jar
JAR_NAME = crossref.jar

# Directorios
SRC_DIR = src
BIN_DIR = bin
DOC_DIR = docs

# Rutas
SRC_APLICACION = $(SRC_DIR)/aplicacion
SRC_DOMINIO = $(SRC_DIR)/dominio

# Comando para buscar archivos Java
JAVA_FILES = $(shell find $(SRC_DIR) -name "*.java")

# Limpia los archivos compilados y el jar
limpiar:
	rm -f $(JAR_NAME)
	rm -rf $(BIN_DIR)
	rm -rf $(DOC_DIR)

# Compila el código fuente en bin/
compilar:
	rm -rf $(BIN_DIR)
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(JAVA_FILES)

# Crea el archivo jar ejecutable
jar: compilar
	jar cvfm $(JAR_NAME) Manifest.txt -C $(BIN_DIR) .

# Genera la documentación javadoc en /docs
javadoc:
	mkdir -p $(DOC_DIR)
	javadoc -d $(DOC_DIR) -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 $(JAVA_FILES)

# Ejecuta la aplicación (requiere jar o compilación previa)
ejecutar:
	java -cp $(BIN_DIR) aplicacion.Principal archivo

# Ejecuta con un archivo de entrada
runfile:
	java -cp $(BIN_DIR) aplicacion.Principal entrada.txt
