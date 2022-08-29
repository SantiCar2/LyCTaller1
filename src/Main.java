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
	public static String rutaEscritura = "Archivos\\EscribeAqui.txt";// Esta ruta se
	//utiliza para el fichero en el cual se debee escribir el texto para despues compilar nuestro lenguaje.

	public static String rutaTokens = "Archivos\\tokens.txt";

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
		try {
			m.leerTuplas();
			m.crearTabla(tuplas, rutaEscritura);
		} catch (Excepciones e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		// System.out.println(m.crearSimbolos(colaDeSimbolos,
		// colaDeTipos).poll().toString());

	}

	public static String[][] operacionesAritmeticasData(Queue<filaTabla> data, String textoCompleto){
		Queue<Integer> operacionesFilas = new LinkedList<Integer>();
		boolean repetido = false;
		for(filaTabla fila : data){
			for(String s : fila.getTupla().getTipos()){
				if(s.equals("Operador")){
					for (int i : operacionesFilas) {
						if(i == Integer.parseInt(fila.getUbicacion().split(",")[0])){
							repetido = true;
						}
					}
					if(!repetido){
						operacionesFilas.add(Integer.parseInt(fila.getUbicacion().split(",")[0]));
					}
				}
			}
			repetido = false;
		}

		String[][] ret = new String[operacionesFilas.size()][2];

		int contador = 0;
		String[] filaTexto = textoCompleto.split("\n");
		for (int fila : operacionesFilas) {
			ret[contador][0] = filaTexto[fila];
			fila++;
			ret[contador][1] = "Fila: " + fila;
			contador++;
		}
		return ret;
	}

	public static String[][] tablaDeTokens(Queue<filaTabla> data) throws Excepciones {
		filaTabla[] filas = new filaTabla[data.size()];
		int contador = 0;
		int lexemasIdentificados = 0;
		for (filaTabla fila : data) {
			filas[contador] = fila;
			if(buscarLexema(fila.getTupla().getSimbolo()) != null){
				lexemasIdentificados++;
			}
			contador++;
		}

		String[][] ret = new String[lexemasIdentificados][3];

		lexemasIdentificados = 0;

		for (int i = 0; i < filas.length; i++) {
			if(filas[i] != null) {
				if(buscarLexema(filas[i].getTupla().getSimbolo()) != null) {
					ret[lexemasIdentificados][0] = buscarLexema(filas[i].getTupla().getSimbolo())[0];
					ret[lexemasIdentificados][1] = buscarLexema(filas[i].getTupla().getSimbolo())[1];
					ret[lexemasIdentificados][2] = buscarLexema(filas[i].getTupla().getSimbolo())[2];
					lexemasIdentificados++;
				}
			}
		}

		return ret;
	}

	public static String[] buscarLexema(String simbolo) throws Excepciones {
		String texto = "";
		if (ManejadorDeFicheros.leerFichero(rutaTokens)!=null) {
			texto = ManejadorDeFicheros.leerFichero(rutaTokens);	//lo guarda todo en un String
				//Retorna la informacion obtenida del fichero
		}else {
			throw new Excepciones("La ruta del archivo no existe");
		}
		for (String linea : texto.split("\n")) {
			if (linea.split(":D")[1].equalsIgnoreCase(simbolo)) {
				String[] ret = linea.split(":D");
				if(ret.length != 3){
					return new String[]{ret[0], ret[1], "?"};
				}else{
					return ret;
				}
			}
		}
		return null;
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

	public static Queue<tuplaSimbolos> extraerFicheroSimbolo() throws Excepciones {//Se extraen los simbolos del fichero
		if (ManejadorDeFicheros.leerFichero(rutaSimbolos)!=null) {
			String texto = ManejadorDeFicheros.leerFichero(rutaSimbolos); //Obtenemos todo el fichero en un String
			String[] divisionSeparaciones = texto.split(":D\n");	//Separamos el fichero por el separador que defnimo (:D)
			for (int i = 0; i < divisionSeparaciones.length; i++) {
				String[] split = divisionSeparaciones[i].split("\n");	//Separamos los nombres de los tipos
				tuplas.add(new tuplaSimbolos(split[0], split[1].split(","))); //Lo añadimos a la cola con la informacion
			}
			return tuplas; //Retornamos toda la informacion obtenida del fichero
		}
		throw new Excepciones("La lectura del fichero ha sido incorrecta");

	}

	public static String extraerFicheroEscritura() throws Excepciones {	//Lee el fichero con el texto de entrada
		if (ManejadorDeFicheros.leerFichero(rutaEscritura)!=null) {
			String texto = ManejadorDeFicheros.leerFichero(rutaEscritura);	//lo guarda todo en un String
			return texto;	//Retorna la informacion obtenida del fichero
		}else {
			throw new Excepciones("La ruta del archivo no existe");
		}

	}

	public void leerTuplas() throws Excepciones {	//**DEBUGGING**
		if (ManejadorDeFicheros.leerFichero(rutaSimbolos)!=null) {
			extraerFicheroSimbolo().forEach(s -> System.out.println(s)); //Imprime en consola los simbolos encontrados del fichero
		}else {
			throw new Excepciones("La lectura del fichero no se ha dado, hay un error en la ruta");
		}

	}

	public static Queue<filaTabla> crearTabla(Queue<tuplaSimbolos> tupla, String textoCompleto) throws Excepciones{ //Crea la tabla con la informacion de los simbolos encontrados
		Queue<filaTabla> tabla = new LinkedList<filaTabla>();	//Creamos la cola para guardar las filas de la tabla
		String auxiliar = "";	//String vacio para guardar los caracteres hasta encontrar un separador
		String auxiliar2 = "";
		textoCompleto = extraerFicheroEscritura();	//Obtiene el texto de entrada
		if(textoCompleto.length() < 1){
			throw new Excepciones("¿El texto de entrada está vacío?");
		}
		int fila = 0;	//Indicador para la posicion
		int col = 0;	//Indicador para la posicion
		for (int i = 0; i < textoCompleto.length(); i++) {	//Revisa todos los caracteres del texto de entrada
			String caracter = String.valueOf(textoCompleto.charAt(i)); //Guarda el caracter a revisar
			
			
		
			if (caracter.compareTo("\n") == 0) {	//Revisa si este caracter es un "Enter"
				fila++;	//Si es un enter añade 1 a la linea
				col = 0;	//Hace que la columna esté en 0
				auxiliar = caracter;
				auxiliar = "";	//Reinicia el auxiliar a su estado original
			} else {
				tuplaSimbolos tuplaCaracter = categorizarCaracter(tupla, caracter);	//Obtiene el caracter y lo categoriza
				if (tuplaCaracter != null) {	//Revisa si está vacío
					
					
						int iSeparador = 0;

						while (iSeparador < tuplaCaracter.getTipos().length	//Revisa si en los tipos del caracter es un separador
								&& tuplaCaracter.getTipos()[iSeparador].compareToIgnoreCase("separador") != 0) {
							iSeparador++;
						}
						if (iSeparador < tuplaCaracter.getTipos().length) {


							System.out.println(auxiliar);	//**DEBUGGING** Imprime el progreso de auxiliar en consola
							tuplaSimbolos tuplaPalabra = categorizarCaracter(tupla, auxiliar);	//Categoriza la palabra guardada en el auxiliar
							
							if (tuplaPalabra != null) {	//Revisa si es vacío
								boolean isComentario = separarCometario(tuplaPalabra);
								if (isComentario) {
									int k = i;
									String aux = "";
									while (k<textoCompleto.length()&&textoCompleto.charAt(k)!='\n') {
										aux+=textoCompleto.charAt(k);
										k++;
										col++;
									}
									tabla.add(new filaTabla(new tuplaSimbolos("/*"+aux, new String[] {"Comentario"}), fila + "," + (col - aux.length())));
									i = k;
									fila++;
								}else {
									tabla.add(new filaTabla(tuplaPalabra, fila + "," + (col - auxiliar.length())));	//Si existe lo guarda
								}
								

							} else{	//Si no existe lo guarda como identificador
								tabla.add(new filaTabla(new tuplaSimbolos(auxiliar, new String[]{"Identificador"}), fila + "," + (col + 1 - auxiliar.length())));
							}
							tabla.add(new filaTabla(tuplaCaracter, fila + "," + (col)));	//Añade el separador encontrado
							
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

	private static boolean separarCometario(tuplaSimbolos tupla) {
		int i = 0;
		while (i<tupla.getTipos().length&&tupla.getTipos()[i].compareTo("Comentario")!=0) {
			i++;
		}if (i<tupla.getTipos().length) {
			return true;
		}
		return false;
		
	}
	
	public static tuplaSimbolos categorizarCaracter(Queue<tuplaSimbolos> tuplas, String s){	//Categoriza el caracter que le pase
		if (tuplas!= null && s != "") {
			for (tuplaSimbolos tupla : tuplas) {
				// System.out.println(tupla.getSimbolo() + "===" + s);
				if (tupla.getSimbolo().compareTo(s) == 0) {	//Revisa si es igual a algun simbolo de la lista
					System.out.println(tupla);	//**DEBUGGING** Muestra el simbolo que encuentre
					return tupla;	//Retorna el simbolo encontrado
				}
			}
		}
		return null;
	}
	
	

}
