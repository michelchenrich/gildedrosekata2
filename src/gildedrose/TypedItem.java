package gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public abstract class TypedItem implements Item {
    private String name;
    protected int sellIn;
    protected int quality;

    public TypedItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update(){
        updateQuality();
        updateSellIn();
    }

    protected abstract void updateQuality();

    protected void updateSellIn() {
        if (sellIn > 0)
            this.sellIn -= 1;
    }
}