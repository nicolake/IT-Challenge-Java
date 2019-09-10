package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Ejercicio4 {

    // listas de ejemplo, pueden variarse su contenido, 
    static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
    static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9, 35};

    /**
     * Para ejecutar el método main se debe hacer boton derecho sobre la clase
     * "Run As --> Java Application"
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("**** inicializando datos ****");

        List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));

        System.out.println("**** inicializacion exitosa ****");

        // EJERCICIO 4.1: explicar salidas y sugerir mejoras
        informacion(lista1, 10);

        // EJERCICIO 4.2: corregir el metodo
        List<Integer> union = unionListas(lista1, lista2);
        System.out.println("union: " + union.toString());

        // EJERCICIO 4.3: implementar
        List<Integer> interseccion = interseccionListas(lista1, lista2);
        System.out.println("interseccion: " + interseccion.toString());

        // EJERCICIO 4.4: implementar
        List<Integer> orden1 = ordenaListaAscendente(lista1);
        System.out.println("orden asc: " + orden1);

        // EJERCICIO 4.5: implementar
        List<Integer> orden2 = ordenaListaDescendente(lista2);
        System.out.println("orden desc: " + orden2);

        // EJERCICIO 4.6: implementar
        boolean b = tienenMismoContenido(lista1, lista2);
        System.out.println("mismo contenido: " + b);

    }

    private static void informacion(List<Integer> lista1, Integer numero) {
        // TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion

        // Sugerencias:
        // 1 - Usar un solo FOR para recorrer la lista y hacer los calculos dentro del mismo.
        // 2 - Reemplazar los '...' por texto algo mas descriptivo.
        // 3 - Utilizar 'pares++' en lugar de 'pares = pares + 1'. (Para todos los contadores)
        // 4 - Utilizar nombres de variables mas representativos.
        // 5 - Dividir codigo en metodos con funciones especificas (divide el problema y ayuda en la reutilizacion del codigo)
        // 6 - Se esta calculando 2 veces lista1.size() / 2.
        // 7 - Hacer uso de streams (a partir de java 8)
        int pares = 0;
        for (Integer n : lista1) {
            if (n % 2 == 0) {
                pares = pares + 1;
            }
        }

        // Muestra el numero total de numeros pares que hay en la lista.
        System.out.println("... " + pares);

        List<Integer> impares = new ArrayList<Integer>();
        for (Integer n : lista1) {
            if (n % 2 != 0) {
                impares.add(n);
            }
        }

        // Muestra el contenido de la lista de numeros impares.
        System.out.println("... " + impares.toString());

        int p = lista1.size() / 2;

        // Muestra el indice de la primera aparicion del numero que resulta de 
        // dividir el tamaño de la lista por 2, en caso de que este numero no 
        // este en la lista se muestra -1.
        System.out.println("..." + lista1.indexOf(p));

        // Cuenta la cantidad de numeros que hay en la lista que son mayores
        // que el numero pasado como parametro.
        int c = 0;
        for (Integer n : lista1) {
            if (n > numero) {
                c = c + 1;
            }
        }
        if (c > lista1.size() / 2) {
            // Muestra '...' si la cantidad de numeros mayores que el parametro
            // es mayor que la mitad de la cantidad de numeros que hay en la lista.
            System.out.println("...");
        } else if (c > 0) {
            // Muestra '...' si hay al menos 1 numero mayor que el parametro.
            System.out.println("...");
        } else {
            // Muestra '...' si ninguna de las otras condiciones se cumple.
            System.out.println("...");
        }
    }

    /**
     * *
     * @param lista1
     * @param lista2
     *
     * retornar una lista que contenga los elementos de ambas listas, sin
     * elementos repetidos
     *
     */
    private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
        // TODO: corregir el metodo para que funcione correctamente 
        Collection<Integer> union = new TreeSet<Integer>(lista1);
        union.addAll(lista2);
        return new ArrayList<Integer>(union);
    }

    /**
     * *
     * @param lista1
     * @param lista2
     *
     * retornar una lista que contenga los elementos que estan presentes en
     * ambas listas, sin elementos repetidos
     *
     */
    private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
        Collection<Integer> interseccion = new TreeSet<Integer>(lista1);
        interseccion.retainAll(lista2);
        return new ArrayList<Integer>(interseccion);
    }

    /**
     * *
     * @param lista1
     *
     * retornar la lista recibida, ordenada en forma ascendente
     *
     */
    private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
        List<Integer> ordenAscendente = new ArrayList<Integer>(lista1);
        Collections.sort(ordenAscendente);
        return ordenAscendente;
    }

    /**
     * *
     * @param lista2
     *
     * retornar la lista recibida, ordenada en forma descendente
     *
     */
    private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
        List<Integer> ordenDescendente = new ArrayList<Integer>(lista2);
        Collections.sort(ordenDescendente, Collections.reverseOrder());
        return ordenDescendente;
    }

    /**
     * *
     * @param lista1
     * @param lista2
     *
     * devuelve true si contienen los mismos elementos NO se considera valido
     * que esten en diferente orden NO se considera valido que la cantidad de
     * repeticiones de los elementos sea diferente
     *
     */
    private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
        // TODO:		
        return lista1.equals(lista2);
    }

}

