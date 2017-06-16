package clases;

public class Producto {

    private String idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String fechaElaboracion;
    private int valorProducto;

    public Producto(String idProducto, String nombreProducto, String descripcionProducto, String fechaElaboracion, int valorProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.fechaElaboracion = fechaElaboracion;
        this.valorProducto = valorProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public String getFechaElaboracion() {
        return fechaElaboracion;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void setFechaElaboracion(String fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }
    
    
}

