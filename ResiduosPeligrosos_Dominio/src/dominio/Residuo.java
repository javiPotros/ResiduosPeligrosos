package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representa a un residuo
 *  @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class Residuo {

 
    private ObjectId id;
    private String nombre;
    private String codigo;
    private Tratamiento tratamiento;
    private ObjectId idProductora;
    private List<Quimico> quimicos;

    /**
     * Constructor por defecto
     */
    public Residuo() {
        quimicos = new ArrayList<>();
    }

    /**
     * Constructor de la clase
     * @param id identificaedor del residuo
     * @param nombre nombre del residuo
     * @param codigo código del residuo
     * @param idProductora id de la productora del residuo
     */
    public Residuo(ObjectId id, String nombre, String codigo, ObjectId idProductora) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.idProductora = idProductora;
        this.quimicos = new ArrayList<>();
    }

     /**
     * Constructor de la clase
     * @param id identificaedor del residuo
     * @param nombre nombre del residuo
     * @param codigo código del residuo
     * @param tratamiento tratamiento que se le hará al residuo
     * @param idProductora id de la productora del residuo
     */
    public Residuo(ObjectId id, String nombre, String codigo, Tratamiento tratamiento, ObjectId idProductora) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.tratamiento = tratamiento;
        this.idProductora = idProductora;
        quimicos = new ArrayList<>();
    }

    /**
     * Devuelve el id del residuo
     * @return id del residuo
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Modifica el id del residuo
     * @param id id del residuo
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del residuo
     * @return nombre del residuo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del residuo
     * @param nombre nombre del residuo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el código del residuo
     * @return código del residuo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * modifica el código del residuo
     * @param codigo código del residuo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el tratamiento del residuo
     * @return tratamiento del residuo
     */
    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    /**
     * Modifica el tratamiento de este residuo
     * @param tratamiento tratamiento del residuo
     */
    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Devielve el id de la productora del residuo
     * @return id de la productora
     */
    public ObjectId getIdProductora() {
        return idProductora;
    }

    /**
     * Modifica el id de la productora del residuo
     * @param idProductora id de la productora
     */
    public void setIdProductora(ObjectId idProductora) {
        this.idProductora = idProductora;
    }

    /**
     * obtiene la lista de quimicos que componen al residuo
     * @return lista de quimicos del residuo
     */
    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    /**
     * Modifica la lista de quimicos que componen al residuo
     * @param quimicos lista de quimicos del residuo
     */
    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

    /**
     * Regresa el hashcode de este residuo
     * @return hashcode de este residuo
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

     /**
     * compara si el objeto dado es igual a este residuo
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
        final Residuo other = (Residuo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Regresa una cadena con los atributos del residuo
     * @return cadena con sus atributos
     */
    @Override
    public String toString() {
        return "Residuo{" + "id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", tratamiento=" + tratamiento + ", idProductora=" + idProductora + ", quimicos=" + quimicos + '}';
    }

}
