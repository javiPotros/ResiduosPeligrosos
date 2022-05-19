package dominio;

import org.bson.types.ObjectId;

/**
 * Representa al usuario administrador
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class Administrador extends Usuario {

    /**
     * Constructor por defecto
     */
    public Administrador() {
    }

    /**
     * Constructor de la clase
     *
     * @param nombreUsuario nombre del usuario
     * @param contrasena constraseña
     * @param nombre nombre del administrador
     * @param direccion dirección del administrador
     * @param tipo tipo de usuario
     */
    public Administrador(String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(nombreUsuario, contrasena, nombre, direccion, tipo);
    }

    /**
     * Constructor de la clase
     *
     * @param id identificador del usuario administrador
     * @param nombreUsuario nombre del usuario
     * @param contrasena constraseña
     * @param nombre nombre del administrador
     * @param direccion dirección del administrador
     * @param tipo tipo de usuario
     */
    public Administrador(ObjectId id, String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(id, nombreUsuario, contrasena, nombre, direccion, tipo);
    }

}
