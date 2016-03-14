package gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.type.equals(Type.LEGENDARY))
                item.sellIn = item.sellIn - 1;


            switch (item.type) {
                case NORMAL: {
                    if (item.quality > 0)
                        if (item.sellIn < 0)
                            item.quality = item.quality - 2;
                        else
                            item.quality = item.quality - 1;
                    break;
                }
                case TICKET: {
                    if (item.sellIn < 0)
                        item.quality = 0;
                    else if (item.quality < 50) {
                        if (item.sellIn < 5)
                            item.quality = item.quality + 3;
                        else if (item.sellIn < 10)
                            item.quality = item.quality + 2;
                        else
                            item.quality = item.quality + 1;
                    }
                    break;
                }
                case AGED: {
                    if (item.quality < 50)
                        if (item.sellIn < 0)
                            item.quality = item.quality + 2;
                        else
                            item.quality = item.quality + 1;
                    break;
                }
            }
        }
    }
}