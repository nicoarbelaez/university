package optimization;

public class Optimization {

    public void run() {
        Backpack backpack = new Backpack(15);
        test(backpack);
    }

    public void test(Backpack backpack) {
        Item[] items = {
            new Item(1, 1),
            new Item(1, 2),
            new Item(2, 2),
            new Item(4, 10),
            new Item(12, 4),
        };
        itemsRandom(items);

        BacktrackingBackPack backtrackingBackPack = new BacktrackingBackPack(backpack, items);
        backtrackingBackPack.solve();
        
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println(backtrackingBackPack);
    }

    @SuppressWarnings("unused")
    private void itemsRandom(Item[] items) {
        int min = 2;
        int max = 10;
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item((int) (Math.random() * max) + min, (int) (Math.random() * max) + min);
        }
    }
}
