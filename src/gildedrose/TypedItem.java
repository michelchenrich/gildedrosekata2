package gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TypedItem implements Item {
    private String name;
    private int sellIn;
    private int quality;
    private Type type;

    public TypedItem(String name, int sellIn, int quality) {
        this(name, sellIn, quality, null);
    }

    public TypedItem(String name, int sellIn, int quality, Type type) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public void update() {
        switch (type) {
            case NORMAL:
                updateNormal();
                updateSellIn();
                break;
            case TICKET:
                updateTicket();
                updateSellIn();
                break;
            case AGED:
                updateAged();
                updateSellIn();
                break;
            case LEGENDARY:
                break;
        }
    }

    private void updateNormal() {
        quality = quality - (sellIn == 0 ? 2 : 1);
        quality = max(quality, 0);
    }

    private void updateTicket() {
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

    private void updateAged() {
        quality += (sellIn == 0 ? 2 : 1);
        quality = min(quality, 50);
    }

    private void updateSellIn() {
        if (sellIn > 0)
            this.sellIn -= 1;
    }
}