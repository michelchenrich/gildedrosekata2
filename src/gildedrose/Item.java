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
        return String.format("Name: %s, Quality: %d", name, quality);
    }

    public abstract void update();
}