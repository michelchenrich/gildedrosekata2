package gildedrose;

public class AgedItem extends TypedItem {
    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality, Type.AGED);
    }
}
