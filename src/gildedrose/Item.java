package gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Item {
    private String name;
    private int sellIn;
    private int quality;
    private Type type;

    public Item(String name, int sellIn, int quality) {
        this(name, sellIn, quality, null);
    }

    public Item(String name, int sellIn, int quality, Type type) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateQuality() {
        switch (type) {
            case NORMAL: {
                quality = quality - (sellIn == 0 ? 2 : 1);
                quality = max(quality, 0);
                break;
            }
            case TICKET: {
                if (sellIn > 10)
                    quality += 1;
                else if (sellIn > 5)
                    quality += 2;
                else if (sellIn > 0)
                    quality += 3;
                else
                    quality = 0;
                quality = min(quality, 50);
                break;
            }
            case AGED: {
                quality += (sellIn == 0 ? 2 : 1);
                quality = min(quality, 50);
                break;
            }
        }
    }

    void updateSellIn() {
        if (sellIn > 0)
            this.sellIn -= 1;
    }
}