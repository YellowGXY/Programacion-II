import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Declaracion de Objetos*/
        Proveedor vendor1 = new Proveedor();
        Scanner sc = new Scanner(System.in);

        /** Lectura de datos*/
        String dp, ruc, rs, dir;
        System.out.print("Proveedor RUC: ");
        ruc = sc.nextLine();
        System.out.println();
        System.out.print("Proveedor Razon: ");
        rs = sc.nextLine();
        System.out.println();
        System.out.print("Proveedor Direccion: ");
        dir = sc.nextLine();
        System.out.println();
        dp = vendor1.detalleProveedor(ruc,rs,dir);
        System.out.println("Los datos del proveedor ");
        vendor1.Despliegue(dp);
    }
}