package dominio;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

public class Traslado {

    private ObjectId id;
    private Integer numTransportes;
    private String destino;
    private LocalDate fechaSolicitada;
    private LocalDate fechaLlegada;
    private Float cantidad;
    private Float kmRecorridos;
    private Double costo;
    private String estado;
    private Residuo residuo;
    private ObjectId idTransportadora;
    private List<ObjectId> idTransportes;

    public Traslado() {
    }

    public Traslado(ObjectId id) {
        this.id = id;
    }

    public Traslado(ObjectId id, Integer numTransportes, String destino, LocalDate fechaSolicitada, LocalDate fechaLlegada, Float cantidad, Float kmRecorridos, Double costo, String estado, Residuo residuo, ObjectId idTransportadora, List<ObjectId> idTransportes) {
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId idTraslado) {
        this.id = idTraslado;
    }

    public Integer getNumTransportes() {
        return numTransportes;
    }

    public void setNumTransportes(Integer numTransportes) {
        this.numTransportes = numTransportes;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(LocalDate fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(Float kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    public List<ObjectId> getIdTransportes() {
        return idTransportes;
    }

    public ObjectId getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(ObjectId idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public void setIdTransportes(List<ObjectId> idTransportes) {
        this.idTransportes = idTransportes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Traslado{" + "id=" + id + ", numTransportes=" + numTransportes + ", destino=" + destino + ", fechaSolicitada=" + fechaSolicitada + ", fechaLlegada=" + fechaLlegada + ", cantidad=" + cantidad + ", kmRecorridos=" + kmRecorridos + ", costo=" + costo + ", estado=" + estado + ", residuo=" + residuo + ", idTransportadora=" + idTransportadora + ", idTransportes=" + idTransportes + '}';
    }

}
