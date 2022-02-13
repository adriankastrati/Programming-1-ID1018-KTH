public class PolylinjeTest extends Polylinje{
    public static void main(String[] args) {
         Polylinje pol1 = new Polylinje(new Punkt[]{
                new Punkt("A", 1, 2),
                new Punkt("B", 3, 0),
                new Punkt("C", 5, 4),
        });

        String name = pol1.toString();
        System.out.println("Name: " + name);

        String farg = pol1.getFarg();
        System.out.println("Färg: " + farg);

        pol1.setFarg("Blue");
        farg = pol1.getFarg();
        System.out.println("Färg: " + farg);

        int width = pol1.getBredd();
        System.out.println("Bredd: " + width);

        pol1.setBredd(3);
        width = pol1.getBredd();
        System.out.println("Bredd: " + width);

        System.out.println("längd: " + pol1.langd());

       pol1.laggTill(new Punkt("G", 4, 2));
       System.out.println("längd: " + pol1.langd());


        pol1.laggTillFramfor(new Punkt("F", 4, 6), "B");
        System.out.println("längd: " + pol1.langd());


       pol1.taBort("B");
        System.out.println("längd: " + pol1.langd());


        Polylinje.PolylinjeIterator iterator = pol1.new PolylinjeIterator();

        for(int i = 0; i < pol1.langd(); i++){
            System.out.println("Iteration: " + i + "  Punkt: "+ iterator.horn().getNamn());
            iterator.gaFram();
        }

    }
}


