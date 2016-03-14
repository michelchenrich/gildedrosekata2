package gildedrose;

import static java.lang.Math.min;

public class Ticket extends ExpirableItem {
    public Ticket(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        if (sellIn > 10)
            quality += 1;
        else if (sellIn > 5)
            quality += 2;
        else if (sellIn > 0)
            quality += 3;
        else
            quality = 0;
        quality = min(quality, 50);
    }
}
