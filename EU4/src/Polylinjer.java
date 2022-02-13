class Polylinjer{
    public static Polylinje polylinjeShortYellow(Polylinje[] polylinjer) {

        Polylinje[] shortestYellowPolyline = new Polylinje[1];

        for(int i = 0; i < polylinjer.length; i++) {

            if(polylinjer[i].getColor() == "yellow" ){
                if(shortestYellowPolyline[0] == null)
                    shortestYellowPolyline[0] = polylinjer[i];

                else if (shortestYellowPolyline[0].length() > polylinjer[i].length())
                    shortestYellowPolyline[0] = polylinjer[i];
            }
        }
        return shortestYellowPolyline[0];
    }
}