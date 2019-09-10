/**
 *
 */
package ejercicios;

import java.time.LocalDate;
import java.time.Month;

/**
 * A. Crear una clase Alumnno con los siguientes campos (con sus respectivos
 * getters, setters y constructor)
 *
 * Persona Legajo - Integer
 *
 *
 * @author examen
 *
 */
public class Ejercicio3 {

    /**
     *
     */
    public Ejercicio3() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Alumno nico = new Alumno(Persona.TipoDocumento.DNI, 32411050, "Nicolas", "Chichi", LocalDate.of(1986, Month.JULY, 30), 12345);

        // El metodo toString() fue sobreescrito para imprimir todos los datos de la entidad Persona.
        System.out.println(nico.toString());
    }

}

