package interfaces;

import dominio.Quimico;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public interface iDAOQuimicos {

    public void agregar(Quimico quimico);

    public Quimico consultar(ObjectId id);
    
    public List<Quimico> consultarTodos();
}
