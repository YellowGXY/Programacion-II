import javax.swing.*;

void main() {
    /** 3.13 (La clase Empleado) Cree una clase llamada Empleado, que incluya tres variables de instancia:
     * un primer nombre (tipo String), un apellido paterno (tipo String) y un salario mensual (double).
     * Su clase debe tener un constructor que inicialice las tres variables de instancia. Proporcione
     * un metodo establecer y un metodo obtener para cada variable de instancia. Si el salario mensual
     * no es positivo, no establezca su valor. Escriba una aplicación de prueba llamada PruebaEmpleado,
     * que demuestre las capacidades de la clase Empleado. Cree dos objetos Empleado y muestre el salario
     * anual de cada objeto. Después, proporcione a cada Empleado un aumento del 10% y muestre el salario
     * anual de cada Empleado otra vez.
     */

    /** Declaracion de objetos */
    Empleado empleado1 = new Empleado();
    Empleado empleado2 = new Empleado();
    Scanner sc = new Scanner(System.in);

    /** Declaración de variables */
    int opcion;
    int opcion2;
    double salarioMensual = 0;

    /** Estructura principal del programa */
    do {
        System.out.println("Que empleado desea ingresar?\n1. Empleado 1\n2. Empleado 2");
        opcion = Integer.parseInt(sc.nextLine());
        if (opcion == 1) {
            empleado1.setPrimerNombre(JOptionPane.showInputDialog(null, "Ingrese el primer nombre del empleado: "));
            empleado1.setPrimerApellido(JOptionPane.showInputDialog(null, "Ingrese el primer apellido del empleado: "));
            empleado1.setSalarioMensual(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario mensual del empleado: ")));
        } else if (opcion == 2) {
            empleado2.setPrimerNombre(JOptionPane.showInputDialog(null, "Ingrese el primer nombre del empleado: "));
            empleado2.setPrimerApellido(JOptionPane.showInputDialog(null, "Ingrese el primer apellido del empleado: "));
            empleado2.setSalarioMensual(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario mensual del empleado: ")));
        }
        System.out.println("Desea salir del ingreso?\n1. Si 1\n2. No");
        opcion2 = Integer.parseInt(sc.nextLine());
    } while (opcion2 != 1);
    do {
        System.out.println("De quién desea mostrar el salario anual?\n1. " + empleado1.getPrimerNombre() + " " + empleado1.getPrimerApellido() + "\n2. " + empleado2.getPrimerNombre() + " " + empleado2.getPrimerApellido());
        opcion = Integer.parseInt(sc.nextLine());
        if (opcion == 1) {
            empleado1.mostrarSalarioAnual(empleado1.getPrimerNombre(), empleado1.getPrimerApellido(), empleado1.getSalarioMensual());
        } else if (opcion == 2) {
            empleado2.mostrarSalarioAnual(empleado2.getPrimerNombre(), empleado2.getPrimerApellido(), empleado2.getSalarioMensual());
        }

        System.out.println("Desea aumentar el salario de alguno?\n1. Si 1\n2. No");
        opcion2 = Integer.parseInt(sc.nextLine());
        if (opcion2 == 1) {
            System.out.println("De quién desea aumentar el salario mensual?\n1. " + empleado1.getPrimerNombre() + " " + empleado1.getPrimerApellido() + "\n2. " + empleado2.getPrimerNombre() + " " + empleado2.getPrimerApellido());
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion == 1) {
                salarioMensual = empleado1.aumentarSalarioMensual(empleado1.getPrimerNombre(), empleado1.getPrimerApellido(), empleado1.getSalarioMensual());
            } else if (opcion == 2) {
                salarioMensual = empleado2.aumentarSalarioMensual(empleado2.getPrimerNombre(), empleado2.getPrimerApellido(), empleado2.getSalarioMensual());
            }
            System.out.println("El salario mensual ha sido aumentado a: " + salarioMensual);
        }

        System.out.println("Desea salir?\n1. Si \n2. No");
        opcion2 = Integer.parseInt(sc.nextLine());
    } while (opcion2 != 1);
}
