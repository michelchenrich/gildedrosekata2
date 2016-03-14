package gildedrose;

public abstract class Item {
    protected String name;
    protected int quality;

    public Item(String name, int quality) {
        this.name = name;
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public String toString() {
        return name + ", " + quality;
    }

    public abstract void update();
}