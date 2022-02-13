public class Polylinje {

    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje() {
        this.horn = new Punkt[0];
    }

    public Polylinje(Punkt[] horn) {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt(horn[i]);
    }

    public String toString(){
        StringBuilder StrB = new StringBuilder();
        StrB.append("{");
        if (horn.length > 0) {
            StrB.append("[");

            for (int i = 0; i < horn.length; i++) {
                StrB.append("(");
                //dubbelkolla det under med william sen
                StrB.append(horn[i].getNamn() + " " + horn[i].getX() + " " + horn[i].getY());
                StrB.append(")");
                if(i == horn.length - 1)
                    continue;
                StrB.append(", ");
            }
            StrB.append("]");
        }
       StrB.append(", " + farg + ", " + bredd + "}");

        return StrB.toString();
    }

    public Punkt[] getHorn() {
        Punkt[] newPunktList = new Punkt[horn.length];

        for(int pos = 0; pos < horn.length; pos++) {
            newPunktList[pos] = horn[pos];
        }
        return newPunktList;
    }

    public String getFarg() {
        return farg;
    }

    public int getBredd() {
        return bredd;
    }

    public void setFarg(String newFarg) {
        farg = newFarg;
    }

    public void setBredd(int bredd){
        this.bredd = bredd;
    }

    public double langd() {
        double dist = 0;
        for(int i = 0; i < horn.length - 1; i++){
            dist += horn[i].avstand(horn[i+1]);
        }

        return dist;
    }

    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (; i < this.horn.length; i++)
            h[i] = this.horn[i];

        h[i] = new Punkt(horn);

        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) {
      Punkt[] newPolylinje = new Punkt[this.horn.length + 1];

       for(int punktPos = 0, changePos = 0; punktPos < this.horn.length; punktPos++, changePos++){
           newPolylinje[changePos] = this.horn[punktPos];

           if(this.horn[punktPos].getNamn() == hornNamn){
               changePos++;
               newPolylinje[changePos] = horn;
           }
       }
        this.horn = newPolylinje;
    }

    public void taBort (String hornNamn){
        Punkt[] newPunkt = new Punkt[this.horn.length - 1];

        for(int oldPos = 0, newPos = 0; oldPos < horn.length; oldPos++){

            if(this.horn[oldPos].getNamn() == hornNamn){
                continue;
            }
            newPunkt[newPos] = horn[oldPos];
            newPos++;
        }
        this.horn = newPunkt;
    }

    public class PolylinjeIterator {
        private int aktuell = -1;

        public PolylinjeIterator() {
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;
        }

        public boolean finnsHorn() {
            return aktuell != -1;
        }

        public Punkt horn() throws java.util.NoSuchElementException {
            if (!this.finnsHorn())
                throw new java.util.NoSuchElementException("slut av iterationen");

            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }

        public void gaFram() {
            if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }

}

