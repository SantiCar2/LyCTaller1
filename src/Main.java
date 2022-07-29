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

	/*
	 * Queue<Simbolo> temp = new LinkedList<Simbolo>(); // TODO: Quitar esto por la
	 * Cola de verdad Hashtable<Integer, Simbolo> diccionarioNormis =
	 * fillDict(temp/* TODO: Pasar cola * /);
	 * 
	 * Stack<Simbolo> resultados = ReadText(""/* TODO: Meter input * /,
	 * diccionarioNormis);
	 * 
	 * public Queue<Simbolo> crearSimbolos(Queue<String> nombres, Queue<String[]>
	 * tipos) { Queue<Simbolo> ret = new LinkedList<Simbolo>(); for (int i = 0; i <
	 * nombres.size(); i++) { ret.add(new Simbolo(nombres.poll(), tipos.poll())); }
	 * return ret; }
	 * 
	 * public Hashtable<Integer, Simbolo> fillDict(Queue<Simbolo> cola) {
	 * Hashtable<Integer, Simbolo> ret = new Hashtable<Integer, Simbolo>(); for (int
	 * i = 0; i < cola.size(); i++) { ret.put(i, cola.poll()); } return ret; }
	 * 
	 * public Stack<Simbolo> ReadText(String input, Hashtable<Integer, Simbolo>
	 * diccionarioNormis) { Stack<Simbolo> result = new Stack<Simbolo>();
	 * 
	 * String[] lineas = input.split("\n");
	 * 
	 * for (int i = 0; i < lineas.length; i++) { // Recorre linea por linea for (int
	 * j = 0; j < lineas[i].toCharArray().length; j++) { // Recorre caracter por
	 * caracter for (int k = 0; k < diccionarioNormis.size(); k++) { // Compara el
	 * caracter con el caracter de los // simbolos String temp = ""; for (int l = 0;
	 * l < diccionarioNormis.get(k).toString().length(); l++) { temp = temp +
	 * lineas[i].toCharArray()[j + l]; } if (0 ==
	 * diccionarioNormis.get(k).toString().compareTo(temp)) { Simbolo tempSim =
	 * diccionarioNormis.get(k); tempSim.setpos(i, j); result.add(tempSim); } } } }
	 * return result; } public void extraerFicheros() { File doc = new
	 * File("Archivos\\Simbolos.txt");
	 * 
	 * BufferedReader obj = null; try { obj = new BufferedReader(new
	 * FileReader(doc)); } catch (FileNotFoundException e1) { // TODO Auto-generated
	 * catch block e1.printStackTrace(); } // Queue<String> colaDeSimbolos = new
	 * LinkedList<String>(); // Queue<String> colaDeTipos = new
	 * LinkedList<String>(); String strng = ""; String[] nuevo = {}; try { while
	 * ((strng = obj.readLine()) != null) { if (strng.compareTo(":D") != 0 &&
	 * strng.compareTo("Token,Operador") != 0 && strng.compareTo("Isas") != 0 &&
	 * strng.compareTo("Fore") != 0 && strng.compareTo("Condicional,Palabra
	 * Reservada") != 0 && strng.compareTo("MientrasTanto") != 0) {
	 * 
	 * colaDeSimbolos.add(strng); //System.out.println(colaDeSimbolos.poll()); }
	 * else if (strng.compareTo(":D") != 0) { nuevo = strng.split(",");
	 * colaDeTipos.add(nuevo); //System.out.println(colaDeTipos.poll()); }
	 * 
	 * } // System.out.println(strng);
	 * 
	 * } catch (IOException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); }
	 * 
	 * }
	 */
	public static String[][] tableData(Queue<filaTabla> data) {//Este metodo se utiliza para crear nuestra tabla de datos 
		//recolectados en el ficheroEscritua y pasarselo a nuestro atributo datos en el panel_2.
		String[][] ret = new String[data.size()][3];
		int size = data.size();
		for (int i = 0; i < size; i++) {
			filaTabla temp = data.poll();
			ret[i][0] = temp.getTupla().getSimbolo();
			ret[i][1] = temp.getUbicacion();
			String tiposTemp = "";
			for (String s : temp.getTupla().getTipos()) {
				tiposTemp += s;
				tiposTemp += ", ";
			}
			ret[i][2] = tiposTemp;
		}
		System.out.println(ret);

		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret[i].length; j++) {
				System.out.println(ret[i][j]);
			}
			System.out.println();
		}

		return ret;
	}

	public static Queue<tuplaSimbolos> extraerFicheroSimbolo() {
		String texto = ManejadorDeFicheros.leerFichero(rutaSimbolos);
		String[] divisionSeparaciones = texto.split(":D\n");
		for (int i = 0; i < divisionSeparaciones.length; i++) {
			String[] split = divisionSeparaciones[i].split("\n");
			tuplas.add(new tuplaSimbolos(split[0], split[1].split(",")));
		}
		return tuplas;
	}

	public static String extraerFicheroEscritura() {
		String texto = ManejadorDeFicheros.leerFichero(rutaEscritura);
		return texto;
	}

	public void leerTuplas() {
		extraerFicheroSimbolo().forEach(s -> System.out.println(s));
	}

	public static Queue<filaTabla> crearTabla(Queue<tuplaSimbolos> tupla, String textoCompleto) {
		Queue<filaTabla> tabla = new LinkedList<filaTabla>();
		String auxiliar = "";
		textoCompleto = extraerFicheroEscritura();
		int fila = 0;
		int col = 0;
		for (int i = 0; i < textoCompleto.length(); i++) {
			String caracter = String.valueOf(textoCompleto.charAt(i));
			if (caracter.compareTo("\n") == 0) {
				fila++;
				col = 0;
				auxiliar = "";
			} else {
				tuplaSimbolos esSeparador = categorizarCaracter(tupla, caracter);
				if (esSeparador != null) {
					int iSeparador = 0;

					while (iSeparador < esSeparador.getTipos().length
							&& esSeparador.getTipos()[iSeparador].compareToIgnoreCase("separador") != 0) {
						iSeparador++;
					}
					if (iSeparador < esSeparador.getTipos().length) {

						
						System.out.println(auxiliar);
						tuplaSimbolos tuplaPalabra = categorizarCaracter(tupla, auxiliar);
						if (tuplaPalabra != null) {
							tabla.add(new filaTabla(tuplaPalabra, fila + "," + (col - auxiliar.length())));
							
						} else{
							tabla.add(new filaTabla(new tuplaSimbolos(auxiliar, new String[]{"Identificador"}), fila + "," + (col + 1 - auxiliar.length())));
						}
						tabla.add(new filaTabla(esSeparador, fila + "," + (col)));

						auxiliar = "";
					}

				} else {
					auxiliar += caracter;
				}
			}

			if (i == textoCompleto.length() - 1) {
				tuplaSimbolos tuplaPalabra = categorizarCaracter(tupla, auxiliar);
				if (tuplaPalabra != null) {
					System.out.println(auxiliar);
					tabla.add(new filaTabla(tuplaPalabra, fila + "," + (i + 1 - auxiliar.length())));
					
				} else{
					tabla.add(new filaTabla(new tuplaSimbolos(auxiliar, new String[]{"Identificador"}), fila + "," + (col + 1 - auxiliar.length())));
				}
			}
			col++;

		}

		return tabla;

	}

	public static tuplaSimbolos categorizarCaracter(Queue<tuplaSimbolos> tuplas, String s) {
		int i = 0;
		for (tuplaSimbolos tupla : tuplas) {
			// System.out.println(tupla.getSimbolo() + "===" + s);
			if (tupla.getSimbolo().compareTo(s) == 0) {
				System.out.println(tupla);
				return tupla;
			}
		}

		return null;

	}

}
