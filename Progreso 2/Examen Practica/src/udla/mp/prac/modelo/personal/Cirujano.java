package udla.mp.prac.modelo.personal;

import udla.mp.prac.modelo.paciente.Paciente;
import java.time.LocalDateTime;

public class Cirujano extends Medico {
    protected double costoAdicionalProcedimiento;

    public Cirujano(String nombre, String identificacion, int edad, String telefono,
                    String especialidad, int añosExperiencia, String licenciaMedica, 
                    double costoConsultaBase, double costoAdicionalProcedimiento) {
        super(nombre, identificacion, edad, telefono, especialidad, añosExperiencia, licenciaMedica, costoConsultaBase);
        this.costoAdicionalProcedimiento = costoAdicionalProcedimiento;
    }

    public void programarCirugia(Paciente paciente, LocalDateTime fechaHora) {
        System.out.println("Cirugía programada para el paciente " + paciente.getNombre() + 
                          " el día " + fechaHora);
    }

    public double getCostoAdicionalProcedimiento() {
        return costoAdicionalProcedimiento;
    }
    
    public void setCostoAdicionalProcedimiento(double costoAdicionalProcedimiento) {
        this.costoAdicionalProcedimiento = costoAdicionalProcedimiento;
    }

    @Override
    public String toString() {
        return "Dr(a). " + nombre + " - Cirujano(a), Especialidad: " + getEspecialidad();
    }
}
