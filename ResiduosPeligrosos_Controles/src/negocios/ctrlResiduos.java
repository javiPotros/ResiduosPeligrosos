package negocios;

import datos.DAOResiduos;
import dominio.Residuo;
import interfaces.IConexionBD;
import interfaces.iDAOResiduos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de control para la entidad 'Residuo'.
 */
public class ctrlResiduos {

    iDAOResiduos daoResiduos;

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexionBD conexión a la base de datos
     */
    public ctrlResiduos(IConexionBD conexionBD) {
        daoResiduos = new DAOResiduos(conexionBD);
    }

    /**
     * agrega un residuo a la base de datos.
     *
     * @param residuo residuo a registrar
     */
    public void agregar(Residuo residuo) {
        daoResiduos.agregar(residuo);
    }

    /**
     * Consulta un residuo por su id.
     *
     * @param id id del residuo a consultar
     * @return residuo que coincida con el id dado en el parámetro
     */
    public Residuo consultar(ObjectId id) {
        return daoResiduos.consultar(id);
    }

    /**
     * Consulta la lista de todos los residuos registrados.
     *
     * @return lista de quimicos registrados
     */
    public List<Residuo> consultarTodos() {
        return daoResiduos.consultarTodos();
    }

    /**
     * Consulta la lista de todos los residuos que coincidan con el id de un
     * productor.
     *
     * @param idProductora id del productor con el cual se hará el filtro de
     * consulta
     * @return lista de todos los residuos que coincidentes
     */
    public List<Residuo> consultarPorProductor(ObjectId idProductora) {
        return daoResiduos.consultarPorProductor(idProductora);
    }
}
