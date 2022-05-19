package interfaces;

import dominio.Residuo;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los residuos.
 */
public interface iDAOResiduos {

    /**
     * Agrega un residuo.
     * @param residuo Residuo a agregar.
     */
    public void agregar(Residuo residuo);

    /**
     * Consulta todos los residuos.
     * @return Lista con todos los residuos.
     */
    public List<Residuo> consultarTodos();
    
    /**
     * Consulta un residuo en especifico.
     * @param id Id del residuo a buscar.
     * @return Residuo buscado.
     */
    public Residuo consultar(ObjectId id); 

    /**
     * Consulta todos los residuos por productor.
     * @param idProductora Id de la productora.
     * @return Lista con todos los residuos filtrados por productor.
     */
    public List<Residuo> consultarPorProductor(ObjectId idProductora);
}
