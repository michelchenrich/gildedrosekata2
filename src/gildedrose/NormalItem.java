package gildedrose;

import static java.lang.Math.max;

public class NormalItem extends ExpirableItem {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        quality = quality - (sellIn == 0 ? 2 : 1);
        quality = max(quality, 0);
    }
}
