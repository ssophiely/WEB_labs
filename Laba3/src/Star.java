class Star extends Cosmic_body {
    private double luminosity;
    private String opening_date;

    public Star(String name, int distance_to_sun, double diameter, String opening_date, double weight, double luminosity) {
        super(name, distance_to_sun, diameter, weight);
        this.luminosity = luminosity;
        this.opening_date = opening_date;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public void setLuminosity(double l) {
        luminosity = l;
    }

    public void setOpening_date(String o) {
        opening_date = o;
    }

    @Override
    public String toString() {
        return "Звезда: " + super.getName() + "\nРасстояние до солнца (млн км): " + super.getDistance_to_sun() +
                "\nДиаметр: " + super.getDiameter() + "\nМасса (10^24 кг): " +
                super.getWeight() + "\nДата открытия: " + this.opening_date + "\nСветимость (10^26 Вт): " + this.luminosity + "\n\n";
    }

    public void edit(String f, String v) {
        switch (f) {
            case ("имя"):
                super.setName(v);
                break;
            case ("расстояние до солнца"):
                super.setDistance_to_sun(Integer.parseInt(v));
                break;
            case ("диаметр"):
                super.setDiameter(Double.parseDouble(v));
                break;
            case ("дата открытия"):
                opening_date = v;
                break;
            case ("вес"):
                super.setWeight(Double.parseDouble(v));
                break;
            case ("светимость"):
                luminosity = Double.parseDouble(v);
                break;
            default:
                break;
        }
    }
}
