package gildedrose;

public abstract class ExpirableItem extends Item {
    protected int sellIn;

    public ExpirableItem(String name, int sellIn, int quality) {
        super(name, quality);
        this.sellIn = sellIn;
    }

    public int getSellIn() {
        return sellIn;
    }

    public String toString() {
        return super.toString() + ", " + sellIn;
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