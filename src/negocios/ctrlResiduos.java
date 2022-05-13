package negocios;

import datos.DAOResiduos;
import dominio.Residuo;
import interfaces.IConexionBD;
import interfaces.iDAOResiduos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1
 */
public class ctrlResiduos {
    iDAOResiduos daoResiduos;

    public ctrlResiduos(IConexionBD conexionBD) {
        daoResiduos = new DAOResiduos(conexionBD);
    }

    public void agregar(Residuo residuo){
        daoResiduos.agregar(residuo);
    }
    
    public Residuo consultar(ObjectId id){
        return daoResiduos.consultar(id);
    } 
    
    public List<Residuo> consultarTodos(){
        return daoResiduos.consultarTodos();
    }
    
    public List<Residuo> consultarPorProductor(ObjectId idProductora){
       return  daoResiduos.consultarPorProductor(idProductora);
    }
}
