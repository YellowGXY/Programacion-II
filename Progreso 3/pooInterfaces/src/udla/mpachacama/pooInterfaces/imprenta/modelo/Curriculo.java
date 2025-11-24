package udla.mpachacama.pooInterfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja implements Desplegar{
    /** Declaracion de atributos */
    private String persona;
    private String carrera;
    private List<String> experiencia;

    /** Contructor */
    public Curriculo(String persona, String carrera, String contenido) {
        this.persona = persona;
        this.carrera = carrera;
        super(contenido);
        this.experiencia = new ArrayList<>();
    }

    /** Importar la clase abstracta */
    /** @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.persona).append("\n")
                .append("Resumen: ").append(this.contenido).append("\n")
                .append("Profesión: ").append(this.carrera).append("\n");
        for(String exp:this.experiencia){
            sb.append("- ").append(exp).append("\n");
        }
        return sb.toString();
    } */

    public String imprimir() {
        String v;
        v = this.persona + "\nResumen: " + this.contenido + "\nProfesión: " + this.carrera + "\n";
        for(String exp:this.experiencia){
            v+= " - " + exp + "\n";
        }
        return v;
    }

    /** Metodos de la clase */
    public Curriculo addExperiencia(String exp){
        experiencia.add(exp);
        return this;
    }
}
