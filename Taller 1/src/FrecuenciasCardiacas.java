import javax.swing.*;

public class FrecuenciasCardiacas {
    /** Generacion de atributos */
    private String primerNombre;
    private String apellido;
    private int mes;
    private int dia;
    private int anio;

    /** Generacion de constructores */

    public FrecuenciasCardiacas() {
    }

    public FrecuenciasCardiacas(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public FrecuenciasCardiacas(String primerNombre, String apellido) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
    }

    public FrecuenciasCardiacas(String primerNombre, String apellido, int mes) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.mes = mes;
    }

    public FrecuenciasCardiacas(String primerNombre, String apellido, int mes, int dia) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.mes = mes;
        this.dia = dia;
    }

    public FrecuenciasCardiacas(String primerNombre, String apellido, int mes, int dia, int anio) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }

    /** Metodos de JAVA */

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        JOptionPane.showMessageDialog(null, "El primer nombre es: " + primerNombre);
        this.primerNombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        JOptionPane.showMessageDialog(null, "El apellido es: " + apellido);
        this.apellido = apellido;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        JOptionPane.showMessageDialog(null, "El mes de nacimiento es: " + mes);
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        JOptionPane.showMessageDialog(null, "El día de nacimiento es: " + dia);
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        JOptionPane.showMessageDialog(null, "El año de nacimiento es: " + anio);
        this.anio = anio;
    }

    /** Metodos propios */

    public int calcularEdad() {
        int anioActual = 2025;
        return anioActual - this.anio;
    }

    public int calcularFrecuenciaMaxima() {
        int edad = calcularEdad();
        return 220 - edad;
    }

    public void calcularFrecuenciaEsperada() {
        int frecuenciaMaxima = calcularFrecuenciaMaxima();
        double frecuenciaMinima = frecuenciaMaxima * 0.5;
        double frecuenciaMaximaEsperada = frecuenciaMaxima * 0.85;
        System.out.println("Rango de frecuencia cardiaca esperada: " + frecuenciaMinima + " - " + frecuenciaMaximaEsperada + " ppm");
    }
}
