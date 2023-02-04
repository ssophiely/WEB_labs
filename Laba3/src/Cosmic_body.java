import java.util.ArrayList;

abstract class Cosmic_body {
    private static ArrayList<Cosmic_body> arr = new ArrayList<>();
    private static final int from_earth_to_sun = 150;
    private String name;
    private int distance_to_sun;
    private double diameter;
    private double weight;

    public Cosmic_body(String name, int distance_to_sun, double diameter, double weight) {
        this.name = name;
        this.distance_to_sun = distance_to_sun;
        this.diameter = diameter;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getDistance_to_sun() {
        return distance_to_sun;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setDiameter(double d) {
        this.diameter = d;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setDistance_to_sun(int d) {
        this.distance_to_sun = d;
    }

    public void setWeight(double w) {
        this.weight = w;
    }

    public void arr_push() {
        arr.add(this);
    }

    public static String theFurthest() {
        Cosmic_body o = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(i) instanceof Planet) && (arr.get(i).getDistance_to_sun() > o.getDistance_to_sun()))
                o = arr.get(i);
        }
        return "Самая далекая планета от Солнца:\n" + o.getName() + "\n";
    }

    public static String closer_than_Earth() {
        String result = "";
        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(i) instanceof Planet) && (arr.get(i).getDistance_to_sun() < Cosmic_body.from_earth_to_sun))
                result += arr.get(i).getName() + " ";
        }
        return "Планеты, которые ближе к Солнцу, чем Земля:\n" + result + "\n";
    }

    static public ArrayList<Cosmic_body> sort_array() {
        for (int j = arr.size() - 1; j > 0; j--) {
            for (int i = 0; i <= j - 1; i++) {
                if (arr.get(i).getDistance_to_sun() > arr.get(i + 1).getDistance_to_sun()) {
                    Cosmic_body s = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, s);
                }
            }
        }
        return arr;
    }

    public static Cosmic_body find(String n) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(n)) {
                return arr.get(i);
            }
        }
        return null;
    }

    public abstract void edit(String f, String v);
}
