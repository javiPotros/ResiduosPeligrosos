package interfaces;

import dominio.Residuo;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public interface iDAOResiduos {

    public void agregar(Residuo residuo);

    public List<Residuo> consultarTodos();
    
    public Residuo consultar(ObjectId id); 

    public List<Residuo> consultarPorProductor(String productor);
}
