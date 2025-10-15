import javax.swing.*;
import java.util.Scanner;

void main() {
    /** 3.17 (Computarizacion de los registros médicos) Un tema relacionado con la salud
     * que ha estado ultimamente en las noticias es la computarización de los registros
     * medicos. Esta posibilidad se está tratando con mucho cuidado, debido a las delicadas
     * cuestiones de privacidad y seguridad, entre otras cosas. [Trataremos esas cuestiones
     * en ejercicios posteriores]. La computarización de los registros médicos puede facilitar
     * a los pacientes el proceso de compartir sus perfiles e historiales médicos con los
     * diversos profesionales de la salud que consulten. Esto podría mejorar la calidad del
     * servicio médico, ayudar a evitar conflictos de fármacos y prescripciones erróneas,
     * reducir los costos y, en emergencias, podría ayudar a salvar vidas. En este ejercicio
     * usted diseñará una clase “inicial” llamada PerfilMedico para una 100 Capítulo 3
     * Introducción a las clases, los objetos, los métodos y las cadenas persona. Los atributos
     * de la clase deben incluir el primer nombre de la persona, su apellido, sexo, fecha de
     * nacimiento (que debe consistir de atributos separados para el día, mes y año de nacimiento),
     * altura (en centímetros) y peso (en kilogramos). Su clase debe tener un constructor que
     * reciba estos datos. Para cada atributo, debe proveer los métodos establecer y obtener.
     * La clase también debe incluir métodos que calculen y devuelvan la edad del usuario en años,
     * la frecuencia cardiaca máxima y el rango de frecuencia cardiaca esperada (vea el ejercicio 3.16),
     * además del índice de masa corporal (BM). Escriba una aplicación de Java que pida
     * la información de la persona, cree una instancia de un objeto de la clase PerfilMedico para
     * esa persona e imprima la información de ese objeto (incluyendo el primer nombre de la persona,
     * apellido, sexo, fecha de nacimiento, altura y peso), y que después calcule e imprima la edad
     * de esa persona en años, junto con el BMI, la frecuencia cardiaca máxima y el rango de frecuencia
     * cardiaca esperada. También debe mostrar la tabla de valores del BMI VALORES DE BMI Bajo peso:
     * menos de 18.5 Normal: entre 18.5 y 24.9 Sobrepeso: entre 25 y 29.9 Obeso: 30 o más
     */

        /** Declaracion de objetos */
        PerfilMedico perfil = new PerfilMedico();
        Scanner sc = new Scanner(System.in);

        /** Declaración de variables */
        int opcion;

        /** Estructura principal del programa */
        System.out.println("Desea ingresar el perfil médico de una persona?\n1. Si\n2. No");
        opcion = Integer.parseInt(sc.nextLine());

        while (opcion == 1) {
            perfil.setPrimerNombre(JOptionPane.showInputDialog(null, "Ingrese el primer nombre: "));
            perfil.setApellido(JOptionPane.showInputDialog(null, "Ingrese el apellido: "));
            perfil.setSexo(JOptionPane.showInputDialog(null, "Ingrese el sexo (M/F): "));
            perfil.setDia(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día de nacimiento: ")));
            perfil.setMes(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de nacimiento: ")));
            perfil.setAnio(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de nacimiento: ")));
            perfil.setAltura(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la altura en cm: ")));
            perfil.setPeso(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el peso en kg: ")));

            System.out.println();
            System.out.println("PERFIL MÉDICO:");
            System.out.println("Nombre: " + perfil.getPrimerNombre() + " " + perfil.getApellido());
            System.out.println("Sexo: " + perfil.getSexo());
            System.out.println("Fecha de nacimiento: " + perfil.getDia() + "/" + perfil.getMes() + "/" + perfil.getAnio());
            System.out.println("Altura: " + perfil.getAltura() + " cm");
            System.out.println("Peso: " + perfil.getPeso() + " kg");
            System.out.println();
            System.out.println("Edad: " + perfil.calcularEdad() + " años");
            System.out.println("BMI: " + perfil.calcularBMI());
            System.out.println("Frecuencia cardiaca máxima: " + perfil.calcularFrecuenciaMaxima() + " ppm");
            perfil.calcularFrecuenciaEsperada();
            perfil.mostrarTablaBMI();

            System.out.println();
            System.out.println("Desea ingresar otro perfil médico?\n1. Si\n2. No");
            opcion = Integer.parseInt(sc.nextLine());
        }
}
