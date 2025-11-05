import java.util.Scanner;

public class Main {
    /** Declaracion de las propiedades */
    public static void main(String[] args) {


        // Creaciòn de Objetos
        Automovil auto2 = new Automovil("BMW","i320", 3.6);


        // Asignar valores a los atributos
        /*
        auto1.marca = "BMW";
        auto1.modelo = "i320";
        auto1.color = "Negro";
        auto1.cilindraje = 3.2;
         */


        System.out.print("Ingrese color del auto:");
        Scanner sc = new Scanner(System.in);
        auto2.color = sc.nextLine();


        String color = auto2.detalle(auto2.color);
        System.out.println(color);


        // Desplegar el valor de los Objetos
        System.out.println("auto1.marca : " + auto2.marca);
        System.out.println("auto1.modelo : " + auto2.modelo);
        System.out.println("auto1.color : " + auto2.color);
        System.out.println("auto1.cilindraje : " + auto2.cilindraje);

        // Creaciòn de Objetos
        Laptop laptop1 = new Laptop();

        // Asignar valores a los atributos
        laptop1.marca = "DELL";
        laptop1.modelo = "11330";
        laptop1.color = "Negro";
        laptop1.procesador = "Intel 11th i7 1165G7";
        laptop1.tamanio = "15 Pulgadas";

        // Desplegar el valor de los Objetos
        System.out.println("laptop1.marca : " + laptop1.marca);
        System.out.println("laptop1.modelo : " + laptop1.modelo);
        System.out.println("laptop1.color : " + laptop1.color);
        System.out.println("laptop1.procesador : " + laptop1.procesador);
        System.out.println("laptop1.tamanio: " + laptop1.tamanio);
    }
}