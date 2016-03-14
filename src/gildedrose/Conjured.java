package gildedrose;

public class Conjured implements Item {
    public Conjured(String name, int sellIn, int quality) {
    }

    @Override
    public int getQuality() {
        return 0;
    }

    @Override
    public int getSellIn() {
        return 0;
    }

    @Override
    public void update() {

    }
}
