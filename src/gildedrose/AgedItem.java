package gildedrose;

import static java.lang.Math.min;

public class AgedItem extends ExpirableItem {
    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        quality += (sellIn == 0 ? 2 : 1);
        quality = min(quality, 50);
    }
}
