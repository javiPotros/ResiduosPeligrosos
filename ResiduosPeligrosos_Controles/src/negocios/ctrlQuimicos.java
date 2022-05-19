package negocios;

import datos.DAOQuimicos;
import dominio.Quimico;
import interfaces.IConexionBD;
import interfaces.iDAOQuimicos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de control para la entidad 'Quimico'.
 */
public class ctrlQuimicos {

    iDAOQuimicos daoQuimicos;

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexionBD conexión a la base de datos
     */
    public ctrlQuimicos(IConexionBD conexionBD) {
        daoQuimicos = new DAOQuimicos(conexionBD);
    }

    /**
     * Registra un quimico en la base de datos del sistema.
     *
     * @param quimico quimico a registrar
     */
    public void agregarQuimico(Quimico quimico) {
        daoQuimicos.agregar(quimico);
    }

    /**
     * Consulta un quimico por su id.
     *
     * @param id id del quimico a consultar
     * @return quimico que coincida con el id dado en el parámetro
     */
    public Quimico consultar(ObjectId id) {
        return daoQuimicos.consultar(id);
    }

    /**
     * Consulta la lista de todos los quimicos registrados.
     *
     * @return lista de quimicos registrados
     */ 
    public List<Quimico> consultarTodos() {
        return daoQuimicos.consultarTodos();
    }

}
