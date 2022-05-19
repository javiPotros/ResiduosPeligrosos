package negocios;

import dominio.Quimico;
import dominio.Residuo;
import dominio.Transporte;
import dominio.Traslado;
import dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.iNegocios;
import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase de fachada para controles de entidades.
 */
public class FNegocios implements iNegocios {

    ctrlQuimicos cQuimicos;
    ctrlResiduos cResiduos;
    ctrlTraslados cTraslados;
    ctrlUsuarios cUsuarios;
    ctrlTransportes cTransportes;

    /**
     * Constructor de la clase que recibe la conexión a la base de datos.
     *
     * @param conexionBD conexión a la base de datos
     */
    public FNegocios(IConexionBD conexionBD) {
        cResiduos = new ctrlResiduos(conexionBD);
        cQuimicos = new ctrlQuimicos(conexionBD);
        cTraslados = new ctrlTraslados(conexionBD);
        cUsuarios = new ctrlUsuarios(conexionBD);
        cTransportes = new ctrlTransportes(conexionBD);
    }

    /**
     * Registra un quimico en la base de datos del sistema.
     *
     * @param quimico quimico a registrar
     */
    @Override
    public void agregarQuimico(Quimico quimico) {
        cQuimicos.agregarQuimico(quimico);
    }

    /**
     * Consulta un quimico por su id.
     *
     * @param id id del quimico a consultar
     * @return quimico que coincida con el id dado en el parámetro
     */
    @Override
    public Quimico consultarQuimico(ObjectId id) {
        return cQuimicos.consultar(id);
    }

    /**
     * Consulta la lista de todos los quimicos registrados.
     *
     * @return lista de quimicos registrados
     */
    @Override
    public List<Quimico> consultarQuimicos() {
        return cQuimicos.consultarTodos();
    }

    /**
     * agrega un residuo a la base de datos.
     *
     * @param residuo residuo a registrar
     */
    @Override
    public void agregarResiduo(Residuo residuo) {
        cResiduos.agregar(residuo);
    }

    /**
     * Consulta un residuo por su id.
     *
     * @param id id del residuo a consultar
     * @return residuo que coincida con el id dado en el parámetro
     */
    @Override
    public Residuo consultarResiduo(ObjectId id) {
        return cResiduos.consultar(id);
    }

    /**
     * Consulta la lista de todos los residuos registrados.
     *
     * @return lista de quimicos registrados
     */
    @Override
    public List<Residuo> consultarResiduos() {
        return cResiduos.consultarTodos();
    }

    /**
     * Consulta la lista de todos los residuos que coincidan con el id de un
     * productor.
     *
     * @param idProductora id del productor con el cual se hará el filtro de
     * consulta
     * @return lista de todos los residuos que coincidentes
     */
    @Override
    public List<Residuo> consultarResiduosPorProductor(ObjectId idProductora) {
        return cResiduos.consultarPorProductor(idProductora);
    }

    /**
     * agrega un traslado a la base de datos.
     *
     * @param traslado traslado a registrar
     */
    @Override
    public void agregarTraslado(Traslado traslado) {
        cTraslados.agregar(traslado);
    }

    /**
     * Actualiza un traslado previamente registrado.
     *
     * @param traslado traslado a actualizar
     */
    @Override
    public void actualizarTraslado(Traslado traslado) {
        cTraslados.actualizar(traslado);
    }

    /**
     * Consulta un traslado por su id.
     *
     * @param id id del traslado a consultar
     * @return traslado que coincida con el id dado en el parámetro
     */
    @Override
    public Traslado consultarTraslado(ObjectId id) {
        return cTraslados.consultar(id);
    }

    @Override
    public boolean consultarExistenciaTraslado(Traslado traslado) {
        return cTraslados.consultarExistencia(traslado);
    }

    /**
     * Consulta la lista de todos los traslados registrados.
     *
     * @return lista de traslados registrados
     */
    @Override
    public List<Traslado> consultarTraslados() {
        return cTraslados.consultarTodos();
    }

    /**
     * Consulta la lista de todos los traslados registrados por fecha.
     *
     * @return lista de traslados registrados
     */
    @Override
    public List<Traslado> consultarTrasladosPorFecha(LocalDate fecha) {
        return cTraslados.consultarTodosPorFecha(fecha);
    }

    /**
     * Consulta la lista de todos los traslados que se encuentren en estado de
     * 'pendiente'.
     *
     * @return lista de todos los traslados pendientes
     */
    @Override
    public List<Traslado> consultarTrasladosPendientes() {
        return cTraslados.consultarPendientes();
    }

    /**
     * Consulta la lista de todos los traslados asignados que correspondan a una
     * transportadora.
     *
     * @param idTransportadora id de la transportadora con la cual se hará el
     * filtro
     * @return lista de traslados asignados de transportadora
     */
    @Override
    public List<Traslado> consultarTrasladosAsignados(ObjectId idTransportadora) {
        return cTraslados.consultarAsignados(idTransportadora);
    }

    /**
     * Elimina el traslado dado por el parámetro.
     *
     * @param id id del traslado a eliminar.
     */
    @Override
    public void eliminarTraslado(ObjectId id) {
        cTraslados.eliminar(id);
    }

    /**
     * Consulta un usuario por su id.
     *
     * @param id id del usuario a consultar
     * @return usuario que coincida con el id dado en el parámetro
     */
    @Override
    public Usuario consultarUsuario(ObjectId id) {
        return cUsuarios.consultar(id);
    }

    /**
     * Consulta un usuario por su nombre de usuario y contraseña.
     *
     * @param usuario nombre de usuario de la empresa
     * @param contrasena contraseña del usuario
     * @return el usuario que coincida con las credenciales dadas
     */
    @Override
    public Usuario consultarUsuario(String usuario, String contrasena) {
        return cUsuarios.consultar(usuario, contrasena);
    }

    /**
     * Consulta la lista de todos los usuarios registrados.
     *
     * @return lista de usuarios registrados
     */
    @Override
    public List<Usuario> consultarUsuarios() {
        return cUsuarios.consultarTodos();
    }

    /**
     * Consulta la lista de todos los usuarios registrados que entren en la
     * categoría de 'transportadora'.
     *
     * @return lista de transportadoras
     */
    @Override
    public List<Usuario> consultarUsuariosTransportadoras() {
        return cUsuarios.consultarTransportadoras();
    }

    /**
     * Consulta la lista de todos los transportes registrados.
     *
     * @return lista de transportes registrados
     */
    @Override
    public List<Transporte> consultarTransportes() {
        return cTransportes.consultarTodos();
    }
}
