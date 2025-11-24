import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * ═══════════════════════════════════════════════════════════════════════════════
 *                     UTILIDADES 
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * Clase de utilidades universales para usar en cualquier proyecto Java.
 */
public class Utilidades {
    
    private static Scanner scanner = new Scanner(System.in);
    
    // ═══════════════════════════════════════════════════════════════════
    //          LECTURA DE DATOS CON VALIDACIÓN (LO MÁS IMPORTANTE)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Lee texto del usuario.
     * Uso: String nombre = Utilidades.leerTexto("Nombre: ");
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    /**
     * Lee texto NO VACÍO (campo obligatorio).
     * Uso: String cedula = Utilidades.leerTextoObligatorio("Cédula: ");
     */
    public static String leerTextoObligatorio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("✗ Este campo es obligatorio.");
        }
    }
    
    /**
     * Lee un número entero con validación.
     * Si el usuario pone letras, vuelve a pedir el número.
     * Uso: int edad = leerEntero("Edad: ");
     */
    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("✗ Debe ingresar un número entero válido.");
            }
        }
    }
    
    /**
     * Lee un entero entre min y max (para menús y opciones).
     * Uso: int opcion = leerEnteroEnRango("Opción (1-5): ", 1, 5);
     */
    public static int leerEnteroEnRango(String mensaje, int min, int max) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor >= min && valor <= max) {
                return valor;
            }
            System.out.println("✗ El número debe estar entre " + min + " y " + max + ".");
        }
    }
    
    /**
     * Lee un entero POSITIVO (mayor que 0).
     * Uso: int cantidad = leerEnteroPositivo("Cantidad: ");
     */
    public static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("✗ El número debe ser mayor que 0.");
        }
    }
    
    /**
     * Lee un número decimal (double) con validación.
     * Uso: double precio = leerDecimal("Precio: $");
     */
    public static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = Double.parseDouble(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("✗ Debe ingresar un número decimal válido.");
            }
        }
    }
    
    /**
     * Lee un decimal POSITIVO (mayor que 0).
     * Uso: double salario = leerDecimalPositivo("Salario: $");
     */
    public static double leerDecimalPositivo(String mensaje) {
        while (true) {
            double valor = leerDecimal(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("✗ El número debe ser mayor que 0.");
        }
    }
    
    /**
     * Lee una decimal en un rango específico.
     * Uso: double nota = leerDecimalEnRango("Nota (0-10): ", 0, 10);
     */
    public static double leerDecimalEnRango(String mensaje, double min, double max) {
        while (true) {
            double valor = leerDecimal(mensaje);
            if (valor >= min && valor <= max) {
                return valor;
            }
            System.out.println("✗ El número debe estar entre " + min + " y " + max + ".");
        }
    }
    
    /**
     * Lee respuesta Sí/No (acepta: s, si, n, no).
     * Uso: boolean continuar = leerSiNo("¿Continuar? (s/n): ");
     */
    public static boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("si")) {
                return true;
            } else if (respuesta.equals("n") || respuesta.equals("no")) {
                return false;
            }
            System.out.println("✗ Responda 's' o 'n'.");
        }
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                        VALIDACIONES COMUNES
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Valida si un email tiene formato válido (básico: tiene @ y punto).
     * Uso: if (esEmailValido(email)) { ... }
     */
    public static boolean esEmailValido(String email) {
        if (email == null || email.isEmpty()) return false;
        return email.contains("@") && email.indexOf("@") < email.lastIndexOf(".");
    }
    
    /**
     * Valida si un número es positivo.
     * Uso: if (esPositivo(precio)) { ... }
     */
    public static boolean esPositivo(double numero) {
        return numero > 0;
    }
    
    /**
     * Valida si un número está en un rango.
     * Uso: if (estaEnRango(nota, 0, 10)) { ... }
     */
    public static boolean estaEnRango(double numero, double min, double max) {
        return numero >= min && numero <= max;
    }
    
    /**
     * Valida si un texto contiene solo letras y espacios.
     * Uso: if (soloLetras(nombre)) { ... }
     */
    public static boolean soloLetras(String texto) {
        if (texto == null || texto.isEmpty()) return false;
        return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    
    /**
     * Valida si un texto contiene solo números.
     * Uso: if (soloNumeros(cedula)) { ... }
     */
    public static boolean soloNumeros(String texto) {
        if (texto == null || texto.isEmpty()) return false;
        return texto.matches("\\d+");
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                    FORMATEO DE TEXTO (MUY ÚTIL)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Convierte texto a MAYÚSCULAS.
     * Uso: String codigo = aMayusculas("abc");  // "ABC"
     */
    public static String aMayusculas(String texto) {
        return texto == null ? "" : texto.toUpperCase();
    }
    
    /**
     * Convierte texto a minúsculas.
     * Uso: String email = aMinusculas("USER@MAIL.COM");
     */
    public static String aMinusculas(String texto) {
        return texto == null ? "" : texto.toLowerCase();
    }
    
    /**
     * Capitaliza texto (Primera letra mayúscula, resto minúsculas).
     * Uso: String nombre = capitalizar("JUAN");  // "Juan"
     */
    public static String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }
    
    /**
     * Capitaliza CADA PALABRA de un texto.
     * Uso: String nombre = capitalizarPalabras("juan pérez");  // "Juan Pérez"
     */
    public static String capitalizarPalabras(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        String[] palabras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabras.length; i++) {
            if (!palabras[i].isEmpty()) {
                resultado.append(capitalizar(palabras[i]));
                if (i < palabras.length - 1) resultado.append(" ");
            }
        }
        return resultado.toString();
    }
    
    /**
     * Formatea número como dinero con 2 decimales.
     * Uso: String precio = formatearDinero(150.5);  // "150.50"
     */
    public static String formatearDinero(double cantidad) {
        return String.format("%.2f", cantidad);
    }
    
    /**
     * Redondea un número a N decimales.
     * Uso: double nota = redondear(8.567, 2);  // 8.57
     */
    public static double redondear(double numero, int decimales) {
        double factor = Math.pow(10, decimales);
        return Math.round(numero * factor) / factor;
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                    CÁLCULOS MATEMÁTICOS COMUNES
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Calcula el promedio de números en una lista.
     * Uso: double promedio = calcularPromedio(listaNotas);
     */
    public static double calcularPromedio(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) return 0.0;
        double suma = 0;
        for (int i = 0; i < numeros.size(); i++) {
            suma += numeros.get(i);
        }
        return suma / numeros.size();
    }
    
    /**
     * Calcula el promedio de números en un array.
     * Uso: double[] notas = {8.5, 9.0, 7.5};
     *      double promedio = calcularPromedioArray(notas);
     */
    public static double calcularPromedioArray(double[] numeros) {
        if (numeros == null || numeros.length == 0) return 0.0;
        double suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        return suma / numeros.length;
    }
    
    /**
     * Encuentra el número MÁXIMO en una lista.
     * Uso: double maximo = encontrarMaximo(listaPrecios);
     */
    public static double encontrarMaximo(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) return 0.0;
        double maximo = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) > maximo) {
                maximo = numeros.get(i);
            }
        }
        return maximo;
    }
    
    /**
     * Encuentra el número MÍNIMO en una lista.
     * Uso: double minimo = encontrarMinimo(listaPrecios);
     */
    public static double encontrarMinimo(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) return 0.0;
        double minimo = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) < minimo) {
                minimo = numeros.get(i);
            }
        }
        return minimo;
    }
    
    /**
     * Calcula el porcentaje de un número.
     * Uso: double descuento = calcularPorcentaje(100, 15);  // 15.0 (15% de 100)
     */
    public static double calcularPorcentaje(double cantidad, double porcentaje) {
        return (cantidad * porcentaje) / 100;
    }
    
    /**
     * Aplica un descuento a un precio.
     * Uso: double precioFinal = aplicarDescuento(100, 20);  // 80.0 (20% de descuento)
     */
    public static double aplicarDescuento(double precio, double porcentajeDescuento) {
        return precio - calcularPorcentaje(precio, porcentajeDescuento);
    }
    
    /**
     * Calcula el IVA de un precio.
     * Uso: double iva = calcularIVA(100, 12);  // 12.0 (IVA del 12%)
     */
    public static double calcularIVA(double precio, double porcentajeIVA) {
        return calcularPorcentaje(precio, porcentajeIVA);
    }
    
    /**
     * Calcula el precio total con IVA incluido.
     * Uso: double total = precioConIVA(100, 12);  // 112.0
     */
    public static double precioConIVA(double precio, double porcentajeIVA) {
        return precio + calcularIVA(precio, porcentajeIVA);
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                 IMPRESIÓN Y FORMATO DE CONSOLA
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Imprime una línea separadora.
     * Uso: imprimirSeparador(50);
     */
    public static void imprimirSeparador(int ancho) {
        for (int i = 0; i < ancho; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    
    /**
     * Imprime un título centrado con bordes.
     * Uso: imprimirTitulo("MENÚ PRINCIPAL", 50);
     */
    public static void imprimirTitulo(String titulo, int ancho) {
        imprimirSeparador(ancho);
        int espacios = (ancho - titulo.length()) / 2;
        for (int i = 0; i < espacios; i++) {
            System.out.print(" ");
        }
        System.out.println(titulo);
        imprimirSeparador(ancho);
    }
    
    /**
     * Pausa hasta que el usuario presione Enter.
     * Uso: pausar();
     */
    public static void pausar() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Limpia la pantalla (imprime líneas en blanco).
     * Uso: limpiarPantalla();
     */
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    /**
     * Imprime un mensaje de éxito con símbolo ✓.
     * Uso: mensajeExito("Registro guardado correctamente");
     */
    public static void mensajeExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }
    
    /**
     * Imprime un mensaje de error con símbolo ✗.
     * Uso: mensajeError("No se encontró el registro");
     */
    public static void mensajeError(String mensaje) {
        System.out.println("✗ " + mensaje);
    }
    
    /**
     * Imprime un mensaje de advertencia con símbolo ⚠.
     * Uso: mensajeAdvertencia("El stock está bajo");
     */
    public static void mensajeAdvertencia(String mensaje) {
        System.out.println("⚠ " + mensaje);
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                    UTILIDADES PARA LISTAS/ARRAYS
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Verifica si una lista está vacía o es null.
     * Uso: if (listaVacia(estudiantes)) { ... }
     */
    public static boolean listaVacia(List<?> lista) {
        return lista == null || lista.isEmpty();
    }
    
    /**
     * Convierte un array de enteros a lista.
     * Uso: int[] numeros = {1, 2, 3};
     *      List<Integer> lista = arrayALista(numeros);
     */
    public static List<Integer> arrayALista(int[] array) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            lista.add(array[i]);
        }
        return lista;
    }
    
    /**
     * Busca un elemento en un array de Strings.
     * Uso: boolean existe = buscarEnArray(nombres, "Juan");
     */
    public static boolean buscarEnArray(String[] array, String elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Cuenta cuántas veces aparece un elemento en un array.
     * Uso: int cantidad = contarEnArray(numeros, 5);
     */
    public static int contarEnArray(int[] array, int elemento) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                contador++;
            }
        }
        return contador;
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                        UTILIDADES MISCELÁNEAS
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Genera un número aleatorio entre min y max (incluidos).
     * Uso: int dado = numeroAleatorio(1, 6);
     */
    public static int numeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
    /**
     * Genera un número aleatorio decimal entre min y max.
     * Uso: double temperatura =            decimalAleatorio(20.0, 30.0);
     */
    public static double decimalAleatorio(double min, double max) {
        return min + (Math.random() * (max - min));
    }
    
    /**
     * Repite un carácter N veces.
     * Uso: String linea = repetir('-', 40);  // "----------------------------------------"
     */
    public static String repetir(char caracter, int veces) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            resultado.append(caracter);
        }
        return resultado.toString();
    }
    
    /**
     * Repite un texto N veces.
     * Uso: String texto = repetirTexto("Hola ", 3);  // "Hola Hola Hola "
     */
    public static String repetirTexto(String texto, int veces) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            resultado.append(texto);
        }
        return resultado.toString();
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //              ORDENAMIENTO DE ARRAYS (MUY ÚTIL EN EXÁMENES)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Ordena un array de enteros de MENOR A MAYOR (Método Burbuja).
     * Modifica el array original.
     * Uso: int[] numeros = {5, 2, 8, 1};
     *      ordenarArrayAscendente(numeros);  // [1, 2, 5, 8]
     */
    public static void ordenarArrayAscendente(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Ordena un array de enteros de MAYOR A MENOR.
     * Modifica el array original.
     * Uso: int[] numeros = {5, 2, 8, 1};
     *      ordenarArrayDescendente(numeros);  // [8, 5, 2, 1]
     */
    public static void ordenarArrayDescendente(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    // Intercambiar
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Ordena un array de decimales de MENOR A MAYOR.
     * Modifica el array original.
     * Uso: double[] precios = {15.5, 8.2, 22.1};
     *      ordenarArrayDecimalesAscendente(precios);
     */
    public static void ordenarArrayDecimalesAscendente(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Ordena un array de Strings alfabéticamente (A-Z).
     * Modifica el array original.
     * Uso: String[] nombres = {"Carlos", "Ana", "Beatriz"};
     *      ordenarArrayStrings(nombres);  // [Ana, Beatriz, Carlos]
     */
    public static void ordenarArrayStrings(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                 BÚSQUEDA EN ARRAYS (IMPORTANTE)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Busca un número en un array y devuelve su POSICIÓN (índice).
     * Devuelve -1 si no lo encuentra.
     * Uso: int[] numeros = {10, 20, 30, 40};
     *      int pos = buscarPosicionEnArray(numeros, 30);  // 2
     */
    public static int buscarPosicionEnArray(int[] array, int elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                return i;
            }
        }
        return -1;  // No encontrado
    }
    
    /**
     * Busca un texto en un array de Strings y devuelve su posición.
     * Devuelve -1 si no lo encuentra.
     * Uso: String[] nombres = {"Juan", "María", "Pedro"};
     *      int pos = buscarPosicionString(nombres, "María");  // 1
     */
    public static int buscarPosicionString(String[] array, String elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(elemento)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Cuenta cuántos números PARES hay en un array.
     * Uso: int[] numeros = {1, 2, 3, 4, 5, 6};
     *      int pares = contarPares(numeros);  // 3
     */
    public static int contarPares(int[] array) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Cuenta cuántos números IMPARES hay en un array.
     * Uso: int[] numeros = {1, 2, 3, 4, 5, 6};
     *      int impares = contarImpares(numeros);  // 3
     */
    public static int contarImpares(int[] array) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Cuenta cuántos números POSITIVOS hay en un array.
     * Uso: int[] numeros = {-5, 3, -2, 8, 0};
     *      int positivos = contarPositivos(numeros);  // 2
     */
    public static int contarPositivos(int[] array) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Cuenta cuántos números NEGATIVOS hay en un array.
     * Uso: int[] numeros = {-5, 3, -2, 8, 0};
     *      int negativos = contarNegativos(numeros);  // 2
     */
    public static int contarNegativos(int[] array) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                contador++;
            }
        }
        return contador;
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //              OPERACIONES CON ARRAYS (COPIAR, INVERTIR)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Copia un array de enteros (crea uno nuevo con los mismos valores).
     * Uso: int[] original = {1, 2, 3};
     *      int[] copia = copiarArray(original);
     */
    public static int[] copiarArray(int[] array) {
        int[] copia = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copia[i] = array[i];
        }
        return copia;
    }
    
    /**
     * Invierte un array (modifica el original).
     * Uso: int[] numeros = {1, 2, 3, 4};
     *      invertirArray(numeros);  // [4, 3, 2, 1]
     */
    public static void invertirArray(int[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            int temp = array[inicio];
            array[inicio] = array[fin];
            array[fin] = temp;
            inicio++;
            fin--;
        }
    }
    
    /**
     * Invierte un array de Strings.
     * Uso: String[] nombres = {"Ana", "Luis", "Carlos"};
     *      invertirArrayStrings(nombres);  // ["Carlos", "Luis", "Ana"]
     */
    public static void invertirArrayStrings(String[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            String temp = array[inicio];
            array[inicio] = array[fin];
            array[fin] = temp;
            inicio++;
            fin--;
        }
    }
    
    /**
     * Suma todos los elementos de un array.
     * Uso: int[] numeros = {10, 20, 30};
     *      int total = sumarArray(numeros);  // 60
     */
    public static int sumarArray(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }
    
    /**
     * Suma todos los elementos de un array de decimales.
     * Uso: double[] precios = {10.5, 20.3, 15.2};
     *      double total = sumarArrayDecimales(precios);
     */
    public static double sumarArrayDecimales(double[] array) {
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                    MATRICES (ARREGLOS 2D)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Imprime una matriz de enteros en formato tabla.
     * Uso: int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
     *      imprimirMatriz(matriz);
     */
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    /**
     * Suma todos los elementos de una matriz.
     * Uso: int[][] matriz = {{1, 2}, {3, 4}};
     *      int total = sumarMatriz(matriz);  // 10
     */
    public static int sumarMatriz(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }
    
    /**
     * Encuentra el valor máximo en una matriz.
     * Uso: int[][] matriz = {{5, 2}, {9, 1}};
     *      int max = maximoMatriz(matriz);  // 9
     */
    public static int maximoMatriz(int[][] matriz) {
        int maximo = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                }
            }
        }
        return maximo;
    }
    
    /**
     * Encuentra el valor mínimo en una matriz.
     * Uso: int[][] matriz = {{5, 2}, {9, 1}};
     *      int min = minimoMatriz(matriz);  // 1
     */
    public static int minimoMatriz(int[][] matriz) {
        int minimo = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < minimo) {
                    minimo = matriz[i][j];
                }
            }
        }
        return minimo;
    }
    
    /**
     * Transpone una matriz (intercambia filas por columnas).
     * Uso: int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
     *      int[][] transpuesta = transponerMatriz(matriz);
     */
    public static int[][] transponerMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //              MANIPULACIÓN DE CADENAS (STRINGS)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Invierte un texto.
     * Uso: String texto = invertirTexto("Hola");  // "aloH"
     */
    public static String invertirTexto(String texto) {
        StringBuilder invertido = new StringBuilder(texto);
        return invertido.reverse().toString();
    }
    
    /**
     * Verifica si un texto es un PALÍNDROMO (se lee igual al derecho y al revés).
     * Ignora mayúsculas/minúsculas y espacios.
     * Uso: boolean es = esPalindromo("Anita lava la tina");  // true
     */
    public static boolean esPalindromo(String texto) {
        texto = texto.replaceAll(" ", "").toLowerCase();
        String invertido = invertirTexto(texto);
        return texto.equals(invertido);
    }
    
    /**
     * Cuenta cuántas vocales tiene un texto.
     * Uso: int cantidad = contarVocales("Hola Mundo");  // 4
     */
    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú') {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Cuenta cuántas consonantes tiene un texto.
     * Uso: int cantidad = contarConsonantes("Hola");  // 2
     */
    public static int contarConsonantes(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c) && 
                !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                  c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú')) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Cuenta cuántas palabras tiene un texto.
     * Uso: int palabras = contarPalabras("Hola mundo Java");  // 3
     */
    public static int contarPalabras(String texto) {
        texto = texto.trim();
        if (texto.isEmpty()) return 0;
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }
    
    /**
     * Elimina espacios extras (deja solo 1 espacio entre palabras).
     * Uso: String limpio = limpiarEspacios("Hola    mundo");  // "Hola mundo"
     */
    public static String limpiarEspacios(String texto) {
        return texto.trim().replaceAll("\\s+", " ");
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                  CONVERSIONES ÚTILES
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Convierte grados Celsius a Fahrenheit.
     * Uso: double f = celsiusAFahrenheit(25);  // 77.0
     */
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    
    /**
     * Convierte grados Fahrenheit a Celsius.
     * Uso: double c = fahrenheitACelsius(77);  // 25.0
     */
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
    
    /**
     * Convierte kilómetros a millas.
     * Uso: double millas = kmAMillas(10);  // 6.21
     */
    public static double kmAMillas(double kilometros) {
        return kilometros * 0.621371;
    }
    
    /**
     * Convierte millas a kilómetros.
     * Uso: double km = millasAKm(10);  // 16.09
     */
    public static double millasAKm(double millas) {
        return millas * 1.60934;
    }
    
    /**
     * Convierte metros a pies.
     * Uso: double pies = metrosAPies(10);  // 32.81
     */
    public static double metrosAPies(double metros) {
        return metros * 3.28084;
    }
    
    /**
     * Convierte kilogramos a libras.
     * Uso: double libras = kgALibras(10);  // 22.05
     */
    public static double kgALibras(double kilogramos) {
        return kilogramos * 2.20462;
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //              GENERACIÓN DE DATOS ALEATORIOS (ÚTIL PARA PRUEBAS)
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Genera una letra mayúscula aleatoria (A-Z).
     * Uso: char letra = letraAleatoria();
     */
    public static char letraAleatoria() {
        return (char) (numeroAleatorio(65, 90));  // Códigos ASCII A-Z
    }
    
    /**
     * Genera un array de números aleatorios.
     * Uso: int[] numeros = generarArrayAleatorio(5, 1, 100);
     *      // Genera 5 números entre 1 y 100
     */
    public static int[] generarArrayAleatorio(int tamaño, int min, int max) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = numeroAleatorio(min, max);
        }
        return array;
    }
    
    /**
     * Genera una cadena aleatoria de letras mayúsculas.
     * Uso: String codigo = generarCodigoAleatorio(5);  // "ABXYZ"
     */
    public static String generarCodigoAleatorio(int longitud) {
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            codigo.append(letraAleatoria());
        }
        return codigo.toString();
    }
    
    // ═══════════════════════════════════════════════════════════════════
    //                  VALIDACIONES MATEMÁTICAS
    // ═══════════════════════════════════════════════════════════════════
    
    /**
     * Verifica si un número es PAR.
     * Uso: if (esPar(4)) { ... }
     */
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
    
    /**
     * Verifica si un número es IMPAR.
     * Uso: if (esImpar(5)) { ... }
     */
    public static boolean esImpar(int numero) {
        return numero % 2 != 0;
    }
    
    /**
     * Verifica si un número es PRIMO.
     * Uso: if (esPrimo(7)) { ... }  // true
     */
    public static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Calcula el factorial de un número.
     * Uso: int fact = factorial(5);  // 120 (5! = 5*4*3*2*1)
     */
    public static long factorial(int numero) {
        if (numero < 0) return 0;
        if (numero == 0 || numero == 1) return 1;
        
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    /**
     * Calcula la potencia de un número (base^exponente).
     * Uso: double resultado = potencia(2, 3);  // 8.0 (2^3)
     */
    public static double potencia(double base, int exponente) {
        if (exponente == 0) return 1;
        if (exponente < 0) return 1.0 / potencia(base, -exponente);
        
        double resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
    
    /**
     * Calcula el máximo común divisor (MCD) de dos números.
     * Uso: int mcd = mcd(12, 8);  // 4
     */
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Calcula el mínimo común múltiplo (MCM) de dos números.
     * Uso: int mcm = mcm(12, 8);  // 24
     */
    public static int mcm(int a, int b) {
        return (a * b) / mcd(a, b);
    }
}
