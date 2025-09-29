public class Automovil {
    String marca;
    String modelo;
    String color = "Blanco";
    double cilindraje;

    public Automovil() {
    }

    public Automovil(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Automovil(String marca, double cilindraje, String color, String modelo) {
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.modelo = modelo;
    }

    public void detalle(){
        String modelo = "AUDI";
        System.out.println("marca : " + this.marca);
        System.out.println("modelo : " + this.modelo);
        System.out.println("color : " + this.color);
        System.out.println("cilindraje : " + this.cilindraje);
    }
}
