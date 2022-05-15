package dominio;

import org.bson.types.ObjectId;

/**
 * Representa al usuario de productora
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class Productora extends Usuario {

    /**
     * Constructor por defecto
     */
    public Productora() {
    }

    /**
     * Constructor de la clase
     * @param nombre nombre de la productora
     * @param direccion dirección de la productora
     */
    public Productora(String nombre, String direccion) {
        super(nombre, direccion);
    }

    /**
     * Constructor de la clase
    * @param nombre nombre de la productora
     * @param direccion dirección de la productora
     * @param tipo tipo de ususario
     */
    public Productora(String nombre, String direccion, String tipo) {
        super(nombre, direccion, tipo);
    }

    /**
     * Constructor de la clase
     * @param nombreUsuario nombre del usuario
     * @param contrasena constraseña
     * @param nombre nombre de la productora
     * @param direccion dirección  de la productora
     * @param tipo tipo de usuario
     */
    public Productora(String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(nombreUsuario, contrasena, nombre, direccion, tipo);
    }

     /**
     * Constructor de la clase
     * @param id identificador del usuario productor
     * @param nombreUsuario nombre del usuario
     * @param contrasena constraseña
     * @param nombre nombre de la productora
     * @param direccion dirección  de la productora
     * @param tipo tipo de usuario
     */
    public Productora(ObjectId id, String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(id, nombreUsuario, contrasena, nombre, direccion, tipo);
    }

}
