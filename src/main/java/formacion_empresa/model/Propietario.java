/********************************/
/*  Formación Empresa           */
/*  Clase Propietario           */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.model;

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
