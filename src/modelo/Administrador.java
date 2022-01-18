package modelo;

/**
 *
 * @author alekz y codaya007 xd
 */
public class Administrador extends Persona implements Interface {

    private String username = "admin123";
    //debe tener de 6 a 10 caracteres
    private String password;

    public Administrador(String nombres, String apellidos, String cedula) {
        super(nombres, apellidos, cedula);
        this.password = cedula;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean verificarUserPassword(String username, String password) {
        return username.equals(this.username) && (password.equals(this.password));
    }

    public boolean cambiarContrasenia(String nuevaContrasenia) {
        if (nuevaContrasenia.length() >= 6 && nuevaContrasenia.length() <= 10) {
            this.password = nuevaContrasenia;
            return true;
        }

        return false;
    }
    
    public boolean cambiarUsername(String nuevoUsername) {
        if (nuevoUsername.length() >= 4 && nuevoUsername.length() <= 8) {
            this.password = nuevoUsername;
            return true;
        }

        return false;
    }
}
