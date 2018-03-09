public class U2 extends Rocket {

    public double explosionChance = 0.04;
    public double crashChance = 0.08;

    public U2()
    {
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
    }

    public boolean launch() {
        return !(Math.random() >= 1.0 - explosionChance * ((double)weight/maxWeight));
    }

    public boolean land() {
        return !(Math.random() >= 1.0 - crashChance * ((double)weight/maxWeight));
    }
}