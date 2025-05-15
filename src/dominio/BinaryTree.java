package dominio;
import java.util.*;

/**
 * Clase que implementa el árbol
 */
public class BinaryTree{


    /**
     * Clase del nodo, que es la unidad de la que parte cada árbol.
     * Sus atributos son la información que contengan (en este caso, el nombre del identificador) y las líneas en que figura dicho identificador; elegimos un ArrayList para saber dónde aparece
     * y cuántas veces en cada línea. También añadimos como atributos un árbol a su derecha y un árbol a su izquierda, para que sea binario.
     */
    private class Node{


        public String info;

        public ArrayList <Integer> lineas = new ArrayList<>();

        BinaryTree der;

        BinaryTree izq;

        /**
         * Constructores del nodo
         */
        Node(){}

        Node(String identifier, int lineNumber){
            this.info=identifier;
            this.lineas.add(lineNumber);
        }

        Node(String identifier, int lineNumber, BinaryTree izq, BinaryTree der){
            this.info=identifier;
            this.lineas.add(lineNumber);
            this.der=der;
            this.izq=izq;
        }

    }

    /**
     * Cada árbol tiene una raíz de la que parte, por lo que creamos un atributo de raíz.
     */

    private Node raiz;


    /**
     * Método para añadir elementos al árbol
     * @param info Es el identificador, que se implementa en el nodo como su atributo de "info".
     * @param nLinea Es el número de la línea en la que nos encontramos al examinar el archivo.
     * <p>
     * Partimos del análisis de la raíz del árbol: de ser nula, añadimos un nuevo nodo con la información que tenemos, el número de línea, y nuevos árboles vacíos a izquierda y derecha. Este nuevo nodo es la raíz del árbol a partir de la cual se ordenará todo lo demás.
     * <p>
     * Si ya existiera una raíz, añadimos a izquierda o a derecha, según si el identificador es anterior o posterior en orden alfabético a la raíz. En caso de ser igual -es decir, que coincida la palabra-, solo añadimos a la raíz la nueva línea donde hemos encontrado la misma palabra.
     */
    public void add(String info, int nLinea){
        if (raiz==null){
            raiz=new Node(info, nLinea, new BinaryTree(), new BinaryTree());
        }

        else {
              if (info.compareTo(raiz.info) < 0) {
                  if (raiz.izq==null){
                      raiz.izq = new BinaryTree();
                  }
                  raiz.izq.add(info, nLinea);
              }
              else if (info.compareTo(raiz.info) > 0) {
                  if (raiz.der==null) {
                      raiz.der = new BinaryTree();
                  }
                  raiz.der.add(info, nLinea);

              }
              else  {
                raiz.lineas.add(nLinea);
              }
        }
    }


    /**
     * Método para realizar y mostrar el recorrido inOrden del árbol. Recordamos que inOrden implica primero la izquierda, luego la raíz y después la derecha.
     * <p>
     * En caso de que la raíz sea nula, no hacemos nada.
     * En caso de que no sea nula, analizamos el árbol: si la raíz del árbol de la izquierda no es vacía, realizamos el recorrido inOrden por la izquierda. Después, escribimos la información de la raiz e indicamos en qué líneas aparece.
     * Por último, realizamos el recorrido inOrden por la derecha. Es un método recursivo que se asegura de recorrer todo el árbol siempre en la misma estructura, comenzando siempre por el que está más a la izquierda.
     */
    public void inOrdenTraversal() {

        if (raiz == null) {
            return;
        }

        else {

            if (raiz.izq != null) {
                raiz.izq.inOrdenTraversal();
            }

            System.out.println(raiz.info + " -> aparece en las lineas: " + raiz.lineas);

            if (raiz.der != null){
                raiz.der.inOrdenTraversal();
            }

        }
    }

}