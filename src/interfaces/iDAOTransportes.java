package interfaces;

import dominio.Transporte;
import java.util.List;

/**
 * Clase de acceso a datos con respecto a los transportes.
 */
public interface iDAOTransportes {
    
    /**
     * Consulta todos los transportes.
     * @return Lista con todos los transportes.
     */
    public List<Transporte> consultarTodos();
}
