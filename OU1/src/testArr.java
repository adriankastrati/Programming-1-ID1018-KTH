import java.util.*; //Scanner, Locale

class testArr {
    public static void main(String[] args) {
        System.out.println("TEMPERATURER");

        // inmatningsverktyg
        Scanner myScanner = new Scanner(System.in);
        myScanner.useLocale(Locale.US);

        int antalVeckor = 1;
        int antalMatningarVecka = 3;

        double[][] arr = new double[antalVeckor][antalMatningarVecka];


        arr[antalvecka][antalMatningarVecka] = myScanner.nextInt();


        System.out.println("temperaturerna:");

        System.out.print(arr[1][1] + " ");
    }
}