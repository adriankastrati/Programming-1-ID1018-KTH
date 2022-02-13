import java.util.Scanner;
public class TriangelOchDessCirklar
{
    public static void main(String[] args) {
        System.out.println("Mata in triangels sidor:");

        Scanner valueAndChoiceScanner = new Scanner(System.in);

        System.out.println("Mata in längden på sida a:");
        double sideA = valueAndChoiceScanner.nextDouble();

        System.out.println("Mata in längden på sida b:");
        double sideB = valueAndChoiceScanner.nextDouble();

        System.out.println("Mata in längden på sida c:");
        double sideC = valueAndChoiceScanner.nextDouble();

        System.out.println("Mata in storleken på vinkeln i grader mellan sida sida a och b:");
        double degreeAB = valueAndChoiceScanner.nextDouble();

        System.out.println("Mata in storleken på vinkeln i grader mellan sida sida b och c:");
        double degreeBC = valueAndChoiceScanner.nextDouble();

        System.out.println("Mata in storleken på vinkeln i grader mellan sida sida a och c:");
        double degreeAC = valueAndChoiceScanner.nextDouble();


        for (; ;) {
            System.out.println("\n\nMata in: \n" + "'1' för radie av den inskrivna cirkeln\n" + "'2' för radien av den " +
                    "omskrivna cirkeln\n" + "'3' för bisektris \n" + "'4' för median\n" + "'5' för att avsluta");

            int methodChoice = valueAndChoiceScanner.nextInt();

            if (methodChoice == 1)
                System.out.println("\n\nLängden på den radien av inskrivna cirkeln = " + Triangel.radieInskrivenCirkel(sideA, sideB, sideC));

            else if (methodChoice == 2)
                System.out.println("\n\nLängden på den radien av omskrivna cirkeln = " + Triangel.radieOmskrivenCirkel(sideA, sideB, sideC));

            else if (methodChoice == 3)
            {
                    System.out.println("\n\nMata in: \n" + "'1' för bisektris mellan sida a och b \n" + "'2' för bisektris" +
                    " mellan sida b och c + \n" + "'3' för bisektris mellan a och c\n" + "'4' Gå till föregående alternativ");
                    int choiceBis = valueAndChoiceScanner.nextInt();

                    if (choiceBis == 1)
                        System.out.println("\n\nLängden på bisektrisen från hörnet AB = " + Triangel.bisektris(sideA, sideB, degreeAB));

                    else if (choiceBis == 2)
                        System.out.println("\n\nLängden på bisektrisen från hörnet BC = " + Triangel.bisektris(sideB, sideC, degreeBC));

                    else if (choiceBis == 3)
                        System.out.println("\n\nLängden på bisektrisen från hörnet AC = " + Triangel.bisektris(sideA, sideC, degreeAC));

                    else if (choiceBis == 4);


            }

            else if(methodChoice == 4)
            {
                 System.out.println("\n\nMata in: \n" + "'1' för median på sida A \n" + "'2' för median på sida B\n" +
                 "'3' för median på sida C\n" + "'4' Gå till föregående alternativ");
                 int choiceMedian = valueAndChoiceScanner.nextInt();

                 if (choiceMedian == 1)
                     System.out.println("\n\nMedian för sida A = " + Triangel.medianABC(sideA, sideB, sideC, choiceMedian));

                 else if(choiceMedian == 2)
                     System.out.println("\n\nMedian för sida B = " + Triangel.medianABC(sideA, sideB, sideC, choiceMedian));

                 else if(choiceMedian == 3)
                    System.out.println("\n\nMedian för sida C = " + Triangel.medianABC(sideA, sideB, sideC, choiceMedian));
            }

            else if(methodChoice == 5)
            {
                System.out.println("avslutar program...\n\n");
                break;
            }
        }
        valueAndChoiceScanner.close();
    }
}