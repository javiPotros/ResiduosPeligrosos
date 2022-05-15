package datos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.Quimico;
import interfaces.IConexionBD;
import interfaces.iDAOQuimicos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los químicos.
 */
public class DAOQuimicos implements iDAOQuimicos {

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    /**
     * Constructor por defecto de la clase de acceso a datos.
     * @param conexionBD Conexión a la base de datos.
     */
    public DAOQuimicos(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    /**
     * Obtiene la colección designada a la dao.
     * @return Colección de químicos.
     */
    private MongoCollection<Quimico> getColleccion() {
        return this.basedatos.getCollection("quimicos", Quimico.class);
    }

    /**
     * Agrega un químico.
     * @param quimico Químico a agregar.
     */
    @Override
    public void agregar(Quimico quimico) {
        if (consultarTodos().contains(quimico)) {
            return;
        }
        MongoCollection<Quimico> coleccion = this.getColleccion();
        coleccion.insertOne(quimico);
    }

    /**
     * Consulta un químico en especifico.
     * @param id Id del químico a buscar.
     * @return Químico buscado.
     */
    @Override
    public Quimico consultar(ObjectId id) {
        MongoCollection<Quimico> coleccion = this.getColleccion();
        List<Quimico> listaQuimicos = new LinkedList<>();
        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("_id", id)));

        coleccion.aggregate(etapas).into(listaQuimicos);
        return listaQuimicos.get(0);
    }

    /**
     * Consulta todos los químicos.
     * @return Lista con todos los químicos.
     */
    @Override
    public List<Quimico> consultarTodos() {
        MongoCollection<Quimico> coleccion = this.getColleccion();
        List<Quimico> quimicos = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(quimicos);
        return quimicos;
    }
}
