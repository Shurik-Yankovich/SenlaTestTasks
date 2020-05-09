package Task_6;

public class Thing {

    private int weight;
    private double cost;
    private int name;

    public Thing(int name, int weight, double cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Вещь %d: [вес = %d, стоимость = %f]", name, weight, cost);
    }
}
