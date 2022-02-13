import java.util.*; //Scanner, Locale

class Temperaturer
{
    public static void main (String[] args)
    {
        System.out.println ("TEMPERATURER");

        // inmatningsverktyg
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        // mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print ("antalet veckor: ");
        int antalVeckor = in.nextInt();
        System.out.print ("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt();

        // plats att lagra temperaturer
        double[][] t = new double[antalVeckor + 1] [antalMatningarPerVecka + 1];

        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.println("Mata in temperaturer vecka " + vecka + ": ");

            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextInt();
        }

        // visa temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.println("Temperaturerna vecka: " + vecka);

            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.println(t[vecka][matning] + " ");
        }

        //den minsta,den största och medeltemperaturen–veckovis
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];
        double[] sumT = new double[antalVeckor + 1];
        double[] medelT = new double[antalVeckor + 1];

        System.out.println("Veckans sammanfattning");
        // koden ska skrivas här
        //visa den minsta, den största och medeltemperaturen för varje vecka
        for(int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            double minTemp = t[vecka][1];
            double maxTemp = t[vecka][1];
            double sumTemp = 0;
            double medelTemp = 0;

            for(int matning = 1; matning <= antalMatningarPerVecka; matning++)
            {
                double compTemp = t[vecka][matning];

                if (minTemp >= compTemp)
                {
                    minTemp = compTemp;
                }

                else if (maxTemp <= compTemp)
                {
                    maxTemp = compTemp;
                }

                sumTemp = sumTemp + compTemp;
            }

            medelTemp = sumTemp / antalMatningarPerVecka;

            System.out.println("Vecka " + vecka + "\nMedeltemparatur: " + medelTemp + "  |  Lägsta temperatur: "
            + minTemp + "  |  Högsta temperatur: " + maxTemp + "\n");

            maxT[vecka] = maxTemp;
            minT[vecka] = minTemp;
            sumT[vecka] = sumTemp;
            medelT[vecka] = medelTemp;
        }
        // koden ska skrivas här
        // den minsta, den största och medeltemperaturen hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double medelTemp = 0;
        // koden ska skrivas här
        // visa den minsta, den största och medeltemperaturen i helamätperioden

        for(int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            if(vecka > 1)
            {
                if (minTemp > minT[vecka]) {
                    minTemp = minT[vecka];

                } else if (maxTemp < maxT[vecka]) {
                    maxTemp = maxT[vecka];
                }

                sumTemp = sumTemp + sumT[vecka];
            }
        }

        medelTemp = sumTemp / (antalVeckor * antalMatningarPerVecka);

        System.out.println("Mätperiodens sammanfattning \n" + "Medeltemperatur: " + medelTemp + "  |  Lägsta temperatur: "
        + minTemp + "  |  Högsta temperatur: " + maxTemp);
        //koden ska skrivas här
    }
}