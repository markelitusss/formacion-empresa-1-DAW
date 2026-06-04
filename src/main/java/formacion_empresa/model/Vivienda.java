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

    /**
     * Devuelve el código de la vivienda
     * @return El código de la vivienda
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Cambia el código de la vivienda por otro nuevo
     * @param codigo El nuevo código de la vivienda
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el ID del propietario de la vivienda
     * @return El ID del propietario
     */
    public int getId_propietario() {
        return id_propietario;
    }

    /**
     * Cambia el ID del propietario por otro
     * @param id_propietario El ID del nuevo propietario
     */
    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    /**
     * Devuelve la dirección de la vivienda
     * @return La dirección de la vivienda
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Cambia la dirección de la vivienda por una nueva
     * @param direccion La nueva dirección de la vivienda
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el precio mensual del alquiler
     * @return El precio del alquiler de la vivienda
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Cambia el precio del alquiler de la vivienda
     * @param precio El nuevo precio del alquiler
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la superficie en metros cuadrados de la vivienda
     * @return La superficie de la vivienda
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * Modifica la superficie de la vivienda
     * @param superficie El nuevo valor de la superficie
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    /**
     * Devuelve la descripción de la vivienda
     * @return La descripción de la vivienda
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripción de la vivienda
     * @param descripcion La nueva descripción de la vivienda
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el tipo de vivienda (apartamento, ático o casa)
     * @return El tipo de vivienda
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo de vivienda por otro entre las opciones de apartamento, ático y casa
     * @param tipo El nuevo tipo de vivienda
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve si la vivienda acepta inquilinos con mascota o no
     * @return true si acepta mascotas, false en caso contrario
     */
    public boolean isAcepta_mascota() {
        return acepta_mascota;
    }

    /**
     * Define si la vivienda acepta mascotas o no
     * @param acepta_mascota Un valor booleano
     */
    public void setAcepta_mascota(boolean acepta_mascota) {
        this.acepta_mascota = acepta_mascota;
    }
    
}
