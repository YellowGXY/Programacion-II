import javax.swing.*;

public class Factura {
    /** Generacion de atributos */
    private String[] nombrePieza;
    private String[] descripcionPieza;
    private int[] cantidadCompra;
    private Double[] precioArticulo;

    /** Generacion de constructores */

    public Factura() { /** Constructor con límite*/
    int capacidad = 100;
    this.nombrePieza = new String[capacidad];
    this.descripcionPieza = new String[capacidad];
    this.cantidadCompra = new int[capacidad];
    this.precioArticulo = new Double[capacidad];
    }

    public Factura(String[] nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public Factura(String[] nombrePieza, String[] descripcionPieza) {
        this.nombrePieza = nombrePieza;
        this.descripcionPieza = descripcionPieza;
    }

    public Factura(String[] nombrePieza, String[] descripcionPieza, int[] cantidadCompra) {
        this.nombrePieza = nombrePieza;
        this.descripcionPieza = descripcionPieza;
        this.cantidadCompra = cantidadCompra;
    }

    public Factura(String[] nombrePieza, int[] cantidadCompra, String[] descripcionPieza, Double[] precioArticulo) {
        this.nombrePieza = nombrePieza;
        this.cantidadCompra = cantidadCompra;
        this.descripcionPieza = descripcionPieza;
        this.precioArticulo = precioArticulo;
    }

    /** Metodos de JAVA */

    public String[] getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza, int cont) {
        JOptionPane.showMessageDialog(null, "El nombre asignado es: "+ nombrePieza);
        this.nombrePieza[cont] = nombrePieza;
    }

    public String[] getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza, int cont) {
        JOptionPane.showMessageDialog(null, "La descripción asignada a la pieza es: "+ descripcionPieza);
        this.descripcionPieza[cont] = descripcionPieza;
    }

    public int[] getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(String cantidadCompra, int cont) {
        JOptionPane.showMessageDialog(null, "La cantidad de compra asignada es: "+ cantidadCompra);
        int val = Integer.parseInt(cantidadCompra);
        this.cantidadCompra[cont] = Math.max(0, val);
    }

    public Double[] getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(String precioArticulo, int cont) {
        JOptionPane.showMessageDialog(null, "El precio asignado es: "+ precioArticulo);
        double val = Double.parseDouble(precioArticulo);
        this.precioArticulo[cont] = Math.max(0.0, val);
    }

    /** Metodos propios */

    public double obtenerMontoFactura(String[] nombrePieza,
                                    int[] cantidadCompra, Double[] precioArticulo, int contProd){
        double precioFinal = 0;
        System.out.println("  | " + " Nombre " + " | " + " Cantidad " + " | " + " Precio ");
        for (int i = 0; i<contProd; i++){
            int cant = Math.max(0, cantidadCompra[i]);
            double precio = Math.max(0.0, precioArticulo[i]);
            System.out.println(i+1 + " | " + nombrePieza[i] + " | " + cant + " | " + precio);
            precioFinal = precioFinal + (cant * precio);
        }
        return precioFinal;
    }
}
