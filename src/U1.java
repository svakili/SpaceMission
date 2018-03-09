public class U1 extends Rocket {

    public double explosionChance = 0.05;
    public double crashChance = 0.01;

    public U1()
    {
        cost = 100;
        weight = 10000;
        maxWeight = 18000;
    }

    public boolean launch() {
        return !(Math.random() >= 1.0 - explosionChance * ((double)weight/maxWeight));
    }

    public boolean land() {
        return !(Math.random() >= 1.0 - crashChance * ((double)weight/maxWeight));
    }
}
