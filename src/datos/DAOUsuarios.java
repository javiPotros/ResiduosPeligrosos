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
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class DAOUsuarios implements iDAOUsuarios {

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    public DAOUsuarios(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    private MongoCollection<Usuario> getColleccion() {
        return this.basedatos.getCollection("usuarios", Usuario.class);
    }

    @Override
    public Usuario consultar(ObjectId id) {
        MongoCollection<Usuario> coleccion = this.getColleccion();
        List<Usuario> listaQuimicos = new LinkedList<>();
        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("_id", id)));

        coleccion.aggregate(etapas).into(listaQuimicos);
        return listaQuimicos.get(0);
    }

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

    @Override
    public List<Usuario> consultarTodos() {
        MongoCollection<Usuario> coleccion = this.getColleccion();
        List<Usuario> usuarios = new ArrayList();
        FindIterable iterable = coleccion.find();
        iterable.into(usuarios);
        return usuarios;
    }
}
