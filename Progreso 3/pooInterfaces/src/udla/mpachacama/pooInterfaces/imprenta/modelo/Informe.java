package udla.mpachacama.pooInterfaces.imprenta.modelo;

public class Informe extends Hoja implements Desplegar{
    /** Atributos de la clase */
    private String autor;
    private String revisor;

    /** Herencia del Constructor */
    public Informe(String autor, String revisor) {
        this.autor = autor;
        this.revisor = revisor;
    }

    public Informe(String autor, String revisor, String contenido) {
        super(contenido);
        this.autor = autor;
        this.revisor = revisor;
    }

    /** Herencia del metodo abstracto */
    @Override
    public String imprimir(){
        StringBuilder sb = new StringBuilder();
        sb.append("Informe escrito por: ").append(this.autor)
                .append("\nRevisado por: ").append(this.revisor).append("\n")
                .append(this.contenido);

        return sb.toString();
    }

    /** public String imprimir(){
        return "Informe escrito por: " + this.autor +
             "\nRevisado por: " + this.revisor +
             "\n" + this.contenido;
    } */


}
