package modelo.personal;

import modelo.paciente.Paciente;
import modelo.cita.CitaMedica;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona {
    protected String especialidad;
    protected double costoConsultaBase;
    protected List<CitaMedica> citasAsignadas;

    public Medico(String nombre, String identificacion, int edad, String telefono,
                  String especialidad, double costoConsultaBase) {
        super(nombre, identificacion, edad, telefono);
        this.especialidad = especialidad;
        this.costoConsultaBase = costoConsultaBase;
        this.citasAsignadas = new ArrayList<>();
    }

    public String diagnosticar(Paciente paciente, String diagnostico) {
        String resultado = "Diagnóstico para " + paciente.getNombre() + ": " + diagnostico;
        paciente.agregarConsulta(resultado);
        return resultado;
    }

    public String prescribirMedicamento(Paciente paciente, String medicamento) {
        String prescripcion = "Prescripción: " + medicamento + " para " + paciente.getNombre();
        paciente.agregarConsulta(prescripcion);
        return prescripcion;
    }

    public void agregarCita(CitaMedica cita) {
        citasAsignadas.add(cita);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getCostoConsultaBase() {
        return costoConsultaBase;
    }

    public void setCostoConsultaBase(double costoConsultaBase) {
        this.costoConsultaBase = costoConsultaBase;
    }

    public List<CitaMedica> getCitasAsignadas() {
        return citasAsignadas;
    }

    @Override
    public String toString() {
        return "Dr(a). " + nombre + " - Especialidad: " + especialidad;
    }
}
