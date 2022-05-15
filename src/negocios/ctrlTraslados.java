package negocios;

import datos.DAOTraslados;
import dominio.Traslado;
import interfaces.IConexionBD;
import interfaces.iDAOTraslados;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public class ctrlTraslados {
    
    iDAOTraslados daoTraslados;
    
    public ctrlTraslados(IConexionBD conexionBD) {
        daoTraslados = new DAOTraslados(conexionBD);
    }
    
    public void agregar(Traslado traslado) {
        daoTraslados.agregar(traslado);
    }
    
    public void actualizar(Traslado traslado) {
        daoTraslados.actualizar(traslado);
    }
    
    public void actualizarPendiente(Document traslado, String residuo) {
        daoTraslados.actualizarResiduos(traslado, residuo);
    }
    
    public void eliminar(ObjectId id){
        daoTraslados.eliminar(id);
    }
    
    public Traslado consultar(ObjectId id){
        return daoTraslados.consultar(id);
    }
    
    public List<Traslado> consultarTodos() {
        return daoTraslados.consultarTodos();
    }
    
    public List<Traslado> consultarPendientes() {
        return daoTraslados.consultarPendientes();
    }
    
    public List<Traslado> consultarAsignados(ObjectId idTransportadora) {
        return daoTraslados.consultarAsignados(idTransportadora);
    }
}
