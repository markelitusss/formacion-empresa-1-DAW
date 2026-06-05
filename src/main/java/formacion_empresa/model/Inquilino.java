/********************************/
/*  Formación Empresa           */
/*  Clase Inquilino             */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.model;

/**
 * @author Markel Canales Ramos
 */
public class Inquilino {
    
    // Definición de atributos
    private int id;
    private String DNI;
    private String nombre;
    private String email;
    private String telefono;
    private boolean mascota;

    // Constructor
    public Inquilino(int id, String DNI, String nombre, String email, String telefono, boolean mascota) {
        this.id = id;
        this.DNI = DNI;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.mascota = mascota;
    }

    // Getters y setters

    /**
     * Returns the tenant's ID
     * @return The tenant's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Changes the tenant's ID value
     * @param id The new tenant's ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the tenant's DNI
     * @return The tenant's DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Changes the tenant's DNI value
     * @param DNI The new tenant's DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Returns the name of the tenant
     * @return The tenant's name
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Changes the tenant's name value
     * @param nombre The new tenant's name
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Returns the tenant's email
     * @return The tenant's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Changes the value of the tenant's email
     * @param email The new tenant's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the tenant's telephone number
     * @return The tenant's telephone number
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Changes the value of the tenant's telephone number
     * @param telefono The new tenant's telephone number
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Returns if the tenant has pets or not
     * @return true if the tenant has pets, false on the contrary case
     */
    public boolean getMascota() {
        return mascota;
    }

    /**
     * Sets if the tenant has pets or not
     * @param mascota Boolean value (true/false)
     */
    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

}
