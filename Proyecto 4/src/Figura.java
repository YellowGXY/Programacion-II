public class Figura {
    /** Generacion de atributos */
    private double Triangulo;
    private double Cuadrado;
    private double Circulo;

    /** Generacion de constructores */
    public Figura() {
    }

    public Figura(double triangulo) {
        Triangulo = triangulo;
    }

    public Figura(double triangulo, double cuadrado) {
        Triangulo = triangulo;
        Cuadrado = cuadrado;
    }

    public Figura(double triangulo, double cuadrado, double circulo) {
        Triangulo = triangulo;
        Cuadrado = cuadrado;
        Circulo = circulo;
    }

    /** Metodos de JAVA */
    public double getTriangulo() {

        return Triangulo;
    }

    public void setTriangulo(double triangulo) {
        Triangulo = triangulo;
    }

    public double getCuadrado() {
        return Cuadrado;
    }

    public void setCuadrado(double cuadrado) {
        Cuadrado = cuadrado;
    }

    public double getCirculo() {
        return Circulo;
    }

    public void setCirculo(double circulo) {
        Circulo = circulo;
    }

    /** Metodos propios */

}
