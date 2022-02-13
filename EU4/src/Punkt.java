import java.lang.Math;
public class Punkt {
    private String name;
    private int x;
    private int y;

    public Punkt(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Punkt(Punkt p){
        this.name = p.getName();
        this.x = p.getX();
        this.y = p.getY();
    }

    public String getName(){
        return name;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double avstand(Punkt p){
        int k1 = Math.abs(Math.abs(x) - Math.abs(p.getX()));
        int k2 = Math.abs(Math.abs(y) - Math.abs(p.getY()));
        double distance = Math.sqrt(Math.pow(k1, 2) + Math.pow(k2, 2));
        return distance;
    }

    public boolean equals(Punkt p){
        if(p.getX() == x && p.getY() == y)
            return true;
        else
            return false;

    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
