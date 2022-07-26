import java.util.ArrayList;
import java.util.List;

public class toDoRuta4Reactiva {

	public static void main(String[] args) {
		List<Double> s = new ArrayList<Double>();
		s.add((double) 12);
		s.add((double) 13);
		s.add((double) 45);
		s.add((double) 6);
		System.out.println(calcularEdadPromedio(s));
		System.out.println(sumaDeEdades(s));
		System.out.println(personaEdadMayor(s));
		System.out.println(personaEdadMenor(s));
	}

	public static double calcularEdadPromedio(List<Double> edades) {
		double acumulador = 0;
		for (int i = 0; i < edades.size(); i++) {
			acumulador += edades.get(i);
		}
		return acumulador / edades.size();
	}

	public static double sumaDeEdades(List<Double> edades) {
		double acumulador = 0;
		for (int i = 0; i < edades.size(); i++) {
			acumulador += edades.get(i);
		}
		return acumulador;
	}

	public static double personaEdadMayor(List<Double> edades) {
		double auxiliar = 0;
		for (int i = 0; i < edades.size(); i++) {
			if (auxiliar < edades.get(i)) {
				auxiliar = edades.get(i);
			}
		}
		return auxiliar;

	}

	public static double personaEdadMenor(List<Double> edades) {
		double auxiliar = edades.get(0);
		for (int i = 1; i < edades.size(); i++) {
			if (auxiliar > edades.get(i)) {
				auxiliar = edades.get(i);
			}
		}
		return auxiliar;
	}
}
