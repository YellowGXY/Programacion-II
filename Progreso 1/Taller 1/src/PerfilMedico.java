import javax.swing.*;

public class PerfilMedico {
    /** Generacion de atributos */
    private String primerNombre;
    private String apellido;
    private String sexo;
    private int dia;
    private int mes;
    private int anio;
    private double altura;
    private double peso;

    /** Generacion de constructores */

    public PerfilMedico() {
    }

    public PerfilMedico(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public PerfilMedico(String primerNombre, String apellido) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
    }

    public PerfilMedico(String primerNombre, String apellido, String sexo) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }

    public PerfilMedico(String primerNombre, String apellido, String sexo, int dia) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dia = dia;
    }

    public PerfilMedico(String primerNombre, String apellido, String sexo, int dia, int mes) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
    }

    public PerfilMedico(String primerNombre, String apellido, String sexo, int dia, int mes, int anio) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public PerfilMedico(String primerNombre, String apellido, String sexo, int dia, int mes, int anio, double altura) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.altura = altura;
    }

    public PerfilMedico(String primerNombre, String apellido, String sexo, int dia, int mes, int anio, double altura, double peso) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.altura = altura;
        this.peso = peso;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        JOptionPane.showMessageDialog(null, "El sexo es: " + sexo);
        this.sexo = sexo;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        JOptionPane.showMessageDialog(null, "El día de nacimiento es: " + dia);
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        JOptionPane.showMessageDialog(null, "El mes de nacimiento es: " + mes);
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        JOptionPane.showMessageDialog(null, "El año de nacimiento es: " + anio);
        this.anio = anio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        JOptionPane.showMessageDialog(null, "La altura es: " + altura + " cm");
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        JOptionPane.showMessageDialog(null, "El peso es: " + peso + " kg");
        this.peso = peso;
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

    public double calcularBMI() {
        double alturaMetros = this.altura / 100;
        return this.peso / (alturaMetros * alturaMetros);
    }

    public void mostrarTablaBMI() {
        System.out.println();
        System.out.println("VALORES DE BMI:");
        System.out.println("Bajo peso: menos de 18.5");
        System.out.println("Normal: entre 18.5 y 24.9");
        System.out.println("Sobrepeso: entre 25 y 29.9");
        System.out.println("Obeso: 30 o más");
    }
}
