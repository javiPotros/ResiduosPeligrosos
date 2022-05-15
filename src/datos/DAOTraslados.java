package datos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
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
     * @param conexionBD Conexión a la base de datos.
     */
    public DAOTraslados(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    /**
     * Obtiene la colección designada a la dao.
     * @return Colección de traslados.
     */
    private MongoCollection<Traslado> getColleccion() {
        return this.basedatos.getCollection("traslados", Traslado.class);
    }

    /**
     * Agrega un traslado.
     * @param traslado Traslado a agregar.
     */
    @Override
    public void agregar(Traslado traslado) {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        coleccion.insertOne(traslado);
    }

    /**
     * Actualiza un traslado.
     * @param traslado Traslado a actualizar.
     */
    @Override
    public void actualizar(Traslado traslado) {
        MongoCollection<Traslado> collection = this.getColleccion();
        Bson filtro = eq("_id", traslado.getId());
        collection.replaceOne(filtro, traslado);
    }

    /**
     * Consulta un traslado en específico.
     * @param id Id del traslado a buscar.
     * @return Traslado buscado.
     */
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

    /**
     * Consulta todos los traslados.
     * @return Lista con todos los traslados.
     */
    @Override
    public List<Traslado> consultarTodos() {
        MongoCollection<Traslado> coleccion = this.getColleccion();
        List<Traslado> traslados = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(traslados);
        return traslados;
    }

    /**
     * Consulta todos los traslados que se encuentran pendientes.
     * @return Lista con todos los traslados pendientes.
     */
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
    
    /**
     * Consulta todos los traslados que se encuentran asignados de una transportadora específica.
     * @param idTransportadora Id de la transportadora asociada.
     * @return Lista con todos los traslados asignados a una transportadora.
     */
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
