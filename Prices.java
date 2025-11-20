public enum Prices {

    BOTTLES("BOTTLES", 100),
    TAGS("TAGS", 50),
    PALLETES("PALLETES" , 15);


    private final String material;
    private final double price;

    Prices(String material, double price) {
        this.material = material;
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public static Prices fromMaterial(String material) {
        for (Prices p : Prices.values()) {
            if (p.material.equalsIgnoreCase(material)) {
                return p;
            }
        }
        return null;
    }

    public static void showPrices() {
        for (Prices p : Prices.values()) {
            System.out.println(p.getMaterial() + " → " + p.getPrice());
        }
    }



    public static double totalPrices() {
        double total = 0;

        for (Prices p : Prices.values()) {
            total += p.getPrice();
        }

        return total;
    }

}
