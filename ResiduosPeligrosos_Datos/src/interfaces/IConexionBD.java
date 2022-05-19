package interfaces;

import com.mongodb.client.MongoDatabase;

/**
 * Configura una conexión a la base de datos.
 */
public interface IConexionBD {

    /**
     * Crea la conexión a la base de datos de Mongo.
     * @return Referencia a la base de datos de Mongo.
     */
    public MongoDatabase crearConexion();

}
