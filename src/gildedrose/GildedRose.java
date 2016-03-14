package gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getType()) {
                case NORMAL: {
                    item.setQuality(item.getQuality() - (item.getSellIn() == 0 ? 2 : 1));
                    item.setQuality(max(item.getQuality(), 0));
                    break;
                }
                case TICKET: {
                    if (item.getSellIn() > 10)
                        item.setQuality(item.getQuality() + 1);
                    else if (item.getSellIn() > 5)
                        item.setQuality(item.getQuality() + 2);
                    else if (item.getSellIn() > 0)
                        item.setQuality(item.getQuality() + 3);
                    else
                        item.setQuality(0);
                    item.setQuality(min(item.getQuality(), 50));
                    break;
                }
                case AGED: {
                    item.setQuality(item.getQuality() + (item.getSellIn() == 0 ? 2 : 1));
                    item.setQuality(min(item.getQuality(), 50));
                    break;
                }
            }

            if (item.getSellIn() > 0)
                item.setSellIn(item.getSellIn() - 1);
        }
    }

}