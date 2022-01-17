/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alekz
 */
public class Propietario extends Persona implements Interface {
    private String user;
    private int password;

    public Propietario(String user, int password, String nombres, int cedula) {
        super(nombres, cedula);
        this.user = user;
        this.password = password;
    }
    
    @Override
    public int verificarUserPassword (String user, int password) {
        if(user.equals(this.user) && (password == this.password)){
            return 2;
        }
        return 0;
    }
}
