/********************************/
/*  Formación Empresa           */
/*  Clase Vivienda              */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.model;

public class Vivienda {

    // Definición de atributos
    private String codigo;
    private int id_propietario;
    private String direccion;
    private double precio;
    private int superficie;
    private String descripcion;
    private String tipo;
    private boolean acepta_mascota;

    // Constructor
    public Vivienda(String codigo, int id_propietario, String direccion, double precio, int superficie, String descripcion, String tipo, boolean acepta_mascota) {
        this.codigo = codigo;
        this.id_propietario = id_propietario;
        this.direccion = direccion;
        this.precio = precio;
        this.superficie = superficie;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.acepta_mascota = acepta_mascota;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAcepta_mascota() {
        return acepta_mascota;
    }

    public void setAcepta_mascota(boolean acepta_mascota) {
        this.acepta_mascota = acepta_mascota;
    }
    
}
