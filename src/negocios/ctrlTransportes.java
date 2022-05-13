package negocios;

import datos.DAOTransportes;
import dominio.Transporte;
import interfaces.IConexionBD;
import interfaces.iDAOTransportes;
import java.util.List;

public class ctrlTransportes {
    
    iDAOTransportes daoTransportes;

    public ctrlTransportes(IConexionBD conexionBD) {
        this.daoTransportes = new DAOTransportes(conexionBD);
    }
    
    public List<Transporte> consultarTodos() {
        return daoTransportes.consultarTodos();
    }
}
