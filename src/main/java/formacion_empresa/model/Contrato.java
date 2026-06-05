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

    /**
     * Returns the contract ID
     * @return The contract ID
     */
    public int getId() {
        return id;
    }

    /**
     * Changes the value of the ID
     * @param id The new ID value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the ID of the tenant
     * @return The value of the tenant's ID
     */
    public int getId_inquilino() {
        return id_inquilino;
    }

    /**
     * Changes the value of the tenant's ID
     * @param id_inquilino The new tenant's ID
     */
    public void setId_inquilino(int id_inquilino) {
        this.id_inquilino = id_inquilino;
    }

    /**
     * Returns the house's code
     * @return The house's code
     */
    public String getCodigo_vivienda() {
        return codigo_vivienda;
    }

    /**
     * Changes the house's code to a new value
     * @param codigo_vivienda The new house's code
     */
    public void setCodigo_vivienda(String codigo_vivienda) {
        this.codigo_vivienda = codigo_vivienda;
    }

    /**
     * Returns the starting date of the contract
     * @return The starting date of the contract
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * Changes de starting date of the contract
     * @param fecha_inicio The new starting date of the contract
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * Returns the ending date of the contract
     * @return The ending date of the contract
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * Changes the ending date of the contract
     * @param fecha_fin The new ending date of the contract
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * Returns the monthly rent price as established in the contract
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
     * Returns the state of the contract (pending, active or expired)
     * @return The state of the contract
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Changes the state of the contract
     * @param estado The new state of the contract
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
