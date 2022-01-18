
package modelo;

/**
 *
 * @author alekz
 */
public class Propietario extends Persona implements Interface {
    private String username;
    private String password;
    private String departamentoID;

    public void setDepartamentoID(String departamentoID) {
        this.departamentoID = departamentoID;
    }

    public String getDepartamentoID() {
        return departamentoID;
    }
    
    public Propietario(String nombres, String apellidos, String cedula) {
        super(nombres, apellidos, cedula);
        //por default sera el primer nombre
        this.username = username = nombres.split(" ")[0]; 
        //por default sera la cedula
        this.password = cedula; 
    }

    public String getUsername() {
        return username;
    }
    
    @Override
    public boolean verificarUserPassword(String username, String password) {
        return username.equals(this.username) && (password.equals(this.password));
    }
}
