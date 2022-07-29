import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {//En esta clase creamos todos los metodos principales para pasarle 

	private static final String rutaSimbolos = "Archivos\\Simbolos.txt";// Es la ruta que 
	//utilizamos para almacenar nuestra tabla de simbolos.
	private static Queue<tuplaSimbolos> tuplas = new LinkedList<tuplaSimbolos>();//En etse Queue almacenamos nuestra Tupla de 
	//Simbolos.
	private static final String rutaEscritura = "Archivos\\EscribeAqui.txt";// Esta ruta se
	//utiliza para el fichero en el cual se debee escribir el texto para despues compilar nuestro lenguaje.

	public static Queue<tuplaSimbolos> getTuplas() {//LA usamos para acceder a nuestra Tupla de simbolos.
		return tuplas;
	}

	public static void setTuplas(Queue<tuplaSimbolos> tuplas) {//Lo utiliamos para llenar nuestra Tupla de simbolos.
		Main.tuplas = tuplas;
	}

	public static void main(String[] args) {//En este Main probamos la clase Main y verificamos que los archivos se lean y se
		//creen bien y ademas hacemos el metodo de verificacion.
		Main m = new Main();
		// m.extraerFichero();
		m.leerTuplas();
		// System.out.println(m.crearSimbolos(colaDeSimbolos,
		// colaDeTipos).poll().toString());

	}


	public static String[][] tableData(Queue<filaTabla> data) {//Este metodo se utiliza para crear nuestra tabla de datos 
		//recolectados en el ficheroEscritua y pasarselo a nuestro atributo datos en el panel_2.
		String[][] ret = new String[data.size()][3]; //Creamos una matriz temporal para retornarla al final despues de llenarla
		int size = data.size(); //Obetenemos la cantidad de simbolos que se encontraron
		for (int i = 0; i < size; i++) {
			filaTabla temp = data.poll();	//Creamos un temporal para guardar la fila con la informacion obtenida
			ret[i][0] = temp.getTupla().getSimbolo(); //llenamos la matriz con el simbolo
			ret[i][1] = temp.getUbicacion(); //Guardamos la ubicacion en la matriz
			String tiposTemp = "";
			for (String s : temp.getTupla().getTipos()) { //Guardamos todos los tipos del simbolo que se encontró
				tiposTemp += s;
				tiposTemp += ", ";
			}
			ret[i][2] = tiposTemp;
		}
		System.out.println(ret);

		for (int i = 0; i < ret.length; i++) { //Debugging
			for (int j = 0; j < ret[i].length; j++) {
				System.out.println(ret[i][j]);
			}
			System.out.println();
		}

		return ret; //retornamos la informacion organizada
	}

	public static Queue<tuplaSimbolos> extraerFicheroSimbolo() { //Se extraen los simbolos del fichero
		String texto = ManejadorDeFicheros.leerFichero(rutaSimbolos); //Obtenemos todo el fichero en un String
		String[] divisionSeparaciones = texto.split(":D\n");	//Separamos el fichero por el separador que defnimo (:D)
		for (int i = 0; i < divisionSeparaciones.length; i++) {
			String[] split = divisionSeparaciones[i].split("\n");	//Separamos los nombres de los tipos
			tuplas.add(new tuplaSimbolos(split[0], split[1].split(","))); //Lo añadimos a la cola con la informacion
		}
		return tuplas; //Retornamos toda la informacion obtenida del fichero
	}

	public static String extraerFicheroEscritura() {	//Lee el fichero con el texto de entrada
		String texto = ManejadorDeFicheros.leerFichero(rutaEscritura);	//lo guarda todo en un String
		return texto;	//Retorna la informacion obtenida del fichero
	}

	public void leerTuplas() {	//**DEBUGGING**
		extraerFicheroSimbolo().forEach(s -> System.out.println(s)); //Imprime en consola los simbolos encontrados del fichero
	}

	public static Queue<filaTabla> crearTabla(Queue<tuplaSimbolos> tupla, String textoCompleto) throws Exception{ //Crea la tabla con la informacion de los simbolos encontrados
		Queue<filaTabla> tabla = new LinkedList<filaTabla>();	//Creamos la cola para guardar las filas de la tabla
		String auxiliar = "";	//String vacio para guardar los caracteres hasta encontrar un separador
		textoCompleto = extraerFicheroEscritura();	//Obtiene el texto de entrada
		if(textoCompleto.length() < 1){
			throw new Exception("¿El texto de entrada está vacío!");
		}
		int fila = 0;	//Indicador para la posicion
		int col = 0;	//Indicador para la posicion
		for (int i = 0; i < textoCompleto.length(); i++) {	//Revisa todos los caracteres del texto de entrada
			String caracter = String.valueOf(textoCompleto.charAt(i));	//Guarda el caracter a revisar
			if (caracter.compareTo("\n") == 0) {	//Revisa si este caracter es un "Enter"
				fila++;	//Si es un enter añade 1 a la linea
				col = 0;	//Hace que la columna esté en 0
				auxiliar = "";	//Reinicia el auxiliar a su estado original
			} else {
				tuplaSimbolos esSeparador = categorizarCaracter(tupla, caracter);	//Obtiene el caracter y lo categoriza
				if (esSeparador != null) {	//Revisa si está vacío
					int iSeparador = 0;

					while (iSeparador < esSeparador.getTipos().length	//Revisa si en los tipos del caracter es un separador
							&& esSeparador.getTipos()[iSeparador].compareToIgnoreCase("separador") != 0) {
						iSeparador++;
					}
					if (iSeparador < esSeparador.getTipos().length) {

						
						System.out.println(auxiliar);	//**DEBUGGING** Imprime el progreso de auxiliar en consola
						tuplaSimbolos tuplaPalabra = categorizarCaracter(tupla, auxiliar);	//Categoriza la palabra guardada en auxiliar
						if (tuplaPalabra != null) {	//Revisa si es vacío
							tabla.add(new filaTabla(tuplaPalabra, fila + "," + (col - auxiliar.length())));	//Si existe lo guarda
							
						} else{	//Si no existe lo guarda como identificador
							tabla.add(new filaTabla(new tuplaSimbolos(auxiliar, new String[]{"Identificador"}), fila + "," + (col + 1 - auxiliar.length())));
						}
						tabla.add(new filaTabla(esSeparador, fila + "," + (col)));	//Añade el separador encontrado

						auxiliar = "";	//Revierte auxiliar a su estado original
					}

				} else {
					auxiliar += caracter;	//Aáde el caracter a auxiliar para luego evaluarlo
				}
			}

			if (i == textoCompleto.length() - 1) {	//Revisa si llegó al final del texto
				tuplaSimbolos tuplaPalabra = categorizarCaracter(tupla, auxiliar);	//Categoriza a la palabra guardada en auxiliar
				if (tuplaPalabra != null) {	//revisa si existe
					System.out.println(auxiliar);	//**DEBUGGING** Imprime el valor de auxiliar
					tabla.add(new filaTabla(tuplaPalabra, fila + "," + (i + 1 - auxiliar.length())));	//Agrega la informacion a la tabla
					
				} else{	//Si no existe en la lista de simbolos, lo añade como un identificador
					tabla.add(new filaTabla(new tuplaSimbolos(auxiliar, new String[]{"Identificador"}), fila + "," + (col + 1 - auxiliar.length())));
				}
			}
			col++;	//Agrega 1 al valor de la columna

		}

		return tabla;

	}

	public static tuplaSimbolos categorizarCaracter(Queue<tuplaSimbolos> tuplas, String s) {	//Categoriza el caracter que le pase
		for (tuplaSimbolos tupla : tuplas) {
			// System.out.println(tupla.getSimbolo() + "===" + s);
			if (tupla.getSimbolo().compareTo(s) == 0) {	//Revisa si es igual a algun simbolo de la lista
				System.out.println(tupla);	//**DEBUGGING** Muestra el simbolo que encuentre
				return tupla;	//Retorna el simbolo encontrado
			}
		}

		return null;	//Si no lo encuentra retorna vacío

	}

}
