package optimization;

public class BacktrackingBackPack {
    private Backpack backpack;
    private Item[] items;
    private Backpack bestSolution;

    public BacktrackingBackPack(Backpack backpack, Item[] items) {
        this.backpack = backpack;
        this.items = items;
        bestSolution = new Backpack(backpack.getWeightCapacity());
    }

    public void solve() {
        fillBackpack(false);
    }

    public void fillBackpack(boolean full) {
        if (full) {
            if (backpack.getValue() > bestSolution.getValue()) {
                bestSolution = backpack.clone();
            }
        } else {
            for (int i = 0; i < items.length; i++) {
                if (!backpack.exists(items[i])) {
                    if (backpack.addItem(items[i])) {
                        fillBackpack(false);
                        backpack.removeItem(items[i]);
                    } else {
                        fillBackpack(true);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return bestSolution.toString();
    }
}
