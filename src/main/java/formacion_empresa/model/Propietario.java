/********************************/
/*  Formación Empresa           */
/*  Clase Propietario           */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.model;

/**
 * @author Markel Canales Ramos
 */
public class Propietario {
    
    // Definición de atributos
    private int id;
    private String DNI;
    private String nombre;
    private String email;
    private String telefono;

    // Constructor
    public Propietario(int id, String DNI, String nombre, String email, String telefono) {
        this.id = id;
        this.DNI = DNI;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y setters

    /**
     * Returns the landlord's ID
     * @return The landlord's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Changes the value of the landlord's ID
     * @param id The new landlord's ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the landlord's DNI
     * @return The landlord's DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Changes the value of the landlord's DNI
     * @param DNI The new landlord's DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Returns the landlord's name
     * @return The landlord's name
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Changes the name of the landlord
     * @param nombre The new landlord's name
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Returns the landlord's email
     * @return The landlord's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Changes the value of the landlord's email
     * @param email The new landlord's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the telephone number of the landlord
     * @return The landlord's telephone number
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Changes the value of the landlord's telephone number
     * @param telefono The new landlord's telephone number
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
