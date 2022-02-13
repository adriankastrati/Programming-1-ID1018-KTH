public class testi {
    public static void main(String[] args) {
        String tal1 = "123";
        String tal2 = "20";
        int tal1Int = 0;
        int tal2Int = 0;
        int factorTal1 = 1;
        int factorTal2 = 1;


        for (int i = tal1.length() - 1; i >= 0; i--) {
            tal1Int += (tal1.charAt(i) - '0') * factorTal1;
            factorTal1 *= 10;
        }

        for (int i = tal2.length() - 1; i >= 0; i--) {
            tal2Int += (tal2.charAt(i) - '0') * factorTal2;
            factorTal2 *= 10;
        }


        System.out.println(summa);
    }
}
