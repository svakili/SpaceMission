import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Simulation {

    public ArrayList<Item> itemArray = new ArrayList<Item>();

    public Simulation() {
        //itemArray = loadItems(fileName);
        //runSimulation();
    }

    public ArrayList<Item> loadItems (String fileName)
    {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            String fileLine;
            String[] fileLineParts;
            while (scanner.hasNextLine()) {
                fileLine = scanner.nextLine();
                fileLineParts = fileLine.split("=");
                Item it = new Item();
                it.name = fileLineParts[0];
                it.weight = Integer.parseInt(fileLineParts[1]);
                itemArray.add(it);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return itemArray;
    }

    public ArrayList<U1> loadU1 (ArrayList<Item> itemArray)
    {
        ArrayList<U1> u1List = new ArrayList<U1>();
        U1 u1 = new U1();
        u1List.add(u1);

        for (Item it : itemArray){
            if (u1.weight < u1.maxWeight)
            {
                u1.carry(it);
            }
            else
            {
                u1 = new U1();
                u1List.add(u1);
                u1.carry(it);
            }
        }

        return u1List;
    }

    public ArrayList<U2> loadU2 (ArrayList<Item> itemArray)
    {
        ArrayList<U2> u2List = new ArrayList<U2>();
        U2 u2 = new U2();
        u2List.add(u2);

        for (Item it : itemArray){
            if (u2.weight < u2.maxWeight)
            {
                u2.carry(it);
            }
            else
            {
                u2 = new U2();
                u2List.add(u2);
                u2.carry(it);
            }
        }

        return u2List;
    }

    public int runSimulation (ArrayList<Rocket> rocketList)
    {
        int totalCost = 0;

        for (Rocket rocket : rocketList)
        {
            totalCost += rocket.cost;

            while (!(rocket.launch() && rocket.land()))
            {
                totalCost += rocket.cost;
            }
        }

        return totalCost;
    }

}
