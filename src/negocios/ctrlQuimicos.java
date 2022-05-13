package negocios;

import datos.DAOQuimicos;
import dominio.Quimico;
import interfaces.IConexionBD;
import interfaces.iDAOQuimicos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public class ctrlQuimicos {

    iDAOQuimicos daoQuimicos;

    public ctrlQuimicos(IConexionBD conexionBD) {
        daoQuimicos = new DAOQuimicos(conexionBD);
    }

    public void agregarQuimico(Quimico quimico) {
        daoQuimicos.agregar(quimico);
    }
    
    public Quimico consultar(ObjectId id){
        return daoQuimicos.consultar(id);
    }

    public List<Quimico> consultarTodos() {
        return daoQuimicos.consultarTodos();
    }

}
