public class Tigre {
    String especie;
    int edad;
    String tamanio;
    double masa;

    public void detalle(){
        for (int i = 1 ; i <= 1 ; i++){
            System.out.println("tigre" + i + ".especie : " + especie);
            System.out.println("tigre" + i + ".edad : " + edad + " años");
            System.out.println("tigre" + i + ".tamanio : " + tamanio);
            System.out.println("tigre" + i + ".masa : " + masa + " Kg");
        }

    }
}
