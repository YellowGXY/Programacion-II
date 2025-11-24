package udla.mp.prac.modelo.personal;

import udla.mp.prac.modelo.paciente.Paciente;
import udla.mp.prac.enums.Turno;

public class Enfermero extends Persona {
    private Turno turno;
    private String areaAsignada;

    public Enfermero(String nombre, String identificacion, int edad, String telefono,
                     Turno turno, String areaAsignada) {
        super(nombre, identificacion, edad, telefono);
        this.turno = turno;
        this.areaAsignada = areaAsignada;
    }

    public String administrarMedicamento(Paciente paciente, String medicamento) {
        return "Enfermero(a) " + nombre + " administró " + medicamento + " a " + paciente.getNombre();
    }

    public String tomarSignosVitales(Paciente paciente, String signosVitales) {
        String registro = "Signos vitales de " + paciente.getNombre() + ": " + signosVitales;
        paciente.agregarConsulta(registro);
        return registro;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }

    @Override
    public String toString() {
        return "Enfermero(a) " + nombre + " - Turno: " + turno + ", Área: " + areaAsignada;
    }
}
