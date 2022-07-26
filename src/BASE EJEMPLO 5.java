import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterator;

public class Ejercicio5 {

	public static void main(String[] args) {
		// System.out.println(
		// ocurrenciasWhileForIf("while is a awesome and perfecto operator the while is
		// so good for if if if"));
		posicionDeWhileForIf("while is a awesome and perfect operator the while is so good for if if if");
	}

	public static int ocurrenciasWhileForIf(String oracion) {
		int cont = 0;
		int posicion = 0;
		String a = oracion.toLowerCase();
		String[] divisiones = {};
		divisiones = a.split(" ");
		for (int i = 0; i < divisiones.length; i++) {
			if (divisiones[i].compareTo("while") == 0 || divisiones[i].compareTo("for") == 0
					|| divisiones[i].compareTo("if") == 0) {
				cont++;
				posicion = i;
				System.out.println(posicion);
			}
		}
		return cont;
	}

	// Guardar los characteres hasta que encuentre un espacio, paro y reviso que es
	// un while o no o un for o un if.

	public static Queue<Integer> posicionWhile = new LinkedList<Integer>();
	public static Queue<Integer> posicionFor = new LinkedList<Integer>();
	public static Queue<Integer> posicionIf = new LinkedList<Integer>();
	public static int contFor = 0;
	public static int contWhile = 0;
	public static int contIf = 0;

	public static void posicionDeWhileForIf(String oracion) {
		posicionWhile.clear();
		posicionFor.clear();
		posicionIf.clear();
		contFor = 0;
		contIf = 0;
		contWhile = 0;
		String auxiliar = "";
		int inicio = 0;

		for (int i = 0; i < oracion.length(); i++) {
			char d = oracion.charAt(i);

			if (oracion.charAt(i) == ' ' || i == oracion.length() - 1) {
				if (i == oracion.length() - 1) {
					auxiliar += d;
				}
				condicionalesWhileForIf(auxiliar, inicio);
				auxiliar = "";
				inicio = i;
			} else {
				auxiliar += d;
			}

		}
		System.out.println(posicionWhile);
		System.out.println(posicionFor);
		System.out.println(posicionIf);

	}

	public static void condicionalesWhileForIf(String auxiliar, int posicion) {
		String r = auxiliar.toLowerCase();
		if (r.compareTo("while") == 0) {
			posicionWhile.add(posicion);
			contWhile++;
		} else if (r.compareTo("for") == 0) {
			posicionFor.add(posicion);
			contFor++;
		} else if (r.compareTo("if") == 0) {
			posicionIf.add(posicion);
			contIf++;
		}
	}

}
