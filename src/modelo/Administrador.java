/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alekz
 */
public class Administrador implements Interface{
    private String user;
    private int password;

    public Administrador(String user, int password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public int verificarUserPassword (String user, int password) {
        if(user.equals(this.user) && (password == this.password)){
            return 1;
        }
        return 0;
    }
}
