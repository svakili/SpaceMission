import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        ArrayList<Item> ph1items = sim.loadItems("phase-1.txt");
        ArrayList<Item> ph2items = sim.loadItems("phase-2.txt");


        ArrayList<Rocket> u1all = new ArrayList<>();
        u1all.addAll(sim.loadU1(ph1items));
        u1all.addAll(sim.loadU1(ph2items));
        int u1Cost = sim.runSimulation(u1all);

        ArrayList<Rocket> u2all = new ArrayList<>();
        u2all.addAll(sim.loadU2(ph1items));
        u2all.addAll(sim.loadU2(ph2items));
        int u2Cost = sim.runSimulation(u2all);

        System.out.println("Cost of running U1 rockets is : $" + u1Cost + "M");
        System.out.println("Cost of running U2 rockets is : $" + u2Cost + "M");


    }
}
