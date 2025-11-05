import javax.swing.*;

public class Automovil {
    String marca;
    String modelo;
    String color = "Blanco";
    double cilindraje;

    /** Declaracion de los constructores y destructores*/

    public Automovil() {
    }

    public Automovil(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Automovil(String marca, String modelo, double cilindraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
    }

    public Automovil(String marca, double cilindraje, String color, String modelo) {
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.modelo = modelo;
    }

    /** Creacion de los metodos*/

    public String detalle(String color){

        /* String modelo = "AUDI";
        System.out.println("marca : " + this.marca);
        System.out.println("modelo : " + this.modelo);
        System.out.println("color : " + this.color);
        System.out.println("cilindraje : " + this.cilindraje); */


        JOptionPane.showMessageDialog(null, this.color);
        JOptionPane.showMessageDialog(null, color);
        return color;
    }
}
