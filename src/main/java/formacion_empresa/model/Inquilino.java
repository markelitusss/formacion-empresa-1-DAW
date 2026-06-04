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
     * Devuelve el ID del inquilino
     * @return El ID del inquilino
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el valor del ID del inquilino
     * @param id El nuevo ID del inquilino
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el DNI del inquilino
     * @return El DNI del inquilino
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Cambia el valor del DNI del inquilino
     * @param DNI El nuevo DNI del inquilino
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Devuelve el nombre del inquilino
     * @return El nombre del inquilino
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el valor del nombre del inquilino
     * @param nombre El nuevo nombre del inquilino
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el email del inquilino
     * @return El email del inquilino
     */
    public String getEmail() {
        return email;
    }

    /**
     * Cambia el valor del email del inquilino
     * @param email El nuevo email del inquilino
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el nº de telefono del inquilino
     * @return El nº de telefono del inquilino
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Cambia el valor del nº de telefono del inquilino
     * @param telefono El nuevo nº de telefono del inquilino
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve si el inquilino tiene mascota o no
     * @return true si tiene mascota o false si no tiene
     */
    public boolean getMascota() {
        return mascota;
    }

    /**
     * Define si el inquilino tiene mascota o no
     * @param mascota Valor booleano (tiene/no tiene mascota)
     */
    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

}
