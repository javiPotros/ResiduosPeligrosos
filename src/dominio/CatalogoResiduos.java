package dominio;

import java.util.ArrayList;
import java.util.List;

public class CatalogoResiduos {

    List<Residuo> catalogo;

    public CatalogoResiduos() {
        catalogo = new ArrayList<>();
    }

    public List<Residuo> consultar() {
        return catalogo;
    }

    public void agregar(Residuo residuo) {
        catalogo.add(residuo);
    }

    public void actualizar(Residuo residuo) {

    }

    public void eliminar(Residuo residuo) {
        catalogo.remove(residuo);
    }

}
