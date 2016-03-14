package gildedrose;

public class Conjured extends ExpirableItem {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        quality -= sellIn == 0 ? 4 : 2;
        quality = Math.max(quality, 0);
    }
}
