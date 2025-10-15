import java.util.Scanner;

void main() {
        /** 3.12 (La clase Factura) Cree una clase llamada Factura que una ferretería podría utilizar
         * para representar una factura para un artículo vendido en la tienda. Una Factura debe incluir
         * cuatro piezas de información como variables de instancia: un número de pieza (tipo String),
         * la descripción de la pieza (tipo String), la cantidad de artículos de ese tipo que se van a
         * comprar (tipo int) y el precio por artículo (double). Su clase debe tener un constructor que
         * inicialice las cuatro variables de instancia. Proporcione un metodo establecer y un metodo
         * obtener para cada variable de instancia. Además, proporcione un metodo llamado obtenerMontoFactura,
         * que calcule el monto de la factura (es decir, que multiplique la cantidad de artículos por el precio de cada uno)
         * y después devuelva ese monto como un valor double. Si la cantidad no es positiva, debe establecerse en 0.
         * Si el precio por artículo no es positivo, debe establecerse en 0.0. Escriba una aplicación de prueba
         * llamada PruebaFactura, que demuestre las capacidades de la clase Factura. */

        /** Declaracion de objetos */

        Scanner sc = new Scanner(System.in);
        Factura factura = new Factura();

        /** Declaración de variables */
        int contPiezas = 0;
        int capacidad = 100;
        int opcion;

        /** Estructura principal del programa */

        System.out.println("Desea comenzar con el ingreso de la factura?\n1. Si\n2. No");
        opcion = Integer.parseInt(sc.nextLine());
        while (opcion == 1) {
            if (contPiezas >= capacidad) {
                System.out.println("Capacidad máxima alcanzada, no es posible ingresar más productos.");
                break;
            }

            System.out.println();
            System.out.println("Comience el ingreso de productos");

            System.out.print("Ingrese el nombre del producto: ");
            factura.setNombrePieza(sc.nextLine(), contPiezas);

            System.out.print("Ingrese la descripción del producto: ");
            factura.setDescripcionPieza(sc.nextLine(), contPiezas);

            System.out.print("Ingrese el precio del producto: ");
            factura.setPrecioArticulo(sc.nextLine(), contPiezas);

            System.out.print("Ingrese la cantidad de productos a vender: ");
            factura.setCantidadCompra(sc.nextLine(), contPiezas);

            contPiezas += 1;

            System.out.println("Desea seguir con el ingreso de productos?\n1. Si\n2. No");
            opcion = Integer.parseInt(sc.nextLine());
        }

        double total = factura.obtenerMontoFactura(
                factura.getNombrePieza(),
                factura.getCantidadCompra(),
                factura.getPrecioArticulo(),
                contPiezas
        );

        System.out.println("Total a pagar: " + total);
}