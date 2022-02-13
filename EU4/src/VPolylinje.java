import java.util.Iterator;
public class VPolylinje implements Polylinje {

    private Punkt[] punktList;
    private String color = "svart";
    private int width = 1;

    public VPolylinje() {
        this.punktList = new Punkt[0];
    }

    public VPolylinje(Punkt[] punktList) {
        this.punktList = new Punkt[punktList.length];
        for (int i = 0; i < punktList.length; i++)
            this.punktList[i] = new Punkt(punktList[i]);
    }

    public Punkt[] getCorners() {
        return this.punktList;
    }

    public String getColor() {
        return this.color;
    }

    public int getWidth() {
        return this.width;
    }

    public double length() {
        double dist = 0;
        for(int i = 0; i < punktList.length - 1; i++){
            dist += punktList[i].avstand(punktList[i+1]);
        }
        return dist;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void putIn(Punkt punkt) {
        Punkt[] tempPunktList = new Punkt[punktList.length + 1];
        int i = 0;
        for (; i < punktList.length; i++) {
            tempPunktList[i] = punktList[i];
        }
        tempPunktList[i] = new Punkt(punkt);

        punktList = tempPunktList;
    }

    public void putInFront(Punkt newPunkt, String cornerName) {
       Punkt[] tempPunktList = new Punkt[this.punktList.length + 1];

        for (int tempPos = 0, oldPos = 0; oldPos < punktList.length; tempPos++, oldPos++) {
            tempPunktList[tempPos] = punktList[oldPos];
            if (cornerName == punktList[oldPos].getName()) {
                tempPos++;
                tempPunktList[tempPos] = newPunkt;
            }

        }
        punktList = tempPunktList;
    }


    public void remove(String cornerName) {
        Punkt[] tempPunktList = new Punkt[punktList.length - 1];

        for (int oldPos = 0, newPos = 0; oldPos < punktList.length; oldPos++) {
            if (punktList[oldPos].getName() == cornerName) {
                continue;
            }
            tempPunktList[newPos] = punktList[oldPos];
            newPos++;
        }
        punktList = tempPunktList;
    }

    public String toString() {
        StringBuilder strB = new StringBuilder();
        strB.append("{");
        if (punktList.length > 0) {
            strB.append("[");

            for (int i = 0; i < punktList.length; i++) {
                strB.append("(");
                strB.append(punktList[i].getName() + " " + punktList[i].getX() + " " + punktList[i].getY());
                strB.append(")");
                if (i == punktList.length - 1)
                    continue;
                strB.append(", ");
            }
            strB.append("]");
        }
        strB.append(", " + color + ", " + width + "}");

        return strB.toString();
    }

    public java.util.Iterator<Punkt> iterator (){
        Iterator<Punkt> VPolylinjeIterator = new Iterator<Punkt>() {
            private int current = 0;

            public Punkt next()throws java.lang.ArrayIndexOutOfBoundsException{
                current++;
                Punkt punkt = punktList[current];
                return punkt;
            }

            public boolean hasNext(){
                 if(punktList[current + 1] == null) {
                     System.out.println("End of iteration");
                     return false;
                 }

                 else
                     return false;
            }
        };
        return VPolylinjeIterator;
    }

}
