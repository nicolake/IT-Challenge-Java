package ejercicios;

import java.time.LocalDate;

/**
 *
 * @author nicolake
 */
public class Alumno extends Persona {

    private int legajo;

    public Alumno(TipoDocumento tipoDocumento, int numeroDocumento, String nombre, String apellido, LocalDate fechaNacimiento, int legajo) {
        super(tipoDocumento, numeroDocumento, nombre, apellido, fechaNacimiento);
        this.legajo = legajo;

    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    
    @Override public String toString(){
        StringBuilder result = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        result.append(super.toString());
        result.append(lineSeparator);
        result.append("Legajo: ").append(legajo);
        return result.toString();
    }
}
