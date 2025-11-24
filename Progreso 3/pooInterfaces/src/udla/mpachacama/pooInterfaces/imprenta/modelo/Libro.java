package udla.mpachacama.pooInterfaces.imprenta.modelo;
import java.util.ArrayList;
import java.util.List;

public class Libro implements Desplegar{
    private List<Desplegar> paginas;
    public String autor;
    public String titulo;
    public Genero genero;

    public Libro(String autor, String titulo, Genero genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = new ArrayList<Desplegar>();
    }

    public Libro addPagina(Desplegar pagina){
        paginas.add(pagina);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título : ").append(this.titulo).append("\n")
                .append("Autor  : ").append(this.autor).append("\n")
                .append("Género : ").append(this.genero).append("\n");
        for(Desplegar pag : this.paginas){
            sb.append(" - ").append(pag.imprimir()).append("\n");
        }
        return sb.toString();
    }
}
