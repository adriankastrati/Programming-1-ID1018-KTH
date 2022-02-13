import java.util.Iterator;
class NPolylinjeTest{
    public static void main(String[] args){
        Polylinje pol1 = new NPolylinje(new Punkt[]{
                new Punkt("A", 1, 2),
                new Punkt("B", 3, 0),
                new Punkt("C", 5, 4),
        });

        Punkt[] punktList;

        punktList = pol1.getCorners();

        for(int i = 0; i < punktList.length; i++) {
            System.out.println(punktList[i].getName());
        }

        pol1.putIn(new Punkt("D", 4, 2));


        punktList = pol1.getCorners();

        System.out.println();
        for(int i = 0; i < punktList.length; i++) {
            System.out.println(punktList[i].getName());
        }

        System.out.println();
        pol1.putInFront(new Punkt("E", 4, 2), "B");
        punktList = pol1.getCorners();

        for(int i = 0; i < punktList.length; i++) {
            System.out.println(punktList[i].getName());
        }

        pol1.remove("D");
        punktList = pol1.getCorners();

        System.out.println();
        for(int i = 0; i < punktList.length; i++) {
            System.out.println(punktList[i].getName());
        }

        System.out.println("Color: " + pol1.getColor());

        System.out.println("Width: " + pol1.getWidth());

        System.out.println("Length: " + pol1.length());

        pol1.setColor("White");
        System.out.println("Color: " + pol1.getColor());

        pol1.setWidth(2);
        System.out.println("Width: " + pol1.getWidth());

        System.out.println("Name: " + pol1.toString());

        pol1.iterator();
        System.out.println("Name: " + pol1.toString());



        Iterator<Punkt> it = pol1.iterator();
        System.out.println("Name: " + it.next().getName());

        for(int i = 0; i < punktList.length - 1; i ++){
            System.out.println("Name: " + it.next().getName());
            if(it.hasNext() == false)
                break;
        }


    }
}