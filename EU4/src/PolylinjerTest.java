import java.util.Iterator;
class PolylinjerTest{
    public static void main(String[] args) {
        Polylinje[] mixPolylines = new Polylinje[4];

        Polylinje vPoly1 = new VPolylinje(new Punkt[]{
                new Punkt("AV", 1, 2),
                new Punkt("CV", 5, 4),
        });

        Polylinje vPoly2 = new VPolylinje(new Punkt[]{
                new Punkt("DV", 1, 2),
                new Punkt("EV", 3, 0),
                new Punkt("FV", 5, 4),
                new Punkt("EV", 5, 4),
        });

        Polylinje nPoly1 = new NPolylinje(new Punkt[]{
                new Punkt("AN", 1, 2),
                new Punkt("BN", 3, 0),
                new Punkt("CN", 5, 4),
        });

        Polylinje nPoly2 = new NPolylinje(new Punkt[]{
                new Punkt("DN", 1, 2),
                new Punkt("EN", 3, 0),
                new Punkt("FN", 5, 4),
                new Punkt("GN", 5, 4),
                new Punkt("HN", 5, 4),
        });

    mixPolylines[0] = vPoly1;
    vPoly1.setColor("yellow");
    mixPolylines[1] = vPoly2;

    mixPolylines[2] = nPoly1;
    nPoly1.setColor("yellow");
    mixPolylines[3] = nPoly2;

    Polylinje shortYell = Polylinjer.polylinjeShortYellow(polylines);
    System.out.println(shortYell.toString());

    shortYell = Polylinjer.polylinjeShortYellow(polylines);
    System.out.println(shortYell.toString());

    shortYell = Polylinjer.polylinjeShortYellow(polylines);
    System.out.println(shortYell.toString());
    }
}
