class Planet extends Cosmic_body {
    private int satellite;
    private int period;

    public Planet(String name, int distance_to_sun, double diameter, double weight, int satellite, int period) {
        super(name, distance_to_sun, diameter, weight);
        this.satellite = satellite;
        this.period = period;
    }

    public int getSatellite() {
        return satellite;
    }

    public int getPeriod() {
        return period;
    }

    public void setSatellite(int s) {
        this.satellite = s;
    }

    public void setPeriod(int p) {
        this.period = p;
    }

    @Override
    public String toString() {
        return "Планета: " + super.getName() + "\nРасстояние до солнца (млн км): " + super.getDistance_to_sun() +
                "\nДиаметр: " + super.getDiameter() + "\nПериод обращения: " + this.getPeriod() +
                "\nЧисло спутников: " + this.getSatellite() + "\nМасса (10^24 кг): " + super.getWeight() + "\n\n";
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
            case ("вес"):
                super.setWeight(Double.parseDouble(v));
                break;
            case ("число спутников"):
                satellite = Integer.parseInt(v);
                break;
            case ("период обращения"):
                period = Integer.parseInt(v);
                break;
            default:
                break;
        }
    }
}
