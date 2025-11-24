package modelo.personal;

import modelo.paciente.Paciente;
import enums.Turno;

public class Enfermero extends Persona {
    protected Turno turno;

    public Enfermero(String nombre, String identificacion, int edad, String telefono, Turno turno) {
        super(nombre, identificacion, edad, telefono);
        this.turno = turno;
    }

    public void administrarMedicamento(Paciente paciente, String medicamento) {
        System.out.println("Enfermero(a) " + nombre + " administró " + medicamento + " a " + paciente.getNombre());
    }

    public void tomarSignosVitales(Paciente paciente) {
        System.out.println("Signos vitales tomados al paciente " + paciente.getNombre());
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Enfermero(a) " + nombre + " - Turno: " + turno;
    }
}
