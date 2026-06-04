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
     * Devuelve el ID del contrato
     * @return El ID del contrato
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el valor del ID del contrato
     * @param id El nuevo valor del ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el valor del ID del inquilino implicado en el contrato
     * @return El valor del ID del inquilino
     */
    public int getId_inquilino() {
        return id_inquilino;
    }

    /**
     * Cambia el valor del ID del inquilino
     * @param id_inquilino El nuevo ID del inquilino
     */
    public void setId_inquilino(int id_inquilino) {
        this.id_inquilino = id_inquilino;
    }

    /**
     * Devuelve el valor del código de la vivienda
     * @return El código de la vivienda
     */
    public String getCodigo_vivienda() {
        return codigo_vivienda;
    }

    /**
     * Cambia el codigo de la vivienda por un nuevo valor
     * @param codigo_vivienda El nuevo código de la vivienda
     */
    public void setCodigo_vivienda(String codigo_vivienda) {
        this.codigo_vivienda = codigo_vivienda;
    }

    /**
     * Devuelve la fecha de inicio del contrato
     * @return La fecha de inicio del contrato
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * Cambia la fecha de inicio del contrato por otra nueva
     * @param fecha_inicio La nueva fecha de inicio del contrato
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * Devuelve la fecha de fin del contrato
     * @return La fecha de fin del contrato
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * Cambia la fecha de fin del contrato por otra nueva
     * @param fecha_fin La nueva fecha de fin del contrato
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * Devuelve el precio mensual del alquiler establecido en el contrato
     * @return El precio mensual del alquiler
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Cambia el precio del alquiler por otro nuevo
     * @param precio El nuevo precio del alquiler en el contrato
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el estado actual del contrato (pendiente, activo o vencido)
     * @return El estado actual del contrato
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Modifica el estado del contrato entre las opciones de pendiente, activo o vencido
     * @param estado El nuevo estado del contrato
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
