package gildedrose;

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

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    Type getType() {
        return type;
    }

    int getSellIn() {
        return sellIn;
    }

    void setQuality(int quality) {
        this.quality = quality;
    }

    int getQuality() {
        return quality;
    }

    void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }
}