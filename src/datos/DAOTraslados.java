package datos;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import dominio.Traslado;
import interfaces.IConexionBD;
import interfaces.iDAOTraslados;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los traslados.
 */
public class DAOTraslados implements iDAOTraslados {

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    /**
     * Constructor por defecto de la clase de acceso a datos.
     *
     * @param conexionBD Conexión a la base de datos.
     */
    public DAOTraslados(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    private MongoCollection<Traslado> getColleccion() {
        return this.basedatos.getCollection("traslados", Traslado.class);
    }

    @Override
    public void agregar(Traslado traslado) {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        coleccion.insertOne(traslado);
    }

    @Override
    public void actualizar(Traslado traslado) {
        MongoCollection<Traslado> collection = this.getColleccion();
        Bson filtro = eq("_id", traslado.getId());
        collection.replaceOne(filtro, traslado);
    }
    
    @Override
    public void eliminar(ObjectId id) {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        Bson query = eq("_id", id);
        try {
            DeleteResult result = coleccion.deleteOne(query);
        } catch (MongoException me) {
        }
    }

    @Override
    public void actualizarResiduos(Document traslado, String residuo) {
        MongoCollection<Traslado> coleccion = this.getColleccion();

        Bson valorActualizado = new Document("residuos", residuo);
        Bson operacion = new Document("$pull", valorActualizado);
        coleccion.updateOne(traslado, operacion);
    }

    @Override
    public Traslado consultar(ObjectId id) {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        List<Traslado> listaTraslados = new LinkedList<>();
        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("_id", id)));

        coleccion.aggregate(etapas).into(listaTraslados);
        return listaTraslados.get(0);
    }

    @Override
    public List<Traslado> consultarTodos() {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        List<Traslado> traslados = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(traslados);
        return traslados;
    }

    @Override
    public List<Traslado> consultarPendientes() {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        List<Traslado> listaTraslados = new LinkedList<>();
        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("estado", "pendiente")));

        coleccion.aggregate(etapas).into(listaTraslados);
        return listaTraslados;
    }

    @Override
    public List<Traslado> consultarAsignados(ObjectId idTransportadora) {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        List<Traslado> listaTraslados = new LinkedList<>();
        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("estado", "asignado")
                        .append("idTransportadora", idTransportadora)));

        coleccion.aggregate(etapas).into(listaTraslados);
        return listaTraslados;
    }
}
