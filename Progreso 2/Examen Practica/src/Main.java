import udla.mp.prac.gestion.Hospital;
import udla.mp.prac.modelo.personal.Medico;
import udla.mp.prac.modelo.personal.Cirujano;
import udla.mp.prac.modelo.personal.Enfermero;
import udla.mp.prac.modelo.paciente.Paciente;
import udla.mp.prac.modelo.cita.CitaMedica;
import udla.mp.prac.enums.TipoAfiliacion;
import udla.mp.prac.enums.Turno;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Hospital hospital = new Hospital("Hospital Central");
    
    // ======================= MÉTODOS AUXILIARES PARA IMPRIMIR TABLAS =======================
    
    private static void imprimirSeparador(int ancho) {
        for (int i = 0; i < ancho; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    
    private static void imprimirLineaTabla(String col1, String col2, String col3, String col4, String col5) {
        System.out.printf("| %-20s | %-15s | %-15s | %-12s | %-20s |\n", col1, col2, col3, col4, col5);
    }
    
    private static void imprimirEncabezadoPersonal() {
        imprimirSeparador(100);
        imprimirLineaTabla("Nombre", "Identificación", "Edad", "Teléfono", "Rol/Especialidad");
        imprimirSeparador(100);
    }
    
    private static void imprimirEncabezadoPacientes() {
        imprimirSeparador(100);
        imprimirLineaTabla("Nombre", "Identificación", "Edad", "Teléfono", "Tipo Afiliación");
        imprimirSeparador(100);
    }
    
    private static void imprimirEncabezadoCitas() {
        imprimirSeparador(120);
        System.out.printf("| %-25s | %-20s | %-20s | %-15s | %-15s |\n", 
                         "Fecha y Hora", "Médico", "Paciente", "Estado", "Costo");
        imprimirSeparador(120);
    }
    
    private static void imprimirFilaCita(CitaMedica cita) {
        String fecha = cita.getFechaHora().toString().replace("T", " ");
        String medico = cita.getMedicoAsignado().getNombre();
        String paciente = cita.getPaciente().getNombre();
        String estado = cita.getEstado().toString();
        String costo = "$" + String.format("%.2f", cita.getCosto());
        
        System.out.printf("| %-25s | %-20s | %-20s | %-15s | %-15s |\n",
                         fecha, medico, paciente, estado, costo);
    }
    
    // ======================= PROGRAMA PRINCIPAL CON MENÚ INTERACTIVO =======================
    
    void main() {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE GESTIÓN HOSPITALARIA - HOSPITAL CENTRAL          ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    menuMedicos();
                    break;
                case 2:
                    menuEnfermeros();
                    break;
                case 3:
                    menuPacientes();
                    break;
                case 4:
                    menuCitas();
                    break;
                case 5:
                    verPersonal();
                    break;
                case 6:
                    verPacientes();
                    break;
                case 7:
                    verCitas();
                    break;
                case 8:
                    buscarPorEspecialidad();
                    break;
                case 9:
                    buscarPorTurno();
                    break;
                case 10:
                    generarReportes();
                    break;
                case 11:
                    System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
                    System.out.println("║           GRACIAS POR USAR EL SISTEMA HOSPITALARIO              ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════════╝");
                    salir = true;
                    break;
                default:
                    System.out.println("\n✗ Opción inválida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
    
    // ======================= MENÚS =======================
    
    private static void mostrarMenuPrincipal() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      MENÚ PRINCIPAL                              ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.println("║  1. Gestión de Médicos y Cirujanos                              ║");
        System.out.println("║  2. Gestión de Enfermeros                                        ║");
        System.out.println("║  3. Gestión de Pacientes                                         ║");
        System.out.println("║  4. Gestión de Citas                                             ║");
        System.out.println("║  5. Ver Todo el Personal                                         ║");
        System.out.println("║  6. Ver Todos los Pacientes                                      ║");
        System.out.println("║  7. Ver Todas las Citas                                          ║");
        System.out.println("║  8. Buscar Médico por Especialidad                               ║");
        System.out.println("║  9. Buscar Enfermero por Turno                                   ║");
        System.out.println("║ 10. Generar Estadísticas y Reportes                              ║");
        System.out.println("║ 11. Salir                                                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }
    
    // ======================= GESTIÓN DE MÉDICOS =======================
    
    private static void menuMedicos() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│         GESTIÓN DE MÉDICOS Y CIRUJANOS                  │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Agregar Médico                                       │");
        System.out.println("│ 2. Agregar Cirujano                                     │");
        System.out.println("│ 3. Actualizar Médico                                    │");
        System.out.println("│ 4. Eliminar Médico                                      │");
        System.out.println("│ 5. Volver al Menú Principal                             │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        int opcion = leerEntero("Seleccione una opción: ");
        
        switch (opcion) {
            case 1:
                agregarMedico();
                break;
            case 2:
                agregarCirujano();
                break;
            case 3:
                actualizarMedico();
                break;
            case 4:
                eliminarMedico();
                break;
            case 5:
                break;
            default:
                System.out.println("\n✗ Opción inválida.");
        }
    }
    
    private static void agregarMedico() {
        System.out.println("\n▶ AGREGAR MÉDICO");
        String nombre = leerTexto("Nombre completo: ");
        String identificacion = leerTexto("Identificación: ");
        int edad = leerEntero("Edad: ");
        String telefono = leerTexto("Teléfono: ");
        String especialidad = leerTexto("Especialidad: ");
        int añosExperiencia = leerEntero("Años de experiencia: ");
        String licenciaMedica = leerTexto("Licencia médica: ");
        double costoConsulta = leerDecimal("Costo de consulta base: $");
        
        Medico medico = new Medico(nombre, identificacion, edad, telefono, especialidad, añosExperiencia, licenciaMedica, costoConsulta);
        hospital.agregarMedico(medico);
        
        System.out.println("\n✓ Médico agregado exitosamente.");
    }
    
    private static void agregarCirujano() {
        System.out.println("\n▶ AGREGAR CIRUJANO");
        String nombre = leerTexto("Nombre completo: ");
        String identificacion = leerTexto("Identificación: ");
        int edad = leerEntero("Edad: ");
        String telefono = leerTexto("Teléfono: ");
        String especialidad = leerTexto("Especialidad quirúrgica: ");
        int añosExperiencia = leerEntero("Años de experiencia: ");
        String licenciaMedica = leerTexto("Licencia médica: ");
        double costoConsulta = leerDecimal("Costo de consulta base: $");
        double costoAdicional = leerDecimal("Costo adicional por procedimiento: $");
        
        Cirujano cirujano = new Cirujano(nombre, identificacion, edad, telefono, 
                                         especialidad, añosExperiencia, licenciaMedica, costoConsulta, costoAdicional);
        hospital.agregarMedico(cirujano);
        
        System.out.println("\n✓ Cirujano agregado exitosamente.");
    }
    
    private static void actualizarMedico() {
        System.out.println("\n▶ ACTUALIZAR MÉDICO");
        String identificacion = leerTexto("Identificación del médico a actualizar: ");
        
        Medico medico = hospital.buscarMedicoPorId(identificacion);
        if (medico == null) {
            System.out.println("\n✗ Médico no encontrado.");
            return;
        }
        
        System.out.println("\nMédico encontrado: " + medico.getNombre());
        System.out.println("Deje en blanco para mantener el valor actual.");
        
        String nombre = leerTexto("Nuevo nombre [" + medico.getNombre() + "]: ");
        if (!nombre.isEmpty()) medico.setNombre(nombre);
        
        String telefono = leerTexto("Nuevo teléfono [" + medico.getTelefono() + "]: ");
        if (!telefono.isEmpty()) medico.setTelefono(telefono);
        
        String especialidad = leerTexto("Nueva especialidad [" + medico.getEspecialidad() + "]: ");
        if (!especialidad.isEmpty()) medico.setEspecialidad(especialidad);
        
        String costoStr = leerTexto("Nuevo costo consulta [" + medico.getCostoConsultaBase() + "]: ");
        if (!costoStr.isEmpty()) {
            try {
                double costo = Double.parseDouble(costoStr);
                medico.setCostoConsultaBase(costo);
            } catch (NumberFormatException e) {
                System.out.println("Costo inválido, se mantiene el anterior.");
            }
        }
        
        System.out.println("\n✓ Médico actualizado exitosamente.");
    }
    
    private static void eliminarMedico() {
        System.out.println("\n▶ ELIMINAR MÉDICO");
        String identificacion = leerTexto("Identificación del médico a eliminar: ");
        
        boolean eliminado = hospital.eliminarMedico(identificacion);
        if (eliminado) {
            System.out.println("\n✓ Médico eliminado exitosamente.");
        } else {
            System.out.println("\n✗ Médico no encontrado.");
        }
    }
    
    // ======================= GESTIÓN DE ENFERMEROS =======================
    
    private static void menuEnfermeros() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│            GESTIÓN DE ENFERMEROS                        │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Agregar Enfermero                                    │");
        System.out.println("│ 2. Actualizar Enfermero                                 │");
        System.out.println("│ 3. Eliminar Enfermero                                   │");
        System.out.println("│ 4. Volver al Menú Principal                             │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        int opcion = leerEntero("Seleccione una opción: ");
        
        switch (opcion) {
            case 1:
                agregarEnfermero();
                break;
            case 2:
                actualizarEnfermero();
                break;
            case 3:
                eliminarEnfermero();
                break;
            case 4:
                break;
            default:
                System.out.println("\n✗ Opción inválida.");
        }
    }
    
    private static void agregarEnfermero() {
        System.out.println("\n▶ AGREGAR ENFERMERO");
        String nombre = leerTexto("Nombre completo: ");
        String identificacion = leerTexto("Identificación: ");
        int edad = leerEntero("Edad: ");
        String telefono = leerTexto("Teléfono: ");
        
        System.out.println("\nTurnos disponibles:");
        System.out.println("1. MAÑANA");
        System.out.println("2. TARDE");
        System.out.println("3. NOCHE");
        int turnoOpcion = leerEntero("Seleccione turno: ");
        
        Turno turno = Turno.MANANA;
        switch (turnoOpcion) {
            case 1: turno = Turno.MANANA; break;
            case 2: turno = Turno.TARDE; break;
            case 3: turno = Turno.NOCHE; break;
        }
        
        String areaAsignada = leerTexto("Área asignada: ");
        
        Enfermero enfermero = new Enfermero(nombre, identificacion, edad, telefono, turno, areaAsignada);
        hospital.agregarEnfermero(enfermero);
        
        System.out.println("\n✓ Enfermero agregado exitosamente.");
    }
    
    private static void actualizarEnfermero() {
        System.out.println("\n▶ ACTUALIZAR ENFERMERO");
        String identificacion = leerTexto("Identificación del enfermero a actualizar: ");
        
        Enfermero enfermero = hospital.buscarEnfermeroPorId(identificacion);
        if (enfermero == null) {
            System.out.println("\n✗ Enfermero no encontrado.");
            return;
        }
        
        System.out.println("\nEnfermero encontrado: " + enfermero.getNombre());
        System.out.println("Deje en blanco para mantener el valor actual.");
        
        String nombre = leerTexto("Nuevo nombre [" + enfermero.getNombre() + "]: ");
        if (!nombre.isEmpty()) enfermero.setNombre(nombre);
        
        String telefono = leerTexto("Nuevo teléfono [" + enfermero.getTelefono() + "]: ");
        if (!telefono.isEmpty()) enfermero.setTelefono(telefono);
        
        System.out.println("\n✓ Enfermero actualizado exitosamente.");
    }
    
    private static void eliminarEnfermero() {
        System.out.println("\n▶ ELIMINAR ENFERMERO");
        String identificacion = leerTexto("Identificación del enfermero a eliminar: ");
        
        boolean eliminado = hospital.eliminarEnfermero(identificacion);
        if (eliminado) {
            System.out.println("\n✓ Enfermero eliminado exitosamente.");
        } else {
            System.out.println("\n✗ Enfermero no encontrado.");
        }
    }
    
    // ======================= GESTIÓN DE PACIENTES =======================
    
    private static void menuPacientes() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│            GESTIÓN DE PACIENTES                         │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Agregar Paciente                                     │");
        System.out.println("│ 2. Actualizar Paciente                                  │");
        System.out.println("│ 3. Eliminar Paciente                                    │");
        System.out.println("│ 4. Volver al Menú Principal                             │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        int opcion = leerEntero("Seleccione una opción: ");
        
        switch (opcion) {
            case 1:
                agregarPaciente();
                break;
            case 2:
                actualizarPaciente();
                break;
            case 3:
                eliminarPaciente();
                break;
            case 4:
                break;
            default:
                System.out.println("\n✗ Opción inválida.");
        }
    }
    
    private static void agregarPaciente() {
        System.out.println("\n▶ AGREGAR PACIENTE");
        String nombre = leerTexto("Nombre completo: ");
        String identificacion = leerTexto("Identificación: ");
        int edad = leerEntero("Edad: ");
        String telefono = leerTexto("Teléfono: ");
        
        System.out.println("\nTipos de afiliación:");
        System.out.println("1. POS (20% descuento)");
        System.out.println("2. PREPAGADA");
        System.out.println("3. PARTICULAR");
        int afiliacionOpcion = leerEntero("Seleccione tipo de afiliación: ");
        
        TipoAfiliacion afiliacion = TipoAfiliacion.PARTICULAR;
        switch (afiliacionOpcion) {
            case 1: afiliacion = TipoAfiliacion.POS; break;
            case 2: afiliacion = TipoAfiliacion.PREPAGADA; break;
            case 3: afiliacion = TipoAfiliacion.PARTICULAR; break;
        }
        
        Paciente paciente = new Paciente(nombre, identificacion, edad, telefono, afiliacion);
        hospital.agregarPaciente(paciente);
        
        System.out.println("\n✓ Paciente agregado exitosamente.");
    }
    
    private static void actualizarPaciente() {
        System.out.println("\n▶ ACTUALIZAR PACIENTE");
        String identificacion = leerTexto("Identificación del paciente a actualizar: ");
        
        Paciente paciente = hospital.buscarPacientePorId(identificacion);
        if (paciente == null) {
            System.out.println("\n✗ Paciente no encontrado.");
            return;
        }
        
        System.out.println("\nPaciente encontrado: " + paciente.getNombre());
        System.out.println("Deje en blanco para mantener el valor actual.");
        
        String nombre = leerTexto("Nuevo nombre [" + paciente.getNombre() + "]: ");
        if (!nombre.isEmpty()) paciente.setNombre(nombre);
        
        String telefono = leerTexto("Nuevo teléfono [" + paciente.getTelefono() + "]: ");
        if (!telefono.isEmpty()) paciente.setTelefono(telefono);
        
        System.out.println("\n✓ Paciente actualizado exitosamente.");
    }
    
    private static void eliminarPaciente() {
        System.out.println("\n▶ ELIMINAR PACIENTE");
        String identificacion = leerTexto("Identificación del paciente a eliminar: ");
        
        boolean eliminado = hospital.eliminarPaciente(identificacion);
        if (eliminado) {
            System.out.println("\n✓ Paciente eliminado exitosamente.");
        } else {
            System.out.println("\n✗ Paciente no encontrado.");
        }
    }
    
    // ======================= GESTIÓN DE CITAS =======================
    
    private static void menuCitas() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│            GESTIÓN DE CITAS MÉDICAS                     │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Programar Cita                                       │");
        System.out.println("│ 2. Completar Cita                                       │");
        System.out.println("│ 3. Cancelar Cita                                        │");
        System.out.println("│ 4. Eliminar Cita                                        │");
        System.out.println("│ 5. Volver al Menú Principal                             │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        int opcion = leerEntero("Seleccione una opción: ");
        
        switch (opcion) {
            case 1:
                programarCita();
                break;
            case 2:
                completarCita();
                break;
            case 3:
                cancelarCita();
                break;
            case 4:
                eliminarCita();
                break;
            case 5:
                break;
            default:
                System.out.println("\n✗ Opción inválida.");
        }
    }
    
    private static void programarCita() {
        System.out.println("\n▶ PROGRAMAR CITA MÉDICA");
        
        // Mostrar médicos disponibles
        List<Medico> medicos = hospital.getMedicos();
        if (medicos.isEmpty()) {
            System.out.println("\n✗ No hay médicos registrados.");
            return;
        }
        
        System.out.println("\nMédicos disponibles:");
        for (int i = 0; i < medicos.size(); i++) {
            Medico m = medicos.get(i);
            String tipo = (m instanceof Cirujano) ? "[CIRUJANO]" : "[MÉDICO]";
            System.out.println((i + 1) + ". " + tipo + " " + m.getNombre() + " - " + 
                             m.getEspecialidad() + " (ID: " + m.getIdentificacion() + ")");
        }
        
        int medicoIndex = leerEntero("Seleccione número de médico: ") - 1;
        if (medicoIndex < 0 || medicoIndex >= medicos.size()) {
            System.out.println("\n✗ Médico inválido.");
            return;
        }
        Medico medico = medicos.get(medicoIndex);
        
        // Mostrar pacientes disponibles
        List<Paciente> pacientes = hospital.getPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("\n✗ No hay pacientes registrados.");
            return;
        }
        
        System.out.println("\nPacientes disponibles:");
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " - " + 
                             p.getTipoAfiliacion() + " (ID: " + p.getIdentificacion() + ")");
        }
        
        int pacienteIndex = leerEntero("Seleccione número de paciente: ") - 1;
        if (pacienteIndex < 0 || pacienteIndex >= pacientes.size()) {
            System.out.println("\n✗ Paciente inválido.");
            return;
        }
        Paciente paciente = pacientes.get(pacienteIndex);
        
        // Leer fecha y hora
        int año = leerEntero("Año (ej. 2024): ");
        int mes = leerEntero("Mes (1-12): ");
        int dia = leerEntero("Día (1-31): ");
        int hora = leerEntero("Hora (0-23): ");
        int minuto = leerEntero("Minuto (0-59): ");
        
        LocalDateTime fechaHora = LocalDateTime.of(año, mes, dia, hora, minuto);
        CitaMedica cita = new CitaMedica(fechaHora, medico, paciente);
        
        boolean programada = hospital.programarCita(cita);
        if (programada) {
            System.out.println("\n✓ Cita programada exitosamente.");
            System.out.println("Costo estimado: $" + String.format("%.2f", cita.getCosto()));
        } else {
            System.out.println("\n✗ No se pudo programar la cita.");
            System.out.println("Nota: Los cirujanos no atienden los fines de semana.");
        }
    }
    
    private static void completarCita() {
        System.out.println("\n▶ COMPLETAR CITA");
        mostrarCitasConIndices();
        
        int indice = leerEntero("Número de cita a completar: ") - 1;
        List<CitaMedica> citas = hospital.getCitasMedicas();
        
        if (indice < 0 || indice >= citas.size()) {
            System.out.println("\n✗ Cita inválida.");
            return;
        }
        
        hospital.completarCita(citas.get(indice));
    }
    
    private static void cancelarCita() {
        System.out.println("\n▶ CANCELAR CITA");
        mostrarCitasConIndices();
        
        int indice = leerEntero("Número de cita a cancelar: ") - 1;
        List<CitaMedica> citas = hospital.getCitasMedicas();
        
        if (indice < 0 || indice >= citas.size()) {
            System.out.println("\n✗ Cita inválida.");
            return;
        }
        
        hospital.cancelarCita(citas.get(indice));
    }
    
    private static void eliminarCita() {
        System.out.println("\n▶ ELIMINAR CITA");
        mostrarCitasConIndices();
        
        int indice = leerEntero("Número de cita a eliminar: ") - 1;
        
        boolean eliminada = hospital.eliminarCita(indice);
        if (eliminada) {
            System.out.println("\n✓ Cita eliminada exitosamente.");
        } else {
            System.out.println("\n✗ Cita inválida.");
        }
    }
    
    private static void mostrarCitasConIndices() {
        List<CitaMedica> citas = hospital.getCitasMedicas();
        if (citas.isEmpty()) {
            System.out.println("\n✗ No hay citas programadas.");
            return;
        }
        
        System.out.println("\nCitas programadas:");
        for (int i = 0; i < citas.size(); i++) {
            CitaMedica c = citas.get(i);
            System.out.println((i + 1) + ". " + c.getFechaHora() + " | " + 
                             c.getMedicoAsignado().getNombre() + " → " + 
                             c.getPaciente().getNombre() + " [" + c.getEstado() + "]");
        }
    }
    
    // ======================= CONSULTAS =======================
    
    private static void verPersonal() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    PERSONAL DEL HOSPITAL                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        
        System.out.println("\n▶ MÉDICOS Y CIRUJANOS:");
        imprimirEncabezadoPersonal();
        List<Medico> listaMedicos = hospital.getMedicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("| No hay médicos registrados                                                                   |");
        } else {
            for (int i = 0; i < listaMedicos.size(); i++) {
                Medico m = listaMedicos.get(i);
                String rol = (m instanceof Cirujano) ? "Cirujano" : "Médico";
                imprimirLineaTabla(m.getNombre(), m.getIdentificacion(), 
                                  String.valueOf(m.getEdad()), m.getTelefono(),
                                  rol + " - " + m.getEspecialidad());
            }
        }
        imprimirSeparador(100);
        
        System.out.println("\n▶ ENFERMEROS:");
        imprimirEncabezadoPersonal();
        List<Enfermero> listaEnfermeros = hospital.getEnfermeros();
        if (listaEnfermeros.isEmpty()) {
            System.out.println("| No hay enfermeros registrados                                                                |");
        } else {
            for (int i = 0; i < listaEnfermeros.size(); i++) {
                Enfermero e = listaEnfermeros.get(i);
                imprimirLineaTabla(e.getNombre(), e.getIdentificacion(),
                                  String.valueOf(e.getEdad()), e.getTelefono(),
                                  "Enfermero - Turno " + e.getTurno());
            }
        }
        imprimirSeparador(100);
    }
    
    private static void verPacientes() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    PACIENTES REGISTRADOS                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");
        
        imprimirEncabezadoPacientes();
        List<Paciente> listaPacientes = hospital.getPacientes();
        if (listaPacientes.isEmpty()) {
            System.out.println("| No hay pacientes registrados                                                                 |");
        } else {
            for (int i = 0; i < listaPacientes.size(); i++) {
                Paciente p = listaPacientes.get(i);
                imprimirLineaTabla(p.getNombre(), p.getIdentificacion(),
                                  String.valueOf(p.getEdad()), p.getTelefono(),
                                  p.getTipoAfiliacion().toString());
            }
        }
        imprimirSeparador(100);
    }
    
    private static void verCitas() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    CITAS MÉDICAS PROGRAMADAS                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");
        
        imprimirEncabezadoCitas();
        List<CitaMedica> listaCitas = hospital.getCitasMedicas();
        if (listaCitas.isEmpty()) {
            System.out.println("| No hay citas programadas                                                                                  |");
        } else {
            for (int i = 0; i < listaCitas.size(); i++) {
                imprimirFilaCita(listaCitas.get(i));
            }
        }
        imprimirSeparador(120);
    }
    
    private static void buscarPorEspecialidad() {
        System.out.println("\n▶ BÚSQUEDA POR ESPECIALIDAD");
        String especialidad = leerTexto("Ingrese la especialidad a buscar: ");
        
        List<Medico> encontrados = hospital.buscarMedicoPorEspecialidad(especialidad);
        if (encontrados.isEmpty()) {
            System.out.println("\n✗ No se encontraron médicos con esa especialidad.");
        } else {
            System.out.println("\n✓ Médicos encontrados:");
            for (int i = 0; i < encontrados.size(); i++) {
                System.out.println("  • " + encontrados.get(i).getNombre() + " - " + 
                                 encontrados.get(i).getEspecialidad());
            }
        }
    }
    
    private static void buscarPorTurno() {
        System.out.println("\n▶ BÚSQUEDA POR TURNO");
        System.out.println("Turnos disponibles:");
        System.out.println("1. MAÑANA");
        System.out.println("2. TARDE");
        System.out.println("3. NOCHE");
        int turnoOpcion = leerEntero("Seleccione turno: ");
        
        Turno turno = Turno.MANANA;
        switch (turnoOpcion) {
            case 1: turno = Turno.MANANA; break;
            case 2: turno = Turno.TARDE; break;
            case 3: turno = Turno.NOCHE; break;
        }
        
        List<Enfermero> encontrados = hospital.buscarEnfermeroPorTurno(turno);
        if (encontrados.isEmpty()) {
            System.out.println("\n✗ No se encontraron enfermeros en ese turno.");
        } else {
            System.out.println("\n✓ Enfermeros encontrados:");
            for (int i = 0; i < encontrados.size(); i++) {
                System.out.println("  • " + encontrados.get(i).getNombre() + " - Turno: " + 
                                 encontrados.get(i).getTurno());
            }
        }
    }
    
    private static void generarReportes() {
        hospital.mostrarEstadisticas();
        hospital.generarReportePacientesPorMedico();
    }
    
    // ======================= UTILIDADES DE ENTRADA =======================
    
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("✗ Debe ingresar un número entero válido.");
            }
        }
    }
    
    private static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = Double.parseDouble(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("✗ Debe ingresar un número decimal válido.");
            }
        }
    }
}
