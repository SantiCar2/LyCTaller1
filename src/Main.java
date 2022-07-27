import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

	private static final String rutaSimbolos = "C:\\Users\\Dennis\\eclipse-workspace\\LC\\Archivos\\Simbolos.txt";
	private static Queue<tuplaSimbolos> tuplas = new LinkedList<tuplaSimbolos>();

	public static Queue<tuplaSimbolos> getTuplas() {
		return tuplas;
	}

	public static void setTuplas(Queue<tuplaSimbolos> tuplas) {
		Main.tuplas = tuplas;
	}

	public static void main(String[] args) {
		Main m = new Main();
		// m.extraerFichero();
		m.leerTuplas();
		// System.out.println(m.crearSimbolos(colaDeSimbolos,
		// colaDeTipos).poll().toString());

	}

	// Queue<Simbolo> temp = new LinkedList<Simbolo>(); // TODO: Quitar esto por la
	// Cola de verdad
	// Hashtable<Integer, Simbolo> diccionarioNormis = fillDict(temp/* TODO: Pasar
	// cola */);
	//
	// Stack<Simbolo> resultados = ReadText(""/* TODO: Meter input */,
	// diccionarioNormis);
	//
	// public Queue<Simbolo> crearSimbolos(Queue<String> nombres, Queue<String[]>
	// tipos) {
	// Queue<Simbolo> ret = new LinkedList<Simbolo>();
	// for (int i = 0; i < nombres.size(); i++) {
	// ret.add(new Simbolo(nombres.poll(), tipos.poll()));
	// }
	// return ret;
	// }
	//
	// public Hashtable<Integer, Simbolo> fillDict(Queue<Simbolo> cola) {
	// Hashtable<Integer, Simbolo> ret = new Hashtable<Integer, Simbolo>();
	// for (int i = 0; i < cola.size(); i++) {
	// ret.put(i, cola.poll());
	// }
	// return ret;
	// }
	//
	// public Stack<Simbolo> ReadText(String input, Hashtable<Integer, Simbolo>
	// diccionarioNormis) {
	// Stack<Simbolo> result = new Stack<Simbolo>();
	//
	// String[] lineas = input.split("\n");
	//
	// for (int i = 0; i < lineas.length; i++) { // Recorre linea por linea
	// for (int j = 0; j < lineas[i].toCharArray().length; j++) { // Recorre
	// caracter por caracter
	// for (int k = 0; k < diccionarioNormis.size(); k++) { // Compara el caracter
	// con el caracter de los
	// // simbolos
	// String temp = "";
	// for (int l = 0; l < diccionarioNormis.get(k).toString().length(); l++) {
	// temp = temp + lineas[i].toCharArray()[j + l];
	// }
	// if (0 == diccionarioNormis.get(k).toString().compareTo(temp)) {
	// Simbolo tempSim = diccionarioNormis.get(k);
	// tempSim.setpos(i, j);
	// result.add(tempSim);
	// }
	// }
	// }
	// }
	// return result;
	// }

	// public void extraerFicheros() {
	// File doc = new
	// File("C:\\Users\\Dennis\\eclipse-workspace\\LC\\Archivos\\Simbolos.txt");
	//
	// BufferedReader obj = null;
	// try {
	// obj = new BufferedReader(new FileReader(doc));
	// } catch (FileNotFoundException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// // Queue<String> colaDeSimbolos = new LinkedList<String>();
	// // Queue<String> colaDeTipos = new LinkedList<String>();
	// String strng = "";
	// String[] nuevo = {};
	// try {
	// while ((strng = obj.readLine()) != null) {
	// if (strng.compareTo(":D") != 0 && strng.compareTo("Token,Operador") != 0 &&
	// strng.compareTo("Isas") != 0
	// && strng.compareTo("Fore") != 0 && strng.compareTo("Condicional,Palabra
	// Reservada") != 0
	// && strng.compareTo("MientrasTanto") != 0) {
	//
	// colaDeSimbolos.add(strng);
	// //System.out.println(colaDeSimbolos.poll());
	// } else if (strng.compareTo(":D") != 0) {
	// nuevo = strng.split(",");
	// colaDeTipos.add(nuevo);
	// //System.out.println(colaDeTipos.poll());
	// }
	//
	// }
	// // System.out.println(strng);
	//
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	// }

	public static Queue<tuplaSimbolos> extraerFichero() {
		String texto = ManejadorDeFicheros.leerFichero(rutaSimbolos);
		String[] divisionSeparaciones = texto.split(":D\n");
		for (int i = 0; i < divisionSeparaciones.length; i++) {
			String[] split = divisionSeparaciones[i].split("\n");
			tuplas.add(new tuplaSimbolos(split[0], split[1].split(",")));
		}
		return tuplas;
	}

	public void leerTuplas() {
		extraerFichero().forEach(s -> System.out.println(s));
	}

	public static Queue<filaTabla> crearTabla(Queue<tuplaSimbolos> tupla, String textoCompleto) {
		Queue<filaTabla> tabla = new LinkedList<filaTabla>();
		String auxiliar = "";
		int fila = 0;
		for (int i = 0; i < textoCompleto.length(); i++) {
			String caracter = String.valueOf(textoCompleto.charAt(i));
			if (caracter.compareTo("\n") == 0) {
				fila++;
				auxiliar = "";
			} else {
				tuplaSimbolos tuplaString = categorizarCaracter(tupla, caracter);
				if (tuplaString != null) {
					for (String s : tuplaString.getTipos()) {
						if (s.compareTo("Separador") == 0) {
							tabla.add(new filaTabla(tuplaString, fila + "," + i));
							tuplaSimbolos t = categorizarCaracter(tupla, auxiliar);// Corregir fila y columna
							auxiliar = "";
							if (t != null) {
								tabla.add(new filaTabla(t, fila + "," + i));
							}
						}

					}
				} else {
					auxiliar += caracter;

				}
			}

		}
		return tabla;

	}

	public static tuplaSimbolos categorizarCaracter(Queue<tuplaSimbolos> tuplas, String s) {
		System.out.println(s);
		int i = 0;
		for (tuplaSimbolos tupla : tuplas) {
			System.out.println(tupla.getSimbolo() + "===" + s);
			if (tupla.getSimbolo().compareTo(s) == 0) {
				System.out.println(tupla);
				return tupla;
			}
		}

		return null;

	}

}
