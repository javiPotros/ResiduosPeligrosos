package negocios;

import datos.DAOTransportes;
import dominio.Transporte;
import interfaces.IConexionBD;
import interfaces.iDAOTransportes;
import java.util.List;

/**
 * Clase de control para la entidad 'Transporte'.
 */
public class ctrlTransportes {

    iDAOTransportes daoTransportes;

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexionBD conexión a la base de datos
     */
    public ctrlTransportes(IConexionBD conexionBD) {
        this.daoTransportes = new DAOTransportes(conexionBD);
    }

    /**
     * Consulta la lista de todos los transportes registrados.
     *
     * @return lista de transportes registrados
     */
    public List<Transporte> consultarTodos() {
        return daoTransportes.consultarTodos();
    }
}
