package gildedrose;

public class TextBasedMain {
    public static void main(String[] arguments) {
        new GildedRosePrinter(makeItems(), getNumberOfUpdates(arguments)).run();
    }

    private static Item[] makeItems() {
        return new Item[]{
                new NormalItem("+5 Dexterity Vest", 10, 20),
                new AgedItem("Aged Brie", 2, 0),
                new NormalItem("Elixir of the Mongoose", 5, 7),
                new LegendaryItem("Sulfuras, Hand of Ragnaros", 80),
                new LegendaryItem("Sulfuras, Hand of Ragnaros", 80),
                new Ticket("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Ticket("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Ticket("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Conjured("Conjured Mana Cake", 3, 6)};
    }

    private static int getNumberOfUpdates(String[] args) {
        if (args.length > 0)
            return Integer.parseInt(args[0]) + 1;
        return 2;
    }

    private static class GildedRosePrinter {
        private Item[] items;
        private int numberOfUpdates;
        private GildedRose shop;

        public GildedRosePrinter(Item[] items, int numberOfUpdates) {
            this.items = items;
            this.shop = new GildedRose(items);
            this.numberOfUpdates = numberOfUpdates;
        }

        public void run() {
            System.out.println("Welcome to the Gilded Rose shop!");
            printUpdates();
        }

        private void printUpdates() {
            for (int updateNumber = 0; updateNumber < numberOfUpdates; updateNumber++)
                printUpdate(updateNumber);
        }

        private void printUpdate(int updateNumber) {
            System.out.println("-------- Day " + updateNumber + " --------");
            printItems();
            System.out.println();
            shop.updateQuality();
        }

        private void printItems() {
            for (Item item : items)
                System.out.println(item);
        }
    }
}