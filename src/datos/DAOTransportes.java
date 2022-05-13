package datos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.Transporte;
import interfaces.IConexionBD;
import interfaces.iDAOTransportes;
import java.util.ArrayList;
import java.util.List;

public class DAOTransportes implements iDAOTransportes {
    
    private MongoDatabase basedatos;
    private IConexionBD conexionBD;

    public DAOTransportes(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.basedatos = this.conexionBD.crearConexion();
    }

    private MongoCollection<Transporte> getColeccion() {
        return this.basedatos.getCollection("transportes", Transporte.class);
    }

    @Override
    public List<Transporte> consultarTodos() {
        MongoCollection<Transporte> coleccion = this.getColeccion();
        List<Transporte> transportes = new ArrayList<>();
        FindIterable iterable = coleccion.find();
        iterable.into(transportes);
        return transportes;
    }
}
