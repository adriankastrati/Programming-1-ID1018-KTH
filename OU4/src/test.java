import java.util.*;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;

public class test {
    public static void main(String[] args) {
        String tal1 = "1000000";
        String tal2 = "999999";

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

        System.out.println(tal1 + "|" + tal2);

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
/*
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
            System.out.println("Counter:  " + counter + "\n" + "difference:  " + difference + "\n" + "Bas:  " + (base + 1)+ "\n" + "carry:  " + loan +
            "\n------------");

            difference = Integer.toString(counter) + difference;
        }

        while(difference.startsWith("0")) {
            difference = difference.substring(1);
        }
        */


        String sum = "";
        int counter;
        int carry = 0;

        for(int base = tal1.length() - 1; base >= 0; base--){

            counter = tal1Arr[base] + tal2Arr[base] + carry;
            carry = 0;

            if(counter >= 10) {
                carry = 1;
                counter -= 10;
            }

                sum = Integer.toString(counter) + sum;
                System.out.println("Counter:  " + counter + "\n" + "Summa:  " + sum + "\n" + "Bas:  " + (base + 1)+ "\n" + "carry:  " + carry +
                        "\n------------");
        }

    }
}

