package gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.type.equals(Type.LEGENDARY)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.type.equals(Type.NORMAL)) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            } else if (item.type.equals(Type.TICKET)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 10) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 5) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
                if (item.sellIn < 0) {
                    item.quality = item.quality - item.quality;
                }
            } else if (item.type.equals(Type.AGED)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }

            if (item.type.equals(Type.NORMAL)) {
                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }
}