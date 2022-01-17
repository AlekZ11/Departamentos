/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alekz
 */
public class SistemaDepartamentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador("admin",12345);
        ArrayList <Propietario> propietarios = new ArrayList();
        ArrayList <Departamento> departamentos = new ArrayList();
        int password = 0;
        String user; 
        int opcion = 0;
        char c = 's';
        do{
        do{
            System.out.print("Ingrese su usuario:  ");
            user = sc.nextLine();
            System.out.print("Ingrese su contrasena:  ");
            try {
                password = sc.nextInt();
            } catch (Exception e) {
                System.out.println("La contrasena ingresada debe ser numeros");
                sc.nextLine();
            }
            opcion = admin.verificarUserPassword(user, password);
            if (opcion != 1){
                for (Propietario p : propietarios) {
                    opcion = p.verificarUserPassword(user, password);
                    if(opcion == 2){
                        break;
                    }
                }
            }
        }while(password == 0 && opcion == 0);
        switch (opcion) {
            case 1:
                int opcion2 = 0; 
                do {
                    System.out.println("  ===  Menu de Opciones Administrador  ===");
                    System.out.print("\t1.Crear Departamento\n\t2.Crear y asignar Propietarios\n\t3.Salir\nOpcion:  ");
                    opcion2 = sc.nextInt();
                    switch (opcion2) {
                        case 1:
                            System.out.println("Ingrese los siguientes datos del departamento");
                            System.out.print("Numero de Piso:  ");
                            int piso = sc.nextInt();
                            System.out.print("Contrasena para Propietarios(Numeros):  ");
                            int password2 = sc.nextInt();
                            System.out.print("Capacidad:  ");
                            int capacidad = sc.nextInt();
                            System.out.print("Id:  ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Tipo:  ");
                            String tipo = sc.nextLine();
                            departamentos.add(new Departamento(piso,password2,capacidad,tipo,id));
                            break;
                        case 2:
                            System.out.println("Departamentos Disponibles");
                            int i = 0;
                            for (Departamento d : departamentos) {
                                System.out.println(" --- Departamento " + i + " ---");
                                d.getInformacion();
                            }
                            System.out.print("Ingrese el numero del departamento: ");
                            int opcion3 = sc.nextInt();
                            int aux = 1;
                            do{
                                System.out.print("Ingrese la cantidad de propietarios a asignar al departamento: ");
                                aux = sc.nextInt();
                            }while(aux > departamentos.get(opcion3).getCapacidad());
                            sc.nextLine();
                            for (int j = 0; j < aux; j++) {  
                                System.out.println("Ingrese los siguientes datos del Propietario");
                                System.out.print("Nombres:  ");
                                String nombres = sc.nextLine();
                                System.out.print("Cedula:  ");
                                int cedula = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Usuario:  ");
                                String usuario = sc.nextLine();
                                int password3 = departamentos.get(opcion3).getPassword();
                                propietarios.add(new Propietario(usuario, password3, nombres, cedula));
                                //departamentos.get(opcion3).setPropietario(propietarios.get(j), j); Me sale un error no se cual sera ni como solucionarlo
                            }
                            break;
                        default:
                            break;
                    }
                } while (opcion2 != 3);
                break;
            case 2:
                System.out.println("Contrasena y usuarios correctos. BIENVENIDO");
                break;
            default:
                break;
        }
        System.out.print("Desea salir del programa (S/N):  ");
        c = sc.next().charAt(0);
        sc.nextLine();
        }while(c != 's' || c != 'S');
    }
    
}
