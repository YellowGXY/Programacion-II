package udla.mpachacama.pooInterfaces.imprenta.modelo;

abstract public class Hoja {
    /** Declaración de atributos*/
    protected String contenido;

    /** Constructores y Destructores */
    public Hoja() {
    }

    public Hoja(String contenido) {
        this.contenido = contenido;
    }

    /** Metodos abstractos */
    abstract public String imprimir();
}
