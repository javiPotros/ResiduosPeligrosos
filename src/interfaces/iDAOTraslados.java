package interfaces;

import dominio.Traslado;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public interface iDAOTraslados {
    
    public void agregar(Traslado traslado);
    
    public void actualizar(Traslado traslado);
    
    public void actualizarResiduos(Document traslado, String residuo);
    
    public void eliminar(ObjectId id);
    
    public Traslado consultar(ObjectId id);
    
    public List<Traslado> consultarTodos();
    
    public List<Traslado> consultarPendientes();
    
    public List<Traslado> consultarAsignados(ObjectId idTransportadora);
}
