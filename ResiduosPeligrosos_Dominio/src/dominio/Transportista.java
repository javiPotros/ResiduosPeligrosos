package dominio;

import org.bson.types.ObjectId;

/**
 * Representa la empresa trasnportista
 *
 * @author @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class Transportista extends Usuario {

    /**
     * Constructor por defecto
     */
    public Transportista() {
    }

    /**
     * Constructor de la clase
     *
     * @param nombre nombre de la trasnportista
     * @param direccion direccion de la transportista
     */
    public Transportista(String nombre, String direccion) {
        super(nombre, direccion);
    }

    /**
     * Constructor de la clase
     *
     * @param nombre nombre de la trasnportista
     * @param direccion direccion de la transportista
     * @param tipo tipo de la trasnportista
     */
    public Transportista(String nombre, String direccion, String tipo) {
        super(nombre, direccion, tipo);
    }

    /**
     * Constructor de la clase
     *
     * @param nombre nombre de la trasnportista
     * @param direccion direccion de la transportista
     * @param tipo tipo de la trasnportista
     * @param nombreUsuario nombre del usuario
     * @param contrasena constraseña
     */
    public Transportista(String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(nombreUsuario, contrasena, nombre, direccion, tipo);
    }

    /**
     *
     * @param id identificado de la transportista
     * @param nombre nombre de la trasnportista
     * @param direccion direccion de la transportista
     * @param tipo tipo de la trasnportista
     * @param nombreUsuario nombre del usuario
     * @param contrasena constraseña
     */
    public Transportista(ObjectId id, String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(id, nombreUsuario, contrasena, nombre, direccion, tipo);
    }

}
