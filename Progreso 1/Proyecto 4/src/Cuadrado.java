import javax.swing.*;

public class Cuadrado {
    /** Generacion de atributos */
    private double base;
    private double altura;

    /** Generacion de constructores */
    public Cuadrado() {
    }

    public Cuadrado(double base) {
        this.base = base;
    }

    public Cuadrado(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /** Metodos de JAVA */
    public double getBase() {
        JOptionPane.showInputDialog(base, "Ingrese la base del Cuadrado:");
        return base;
    }

    public void setBase(double base) {
        JOptionPane.showMessageDialog(null, "La Base del Cuadrado es: " + base);
        this.base = base;
    }

    public double getAltura() {
        JOptionPane.showInputDialog(altura, "Ingrese la altura del Cuadrado:");
        return altura;
    }

    public void setAltura(double altura) {
        JOptionPane.showMessageDialog(null, "La Altura del Cuadrado es: " + altura);
        this.altura = altura;
    }

    /** Metodos propios */

    public void calculoDeArea(Double altura, Double base){
        double Result;
        Result = (this.base * this.altura);
        if (this.base == this.altura){
            JOptionPane.showMessageDialog(null, "El area del Cuadrado es: " + Result);
        } else {
            JOptionPane.showMessageDialog(null, "El area del Rectángulo es: " + Result);
        }
    }
}