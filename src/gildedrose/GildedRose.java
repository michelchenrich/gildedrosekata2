package gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items)
            updateItem(item);
    }

    private void updateItem(Item item) {
        item.updateQuality();
        item.updateSellIn();
    }
}