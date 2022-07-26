import java.util.*;

public class Main {
    Queue<Simbolo> temp = new LinkedList<Simbolo>(); //TODO: Quitar esto por la Cola de verdad
    Hashtable<Integer, Simbolo> diccionarioNormis = fillDict(temp/*TODO: Pasar cola*/);

    Stack<Simbolo> resultados = ReadText(""/*TODO: Meter input*/, diccionarioNormis);

    public static void main(String[] args) {

    }
    public Queue<Simbolo> crearSimbolos(Queue<String> nombres, Queue<String[]> tipos){
        Queue<Simbolo> ret = new LinkedList<Simbolo>();
        for(int i = 0; i < nombres.size(); i++){
            ret.add(new Simbolo(nombres.poll(), tipos.poll()));
        }
        return ret;
    }
    public Hashtable<Integer, Simbolo> fillDict(Queue<Simbolo> cola){
        Hashtable<Integer, Simbolo> ret = new Hashtable<Integer, Simbolo>();
        for(int i = 0; i < cola.size(); i++){
            ret.put(i, cola.poll());
        }
        return ret;
    }

    public Stack<Simbolo> ReadText(String input, Hashtable<Integer, Simbolo> diccionarioNormis){
        Stack<Simbolo> result = new Stack<Simbolo>();

        String[] lineas = input.split("\n");

        for(int i = 0; i < lineas.length; i++) { //Recorre linea por linea
            for (int j = 0; j < lineas[i].toCharArray().length; j++) { //Recorre caracter por caracter
                for (int k = 0; k < diccionarioNormis.size(); k++) { //Compara el caracter con el caracter de los simbolos
                    String temp = "";
                    for(int l = 0; l < diccionarioNormis.get(k).toString().length(); l++){
                            temp = temp + lineas[i].toCharArray()[j+l];
                    }
                    if(0 == diccionarioNormis.get(k).toString().compareTo(temp)){
                        Simbolo tempSim = diccionarioNormis.get(k);
                        tempSim.setpos(i, j);
                        result.add(tempSim);
                    }
                }
            }
        }
        return result;
    }
}


