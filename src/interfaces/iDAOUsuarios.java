package interfaces;

import dominio.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public interface iDAOUsuarios {

    public Usuario consultar(ObjectId id);
    
    public Usuario consultar(String usuario, String contrasena);

    public List<Usuario> consultarTodos();
}
