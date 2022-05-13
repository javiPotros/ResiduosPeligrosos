package dominio;

import org.bson.types.ObjectId;

public class Transportista extends Usuario {

    public Transportista() {
    }

    public Transportista(String nombre, String direccion) {
        super(nombre, direccion);
    }

    public Transportista(String nombre, String direccion, String tipo) {
        super(nombre, direccion, tipo);
    }

    public Transportista(String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(nombreUsuario, contrasena, nombre, direccion, tipo);
    }

    public Transportista(ObjectId id, String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        super(id, nombreUsuario, contrasena, nombre, direccion, tipo);
    }

}
