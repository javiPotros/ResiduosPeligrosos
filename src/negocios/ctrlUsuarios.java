package negocios;

import datos.DAOUsuarios;
import dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.iDAOUsuarios;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de control para la entidad 'Usuario'.
 */
public class ctrlUsuarios {

    iDAOUsuarios daoUsuarios;

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexionBD conexión a la base de datos
     */
    public ctrlUsuarios(IConexionBD conexionBD) {
        daoUsuarios = new DAOUsuarios(conexionBD);
    }

    /**
     * Consulta un usuario por su id.
     *
     * @param id id del usuario a consultar
     * @return usuario que coincida con el id dado en el parámetro
     */
    public Usuario consultar(ObjectId id) {
        return daoUsuarios.consultar(id);
    }

    /**
     * Consulta un usuario por su nombre de usuario y contraseña.
     *
     * @param usuario nombre de usuario de la empresa
     * @param contrasena contraseña del usuario
     * @return el usuario que coincida con las credenciales dadas
     */
    public Usuario consultar(String usuario, String contrasena) {
        return daoUsuarios.consultar(usuario, contrasena);
    }

    /**
     * Consulta la lista de todos los usuarios registrados.
     *
     * @return lista de usuarios registrados
     */
    public List<Usuario> consultarTodos() {
        return daoUsuarios.consultarTodos();
    }

    /**
     * Consulta la lista de todos los usuarios registrados que entren en la
     * categoría de 'transportadora'.
     *
     * @return lista de transportadoras
     */
    public List<Usuario> consultarTransportadoras() {
        return daoUsuarios.consultarTransportadoras();
    }

}
