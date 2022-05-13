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
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class DAOQuimicos implements iDAOQuimicos {

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    public DAOQuimicos(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    private MongoCollection<Quimico> getColleccion() {
        return this.basedatos.getCollection("quimicos", Quimico.class);
    }

    @Override
    public void agregar(Quimico quimico) {
        if (consultarTodos().contains(quimico)) {
            return;
        }
        MongoCollection<Quimico> coleccion = this.getColleccion();
        coleccion.insertOne(quimico);
    }

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

    @Override
    public List<Quimico> consultarTodos() {
        MongoCollection<Quimico> coleccion = this.getColleccion();
        List<Quimico> quimicos = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(quimicos);
        return quimicos;
    }

}
