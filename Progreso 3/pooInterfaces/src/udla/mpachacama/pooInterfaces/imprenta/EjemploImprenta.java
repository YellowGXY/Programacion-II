package udla.mpachacama.pooInterfaces.imprenta;
import udla.mpachacama.pooInterfaces.imprenta.modelo.*;

public class EjemploImprenta {
    static void main() {
        /** Declaracion de Objetos */
        Curriculo cv = new Curriculo("JJ", "Ing. de Software", "Resumen Laboral");
        cv.addExperiencia("Java");
        cv.addExperiencia("Oracle DBA");
        cv.addExperiencia("Spring Framework");
        cv.addExperiencia("Fullstack Developer");
        cv.addExperiencia("Angular");

        Libro libro = new Libro("Erich Gamma", "Patrones de Diseño: Elemen. Reusables de POO", Genero.PROGRAMACION);
        libro.addPagina(new Pagina("Patrón Singleton"))
                .addPagina(new Pagina("Patrón Observador"))
                .addPagina(new Pagina("Patrón Factory"))
                .addPagina(new Pagina("Composite"))
                .addPagina(new Pagina("ascade"));

        Informe informe = new Informe("JJ", "SR", "Estudio de Hoja de Vida");

        imprimir(cv);
        imprimir(informe);
        System.out.println();
        imprimir(libro);


    }

    public static void imprimir(Desplegar desplegar){
        System.out.println(desplegar.imprimir());
    }
}
