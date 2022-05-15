package dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representa a un usuario del sistema
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class Usuario {

    ObjectId id;
    String nombreUsuario;
    String contrasena;
    String nombre;
    String direccion;
    String tipo;

    
    /**
     * Constructor por defecto
     */
    public Usuario() {
    }

     /**
     * Constructor de la clase
     * @param nombre nombre de la productora
     * @param direccion dirección de la productora
     */
    public Usuario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    
    /**
     * Constructor de la clase
    * @param nombre nombre de la productora
     * @param direccion dirección de la productora
     * @param tipo tipo de ususario
     */
    public Usuario(String nombre, String direccion, String tipo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    
    /**
     * Constructor de la clase
     * @param nombreUsuario nombre del usuario
     * @param contrasena constraseña
     * @param nombre nombre de la productora
     * @param direccion dirección  de la productora
     * @param tipo tipo de usuario
     */
    public Usuario(String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
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
    public Usuario(ObjectId id, String nombreUsuario, String contrasena, String nombre, String direccion, String tipo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    
    /**
     * Devuelve el id del usuario
     * @return id del usuario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Modifica el id del usuario
     * @param id id del usuario
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del usuario
     * @return nombre del usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * modifica el nombre del usuario
     * @param nombreUsuario nombre del usuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * devuelve la contraseña del usuario
     * @return contraseña del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * modifica la contraseña del usuario
     * @param contrasena contraseña del usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * devuelve el nombre 
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * modifica el nombre
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección del usuario
     * @return direccion del usuario
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * modifica la direccion del usuario
     * @param direccion direccion del usuario
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * devuelve el tipo de usuario
     * @return tipo de usuario
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * modifica el tipo de usuario
     * @param tipo tipo de usuario
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

     /**
     * Regresa el hashcode de este objeto usuario
     * @return hashcode de este usuario
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

      /**
     * compara si el objeto dado es igual a este usuario
     * @param obj objeto a comparar
     * @return true si los objetos son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Regresa una cadena con los atributos del usuario
     * @return cadena con sus atributos
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", direccion=" + direccion + ", tipo=" + tipo + '}';
    }

}
