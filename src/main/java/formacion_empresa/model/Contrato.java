/********************************/
/*  Formación Empresa           */
/*  Clase Contrato              */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.model;

public class Contrato {
    
    // Definición de atributos
    private int id;
    private int id_inquilino;
    private String codigo_vivienda;
    private String fecha_inicio;
    private String fecha_fin;
    private double precio;
    private String estado;

    // Constructor
    public Contrato(int id, int id_inquilino, String codigo_vivienda, String fecha_inicio, String fecha_fin, double precio, String estado) {
        this.id = id;
        this.id_inquilino = id_inquilino;
        this.codigo_vivienda = codigo_vivienda;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.precio = precio;
        this.estado = estado;
    }
    
    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_inquilino() {
        return id_inquilino;
    }

    public void setId_inquilino(int id_inquilino) {
        this.id_inquilino = id_inquilino;
    }

    public String getCodigo_vivienda() {
        return codigo_vivienda;
    }

    public void setCodigo_vivienda(String codigo_vivienda) {
        this.codigo_vivienda = codigo_vivienda;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
