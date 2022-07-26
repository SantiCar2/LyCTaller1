
public class toDoRuta4Estructurado {

	public static void main(String[] args) {
		double[] vector = { 2, 3, 1, 5, 6, 7, 78 };
		double sumaEdades = 0;
		double promedio = 0;
		int numeroMayor = 0;
		int numeroMenor = 1;

		for (int i = 0; i < vector.length; i++) {
			sumaEdades += vector[i];
		}
		for (int i = 0; i < vector.length; i++) {
			promedio += vector[i];
		}
		for (int i = 0; i < vector.length; i++) {
			if (numeroMayor < vector[i]) {
				numeroMayor = (int) vector[i];
			}
		}
		for (int i = 0; i < vector.length; i++) {
			if (numeroMenor > vector[i]) {
				numeroMenor = (int) vector[i];
			}
		}
		System.out.println(numeroMenor);
		System.out.println(numeroMayor);
		System.out.println(promedio / vector.length);
		System.out.println(sumaEdades);
		
		
	}
}
