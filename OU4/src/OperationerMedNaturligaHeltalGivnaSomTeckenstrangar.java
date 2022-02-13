import java.util.*; // Scanner
import static java.lang.Integer.parseInt;
import static java.lang.System.out;


public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {

    public static void main(String[] args) {
        out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

        // mata in två naturliga heltal
        Scanner in = new Scanner(System.in);
        out.println("två naturliga heltal:");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println();

        // addera heltalen och visa resultatet
        String summa = addera(tal1, tal2);
        visa(tal1, tal2, summa, '+');

        // subtrahera heltalen och visa resultatet
        // koden här

        String differens = subtrahera(tal1, tal2);
        visa(tal1, tal2, differens, '-');
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar derassumma som en teckensträng.
    public static String addera(String tal1, String tal2) {
        // koden ska skrivas här

        if (tal1.length() < tal2.length()){
            while(tal1.length() < tal2.length()) {
                tal1 = "0" + tal1;
            }
        }

        else if (tal1.length() > tal2.length()){
            while (tal1.length() > tal2.length()) {
                tal2 = "0" + tal2;
            }
        }

        char[] tal1Char = tal1.toCharArray();
        char[] tal2Char = tal2.toCharArray();

        int[] tal1Arr = new int[tal1.length()];
        for(int i = 0; i < tal1.length(); i++){
            tal1Arr[i] = tal1Char[i] - '0';
        }

        int[] tal2Arr = new int[tal2.length()];
        for (int i = 0; i < tal2.length(); i++) {
            tal2Arr[i] = tal2Char[i] - '0';
        }

        String sum = "";
        int counter;
        int carry = 0;

        for (int base = tal1.length() - 1; base >= 0; base--) {

            counter = tal1Arr[base] + tal2Arr[base] + carry;
            carry = 0;

            if (counter >= 10) {
                carry = 1;
                counter -= 10;
            }
            sum = Integer.toString(counter) + sum;
        }

        return sum;
    }
        // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerarderas differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera(String tal1, String tal2){
        // koden ska skrivas här
        if(tal1.length() < tal2.length()){
            while(tal1.length() < tal2.length()){
                tal1 = "0" + tal1;
            }
        }

        else if(tal1.length() > tal2.length()){
            while(tal1.length() > tal2.length()){
                tal2 = "0" + tal2;
            }
        }

        char[] tal1Char = tal1.toCharArray();
        char[] tal2Char = tal2.toCharArray();

        int[] tal1Arr =  new int[tal1.length()];
        for(int i = 0; i < tal1.length(); i++) {
            tal1Arr[i] = tal1Char[i] - '0';
        }

        int[] tal2Arr =  new int [tal2.length()];
        for(int i = 0; i < tal2.length(); i++) {
            tal2Arr[i] = tal2Char[i] - '0';
        }

        int counter;
        int loan = 0;

        String difference = "";

        for(int base = tal1.length() - 1; base >= 0; base--){
            counter = (tal1Arr[base] + loan) - tal2Arr[base];
            loan = 0;

            if(counter < 0){
                loan = - 1;
                counter += 10;
            }

            difference = Integer.toString(counter) + difference;
        }

        while(difference.startsWith("0")) {
            difference = difference.substring(1);
        }

        return difference;
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation utförd i samband med hetalen
    public static void visa(String tal1, String tal2, String resultat, char operator) {
        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length();
        int len2 = tal2.length();
        int len = resultat.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        tal1 = sattLen(tal1, maxLen - len1);
        tal2 = sattLen(tal2, maxLen - len2);
        resultat = sattLen(resultat, maxLen - len);

        // visa heltalen och resultatet
        out.println ("  " + tal1);
        out.println("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print("-");
        out.println();
        out.println("  " + resultat + "\n");
    }

    //sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen(String s, int antal) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < antal; i++)
            sb.insert(0, " ");
        return sb.toString();
    }
}
