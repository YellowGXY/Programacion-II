package udla.mp.prac.modelo.cita;

import udla.mp.prac.modelo.personal.Medico;
import udla.mp.prac.modelo.personal.Cirujano;
import udla.mp.prac.modelo.paciente.Paciente;
import udla.mp.prac.enums.EstadoCita;
import udla.mp.prac.enums.TipoAfiliacion;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class CitaMedica {
    private static final double PORCENTAJE_DESCUENTO_POS = 0.20; // 20%
    
    protected LocalDateTime fechaHora;
    protected Medico medicoAsignado;
    protected Paciente paciente;
    protected EstadoCita estado;
    protected double costo;

    public CitaMedica(LocalDateTime fechaHora, Medico medicoAsignado, Paciente paciente) {
        // Validaciones básicas (sin usar try-catch)
        if (fechaHora == null || medicoAsignado == null || paciente == null) {
            System.out.println("ERROR: No se puede crear una cita con datos nulos");
            return;
        }
        
        this.fechaHora = fechaHora;
        this.medicoAsignado = medicoAsignado;
        this.paciente = paciente;
        this.estado = EstadoCita.PROGRAMADA;
        this.costo = calcularCosto();
    }

    public double calcularCosto() {
        // Paso 1: Obtener el costo base del médico
        double costoBase = medicoAsignado.getCostoConsultaBase();
        
        // Paso 2: Si es cirujano, agregar 30% adicional
        if (medicoAsignado instanceof Cirujano) {
            Cirujano cirujano = (Cirujano) medicoAsignado;
            double adicional = cirujano.getCostoAdicionalProcedimiento();
            costoBase = costoBase + adicional;
        }
        
        // Paso 3: Aplicar descuento del 20% para pacientes POS
        if (paciente.getTipoAfiliacion() == TipoAfiliacion.POS) {
            double descuento = costoBase * PORCENTAJE_DESCUENTO_POS;
            costoBase = costoBase - descuento;
        }
        
        return costoBase;
    }

    public boolean validarDisponibilidad() {
        // Regla de negocio: Los cirujanos no atienden citas los fines de semana
        if (medicoAsignado instanceof Cirujano) {
            DayOfWeek diaSemana = fechaHora.getDayOfWeek();
            // Sábado = SATURDAY, Domingo = SUNDAY
            boolean esFinDeSemana = (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY);
            
            if (esFinDeSemana) {
                return false; // No disponible en fin de semana
            }
        }
        return true; // Disponible
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Cita - Fecha: " + fechaHora + ", Médico: " + medicoAsignado.getNombre() +
               ", Paciente: " + paciente.getNombre() + ", Estado: " + estado +
               ", Costo: $" + String.format("%.2f", costo);
    }
}
