import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManejadorDeFicheros {
	

	
	public static void main(String[] args) {
		ManejadorDeFicheros m = new ManejadorDeFicheros();
		
	}

	public static String leerFichero(String ruta) {
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
		return null;
		
	}
}
