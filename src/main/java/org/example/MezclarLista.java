package org.example;
import java.util.ArrayList;
import java.util.List;


public class MezclarLista {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Escriba dos listas de números como argumentos.");
            return;
        }

        List<Integer> lista1 = convertirArgLista(args[0]);
        List<Integer> lista2 = convertirArgLista(args[1]);

        // LLAMAR AL METODO Y MEZCLAR
        List<Integer> resultado = merge(lista1, lista2);

        // IMPRIMIR LISTA FINAL
        System.out.println("Lista Mezclada: " + resultado);
    }

    public static List<Integer> merge(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0; //INDICE 1
        int j = 0; //INDICE 2

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }
        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }
        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }

    public static List<Integer> convertirArgLista(String argumento) {
        String[] elementos = argumento.split(",\\s*");
        List<Integer> lista = new ArrayList<>();


        for (String elemento : elementos) {
            lista.add(Integer.parseInt(elemento.trim())); //CONVIERTE A ENTERO Y QUITA LOS ESPACIOS
        }
        return lista;
    }
}