package dominio;

import org.bson.types.ObjectId;

public class Productora extends Usuario {

    public Productora() {
    }

    public Productora(String nombre, String direccion) {
        super(nombre, direccion);
    }

    public Productora(String nombre, String direccion, String tipo) {
        super(nombre, direccion, tipo);
    }

    public Productora(String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(nombreUsuario, contrasena, nombre, direccion, tipo);
    }

    public Productora(ObjectId id, String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(id, nombreUsuario, contrasena, nombre, direccion, tipo);
    }

}
