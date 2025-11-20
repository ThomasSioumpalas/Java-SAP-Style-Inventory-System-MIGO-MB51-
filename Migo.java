import java.util.List;

public class Migo  {

    private int id;
    private String material;
    private double ammount;
    private int date;

    public Migo(int id, String material, double ammount, int date) {
        this.id = id;
        this.material = material;
        this.ammount = ammount;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public String getMaterial() {return material;}

    public double getAmmount() {return ammount;}

    public int getDate() {return date;}


    public String toLine() {
        return "Id:" + id + "| Material: " + material + "| Ammount: " + ammount + "| Date of entry: " + date;

    }

    public String toString() {
        return toLine();
    }


        }













