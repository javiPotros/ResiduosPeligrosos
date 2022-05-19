package interfaces;

import dominio.Quimico;
import dominio.Residuo;
import dominio.Transporte;
import dominio.Traslado;
import dominio.Usuario;
import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz de fachada para controles de entidades.
 */
public interface iNegocios {

    /**
     * Registra un quimico en la base de datos del sistema.
     *
     * @param quimico quimico a registrar
     */
    public void agregarQuimico(Quimico quimico);

    /**
     * Consulta un quimico por su id.
     *
     * @param id id del quimico a consultar
     * @return quimico que coincida con el id dado en el parámetro
     */
    public Quimico consultarQuimico(ObjectId id);

    /**
     * Consulta la lista de todos los quimicos registrados.
     *
     * @return lista de quimicos registrados
     */
    public List<Quimico> consultarQuimicos();

    /**
     * agrega un residuo a la base de datos.
     *
     * @param residuo residuo a registrar
     */
    public void agregarResiduo(Residuo residuo);

    /**
     * Consulta un residuo por su id.
     *
     * @param id id del residuo a consultar
     * @return residuo que coincida con el id dado en el parámetro
     */
    public Residuo consultarResiduo(ObjectId id);

    /**
     * Consulta la lista de todos los residuos registrados.
     *
     * @return lista de quimicos registrados
     */
    public List<Residuo> consultarResiduos();

    /**
     * Consulta la lista de todos los residuos que coincidan con el id de un
     * productor.
     *
     * @param idProductora id del productor con el cual se hará el filtro de
     * consulta
     * @return lista de todos los residuos que coincidentes
     */
    public List<Residuo> consultarResiduosPorProductor(ObjectId idProductora);

    /**
     * agrega un traslado a la base de datos.
     *
     * @param traslado traslado a registrar
     */
    public void agregarTraslado(Traslado traslado);

    /**
     * Actualiza un traslado previamente registrado.
     *
     * @param traslado traslado a actualizar
     */
    public void actualizarTraslado(Traslado traslado);

    /**
     * Consulta un traslado por su id.
     *
     * @param id id del traslado a consultar
     * @return traslado que coincida con el id dado en el parámetro
     */
    public Traslado consultarTraslado(ObjectId id);

    public boolean consultarExistenciaTraslado(Traslado traslado);

    /**
     * Consulta la lista de todos los traslados registrados.
     *
     * @return lista de traslados registrados
     */
    public List<Traslado> consultarTraslados();

    /**
     * Consulta la lista de todos los traslados registrados por fecha.
     *
     * @param fecha fecha de filtro
     * @return lista de traslados registrados
     */
    public List<Traslado> consultarTrasladosPorFecha(LocalDate fecha);

    /**
     * Consulta la lista de todos los traslados que se encuentren en estado de
     * 'pendiente'.
     *
     * @return lista de todos los traslados pendientes
     */
    public List<Traslado> consultarTrasladosPendientes();

    /**
     * Consulta la lista de todos los traslados asignados que correspondan a una
     * transportadora.
     *
     * @param idTransportadora id de la transportadora con la cual se hará el
     * filtro
     * @return lista de traslados asignados de transportadora
     */
    public List<Traslado> consultarTrasladosAsignados(ObjectId idTransportadora);

    /**
     * Elimina el traslado dado por el parámetro.
     *
     * @param id id del traslado a eliminar.
     */
    public void eliminarTraslado(ObjectId id);

    /**
     * Consulta un usuario por su id.
     *
     * @param id id del usuario a consultar
     * @return usuario que coincida con el id dado en el parámetro
     */
    public Usuario consultarUsuario(ObjectId id);

    /**
     * Consulta un usuario por su nombre de usuario y contraseña.
     *
     * @param usuario nombre de usuario de la empresa
     * @param contrasena contraseña del usuario
     * @return el usuario que coincida con las credenciales dadas
     */
    public Usuario consultarUsuario(String usuario, String contrasena);

    /**
     * Consulta la lista de todos los usuarios registrados.
     *
     * @return lista de usuarios registrados
     */
    public List<Usuario> consultarUsuarios();

    /**
     * Consulta la lista de todos los usuarios registrados que entren en la
     * categoría de 'transportadora'.
     *
     * @return lista de transportadoras
     */
    public List<Usuario> consultarUsuariosTransportadoras();

    /**
     * Consulta la lista de todos los transportes registrados.
     *
     * @return lista de transportes registrados
     */
    public List<Transporte> consultarTransportes();

}
