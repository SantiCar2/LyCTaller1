import java.io.IOException;

public class OtrosEjerciciosPrimerasClase {

	public static void main(String[] args) {
		System.out.println("Esta es la salida estandar normal");
		System.err.println("Esta es otro tipo de salida en java");
		try {
			int Input = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hola = "HolaMundo";
		System.out.println("Esto es una cadena de texto y asi se lee en java ");
		byte a = 0;
		leerCaracteresJavaCadena("Hola");
	}
	
	public static void leerCaracteresJavaCadena(String oracion) {
		for (int i = 0; i < oracion.length(); i++) {
			char  s = oracion.charAt(i);
			System.out.println(s);
		}
	}
	
	
}
