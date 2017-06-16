package beans;

import clases.Producto;
import java.util.ArrayList;
import javax.ejb.Stateful;

@Stateful(mappedName = "bean")
public class BeanProductos implements BeanProductosLocal {

    ArrayList<Producto> listaProductos;

    public BeanProductos() {
        listaProductos = new ArrayList<Producto>();
    }

    @Override
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    @Override
    public void eliminarProducto(String idProducto) {
        idProducto = idProducto.trim();
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto item = listaProductos.get(i);
            if (item.getIdProducto().equals(idProducto)) {
                listaProductos.remove(i);
            }
        }
    }

    @Override
    public ArrayList getListaProductos() {
        return listaProductos;
    }
}
