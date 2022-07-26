public class Simbolo {
    private String Symbol;  //EL SIMBOLO COMO TAL
    private String[] Tipo;  //EL O LOS TIPOS DE SIMBOLOS
    private int Linea;      //LA POSICION (LINEA)
    private int Caracter;   //LA POSICION DENTRO DE LA LINEA (CARACTER)

    public Simbolo(String Symbol, String[] Tipo, int y, int x){
        this.Symbol = Symbol;
        this.Tipo = Tipo;
        this.Linea = y;
        this.Caracter = x;
    }

    public String getPos(){
        return "Ln: " + Linea + " Char: " + Caracter;
    }

    public String getSymbol() {
        return Symbol;
    }

    public String[] getTipo() {
        return Tipo;
    }
}
