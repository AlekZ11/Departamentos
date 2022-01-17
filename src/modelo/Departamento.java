/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author alekz
 */
public class Departamento {
    private int id;
    private int numeroPiso;
    private int password;
    private int capacidad;
    ArrayList <Propietario> propietarios = new ArrayList();
    private String tipo;

    public Departamento(int numeroPiso, int password, int capacidad, String tipo, int id) {
        this.numeroPiso = numeroPiso;
        this.password = password;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.id = id;
    }

    public void setPropietario(Propietario propietario, int i) {
        propietarios.set(i, propietario);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPassword() {
        return password;
    }
    
    public void getInformacion(){
        System.out.println("\tId: " + id + "\n\tPiso: " + numeroPiso + "\n\tCapacidad: " + capacidad);
    }
}
