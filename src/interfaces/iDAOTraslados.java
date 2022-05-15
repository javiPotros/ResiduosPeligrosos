package interfaces;

import dominio.Traslado;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos con respecto a los traslados.
 */
public interface iDAOTraslados {

    /**
     * Agrega un traslado.
     *
     * @param traslado Traslado a agregar.
     */
    public void agregar(Traslado traslado);

    /**
     * Actualiza un traslado.
     *
     * @param traslado Traslado a actualizar.
     */
    public void actualizar(Traslado traslado);

    /**
     * Elimina un traslado.
     *
     * @param id Id del traslado a eliminar.
     */
    public void eliminar(ObjectId id);

    /**
     * Consulta un traslado en específico.
     *
     * @param id Id del traslado a buscar.
     * @return Traslado buscado.
     */
    public Traslado consultar(ObjectId id);

    /**
     * Consulta todos los traslados.
     *
     * @return Lista con todos los traslados.
     */
    public List<Traslado> consultarTodos();

    /**
     * Consulta todos los traslados que se encuentran pendientes.
     *
     * @return Lista con todos los traslados pendientes.
     */
    public List<Traslado> consultarPendientes();

    /**
     * Consulta todos los traslados que se encuentran asignados de una
     * transportadora específica.
     *
     * @param idTransportadora Id de la transportadora asociada.
     * @return Lista con todos los traslados asignados a una transportadora.
     */
    public List<Traslado> consultarAsignados(ObjectId idTransportadora);
}
