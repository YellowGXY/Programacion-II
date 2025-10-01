import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("");
        System.out.println("INFO TIGRE");
        System.out.println("");
        // Creaciòn de Objetos
        Tigre tigre1 = new Tigre();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese ESPECIE : ");
        tigre1.especie = br.readLine();
        System.out.println("La especie es : " + tigre1.especie);

        System.out.print("Ingrese EDAD : ");
        tigre1.edad = Integer.parseInt(br.readLine());
        System.out.println("La edad es : " + tigre1.edad);

        System.out.print("Ingrese la masa corporal : ");
        tigre1.masa = Double.parseDouble(br.readLine());
        System.out.println("La masa corporal es : " + tigre1.masa);

        tigre1.tamanio = JOptionPane.showInputDialog("Ingrese tamaño : ");
        JOptionPane.showMessageDialog(null,"El tamaño de la especie es: " + tigre1.tamanio);


        // Asignar valores a los atributos
        // tigre1.especie = "Tigre siberiano";
        // tigre1.edad = 4;
        // tigre1.tamanio = "Mediano";
        // tigre1.masa = 110;

        tigre1.detalle();

        System.out.println("");
        System.out.println("INFO LEÓN");
        System.out.println("");

        // Creaciòn de Objetos
        Leon leon1 = new Leon();

        // Asignar valores a los atributos
        leon1.especie = "Leon africano";
        leon1.edad = 6;
        leon1.tamanio = "Grande";
        leon1.masa = 190;

        leon1.detalle();

        System.out.println("");
        System.out.println("INFO PANTERA");
        System.out.println("");

        // Creaciòn de Objetos
        Pantera pantera1 = new Pantera();

        // Asignar valores a los atributos
        pantera1.especie = "Jaguar";
        pantera1.edad = 8;
        pantera1.tamanio = "Pequeño";
        pantera1.masa = 55;

        pantera1.detalle();

    }
}