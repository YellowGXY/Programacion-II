import javax.swing.*;
import java.sql.SQLOutput;

public class Proveedor {
    /** Declaracion de atributos*/
    String RUC;
    String razonSocial;
    String direccion;

    public Proveedor() {
    }

    public Proveedor(String RUC) {
        this.RUC = RUC;
    }

    public Proveedor(String RUC, String razonSocial) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
    }

    public Proveedor(String RUC, String razonSocial, String direccion) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }

    /** Metodos de JAVA*/
    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /** Metodos propios*/
    public String detalleProveedor(String ruc, String rs, String dir) {
        String detcom;
        detcom = "\nEl RUC del proveedor es : " + ruc + "\nRazon Social: " + rs + " \nDirecciòn: " + dir;
        return detcom;
    }

    public void Despliegue(String data) {
        JOptionPane.showMessageDialog(null, "Datos del Proveedor: " + data);
    }
}

