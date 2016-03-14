package gildedrose;

public class NormalItem extends TypedItem {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality, Type.NORMAL);
    }

    public void update(){
        updateNormal();
        updateSellIn();
    }
}
