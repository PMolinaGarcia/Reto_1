package dominio;
import java.util.*;

/**
 * Clase que almacena los listados de palabras y caracteres a los que necesitamos hacer referencia a la hora de almacenar datos en el árbol.
 *
 * Tenemos el conjunto de palabras reservadas, el de caracteres, que incluye las letras y los símbolos de dolar y guion bajo; el de dígitos, que tiene los números; y el de los separadores.
 *
 * Creamos un conjunto de dígitos separado del de caracteres porque se nos especifica en las instrucciones que los identificadores pueden empezar por letras, guiones bajos o símbolos de dólar. Entonces,
 * si la palabra comienza por un numero, no se considerará identificador.
 */
public class CrossReference {

    public static final Set <String> RESERVED_WORDS = new HashSet<>(Arrays.asList("abstract", "continue", "for", "new",	"switch", "assert", "default", "goto", "package", "synchronized","boolean", "do", "if", "private", "this","break", "double", "implements", "protected", "throw","byte", "else", "import", "public", "throws", "case", "enum", "instanceof",	"return", "transient","catch", "extends", "int", "short", "try","char",	"final", "interface", "static", "void","class", "finally", "long", "strictfp", "volatile","const", "float", "native", "super", "while"));

    public static final Set <String> CARACTERES = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "_", "$"));

    public static final Set <String> DIGITOS = new HashSet<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

    public static final Set <String> SEPARADORES = new HashSet<>(Arrays.asList("(", ")", "{", "}", "[", "]", ";", ",", ".", " ", "\n"));
}
