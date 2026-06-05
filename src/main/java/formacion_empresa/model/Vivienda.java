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
     * Returns the house's code
     * @return The house's code
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Changes the house's code
     * @param codigo The new house's code
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Returns the ID of the house owner
     * @return The ID of the house owner
     */
    public int getId_propietario() {
        return id_propietario;
    }

    /**
     * Changes the house owner's ID
     * @param id_propietario The ID of the new house owner
     */
    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    /**
     * Returns the house's address
     * @return The house's address
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Changes the house's address
     * @param direccion The new house's address
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Returns the monthly rent price
     * @return The monthly rent price
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Changes the monthly rent price
     * @param precio The new monthly rent price
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Returns the house's area
     * @return The house's area
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * Changes the house's area
     * @param superficie The new house's area
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    /**
     * Returns the house's description
     * @return The house's description
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Changes the house's description
     * @param descripcion The new house's description
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Returns the house's type (flat, attic or house)
     * @return The house's type
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Changes the house's type (flat, attic or house)
     * @param tipo The new house's type
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Returns if the house accepts tenants with pets or not
     * @return true if it accepts, false otherwise
     */
    public boolean isAcepta_mascota() {
        return acepta_mascota;
    }

    /**
     * Sets if the house accepts pets or not
     * @param acepta_mascota A boolean value
     */
    public void setAcepta_mascota(boolean acepta_mascota) {
        this.acepta_mascota = acepta_mascota;
    }
    
}
