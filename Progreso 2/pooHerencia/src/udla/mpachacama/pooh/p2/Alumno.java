package udla.mpachacama.pooh.p2;

public class Alumno extends Persona{
    /** Atributos de la clase Alumno*/
    private double notap1;
    private double notap2;
    private double notap3;

    /** Constructores y Destructores */
    public Alumno() {
    }

    public Alumno(String nombre, String apellido, int edad, Genero genero, String materia, double notap1, double notap2, double notap3) {
        super(nombre, apellido, edad, genero);
        this.notap1 = notap1;
        this.notap2 = notap2;
        this.notap3 = notap3;
    }

    /** Metodos de Java */
    public double getNotap1() {
        return notap1;
    }

    public void setNotap1(double notap1) {
        this.notap1 = notap1;
    }

    public double getNotap2() {
        return notap2;
    }

    public void setNotap2(double notap2) {
        this.notap2 = notap2;
    }

    public double getNotap3() {
        return notap3;
    }

    public void setNotap3(double notap3) {
        this.notap3 = notap3;
    }

    /** Metodos propios */
}
