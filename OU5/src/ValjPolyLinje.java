
import java.util.Random;
class ValjPolyLinje {
    public static final Random rand = new Random();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main(String[] args) {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];

        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            polylinjer[i] = slumpPolylinje();
        }
        // visa polylinjerna
        for(int i = 0; i < ANTAL_POLYLINJER; i++){
           System.out.println(polylinjer[i].toString());
        }
        // bestäm den kortaste av de polylinjer som är gula
        Polylinje[] yellowPolyline = new Polylinje[1];
        for(int i = 0; i < ANTAL_POLYLINJER; i++) {
            if(polylinjer[i].getFarg() == "yellow" ){
               if(yellowPolyline[0] == null)
                   yellowPolyline[0] = polylinjer[i];
               else if (yellowPolyline[0].langd() > polylinjer[i].langd())
                   yellowPolyline[0] = polylinjer[i];
            }
        }

        // visa den valda polylinjen }
        if(yellowPolyline[0] == null)
            System.out.println("No yellow polyline");

        else
            System.out.println(yellowPolyline[0].toString());

    }
    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
    // det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt () {
        String n = "" + (char) (65 + rand.nextInt (26));
        int x = rand.nextInt (11);
        int y = rand.nextInt (11);
        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje () {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int antalHorn = 2 + rand.nextInt (7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];

        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        char valtChar = 0;
        while (antalValdaHorn < antalHorn)
        {
            valdPunkt = slumpPunkt();
            valtChar = valdPunkt.getNamn().charAt(0);
            if(!valdaNamn[valtChar - 65]){
               polylinje.laggTill(valdPunkt);
               valdaNamn[valtChar - 65] = true;
                antalValdaHorn++;
            }
        }
        // sätt färg
        String[] color = {"yellow", "blue", "red"};
        String randCol = color[rand.nextInt(3)];
        polylinje.setFarg(randCol);

        return polylinje;
    }
}

