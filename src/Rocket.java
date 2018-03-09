public class Rocket implements SpaceShip{

    public int weight;
    public int maxWeight;
    public int cost;


    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {

        return (weight+item.weight<maxWeight);
    }

    public void carry(Item item) {
        weight += item.weight;
    }
}
