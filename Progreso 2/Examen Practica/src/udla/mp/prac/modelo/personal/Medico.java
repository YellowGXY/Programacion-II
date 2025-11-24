package udla.mp.prac.modelo.personal;

import udla.mp.prac.modelo.paciente.Paciente;
import udla.mp.prac.modelo.cita.CitaMedica;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona {
    protected String especialidad;
    protected int añosExperiencia;
    protected String licenciaMedica;
    protected double costoConsultaBase;
    protected List<CitaMedica> citasAsignadas;

    public Medico(String nombre, String identificacion, int edad, String telefono,
                  String especialidad, int añosExperiencia, String licenciaMedica, double costoConsultaBase) {
        super(nombre, identificacion, edad, telefono);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.licenciaMedica = licenciaMedica;
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

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getLicenciaMedica() {
        return licenciaMedica;
    }

    public void setLicenciaMedica(String licenciaMedica) {
        this.licenciaMedica = licenciaMedica;
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
        return "Dr(a). " + nombre + " - Especialidad: " + especialidad + 
               ", Años experiencia: " + añosExperiencia;
    }
}
