package gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Type type;

    public Item(String name, int sellIn, int quality) {
        this(name, sellIn, quality, null);
    }

    public Item(String name, int sellIn, int quality, Type type) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}