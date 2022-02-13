import java.lang.Math;

public class Triangel {
    public static double bisektris(double var1, double var2, double alfa)
    {

        double p = 2 * var1 * var2 * Math.cos(alfa / 2);
        double bis = p / (var1 + var2);

        return bis;
    }

    public static double areaBaseHeight(double base, double height)
    {
        double area = (base * height) / 2;

        return area;
    }

    public static double areaThreeSides(double sideA, double sideB, double sideC)
    {
        double semiperimiter = (sideA + sideB + sideC) / 2;
        double area = Math.sqrt(semiperimiter * (semiperimiter - sideA) * (semiperimiter - sideB) * (semiperimiter - sideC));

        return area;
    }

    public static double circumfrence(double sideA, double sideB, double sideC)
    {
        double circumfrence = sideA + sideB + sideC;

        return circumfrence;
    }

    public static double medianABC(double sideA, double sideB, double sideC, int choice)
    {
        if (choice == 1)
        {
            double aMedian = Math.sqrt((2 * Math.pow(sideB, 2)) + (2 * Math.pow(sideC, 2)) - Math.pow(sideA, 2)) / 2;
            return aMedian;
        }
        else if (choice == 2)
        {
            double bMedian = Math.sqrt((2 * Math.pow(sideA, 2)) + (2 * Math.pow(sideC, 2)) - Math.pow(sideB, 2)) / 2;
            return bMedian;

        }
        else if (choice == 3)
        {
            double cMedian = Math.sqrt((2 * Math.pow(sideA, 2)) + (2 * Math.pow(sideB, 2)) - Math.pow(sideC, 2)) / 2;
            return cMedian;
        }

        else
            System.out.println("Fel inmatningsalternativ");
            return 0;
    }

    public static double radieOmskrivenCirkel(double sideA, double sideB, double sideC)
    {
        double circumfrence = sideA + sideB + sideC;
        double semiperimiter = circumfrence / 2;


        double radius = (sideA * sideB * sideC) / (4 * Math.sqrt(semiperimiter * (semiperimiter - sideA) *
        (semiperimiter- sideB) * (semiperimiter - sideC)));

        return radius;
    }

    public static double radieInskrivenCirkel(double sideA, double sideB, double sideC)
    {
        double circumfrence = sideA + sideB + sideC;
        double semiperimiter = circumfrence / 2;

        double radius = Math.sqrt(((semiperimiter - sideA) * (semiperimiter - sideB) * (semiperimiter - sideC)) /
        semiperimiter);

        return radius;
    }
}
