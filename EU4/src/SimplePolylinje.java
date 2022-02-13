public class SimplePolylinje implements Polylinje{

    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public SimplePolylinje() {
        this.horn = new Punkt[0];
    }

    public SimplePolylinje(Punkt[] horn) {
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
        return horn;
    }



    public String getFarg() {
        return farg;
    }

    public int getBredd() {
        return bredd;
    }

    public void setFarg(String farg) {
        this.farg = farg;
    }

    public void setBredd(int bredd){
        this.bredd = bredd;
    }

    public double langd() {
        return horn.length;
    }

    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt(horn);

        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[] newPunkt = new Punkt[this.horn.length + 1];
        for(int punktPos = 0, changePos = 0; punktPos < this.horn.length; punktPos++, changePos++){

            newPunkt[changePos] = this.horn[punktPos];

            if(this.horn[punktPos].getNamn() == hornNamn){
                changePos++;
                newPunkt[changePos] = horn;
            }
        }
        this.horn = newPunkt;
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

    class PolylinjeIterator {
        private int aktuell = -1;

        public PolylinjeIterator() {
            if (Polylinje.this.horn.length > 0) aktuell = 0;
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

        public void gaFram () {
            if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }

}

