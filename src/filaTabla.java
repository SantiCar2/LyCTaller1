
public class filaTabla {
	tuplaSimbolos tupla;
	String ubicacion;

	public filaTabla(tuplaSimbolos tupla, String ubicacion) {
		super();
		this.tupla = tupla;
		this.ubicacion = ubicacion;
	}

	public tuplaSimbolos getTupla() {
		return tupla;
	}

	public void setTupla(tuplaSimbolos tupla) {
		this.tupla = tupla;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "filaTabla [tupla=" + tupla + ", ubicacion=" + ubicacion + "]";
	}
	
	
}
