import java.util.Arrays;

public class tuplaSimbolos {
	private String Simbolo;
	private String[] tipos;

	public tuplaSimbolos(String simbolo, String[] tipos) { //Clase creada con fines de almacenar informacion
		super();
		this.Simbolo = simbolo;
		this.tipos = tipos;
	}

	public static void main(String[] args) {

	}

	@Override
	public String toString() {
		return " [Simbolo = " + Simbolo + "\ttipos = " + Arrays.toString(tipos) + "]";
	}

	public String getSimbolo() {
		return Simbolo;
	}

	public String[] getTipos() {
		return tipos;
	}

}
