package ejercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author nicolake
 */
public class Persona {

    enum TipoDocumento {
        DNI,
        LIBRETACIVICA
    }
    private TipoDocumento tipoDocumento;
    private int numeroDocumento;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Persona(TipoDocumento tipoDocumento, int numeroDocumento, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        result.append("Tipo de documento: ").append(tipoDocumento);
        result.append(lineSeparator);
        result.append("Numero de documento: ").append(numeroDocumento);
        result.append(lineSeparator);
        result.append("Nombre: ").append(nombre);
        result.append(lineSeparator);
        result.append("Apellido: ").append(apellido);
        result.append(lineSeparator);
        result.append("Fecha de Nacimiento: ").append(fechaNacimiento.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        return result.toString();
    }
}
