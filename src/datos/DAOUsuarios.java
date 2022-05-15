package datos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.iDAOUsuarios;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los usuarios.
 */
public class DAOUsuarios implements iDAOUsuarios {

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    /**
     * Constructor por defecto de la clase de acceso a datos.
     * @param conexionBD Conexión a la base de datos.
     */
    public DAOUsuarios(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    /**
     * Obtiene la colección designada a la dao.
     * @return Colección de usuarios.
     */
    private MongoCollection<Usuario> getColleccion() {
        return this.basedatos.getCollection("usuarios", Usuario.class);
    }

    /**
     * Consulta un usuario en especifico.
     * @param id Id del usuario a buscar.
     * @return Usuario buscado.
     */
    @Override
    public Usuario consultar(ObjectId id) {
        MongoCollection<Usuario> coleccion = this.getColleccion();
        List<Usuario> listaUsuarios = new LinkedList<>();
        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("_id", id)));

        coleccion.aggregate(etapas).into(listaUsuarios);
        return listaUsuarios.get(0);
    }

    /**
     * Consulta un usuario en especifico para poder autenticar.
     * @param usuario Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return Regresa el usuario a autenticar.
     */
    @Override
    public Usuario consultar(String usuario, String contrasena) {
        for (Usuario user : consultarTodos()) {
            if (user.getNombreUsuario().equals(usuario)
                    && user.getContrasena().equals(contrasena)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Consulta todos los usuarios.
     * @return Lista con todos los usuarios.
     */
    @Override
    public List<Usuario> consultarTodos() {
        MongoCollection<Usuario> coleccion = this.getColleccion();
        List<Usuario> usuarios = new ArrayList();
        FindIterable iterable = coleccion.find();
        iterable.into(usuarios);
        return usuarios;
    }

    /**
     * Consulta todos los usuarios que sean transportadoras.
     * @return Lista con todos los usuarios que son transportadoras.
     */
    @Override
    public List<Usuario> consultarTransportadoras() {
        MongoCollection<Usuario> coleccion = this.getColleccion();
        List<Usuario> listaUsuarios = new LinkedList<>();
        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("tipo", "transportadora")));

        coleccion.aggregate(etapas).into(listaUsuarios);
        return listaUsuarios;
    }
}
