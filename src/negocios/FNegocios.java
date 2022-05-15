package negocios;

import dominio.Quimico;
import dominio.Residuo;
import dominio.Transporte;
import dominio.Traslado;
import dominio.Usuario;
import interfaces.IConexionBD;
import interfaces.iNegocios;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public class FNegocios implements iNegocios {

    ctrlQuimicos cQuimicos;
    ctrlResiduos cResiduos;
    ctrlTraslados cTraslados;
    ctrlUsuarios cUsuarios;
    ctrlTransportes cTransportes;

    public FNegocios(IConexionBD conexionBD) {
        cResiduos = new ctrlResiduos(conexionBD);
        cQuimicos = new ctrlQuimicos(conexionBD);
        cTraslados = new ctrlTraslados(conexionBD);
        cUsuarios = new ctrlUsuarios(conexionBD);
        cTransportes = new ctrlTransportes(conexionBD);
    }

    @Override
    public void agregarQuimico(Quimico quimico) {
        cQuimicos.agregarQuimico(quimico);
    }

    @Override
    public Quimico consultarQuimico(ObjectId id) {
        return cQuimicos.consultar(id);
    }

    @Override
    public List<Quimico> consultarQuimicos() {
        return cQuimicos.consultarTodos();
    }

    @Override
    public void agregarResiduo(Residuo residuo) {
        cResiduos.agregar(residuo);
    }

    @Override
    public Residuo consultarResiduo(ObjectId id) {
        return cResiduos.consultar(id);
    }

    @Override
    public List<Residuo> consultarResiduos() {
        return cResiduos.consultarTodos();
    }

    @Override
    public List<Residuo> consultarResiduosPorProductor(ObjectId idProductora) {
        return cResiduos.consultarPorProductor(idProductora);
    }

    @Override
    public void agregarTraslado(Traslado traslado) {
        cTraslados.agregar(traslado);
    }

    @Override
    public void actualizarTraslado(Traslado traslado) {
        cTraslados.actualizar(traslado);
    }

    @Override
    public Traslado consultarTraslado(ObjectId id) {
        return cTraslados.consultar(id);
    }

    @Override
    public List<Traslado> consultarTraslados() {
        return cTraslados.consultarTodos();
    }

    @Override
    public List<Traslado> consultarTrasladosPendientes() {
        return cTraslados.consultarPendientes();
    }

    @Override
    public List<Traslado> consultarTrasladosAsignados(ObjectId idTransportadora) {
        return cTraslados.consultarAsignados(idTransportadora);
    }
    
    @Override
    public void eliminarTraslado(ObjectId id){
        cTraslados.eliminar(id);
    }
    
    @Override
    public Usuario consultarUsuario(ObjectId id) {
        return cUsuarios.consultar(id);
    }

    @Override
    public Usuario consultarUsuario(String usuario, String contrasena) {
        return cUsuarios.consultar(usuario, contrasena);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        return cUsuarios.consultarTodos();
    }

    @Override
    public List<Usuario> consultarUsuariosTransportadoras() {
        return cUsuarios.consultarTransportadoras();
    }

    @Override
    public List<Transporte> consultarTransportes() {
        return cTransportes.consultarTodos();
    }
}
