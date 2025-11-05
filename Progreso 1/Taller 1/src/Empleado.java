import javax.swing.*;
import java.util.Scanner;

public class Empleado {
    /** Generacion de atributos */
    private String primerNombre;
    private String primerApellido;
    private double salarioMensual;

    /** Generacion de constructores */

    public Empleado() {
    }

    public Empleado(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public Empleado(String primerNombre, String primerApellido) {
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Empleado(String primerNombre, String primerApellido, double salarioMensual) {
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.salarioMensual = salarioMensual;
    }

    /** Metodos de JAVA */
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        JOptionPane.showMessageDialog(null, "El primer nombre del empleado es: " + primerNombre);
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        JOptionPane.showMessageDialog(null, "El primer apellido del empleado es: " + primerApellido);
        this.primerApellido = primerApellido;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual > 0){
            JOptionPane.showMessageDialog(null, "El salario mensual del empleado es: " + salarioMensual);
            this.salarioMensual = salarioMensual;
        } else {
            System.out.println("No se ha establecido el valor.");
        }

    }

    /** Metodos propios */
    public void mostrarSalarioAnual(String primerNombre, String primerApellido, double salarioMensual){
        double salarioAnual = salarioMensual * 12;
        System.out.println(" Nombre | Apellido | Salario Mensual | Salario Anual");
        System.out.println(primerNombre + " | " + primerApellido + " | " + salarioMensual + "$ | " + salarioAnual + "$");
    }

    public double aumentarSalarioMensual(String primerNombre, String primerApellido, double salarioMensual){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea aumentar el salaio mensual de " + primerNombre + " " + primerApellido + " en un 10%?\n1. Si\n2. No");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion == 1){
            salarioMensual=salarioMensual*1.1;
        }
        this.salarioMensual = salarioMensual;
        return salarioMensual;
    }
}
