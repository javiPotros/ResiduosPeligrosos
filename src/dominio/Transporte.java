package dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representa a un trasnporte (vehículo)
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class Transporte {

    private ObjectId id;
    private String matricula;
    private String marca;
    private String modelo;
    private String tipo;
    private Transportista transportista;

    /**
     * Constructor por defecto
     */
    public Transporte() {
    }

    /**
     * Constructor de la clase
     *
     * @param id identificador del transporte
     * @param matricula matricula del transporte
     * @param marca marca del transporte
     * @param modelo modelo del transporte
     * @param tipo tipo de transporte
     * @param transportista empresa transportisa
     */
    public Transporte(ObjectId id, String matricula, String marca, String modelo, String tipo, Transportista transportista) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.transportista = transportista;
    }

    /**
     * Devuelve la matricula de este transporte
     *
     * @return matricula de este transporte
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Modifica la matricula de este transporte
     *
     * @param matricula matricula del transporte
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Devuelve la marca del transporte
     *
     * @return marca del transporte
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Modifica la marca del transporte
     *
     * @param marca marca del transporte
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el modelo del trasnporte
     *
     * @return modelo del transporte
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica el modelo del trasnporte
     *
     * @param modelo modelo del transporte
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve el tipo de transporte
     *
     * @return tipo de transporte
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de transporte
     *
     * @param tipo tipo de transporte
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la transportista del transporte
     *
     * @return
     */
    public Transportista getTransportista() {
        return transportista;
    }

    /**
     * Modifica la trasportista del transporte
     *
     * @param transportista trasnportista del trasporte
     */
    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    /**
     * Devuelve el id del trasporte
     *
     * @return id del trasporte
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Modifica el id del trasporte
     *
     * @param id id del trasnporte
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el hashcode de este objeto transporte
     *
     * @return hashcode de este trasporte
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * compara si el objeto dado es igual a este trasporte
     *
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
        final Transporte other = (Transporte) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Regresa una cadena con los atributos del trasporte
     *
     * @return cadena con sus atributos
     */
    @Override
    public String toString() {
        return "Transporte{" + "id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", transportista=" + transportista + '}';
    }
}
