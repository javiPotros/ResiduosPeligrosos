package negocios;

import datos.DAOTraslados;
import dominio.Traslado;
import interfaces.IConexionBD;
import interfaces.iDAOTraslados;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase de control para la entidad 'Traslado'.
 */
public class ctrlTraslados {

    iDAOTraslados daoTraslados;

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexionBD conexión a la base de datos
     */
    public ctrlTraslados(IConexionBD conexionBD) {
        daoTraslados = new DAOTraslados(conexionBD);
    }

    /**
     * agrega un traslado a la base de datos.
     *
     * @param traslado traslado a registrar
     */
    public void agregar(Traslado traslado) {
        daoTraslados.agregar(traslado);
    }

    /**
     * Actualiza un traslado previamente registrado.
     *
     * @param traslado traslado a actualizar
     */
    public void actualizar(Traslado traslado) {
        daoTraslados.actualizar(traslado);
    }

    /**
     * Elimina el traslado dado por el parámetro.
     *
     * @param id id del traslado a eliminar.
     */
    public void eliminar(ObjectId id) {
        daoTraslados.eliminar(id);
    }

    /**
     * Consulta un traslado por su id.
     *
     * @param id id del traslado a consultar
     * @return traslado que coincida con el id dado en el parámetro
     */
    public Traslado consultar(ObjectId id) {
        return daoTraslados.consultar(id);
    }

    /**
     * Consulta la lista de todos los traslados registrados.
     *
     * @return lista de traslados registrados
     */
    public List<Traslado> consultarTodos() {
        return daoTraslados.consultarTodos();
    }

    /**
     * Consulta la lista de todos los traslados que se encuentren en estado de
     * 'pendiente'.
     *
     * @return lista de todos los traslados pendientes
     */
    public List<Traslado> consultarPendientes() {
        return daoTraslados.consultarPendientes();
    }

    /**
     * Consulta la lista de todos los traslados asignados que correspondan a una
     * transportadora.
     *
     * @param idTransportadora id de la transportadora con la cual se hará el
     * filtro
     * @return lista de traslados asignados de transportadora
     */
    public List<Traslado> consultarAsignados(ObjectId idTransportadora) {
        return daoTraslados.consultarAsignados(idTransportadora);
    }
}
