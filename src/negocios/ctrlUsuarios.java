package negocios;

import datos.DAOUsuarios;
import dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.iDAOUsuarios;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class ctrlUsuarios {

    iDAOUsuarios daoUsuarios;

    public ctrlUsuarios(IConexionBD conexionBD) {
        daoUsuarios = new DAOUsuarios(conexionBD);
    }

    public Usuario consultar(ObjectId id) {
        return daoUsuarios.consultar(id);
    }

    public Usuario consultar(String usuario, String contrasena) {
        return daoUsuarios.consultar(usuario, contrasena);
    }

    public List<Usuario> consultarTodos() {
        return daoUsuarios.consultarTodos();
    }

}
