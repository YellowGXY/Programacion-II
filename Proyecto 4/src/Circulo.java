import javax.swing.*;

public class Circulo {
    /** Generacion de atributos */
    private double radio;

    /** Generacion de constructores */
    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    /** Metodos de JAVA */
    public double getRadio() {
        JOptionPane.showInputDialog(radio, "Ingrese la base del Cuadrado:");
        return radio;
    }

    public void setRadio(double radio) {
        JOptionPane.showMessageDialog(null, "La Base del Cuadrado es: " + radio);
        this.radio = radio;
    }

    /** Metodos propios */

    public void calculoDeArea(Double radio){
        double Result;
        Result = (Math.PI * Math.pow(radio, 2));
        JOptionPane.showMessageDialog(null, "El area del Circulo es: " + Result);
    }
}