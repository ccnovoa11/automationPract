package bdd.cucumber.loyalty_cards;

public class MorningFreshnessMember {
    private String name;
    private SuperSmoothieSchema schema;
    private int earnedPoints;

    public MorningFreshnessMember(String name, SuperSmoothieSchema schema) {

        this.schema = schema;
        this.name = name;
    }

    public void orders(Integer amount, String drink) {
        earnedPoints += schema.getPointsFor(drink) * amount;
    }

    public int getPoints() {
        return earnedPoints;
    }
}
