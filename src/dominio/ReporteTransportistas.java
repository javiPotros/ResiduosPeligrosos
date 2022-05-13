package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReporteTransportistas {

    private Integer idReporte;
    private String notas;
    private List<Transportista> transportistas;

    public ReporteTransportistas() {
        transportistas = new ArrayList<>();
    }

    public ReporteTransportistas(Integer id, String notas) {
        this.idReporte = id;
        this.notas = notas;
        transportistas = new ArrayList<>();
    }
    
    
    public List<Transportista> consultar() {
        return transportistas;
    }
    
    public void agregar(Transportista transportista){
        transportistas.add(transportista);
    }
    
    public void actualizar(Transportista transportista){
        
    }
    
    public void eliminar(Transportista transportista){
        transportistas.remove(transportista);
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.idReporte);
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
        final ReporteTransportistas other = (ReporteTransportistas) obj;
        if (!Objects.equals(this.idReporte, other.idReporte)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reporte{" + "idReporte=" + idReporte + ", notas=" + notas + '}';
    }

}
