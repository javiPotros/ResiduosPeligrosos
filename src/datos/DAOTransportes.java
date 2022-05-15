package datos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.Transporte;
import interfaces.IConexionBD;
import interfaces.iDAOTransportes;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de acceso a datos con respecto a los transportes.
 */
public class DAOTransportes implements iDAOTransportes {
    
    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    /**
     * Constructor por defecto de la clase de acceso a datos.
     * @param conexionBD Conexión a la base de datos.
     */
    public DAOTransportes(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    /**
     * Obtiene la colección designada a la dao.
     * 
     * @return Colección de transportes.
     */
    private MongoCollection<Transporte> getColeccion() {
        return this.basedatos.getCollection("transportes", Transporte.class);
    }

    /**
     * Consulta todos los transportes.
     * @return Lista con todos los transportes.
     */
    @Override
    public List<Transporte> consultarTodos() {
        MongoCollection<Transporte> coleccion = this.getColeccion();
        List<Transporte> transportes = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(transportes);
        return transportes;
    }
}
