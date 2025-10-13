import javax.swing.*;

public class Triangulo {
    /** Generacion de atributos */
    private double base;
    private double altura;

    /** Generacion de constructores */
    public Triangulo() {
    }

    public Triangulo(double base) {
        this.base = base;
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /** Metodos de JAVA */
    public double getBase() {
        JOptionPane.showInputDialog(base, "Ingrese la base del Triangulo:");
        return base;
    }

    public void setBase(double base) {
        JOptionPane.showMessageDialog(null, "La Base del Triangulo es: " + base);
        this.base = base;
    }

    public double getAltura() {
        JOptionPane.showInputDialog(altura, "Ingrese la altura del Triangulo:");
        return altura;
    }

    public void setAltura(double altura) {
        JOptionPane.showMessageDialog(null, "La Altura del Triangulo es: " + altura);
        this.altura = altura;
    }

    /** Metodos propios */

    public void calculoDeArea(Double altura, Double base){
        double Result;
        Result = (this.base * this.altura)/2;
        JOptionPane.showMessageDialog(null, "El area del Triangulo es: " + Result);
    }

}