package gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    private Item[] items = new Item[1];


    private GildedRoseTest givenItem(String name, int sellIn, int quality) {
        items[0] = new Item(name, sellIn, quality);
        return this;
    }

    private GildedRoseTest afterUpdatingShop() {
        GildedRose shop = new GildedRose(items);
        shop.updateQuality();
        return this;
    }

    private GildedRoseTest sellInShouldBe(int sellIn) {
        assertEquals(sellIn, items[0].sellIn);
        return this;
    }

    private GildedRoseTest qualityShouldBe(int quality) {
        assertEquals(quality, items[0].quality);
        return this;
    }

    @Test
    public void sellInDecreasesByOne() {
        givenItem("Normal", 1, 1).afterUpdatingShop().sellInShouldBe(0);
        givenItem("Aged Brie", 1, 0).afterUpdatingShop().sellInShouldBe(0);
    }

    @Ignore
    @Test
    public void sellInDoesNotBecomeNegative() {
        givenItem("Normal", 0, 1).afterUpdatingShop().sellInShouldBe(0);
        givenItem("Aged Brie", 0, 50).afterUpdatingShop().sellInShouldBe(0);
    }

    @Test
    public void normalDecreasesQualityByOne() {
        givenItem("Normal", 1, 1).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void expiredNormalDecreasesQualityByTwo() {
        givenItem("Normal", 0, 2).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void normalQualityDoesNotBecomeNegative() {
        givenItem("Normal", 1, 0).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void agedIncreasesQualityByOne() {
        givenItem("Aged Brie", 1, 49).afterUpdatingShop().qualityShouldBe(50);
    }

    @Test
    public void expiredAgedIncreasesQualityByTwo() {
        givenItem("Aged Brie", 0, 0).afterUpdatingShop().qualityShouldBe(2);
    }

    @Test
    public void agedQualityMaxesAtFifty() {
        givenItem("Aged Brie", 1, 50).afterUpdatingShop().qualityShouldBe(50);
    }
}