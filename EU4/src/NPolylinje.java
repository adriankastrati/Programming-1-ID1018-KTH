import java.util.Iterator;

public class NPolylinje implements Polylinje {
    private static class Node {
        public Punkt corner;
        public Node nextNode;

        public Node(Punkt corner){
            this.corner = corner;
            nextNode = null;
        }
    }

    private Node firstCorner;
    private String color = "svart";
    private int width = 1; //pixlar

    public NPolylinje() {
        this.firstCorner = null;
    }


    NPolylinje(Punkt[] listCorners) {
        if (listCorners.length > 0) {
            Node node = new Node(new Punkt(listCorners[0]));
            firstCorner = node;
            int pos = 1;

            while (pos < listCorners.length) {
                node.nextNode = new Node(new Punkt(listCorners[pos++]));
                node = node.nextNode;
            }
        }
    }

    public Punkt[] getCorners() {
        int amountNodes = 0;
        Node node = this.firstCorner;

        if (node != null) {
            amountNodes = 1;
            while (node.nextNode != null) {
                node = node.nextNode;
                amountNodes++;
            }
        }

        Punkt[] pointList = new Punkt[amountNodes];
        node = this.firstCorner;

        for(int listPos = 0; node != null; listPos++){
            pointList[listPos] = node.corner;
            node = node.nextNode;
        }

        return pointList;
    }

    public String getColor () {
        return this.color;
    }

    public int getWidth () {
        return this.width;
    }

    public double length () {
        double dist = 0;
        int amountNodes = 0;
        Node node = this.firstCorner;

        if (node != null) {
            amountNodes = 1;
            while (node.nextNode != null) {
                node = node.nextNode;
                amountNodes++;
            }
        }

        Punkt[] pointList = new Punkt[amountNodes];
        node = this.firstCorner;

        for(int listPos = 0; node != null; listPos++){
            pointList[listPos] = node.corner;
            node = node.nextNode;
        }

        for(int i = 0; i < pointList.length - 1; i++){
            dist += pointList[i].avstand(pointList[i+1]);
        }
        return dist;
    }

    public void setColor (String color){
        this.color = color;
    }

    public void setWidth (int width){
        this.width = width;
    }

    public void putIn (Punkt corner){
        Node node = this.firstCorner;
        if (node != null) {
            while (node.nextNode != null) {
                node = node.nextNode;
            }
        }
        node.nextNode = new Node(corner);
    }


    public void putInFront (Punkt corner, String cornerName){
        Node node = this.firstCorner;
        boolean nodePlaced = false;

        while (node.nextNode != null) {
            if (node.corner.getName() == cornerName) {
                Node tempNextNode = node.nextNode;
                node.nextNode = new Node(corner);

                node = node.nextNode;
                nodePlaced = true;

                node.nextNode = tempNextNode;
            }
            node = node.nextNode;
        }

        if (nodePlaced == false){
            node.nextNode = new Node(corner);
            node = node.nextNode;
        }

    }

    public void remove (String cornerName){
        Node node = this.firstCorner;

        if(node.corner.getName() == cornerName) {
            this.firstCorner = node.nextNode;
        }

        while (node.nextNode != null) {
            if (node.nextNode.corner.getName() == cornerName) {
                Node removedNode = node.nextNode;

                node.nextNode = removedNode.nextNode;
            }
            if(node.nextNode == null)
                break;

            node = node.nextNode;
        }
    }

    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("{");
       Node node = this.firstCorner;
        if(node != null){
            strB.append("[");
            while(node != null){
                strB.append("(");
                strB.append(node.corner.getName() + " " +  node.corner.getX() +
                " " + node.corner.getY());
                strB.append(")");
                node = node.nextNode;
            }
            strB.append("]");
        }
        strB.append("}");
        return strB.toString();
    }

    public java.util.Iterator <Punkt> iterator (){
        Iterator<Punkt> NPolylinjeIterator = new Iterator<Punkt>(){
            Node itNode = firstCorner;

            public Punkt next(){
                Node node = itNode;
                itNode = node.nextNode;

                return itNode.corner;
            }

            public boolean hasNext(){
                if(itNode.nextNode == null) {
                    System.out.println("End of iteration");
                    return false;
                }

                else
                    return true;
            }
        };
        return NPolylinjeIterator;
    }

}




