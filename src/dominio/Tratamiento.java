package dominio;

import java.util.Objects;

/**
 * Representa el tratamiento que se le dará al residuo
 * @author PC
 */
public class Tratamiento {

    private String nombre;
    private String descripcion;

    /**
     * Constructor por defecto
     */
    public Tratamiento() {
    }
    
    /**
     * Constructor de la clase
     * @param nombre nombre del tratamiento
     * @param descripcion descripción del tratamiento
     */

    public Tratamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el nombre del tratamiento
     * @return nombre del tratamiento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del tratamiento
     * @param nombre nombre del tratamiento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /**
     * Devuelve la descripción del tratamiento
     * @return descripción del tratamiento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripción del tratamiento
     * @param descripcion descripción del tratamiento
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     /**
     * Regresa el hashcode de este objeto tratamiento
     * @return hashcode de este tratamiento
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    
      /**
     * compara si el objeto dado es igual a este tratamiento
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
        final Tratamiento other = (Tratamiento) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

     /**
     * Regresa una cadena con los atributos del tratamiento
     * @return cadena con sus atributos
     */
    @Override
    public String toString() {
        return "Tratamiento{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

}
