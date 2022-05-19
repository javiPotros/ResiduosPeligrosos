package dominio;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representa un traslado de un residuo
 */
public class Traslado {

    private ObjectId id;
    private Integer numTransportes;
    private String destino;
    private LocalDate fechaSolicitada;
    private LocalDate fechaLlegada;
    private String cantidad;
    private Float kmRecorridos;
    private Double costo;
    private String estado;
    private Residuo residuo;
    private ObjectId idTransportadora;
    private List<ObjectId> idTransportes;

    /**
     * Constructor por defecto
     */
    public Traslado() {
    }

    /**
     * Constructor de la clase
     * @param id identificador del traslado
     */
    public Traslado(ObjectId id) {
        this.id = id;
    }

    /**
     * Constructor de la clase
     * @param id identificador del traslado
     * @param numTransportes numero de transportes que utiliza
     * @param destino destino del residuo
     * @param fechaSolicitada fecha de la solicitud del traslado
     * @param fechaLlegada fecha de llegada del residuo a su destino
     * @param cantidad cantidad del resiudo
     * @param kmRecorridos km recorridos del traslado
     * @param costo costo del traslado
     * @param estado estado del traslado
     * @param residuo residuo a trasladar
     * @param idTransportadora id de la empresa transportadores
     * @param idTransportes id de los trasnportes
     */
    public Traslado(ObjectId id, Integer numTransportes, String destino, LocalDate fechaSolicitada, LocalDate fechaLlegada, String cantidad, Float kmRecorridos, Double costo, String estado, Residuo residuo, ObjectId idTransportadora, List<ObjectId> idTransportes) {
        this.id = id;
        this.numTransportes = numTransportes;
        this.destino = destino;
        this.fechaSolicitada = fechaSolicitada;
        this.fechaLlegada = fechaLlegada;
        this.cantidad = cantidad;
        this.kmRecorridos = kmRecorridos;
        this.costo = costo;
        this.estado = estado;
        this.residuo = residuo;
        this.idTransportadora = idTransportadora;
        this.idTransportes = idTransportes;
    }
    
    /**
     * Devuelve el id del traslado
     * @return id del traslado
     */

    public ObjectId getId() {
        return id;
    }

    /**
     * modifica el id del traslado
     * @param idTraslado id del traslado
     */
    public void setId(ObjectId idTraslado) {
        this.id = idTraslado;
    }

    /**
     * Devuelve el número de transportes
     * @return número de transportes
     */
    public Integer getNumTransportes() {
        return numTransportes;
    }

    /**
     * Modifica el número de transportes
     * @param numTransportes número de transportes
     */
    public void setNumTransportes(Integer numTransportes) {
        this.numTransportes = numTransportes;
    }

    /**
     * Devuelve el destino del residuo a trasladar
     * @return destino del residuo
     */
    public String getDestino() {
        return destino;
    }

    /**
     * modifica el destino del residuo a trasladar
     * @param destino destino del residuo
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * decuelve fecha en que se solicitó el traslado
     * @return fecha de solicitud de traslado
     */
    public LocalDate getFechaSolicitada() {
        return fechaSolicitada;
    }

    /**
     * modifica fecha en que se solicitó el traslado
     * @param fechaSolicitada fecha de solicitud de traslado
     */
    public void setFechaSolicitada(LocalDate fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

   /**
     * devuelve fecha en que se llegó el residuo a su destino
     * @return fecha de llegada del traslado
     */
    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

      /**
     * devuelve fecha en que llegó el residuo a su destino
     * @param fechaLlegada fecha de llegada de traslado
     */
    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * devuelve la cantidad del residuo a trasladar
     * @return cantidad del residuo
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * modifica la cantidad del residuo a trasladar
     * @param cantidad cantidad del residuo
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Devuelve los km recorridos en el traslado
     * @return km recorridos
     */

    public Float getKmRecorridos() {
        return kmRecorridos;
    }

    /**
     *  Modifica los km recorridos en el traslado
     * @param kmRecorridos km recorridos
     */
    public void setKmRecorridos(Float kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    /**
     * Devuelve el costo del traslado
     * @return costo del traslado
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * modifica el costo del traslado
     * @param costo costo del traslado
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * Devuelve el estado del traslado
     * @return estado del traslado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Modifica el estado del traslado
     * @param estado estado del traslado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Devuelve el residuo trasladado
     * @return residuo trasladado
     */

    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Modifica el residuo trasladado
     * @param residuo residuo trasladado
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Devuelve los id de los tranportes usados
     * @return id de los trasnportes
     */
    public List<ObjectId> getIdTransportes() {
        return idTransportes;
    }

    /**
     * Devuelve el id de la transportadora
     * @return id de trasnportadora
     */
    public ObjectId getIdTransportadora() {
        return idTransportadora;
    }

    /**
     * Devuelve el id de la transportadora
     * @param idTransportadora id de la trasnportadora
     */
    public void setIdTransportadora(ObjectId idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    /**
     * Modifica el id de la transportadora
     * @param idTransportes id de la trasnportadora
     */
    public void setIdTransportes(List<ObjectId> idTransportes) {
        this.idTransportes = idTransportes;
    }

   /**
     * Regresa el hashcode de este objeto traslado
     * @return hashcode de este trasporte
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

     /**
     * compara si el objeto dado es igual a este traslado
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
        final Traslado other = (Traslado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Regresa una cadena con los atributos del traslado
     * @return cadena con sus atributos
     */
    @Override
    public String toString() {
        return "Traslado{" + "id=" + id + ", numTransportes=" + numTransportes + ", destino=" + destino + ", fechaSolicitada=" + fechaSolicitada + ", fechaLlegada=" + fechaLlegada + ", cantidad=" + cantidad + ", kmRecorridos=" + kmRecorridos + ", costo=" + costo + ", estado=" + estado + ", residuo=" + residuo + ", idTransportadora=" + idTransportadora + ", idTransportes=" + idTransportes + '}';
    }

}
