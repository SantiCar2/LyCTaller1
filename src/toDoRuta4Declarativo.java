
public class toDoRuta4Declarativo {

	public static void main(String[] args) {
		int[] s = { 2, 1, 6, 94, -4, 32 };
		System.out.println(calcularEdadPromedio(s));
		System.out.println(sumaDeEdades(s));
		System.out.println(personaEdadMayor(s));
		System.out.println(personaEdadMenor(s));
	}

	public static double calcularEdadPromedio(int[] edades) {
		double acumulador = 0;
		for (int edad : edades) {acumulador+=edad; } return acumulador/edades.length;
	}

	public static int sumaDeEdades(int[] edades) {
		int acumulador = 0;
		for (int edad : edades) {acumulador+=edad; } return acumulador;
	}

	public static int personaEdadMayor(int[] edades) {
		int auxiliar = 0;
		for (int edad : edades) {if (auxiliar<edad) {auxiliar = edad; }} return auxiliar;
	}

	public static int personaEdadMenor(int[] edades) {
		int auxiliar = 1;
		for (int edad : edades) {if (auxiliar>edad) {auxiliar = edad; }} return auxiliar;
	}
}
