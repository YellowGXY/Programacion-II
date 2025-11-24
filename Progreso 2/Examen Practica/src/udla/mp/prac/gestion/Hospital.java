package gestion;

import modelo.personal.Medico;
import modelo.personal.Enfermero;
import modelo.paciente.Paciente;
import modelo.cita.CitaMedica;
import enums.EstadoCita;
import enums.Turno;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    protected String nombre;
    protected List<Medico> medicos;
    protected List<Enfermero> enfermeros;
    protected List<Paciente> pacientes;
    protected List<CitaMedica> citasMedicas;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.medicos = new ArrayList<>();
        this.enfermeros = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citasMedicas = new ArrayList<>();
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarEnfermero(Enfermero enfermero) {
        enfermeros.add(enfermero);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public boolean programarCita(CitaMedica cita) {
        if (cita.validarDisponibilidad()) {
            citasMedicas.add(cita);
            cita.getMedicoAsignado().agregarCita(cita);
            return true;
        }
        return false;
    }

    public void generarReportePacientesPorMedico() {
        System.out.println("\n=== REPORTE DE PACIENTES POR MÉDICO ===");
        
        // Usar bucle for simple en lugar de streams
        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            System.out.println("\nMédico: " + medico.getNombre() + " - " + medico.getEspecialidad());
            
            List<CitaMedica> citasMedico = medico.getCitasAsignadas();
            System.out.println("Total de citas: " + citasMedico.size());
            
            for (int j = 0; j < citasMedico.size(); j++) {
                CitaMedica cita = citasMedico.get(j);
                System.out.println("  - Paciente: " + cita.getPaciente().getNombre() +
                                 " | Fecha: " + cita.getFechaHora() +
                                 " | Estado: " + cita.getEstado());
            }
        }
    }

    public List<Medico> buscarMedicoPorEspecialidad(String especialidad) {
        List<Medico> medicosEncontrados = new ArrayList<>();
        
        // Usar bucle for simple en lugar de streams
        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            if (medico.getEspecialidad().equalsIgnoreCase(especialidad)) {
                medicosEncontrados.add(medico);
            }
        }
        
        return medicosEncontrados;
    }

    public List<Enfermero> buscarEnfermeroPorTurno(Turno turno) {
        List<Enfermero> enfermerosEncontrados = new ArrayList<>();
        
        // Usar bucle for simple en lugar de streams
        for (int i = 0; i < enfermeros.size(); i++) {
            Enfermero enfermero = enfermeros.get(i);
            if (enfermero.getTurno() == turno) {
                enfermerosEncontrados.add(enfermero);
            }
        }
        
        return enfermerosEncontrados;
    }

    public double calcularIngresosTotales() {
        double total = 0;
        
        // Usar bucle for simple en lugar de streams
        for (int i = 0; i < citasMedicas.size(); i++) {
            CitaMedica cita = citasMedicas.get(i);
            if (cita.getEstado() == EstadoCita.COMPLETADA) {
                total = total + cita.getCosto();
            }
        }
        
        return total;
    }

    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DEL HOSPITAL ===");
        System.out.println("Hospital: " + nombre);
        System.out.println("Total de Médicos: " + medicos.size());
        System.out.println("Total de Enfermeros: " + enfermeros.size());
        System.out.println("Total de Pacientes: " + pacientes.size());
        System.out.println("Total de Citas Programadas: " + citasMedicas.size());
        
        // Contar citas por estado usando bucles simples
        int citasCompletadas = 0;
        int citasCanceladas = 0;
        int citasProgramadas = 0;
        
        for (int i = 0; i < citasMedicas.size(); i++) {
            CitaMedica cita = citasMedicas.get(i);
            if (cita.getEstado() == EstadoCita.COMPLETADA) {
                citasCompletadas++;
            } else if (cita.getEstado() == EstadoCita.CANCELADA) {
                citasCanceladas++;
            } else if (cita.getEstado() == EstadoCita.PROGRAMADA) {
                citasProgramadas++;
            }
        }
        
        System.out.println("Citas Completadas: " + citasCompletadas);
        System.out.println("Citas Canceladas: " + citasCanceladas);
        System.out.println("Citas Programadas: " + citasProgramadas);
        System.out.println("Ingresos Totales: $" + String.format("%.2f", calcularIngresosTotales()));
    }

    public void completarCita(CitaMedica cita) {
        cita.setEstado(EstadoCita.COMPLETADA);
        System.out.println("Cita completada exitosamente.");
    }

    public void cancelarCita(CitaMedica cita) {
        cita.setEstado(EstadoCita.CANCELADA);
        System.out.println("Cita cancelada exitosamente.");
    }

    // ======================= MÉTODOS CRUD =======================
    
    // ELIMINAR Médico
    public boolean eliminarMedico(String identificacion) {
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getIdentificacion().equals(identificacion)) {
                medicos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // ELIMINAR Enfermero
    public boolean eliminarEnfermero(String identificacion) {
        for (int i = 0; i < enfermeros.size(); i++) {
            if (enfermeros.get(i).getIdentificacion().equals(identificacion)) {
                enfermeros.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // ELIMINAR Paciente
    public boolean eliminarPaciente(String identificacion) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getIdentificacion().equals(identificacion)) {
                pacientes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // ELIMINAR Cita
    public boolean eliminarCita(int indice) {
        if (indice >= 0 && indice < citasMedicas.size()) {
            citasMedicas.remove(indice);
            return true;
        }
        return false;
    }
    
    // BUSCAR Médico por identificación
    public Medico buscarMedicoPorId(String identificacion) {
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getIdentificacion().equals(identificacion)) {
                return medicos.get(i);
            }
        }
        return null;
    }
    
    // BUSCAR Enfermero por identificación
    public Enfermero buscarEnfermeroPorId(String identificacion) {
        for (int i = 0; i < enfermeros.size(); i++) {
            if (enfermeros.get(i).getIdentificacion().equals(identificacion)) {
                return enfermeros.get(i);
            }
        }
        return null;
    }
    
    // BUSCAR Paciente por identificación
    public Paciente buscarPacientePorId(String identificacion) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getIdentificacion().equals(identificacion)) {
                return pacientes.get(i);
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<CitaMedica> getCitasMedicas() {
        return citasMedicas;
    }
}
