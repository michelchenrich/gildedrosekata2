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
            switch (item.type) {
                case NORMAL: {
                    if (item.sellIn == 0)
                        item.quality -= 2;
                    else
                        item.quality -= 1;
                    item.quality = max(item.quality, 0);
                    break;
                }
                case TICKET: {
                    if (item.sellIn == 0)
                        item.quality = 0;
                    else if (item.sellIn > 10)
                        item.quality += 1;
                    else if (item.sellIn > 5)
                        item.quality += 2;
                    else
                        item.quality += 3;
                    item.quality = min(item.quality, 50);
                    break;
                }
                case AGED: {
                    if (item.sellIn == 0)
                        item.quality += 2;
                    else
                        item.quality += 1;
                    item.quality = min(item.quality, 50);
                    break;
                }
            }

            if (item.sellIn > 0)
                item.sellIn -= 1;

        }
    }
}