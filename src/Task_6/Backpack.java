package Task_6;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private int carryingCapacity;
    private List<Thing> takenThings;

    public Backpack(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
        takenThings = new ArrayList<>();
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    private double howMuchCostIs() {
        double sum = 0;
        if (!takenThings.isEmpty()) {
            for (Thing thing : takenThings) {
                sum += thing.getCost();
            }
        }
        return sum;
    }

    private int howMuchDoeItWeigh(){
        int sum = 0;
        if (!takenThings.isEmpty()) {
            for (Thing thing : takenThings) {
                sum += thing.getWeight();
            }
        }
        return sum;
    }

    private double[][] dynamicProgrammingMethod(Thing[] things) {
        int countThings = things.length;
        double[][] costsArray = new double[countThings + 1][carryingCapacity + 1];

        for (int i = 0; i <= carryingCapacity; i++) {
            costsArray[0][i] = 0;
        }
        for (int i = 1; i <= countThings; i++) {
            for (int weight = 0; weight <= carryingCapacity; weight++) {
                costsArray[i][weight] = costsArray[i - 1][weight];
                if (weight >= things[i - 1].getWeight() && (costsArray[i - 1][weight - things[i - 1].getWeight()] + things[i - 1].getCost() > costsArray[i][weight]))
                    costsArray[i][weight] = costsArray[i - 1][weight - things[i - 1].getWeight()] + things[i - 1].getCost();
            }
        }

        return costsArray;
    }

    public void fillingBackpack(Thing[] things) {
        boolean cycleExecution = true;
        int countThings = things.length;
        int weight = carryingCapacity;
        double[][] costsArray = dynamicProgrammingMethod(things);

        do {
            if (costsArray[countThings][weight] == 0)
                cycleExecution = false;
            else if (costsArray[countThings - 1][weight] == costsArray[countThings][weight])
                countThings--;
            else {
                takenThings.add(things[countThings - 1]);
                weight -= things[countThings - 1].getWeight();
                countThings--;
            }
        } while (cycleExecution);
    }

    @Override
    public String toString() {
        String print = String.format("В рюкзак вместимостью %d были положены следущие вещи общей стоимостью %f и общим весом %d:\n",
                carryingCapacity, howMuchCostIs(), howMuchDoeItWeigh());
        if (!takenThings.isEmpty()) {
            for (Thing thing : takenThings) {
                print += thing.toString() + "\n";
            }
        } else {
            print += "Никакие вещи не поместились!";
        }
        return print;
    }
}
