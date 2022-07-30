import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManejadorDeFicheros {//Esta clase la usamos para manejar la extraccion de datos de un fichero tipo texto.

	public static void main(String[] args) {//Lo utilizamos para hacer pruebas de lectura en el fichero.
		ManejadorDeFicheros m = new ManejadorDeFicheros();

	}

	public static String leerFichero(String ruta) throws Excepciones {//Este metodo se usa para leer el fichero y asi poder extraer todo los datos 
		//con una cadena de tipo String.
		File doc = new File(ruta);
		BufferedReader obj = null;
		try {
			obj = new BufferedReader(new FileReader(doc));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String strng = "";
		String texto = "";
		try {
			while ((strng = obj.readLine()) != null) {
				texto += strng + "\n";
			}
			return texto;

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		throw new Excepciones("La lectura o ruta del fichero no esta disponible");

	}
}
