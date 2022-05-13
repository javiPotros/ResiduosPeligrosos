package dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(nombreUsuario, contrasena, nombre, direccion, tipo);
    }

    public Administrador(ObjectId id, String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(id, nombreUsuario, contrasena, nombre, direccion, tipo);
    }

}
