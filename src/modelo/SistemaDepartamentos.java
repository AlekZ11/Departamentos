package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alekz
 */
public class SistemaDepartamentos {

    static Administrador admin = new Administrador("Viviana Isabel", "Calva Tuza", "1234567890");

    static ArrayList<Propietario> propietarios = new ArrayList();
    static ArrayList<Departamento> departamentos = new ArrayList();

    public static void main(String[] args) {
        String username = "", password = "";
        int menu, submenu;

        while (true) {
            menu = Menu();
            if (menu == 3) {
                break;
            }

            if (menu == 1) {
                username = input("\tIngrese su username: ");
                password = input("\tIngrese su contrasenia: ");
                System.out.println("");
                if (admin.verificarUserPassword(username, password)) {
                    while (true) {
                        submenu = menuAdmin();
                        if (submenu == 6) {
                            break;
                        }
                        seleccionSubmenuAdmin(submenu);
                    }
                } else {
                    //System.out.println(username + " " + password);
                    System.out.println("No está autorizadx para este rol");
                }
            } else {
                username = input("Ingrese su username: ");
                password = input("Ingrese su contrasenia: ");
                System.out.println("");

                Propietario currentProp = null;

                for (int i = 0; i < propietarios.size(); i++) {
                    if (propietarios.get(i).getUsername().equals(username)) {
                        currentProp = propietarios.get(i);
                    }
                }

                if (currentProp != null) {
                    if (currentProp.verificarUserPassword(username, password)) {
                        while (true) {
                            submenu = menuProp();
                            if (submenu == 4) {
                                break;
                            }
                            seleccionSubmenuProp(submenu, currentProp);
                        }
                    } else {
                        System.out.println("No está autorizadx para este rol");
                    }
                } else {
                    System.out.println("Ningun usuario coincide con sus credenciales");
                }

            }
        }

    }

    public static int Menu() {
        System.out.println(" ================= Cual es su rol =================");
        System.out.println("\t1. Administrador");
        System.out.println("\t2. Propietario");
        System.out.println("\t3. Salir");
        System.out.print("Opcion: ");

        return Integer.parseInt(leerDatos());
    }

    public static int menuAdmin() {
        System.out.println(" ================= Que desea hacer =================");
        System.out.println("\t1. Cambiar contrasenia");
        System.out.println("\t2. Cambiar username ");
        System.out.println("\t3. Crear nuevo departamento");
        System.out.println("\t4. Ver informacion de departamento");
        System.out.println("\t5. Asignar propietario a departamento");
        System.out.println("\t6. Volver");
        System.out.print("Opcion: ");
        
        return Integer.parseInt(leerDatos());
    }

    public static int menuProp() {
        System.out.println(" ================= Que desea hacer =================");
        System.out.println("\t1. Ingresar al departamento");
        System.out.println("\t2. Ver quiene estan en el departamento");
        System.out.println("\t3. Ver informacion del departamento");
        System.out.println("\t4. Volver");
        System.out.print("Opcion: ");

        return Integer.parseInt(leerDatos());
    }

    public static String leerDatos() {
        Scanner e = new Scanner(System.in);

        return e.nextLine();
    }

    public static String input(String text) {
        System.out.print(text);
        return leerDatos();
    }

    public static void seleccionSubmenuAdmin(int submenu) {
        String password, username;
        int index;

        switch (submenu) {
            case 1:
                System.out.print("Nueva contrasenia: ");
                password = leerDatos();
                if (admin.cambiarContrasenia(password)) {
                    System.out.println("Se ha cambiado la contrasena");
                } else {
                    System.out.println("Ha ocurrido un error");
                }
                break;
            case 2:
                System.out.print("Nuevo username: ");
                username = leerDatos();
                if (admin.cambiarUsername(username)) {
                    System.out.println("Se ha cambiado el username");
                } else {
                    System.out.println("Ha ocurrido un error");
                }
                break;
            case 3:
                crearDepartamento();
                break;
            case 4:
                if (!departamentos.isEmpty()) {
                    System.out.println("\nINFORMACION DE LOS DEPARTAMENTOS:");
                    System.out.println("De que departamento desea ver su informacion?");
                    mostrarDepartamentos();
                    System.out.print("Opcion: ");
                    index = Integer.parseInt(leerDatos());
                    System.out.println(departamentos.get(index).departamentoDetail());;
                } else {
                    System.out.println("Aun no hay departamentos por mostrar");
                }
                break;
            case 5:
                System.out.println("PRIMERO CREAREMOS AL PROPIETARIO");
                crearPropietario();
                System.out.println("QUE DEPARTAMENTO LE DESEA ASIGNAR?");
                mostrarDepartamentos();
                System.out.print("Opcion: ");
                index = Integer.parseInt(leerDatos());
                departamentos.get(index).anadirPropietarios(propietarios.get(propietarios.size() - 1));
                propietarios.get(propietarios.size() - 1).setDepartamentoID(departamentos.get(index).getID());
                break;
        }
    }

    public static void seleccionSubmenuProp(int submenu, Propietario prop) {
        Departamento departamento;
        departamento = getDepartamentoByID(prop.getDepartamentoID());

        if (departamento != null) {
            switch (submenu) {
                case 1:
                    departamento.entrar(prop);

                    break;
                case 2:
                    System.out.println(departamento.presentesDetail());
                    break;
                case 3:
                    System.out.println(departamento.departamentoDetail());
                    ;
                    break;
            }
        } else {
            System.out.println("Ooops! Parece que no tiene un departamento");
        }

    }

    public static Departamento getDepartamentoByID(String ID) {
        Departamento current = null;

        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i).getID().equals(ID)) {
                current = departamentos.get(i);
            }
        }

        return current;
    }

    public static void crearDepartamento() {
        String tipo;
        int capacidad, piso;

        System.out.print("Piso:");
        piso = Integer.parseInt(leerDatos());
        System.out.print("Capacidad:");
        capacidad = Integer.parseInt(leerDatos());
        System.out.print("Tipo:");
        tipo = leerDatos();

        departamentos.add(new Departamento(piso, capacidad, tipo));
    }

    public static void crearPropietario() {
        String nombres, apellidos, cedula;

        System.out.print("Nombres:");
        nombres = leerDatos();
        System.out.print("Apellidos:");
        apellidos = leerDatos();
        System.out.print("Cedula:");
        cedula = leerDatos();

        propietarios.add(new Propietario(nombres, apellidos, cedula));
    }

    public static void mostrarDepartamentos() {
        System.out.println("");
        for (int i = 0; i < departamentos.size(); i++) {
            System.out.println(i + "._ " + departamentos.get(i).getID());
        }
    }
}
