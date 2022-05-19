package interfaces;

import dominio.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los usuarios.
 */
public interface iDAOUsuarios {

    /**
     * Consulta un usuario en especifico.
     * @param id Id del usuario a buscar.
     * @return Usuario buscado.
     */
    public Usuario consultar(ObjectId id);
    
    /**
     * Consulta un usuario en especifico para poder autenticar.
     * @param usuario Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return Regresa el usuario a autenticar.
     */
    public Usuario consultar(String usuario, String contrasena);

    /**
     * Consulta todos los usuarios.
     * @return Lista con todos los usuarios.
     */
    public List<Usuario> consultarTodos();
    
    /**
     * Consulta todos los usuarios que sean transportadoras.
     * @return Lista con todos los usuarios que son transportadoras.
     */
    public List<Usuario> consultarTransportadoras();
}
