
package beans;

import clases.Producto;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface BeanProductosLocal {

    public void agregarProducto(Producto producto);

    public ArrayList getListaProductos();

    public void eliminarProducto(String idProducto);
    
}
