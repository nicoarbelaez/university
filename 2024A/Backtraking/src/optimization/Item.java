package optimization;

public class Item {
    public static int ID = 0;
    private String name;
    private int weight;
    private int value;

    public Item(int weight, int value) {
        ID++;
        this.name = "item" + ID;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
