import java.sql.Array;
import java.util.Arrays;

public class toDoRuta4POO {

	public static void main(String[] args) {
		int[] s = { 2, 1, 6, 94, -4, 32 };
		System.out.println(calcularEdadPromedio(s));
		System.out.println(sumaDeEdades(s));
		System.out.println(personaEdadMayor(s));
		System.out.println(personaEdadMenor(s));
	}

	public static double calcularEdadPromedio(int[] edades) {
		double acumulador = 0;
		for (int i = 0; i < edades.length; i++) {
			acumulador += edades[i];
		}
		return acumulador / edades.length;
	}

	public static int sumaDeEdades(int[] edades) {
		int acumulador = 0;
		for (int i = 0; i < edades.length; i++) {
			acumulador += edades[i];
		}
		return acumulador;
	}

	public static int personaEdadMayor(int[] edades) {
		int auxiliar = 0;
		for (int i = 0; i < edades.length; i++) {
			if (auxiliar < edades[i]) {
				auxiliar = edades[i];
			}
		}
		return auxiliar;
	}

	public static int personaEdadMenor(int[] edades) {
		int auxiliar = edades[0];
		for (int i = 1; i < edades.length; i++) {
			if (auxiliar > edades[i]) {
				auxiliar = edades[i];
			}
		}
		return auxiliar;
	}
}
