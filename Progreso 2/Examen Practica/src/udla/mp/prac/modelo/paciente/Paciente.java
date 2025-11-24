package udla.mp.prac.modelo.paciente;

import udla.mp.prac.enums.TipoAfiliacion;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    protected String nombre;
    protected String identificacion;
    protected int edad;
    protected String telefono;
    protected TipoAfiliacion tipoAfiliacion;
    protected List<String> historialMedico;
    protected boolean esEmergencia;

    public Paciente(String nombre, String identificacion, int edad, String telefono,
                    TipoAfiliacion tipoAfiliacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.telefono = telefono;
        this.tipoAfiliacion = tipoAfiliacion;
        this.historialMedico = new ArrayList<>();
        this.esEmergencia = false;
    }

    public void agregarConsulta(String consulta) {
        historialMedico.add(consulta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoAfiliacion getTipoAfiliacion() {
        return tipoAfiliacion;
    }

    public void setTipoAfiliacion(TipoAfiliacion tipoAfiliacion) {
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public List<String> getHistorialMedico() {
        return historialMedico;
    }

    public boolean isEsEmergencia() {
        return esEmergencia;
    }

    public void setEsEmergencia(boolean esEmergencia) {
        this.esEmergencia = esEmergencia;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + " - Afiliación: " + tipoAfiliacion + 
               (esEmergencia ? " [EMERGENCIA]" : "");
    }
}
