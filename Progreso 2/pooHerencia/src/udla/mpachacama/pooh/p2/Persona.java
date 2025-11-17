package udla.mpachacama.pooh.p2;

public class Persona {
    /** Atributos de la clase */
    private String nombre;
    private String apellido;
    private int edad;
    private Genero genero;


    /** Constantes */
    public static final String CORREO = "na@dominio.com.ec";

    /** Constructores y Destructores*/
    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, Genero genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }

    /** Metodos propios de Java */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /** Metodos propios del desarrollador*/
}
