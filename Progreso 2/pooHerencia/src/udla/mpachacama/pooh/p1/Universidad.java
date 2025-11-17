import udla.mpachacama.pooh.p2.Alumno;
import udla.mpachacama.pooh.p2.Genero;
import udla.mpachacama.pooh.p2.Materia;
import udla.mpachacama.pooh.p2.Profesor;

void main() {
    Alumno alumno = new Alumno();
    Profesor profesor = new Profesor();

    alumno.setNombre("Julio");
    alumno.setApellido("Jaramillo");
    alumno.setGenero(Genero.MASCULINO);
    profesor.setMateria(Materia.ESTADISTICA);
    profesor.setGenero(Genero.MASCULINO);

}
