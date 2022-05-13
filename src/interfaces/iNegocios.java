package interfaces;

import dominio.Quimico;
import dominio.Residuo;
import dominio.Transporte;
import dominio.Traslado;
import dominio.Usuario;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 1 - Residuos Peligrsosos. Id's: 215058, 228359, 229333
 */
public interface iNegocios {

    public void agregarQuimico(Quimico quimico);

    public Quimico consultarQuimico(ObjectId id);

    public List<Quimico> consultarQuimicos();

    public void agregarResiduo(Residuo residuo);
    
    public Residuo consultarResiduo(ObjectId id);
    
    public List<Residuo> consultarResiduos();

    public List<Residuo> consultarResiduosPorProductor(String productor);

    public void agregarTraslado(Traslado traslado);

    public void actualizarTraslado(Document traslado, String campo, Object valor);

    public void actualizarTrasladoPendiente(Document traslado, String residuo);

    public List<Traslado> consultarTraslados();
    
    public Traslado consultarTraslado(ObjectId id);

    public List<Traslado> consultarTrasladosPendientes();

    public Usuario consultarUsuario(ObjectId id);

    public Usuario consultarUsuario(String usuario, String contrasena);

    public List<Usuario> consultarUsuarios();
    
    public List<Transporte> consultarTransportes();

}
