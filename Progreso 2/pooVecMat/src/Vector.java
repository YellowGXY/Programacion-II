void main() {
    int[] num = new int[5];
    int i;
    num[0] = 9;
    num[1] = 2;
    //num[1] = Integer.valueOf("2");
    num[2] = 8;
    num[3] = 3;
    //num[3] = (int) 3L;
    num[4] = 7;

    System.out.println("Vector datos numéricos");
    for (i = 0; i<4 ; i++){
        System.out.println("Numero [" + i + "] : " + num[i]);
    }
    System.out.println();
    System.out.println("Vector datos numéricos 2");
    for (i = num.length-1; i>=0 ; i--){
        System.out.println("Numero [" + i + "] : " + num[i]);
    }

    System.out.println();
    Arrays.sort(num);
    System.out.println("Vector datos numéricos ordenado");
    for (i = 0; i<4 ; i++){
        System.out.println("Numero [" + i + "] : " + num[i]);
    }


}
