package aplicacion;
import dominio.*;
import java.util.*;
import java.io.*;

/**
 * Clase principal para el funcionamiento del programa mediante la creación de nuevos métodos y la llamada de los creados en el árbol. Si la clase BinaryTree implementa la estructura
 * y la de CrossReference clasifica los elementos que podemos encontrarnos, en esta implementamos los métodos que nos permiten realizar el procesamiento de los datos. Aquí definimos
 * lo que son identificadores para que sea lo único que pueda añadirse al árbol.
 */

public class Principal{

    /**
     * Creamos referencias a los conjuntos de palabras y símbolos creados en CrossReference.
     */
    static Set <String> CARACTERES = CrossReference.CARACTERES;
    static Set <String> DIGITOS = CrossReference.DIGITOS;
    static Set <String> SEPARADORES = CrossReference.SEPARADORES;
    static Set <String> RESERVED_WORDS = CrossReference.RESERVED_WORDS;

    /**
     * Método para el procesamiento de líneas por individual, carácter a carácter.
     *
     * <p>
     * Creamos un StringBuilder que nos permite almacenar cada palabra.
     * Mediante un bucle, recorremos toda la línea símbolo a símbolo y creamos una variable que nos permita almacenar como String cada símbolo que encontremos.
     * En el caso de que encontremos un símbolo que sea de los caracteres reconocidos o un número, lo añadimos a la palabra.
     * De encontrarnos un separador, realizamos el procesamiento de la palabra: convirtiendo el StringBuilder en un String, si la palabra no está vacía y dicha palabra no se encuentra
     * en el listado de palabras reservadas, si el primer símbolo de la palabra es un carácter de los definidos en el conjunto CARACTERES, como es un identificador, lo añadimos al árbol; si comienza
     * por un número, según el criterio expresado en el enunciado, no lo consideramos identificador, por lo que rechazamos la palabra y la saltamos, reseteando el StringBuilder.
     *
     * @param line Es la línea que estamos procesando.
     * @param lineNumber Es el número de la línea en la que nos encontramos.
     * @param tree Es el árbol donde se están organizando los datos.
     */
    public static void procesarLinea(String line, int lineNumber, BinaryTree tree){

        StringBuilder palabra = new StringBuilder();

        for (int i = 0; i < line.length(); i++){

            String c = String.valueOf(line.charAt(i));

            if (CARACTERES.contains(c)){
                palabra.append(c);
            }

            else if(DIGITOS.contains(c)){
                palabra.append(c);
            }

            else if(SEPARADORES.contains(c)){
                String palabraString = palabra.toString();
                if (!palabraString.isEmpty() && !RESERVED_WORDS.contains(palabraString)){
                    if (CARACTERES.contains(String.valueOf(palabraString.charAt(0)))){
                        tree.add(palabraString,lineNumber);
                    }
                    else if (DIGITOS.contains(String.valueOf(palabraString.charAt(0)))){
                        palabra.setLength(0);
                    }
                }
                palabra.setLength(0);
            }
        }

    }

    /**
     * Método para procesar el archivo completo. Nos apoyaremos en el método procesarLinea, de tal forma que procesamos cada archivo línea a línea.
     *
     * <p>
     * En cuanto se recibe un archivo, se crea un nuevo árbol en el que almacenar los datos del archivo.
     * También se crea un Scanner para analizar el archivo y se inicializa en 0 una variable que nos indica el número de la línea en la que nos encontramos.
     * Siempre que exista una siguiente línea, la escaneamos y la procesamos; después, sumamos 1 a la línea para acumular y actualizar la línea en que nos encontramos.
     * <p>
     * Para poder ver el resultado, tras cerrar el escáner, recorremos el árbol en inOrden.
     *
     * @param archivo Es el archivo que estamos procesando.
     * @throws Exception La excepción que se puede elevar al no existir un archivo que le especifiquemos.
     *
     */
    public static void procesarArchivo(File archivo) throws Exception{
        BinaryTree arbol = new BinaryTree();
        Scanner sc = new Scanner (archivo);
        int numeroLinea=0;

        while (sc.hasNextLine()){
            String linea = sc.nextLine();
            procesarLinea(linea, numeroLinea, arbol);
            numeroLinea+=1;
        }
        sc.close();
        arbol.inOrdenTraversal();
    }

    /**
     * Método principal de ejecución.
     * <p>
     * Si no se escribe palabra, se nos invita a repetir.
     * En caso de escribirse algo, se crea un nuevo archivo con el argumento que se ha escrito. Si el archivo no existía, se indica que no existe; si existe, se procesa el archivo creado.
     * @param args Los argumentos que se pasan por terminal. Lo que habría que escribir por terminal sería el nombre del archivo.
     * @throws Exception La posible excepción que puede levantarse.
     */
    public static void main(String[] args) throws Exception {

        if (args.length == 0){
            System.out.println("Por favor, proporcione el nombre del archivo que quiera leer: ");
        }

        else {
            File archivo = new File(args[0]);
            if (!archivo.exists()) {
                System.out.println("El archivo: " + args[0] + " no existe");
            } else {
                procesarArchivo(archivo);
            }
        }


    }

}