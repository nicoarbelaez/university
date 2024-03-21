package optimization;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int weightCapacity;
    private List<Item> items;
    private int weight = 0;
    private int value = 0;

    public Backpack(int weightCapacity) {
        this.weightCapacity = weightCapacity;
        this.items = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        if (isSafeToAdd(item)) {
            items.add(item);
            value += item.getValue();
            weight += item.getWeight();
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        if (items.remove(item)) {
            value -= item.getValue();
            weight -= item.getWeight();
            return true;
        }
        return false;
    }

    public boolean exists(Item item) {
        return items.contains(item);
    }

    public Backpack clone() {
        Backpack backpack = new Backpack(weightCapacity);
        backpack.items = new ArrayList<>(items);
        backpack.weight = weight;
        backpack.value = value;
        return backpack;
    }

    private boolean isSafeToAdd(Item item) {
        return weight + item.getWeight() <= weightCapacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Backpack:{\n\tweightCapacity=").append(weightCapacity).append("\n\titems:\n");
        for (Item item : items) {
            sb.append("\t\t").append(item).append("\n");
        }
        sb.append("\tvalue=").append(value).append("\n");
        sb.append("\twight=").append(weight).append("\n}");

        return sb.toString();
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
