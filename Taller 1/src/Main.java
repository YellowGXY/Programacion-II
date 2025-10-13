import javax.swing.*;
import java.util.Scanner;
void main() {
    /** 3.14 (La clase Fecha) Cree una clase llamada Fecha, que incluya tres variables de instancia:
     * un mes (tipo int), un día (tipo int) y un año (tipo int). Su clase debe tener un constructor
     * que inicialice las tres variables de instancia, y debe asumir que los valores que se
     * proporcionan son correctos. Proporcione un metodo establecer y un metodo obtener para cada
     * variable de instancia. Proporcione un metodo mostrarFecha, que muestre el mes, día y año,
     * separados por barras diagonales (/). Escriba una aplicación de prueba llamada PruebaFecha,
     * que demuestre las capacidades de la clase Fecha.*/

    /** Declaración de objetos */

    Scanner sc = new Scanner(System.in);
    Fecha fecha = new Fecha();

    /** Declaración de variables */

    int cont = 0;

    /** Estructura principal del programa */

    IO.println("Desea comenzar con el ingreso de la fecha?\n1. Si\n2. No");

    while (Integer.parseInt(sc.nextLine()) == 1) {
        IO.println();
        IO.println("Comience el ingreso de dia, mes y año.");
        fecha.setDia(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia:")));
        fecha.setMes(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes:")));
        fecha.setAnio(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año:")));

        fecha.mostrarFecha(fecha.getDia(), fecha.getMes(), fecha.getAnio());

        if (cont == 1){
            IO.println("Desea seguir con el ingreso de la fecha?\n1. Si\n2. No");
        }

        cont = 1;
    }

    IO.println("Terminando el proceso.");
    IO.println();
}

