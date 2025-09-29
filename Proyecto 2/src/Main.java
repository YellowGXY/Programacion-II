public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("INFO TIGRE");
        System.out.println("");
        // Creaciòn de Objetos
        Tigre tigre1 = new Tigre();

        // Asignar valores a los atributos
        tigre1.especie = "Tigre siberiano";
        tigre1.edad = 4;
        tigre1.tamanio = "Mediano";
        tigre1.masa = 110;

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