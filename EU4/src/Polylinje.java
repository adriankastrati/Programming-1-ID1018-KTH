public interface Polylinje extends java.lang.Iterable<Punkt> {
    Punkt[] getCorners ();

    String getColor ();

    int getWidth ();

    double length ();

    void setColor (String farg);

    void setWidth (int bredd);

    void putIn (Punkt horn);

    void putInFront (Punkt horn, String hornNamn);

    void remove (String hornNamn);

    java.util.Iterator<Punkt> iterator ();
}
