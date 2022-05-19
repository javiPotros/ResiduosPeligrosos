package interfaces;

import dominio.Quimico;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los químicos.
 */
public interface iDAOQuimicos {

    /**
     * Agrega un químico.
     * @param quimico Químico a agregar.
     */
    public void agregar(Quimico quimico);

    /**
     * Consulta un químico en especifico.
     * @param id Id del químico a buscar.
     * @return Químico buscado.
     */
    public Quimico consultar(ObjectId id);
    
     /**
     * Consulta todos los químicos.
     * @return Lista con todos los químicos.
     */
    public List<Quimico> consultarTodos();
}
