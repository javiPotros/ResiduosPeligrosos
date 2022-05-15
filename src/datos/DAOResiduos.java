package datos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import dominio.Residuo;
import interfaces.IConexionBD;
import interfaces.iDAOResiduos;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los residuos.
 */
public class DAOResiduos implements iDAOResiduos {

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    /**
     * Constructor por defecto de la clase de acceso a datos.
     *
     * @param conexionBD Conexión a la base de datos.
     */
    public DAOResiduos(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    /**
     * Obtiene la colección designada a la dao.
     *
     * @return Colección de residuos.
     */
    private MongoCollection<Residuo> getColleccion() {
        return this.basedatos.getCollection("residuos", Residuo.class);
    }

    /**
     * Agrega un residuo.
     *
     * @param residuo Residuo a agregar.
     */
    @Override
    public void agregar(Residuo residuo) {
        MongoCollection<Residuo> coleccion = this.getColleccion();
        coleccion.insertOne(residuo);
    }

    /**
     * Consulta todos los residuos.
     *
     * @return Lista con todos los residuos.
     */
    @Override
    public List<Residuo> consultarTodos() {
        MongoCollection<Residuo> coleccion = this.getColleccion();
        List<Residuo> residuos = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(residuos);
        return residuos;
    }

    /**
     * Consulta un residuo en especifico.
     *
     * @param id Id del residuo a buscar.
     * @return Residuo buscado.
     */
    @Override
    public Residuo consultar(ObjectId id) {
        MongoCollection<Residuo> coleccion = this.getColleccion();
        List<Residuo> listaResiduos = new ArrayList<>();

        List<Document> etapas = new ArrayList<>();

        etapas.add(new Document(
                "$match", new Document()
                        .append("_id", id)));

        coleccion.aggregate(etapas).into(listaResiduos);
        return listaResiduos.get(0);
    }

    /**
     * Consulta todos los residuos por productor.
     *
     * @param idProductora Id de la productora.
     * @return Lista con todos los residuos filtrados por productor.
     */
    @Override
    public List<Residuo> consultarPorProductor(ObjectId idProductora) {
        MongoCollection<Residuo> coleccion = this.getColleccion();
        FindIterable iterable = coleccion.find(eq("idProductora", idProductora));
        List<Residuo> residuos = new ArrayList<>();

        iterable.into(residuos);
        return residuos;
    }
}
