public class Simbolo {
    private String Symbol;  //EL SIMBOLO COMO TAL
    private String[] Tipo;  //EL O LOS TIPOS DE SIMBOLOS
    private int Linea;      //LA POSICION (LINEA)
    private int Caracter;   //LA POSICION DENTRO DE LA LINEA (CARACTER)

    public Simbolo(String Symbol, String[] Tipo){
        this.Symbol = Symbol;
        this.Tipo = Tipo;
        this.Linea = 0;
        this.Caracter = 0;
    }

    public void setpos(int Linea, int Caracter){
        this.Linea = Linea;
        this.Caracter = Caracter;
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

    @Override  //Yo lo hice
    public String toString(){
        return Symbol;
    }
}
