package udla.mpachacama.pooInterfaces.imprenta.modelo;

public class Pagina extends Hoja implements Desplegar{
    public Pagina(String contenido) {
        super(contenido);
    }

    @Override
    public String imprimir() {
        return this.contenido;
    }


}
