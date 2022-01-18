package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alekz
 */
public class Departamento {

    private String ID;
    private int piso;
    private String password = "secret1234";
    private int capacidad;
    private ArrayList<Propietario> propietarios = new ArrayList();
    private ArrayList<Propietario> presentes = new ArrayList();
    private String tipo;
    private int aux = 0;

    public void anadirPropietarios(Propietario propietario) {
        this.propietarios.add(propietario);
    }

    private String generaId() {
        Date currentDate = new Date();

        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String dateTime = ft.format(currentDate);

        return dateTime;
    }

    public Departamento(int piso, int capacidad, String tipo) {
        this.piso = piso;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.ID = generaId() + String.valueOf(this.aux++);
    }

    public void setPropietario(Propietario propietario, int i) {
        propietarios.set(i, propietario);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<Propietario> getPresentes() {
        return presentes;
    }

    public void entrar(Propietario propietario) {
        presentes.add(propietario);
    }

    public String presentesDetail() {
        String info = "";

        if (!propietarios.isEmpty()) {
            for (int i = 0; i < propietarios.size(); i++) {
                info += "\n\t" + propietarios.get(i).nombresCompletos();
            }
        } else {
            info += "No hay nadie en el departamento";
        }

        return info;
    }

    public String departamentoDetail() {
        String info = "";
        info += "\tDEPARTAMENTO " + this.ID;
        info += "\nPiso: " + this.piso;
        info += "\nCapacidad:" + this.capacidad;
        info += "\nTipo: " + this.tipo;
        info += "\nPropietarios:";
        if (propietarios.isEmpty()) {
            info += "\n\tNo hay propietarios";
        } else {
            for (int i = 0; i < propietarios.size(); i++) {
                info += "\n\t" + propietarios.get(i).nombresCompletos();
            }
        }

        return info;
    }
}
