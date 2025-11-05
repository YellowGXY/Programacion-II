import javax.swing.*;

public class Fecha {
    /** Generacion de atributos */
    private int dia;
    private int mes;
    private int anio;

    /** Generacion de constructores */
    public Fecha() {
    }

    public Fecha(int dia) {
        this.dia = dia;
    }

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /** Metodos de JAVA */

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        JOptionPane.showMessageDialog(null, "El día asignado es: "+ dia);
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        JOptionPane.showMessageDialog(null, "El mes asignado es: "+ mes);
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        JOptionPane.showMessageDialog(null, "El año asignado es: "+ anio);
        this.anio = anio;
    }

    /** Metodos propios */
    public void mostrarFecha(int dia, int mes, int anio){
        JOptionPane.showMessageDialog(null, "La fecha asignada es: \n" + dia + "/" + mes + "/" + anio);
    }
}