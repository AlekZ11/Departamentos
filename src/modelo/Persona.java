
package modelo;

/**
 *
 * @author alekz
 */
public class Persona {
    private String nombres;    
    private String apellidos;
    private String cedula;

    public Persona(String nombres, String apellidos, String cedula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }    
    
    public String nombresCompletos(){
        return (this.nombres + " " + this.apellidos);
    }
}
