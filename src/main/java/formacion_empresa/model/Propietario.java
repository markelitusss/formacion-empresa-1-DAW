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
     * Devuelve el ID del propietario
     * @return El ID del propietario
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el valor del ID del propietario
     * @param id El nuevo ID del propietario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el DNI del propietario
     * @return El DNI del propietario
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Cambia el valor del DNI del propietario
     * @param DNI El nuevo DNI del propietario
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Devuelve el nombre del propietario
     * @return El nombre del propietario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el valor del nombre del propietario
     * @param nombre El nuevo nombre del propietario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el email del propietario
     * @return El email del propietario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Cambia el valor del email del propietario
     * @param email El nuevo email del propietario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el nº de telefono del propietario
     * @return El telefono del propietario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Cambia el valor del nº de telefono del propietario
     * @param telefono El nuevo nº de telefono del propietario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
