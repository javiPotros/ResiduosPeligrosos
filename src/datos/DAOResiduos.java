package datos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import dominio.Quimico;
import dominio.Residuo;
import interfaces.IConexionBD;
import interfaces.iDAOResiduos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class DAOResiduos implements iDAOResiduos{

    private MongoDatabase basedatos;
    private IConexionBD conexionBD;
    
       
    public DAOResiduos(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }
     
    private MongoCollection<Residuo> getColleccion() {
        return this.basedatos.getCollection("residuos", Residuo.class);
    }
    
    @Override
    public void agregar(Residuo residuo) {
         MongoCollection<Residuo> coleccion = this.getColleccion();
         coleccion.insertOne(residuo);
    }
    
    @Override
    public List<Residuo> consultarTodos(){
        MongoCollection<Residuo> coleccion = this.getColleccion();
        List<Residuo> residuos = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(residuos);
        return residuos;
    }

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

    @Override
    public List<Residuo> consultarPorProductor(String productor) {
        MongoCollection<Residuo> coleccion = this.getColleccion();
        FindIterable iterable = coleccion.find(eq("productora.nombre",productor));
        List<Residuo> residuos = new ArrayList<>();

        iterable.into(residuos);
        return residuos;
    }
    
}
