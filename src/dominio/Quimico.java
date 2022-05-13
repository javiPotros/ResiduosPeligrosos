package dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

public class Quimico {

    private ObjectId idQuimico;
    private String nombre;

    public Quimico() {
    }

    public Quimico(ObjectId id, String nombre) {
        this.idQuimico = id;
        this.nombre = nombre;
    }

    public ObjectId getId() {
        return idQuimico;
    }

    public void setId(ObjectId idQuimico) {
        this.idQuimico = idQuimico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idQuimico);
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
        final Quimico other = (Quimico) obj;
        if (!Objects.equals(this.idQuimico, other.idQuimico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quimico{" + "idQuimico=" + idQuimico + ", nombre=" + nombre + '}';
    }

}
