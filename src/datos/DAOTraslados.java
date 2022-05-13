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
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class DAOTraslados implements iDAOTraslados {

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

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
    public void actualizar(Document traslado, String campo, Object valor) {
        MongoCollection<Traslado> coleccion = this.getColleccion();

        Bson valorActualizado = new Document(campo, valor);
        Bson operacion = new Document("$set", valorActualizado);
        coleccion.updateOne(traslado, operacion);
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
        FindIterable iterable = coleccion.find(eq("pendiente", true));
        List<Traslado> traslados = new ArrayList<>();
        iterable.into(traslados);
        return traslados;
    }

}
