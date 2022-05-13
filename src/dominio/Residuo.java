package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

public class Residuo {

 
    private ObjectId id;
    private String nombre;
    private String codigo;
    private Tratamiento tratamiento;
    private Productora productora;
    private List<Quimico> quimicos;

    public Residuo() {
        quimicos = new ArrayList<>();
    }

    public Residuo(ObjectId id, String nombre, String codigo, Productora productora) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.productora = productora;
        this.quimicos = new ArrayList<>();
    }

    public Residuo(ObjectId id, String nombre, String codigo, Tratamiento tratamiento, Productora productora) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.tratamiento = tratamiento;
        this.productora = productora;
        quimicos = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void generarId(){
        this.id = new ObjectId();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Productora getProductora() {
        return productora;
    }

    public void setProductora(Productora productora) {
        this.productora = productora;
    }

    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Residuo other = (Residuo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Residuo{" + "id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", tratamiento=" + tratamiento + ", productora=" + productora + ", quimicos=" + quimicos + '}';
    }

}
