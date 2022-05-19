package dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representa a un componenete quimico
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class Quimico {

    private ObjectId idQuimico;
    private String nombre;

    /**
     * Contructor por defecto
     */
    public Quimico() {
    }

    /**
     * Constructor de la clase
     * @param id identificador del quimico
     * @param nombre nombre del quimico
     */
    public Quimico(ObjectId id, String nombre) {
        this.idQuimico = id;
        this.nombre = nombre;
    }

    /**
     * Regresa el id del quimico
     * @return id de este quimico
     */
    public ObjectId getId() {
        return idQuimico;
    }

    /**
     * Modifica el identificador de este quimico
     * @param idQuimico id del quimico
     */
    public void setId(ObjectId idQuimico) {
        this.idQuimico = idQuimico;
    }

    /**
     * Regresa el nombre del quimico
     * @return nombre de este quimico
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de este quimico
     * @param nombre nobmre del quimico
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el hashcode de este quimico
     * @return hashcode de este quimico
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idQuimico);
        return hash;
    }

    /**
     * compara si el objeto dado es igual a este quimico
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
        final Quimico other = (Quimico) obj;
        if (!Objects.equals(this.idQuimico, other.idQuimico)) {
            return false;
        }
        return true;
    }

    /**
     * Regresa una cadena con los atributos del quimico
     * @return cadena con sus atributos
     */
    @Override
    public String toString() {
        return "Quimico{" + "idQuimico=" + idQuimico + ", nombre=" + nombre + '}';
    }

}
