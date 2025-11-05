package udla.mpachacama.pooherencia.p1;

public class Profesor extends Persona{
    /** Atributos de Profesor*/
    private String materia;

    /** Constructores y Destructores */
    public Profesor(String nombre, String apellido, int edad, String genero, String materia) {
        super(nombre, apellido, edad, genero);
        this.materia = materia;
    }
}
