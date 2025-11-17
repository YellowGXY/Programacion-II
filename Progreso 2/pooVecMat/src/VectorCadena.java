import java.util.Arrays;
void main() {
    String[] cad = new String[5];
    int i;
    cad[0] = "Memoria Kingstone 64 MB";
    cad[1] = "Apple Phone 17 Pro Max";
    cad[2] = "Samsung Galaxy S24";
    cad[3] = "Notebook Pro 128 GB";
    cad[4] = "Vicicleta Oxford";

    System.out.println("Vector string normal");
    for (i = 0; i<cad.length ; i++){
        System.out.println("Producto [" + i + "] : " + cad[i]);
    }
    System.out.println();

    Arrays.sort(cad, Collections.reverseOrder());

    System.out.println("Vector string ordenado");
    for (i = 0; i<cad.length ; i++){
        System.out.println("Producto [" + i + "] : " + cad[i]);
    }
}