package ejercicios;

import java.time.LocalDate;
import java.time.Month;

/**
 * A. Crear una clase Persona con los siguientes campos (con sus respectivos
 * getters, setters y constructor)
 *
 * TipoDocumento - enum (dni/libretacivica) NroDocumento - Integer Nombre -
 * String Apellido - String FechaNacimiento - Date
 *
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia de la
 * clase persona y settearle valores reales con tus datos
 *
 *
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en
 * consola (crear método main e imprimir valores)
 *
 * @author examen
 *
 */
public class Ejercicio2 {

    /**
     *
     */
    public Ejercicio2() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Persona nico = new Persona(Persona.TipoDocumento.DNI, 32411050, "Nicolas", "Chichi", LocalDate.of(1986, Month.JULY, 30));

        // El metodo toString() fue sobreescrito para imprimir todos los datos de la entidad Persona.
        System.out.println(nico.toString());
    }

}

