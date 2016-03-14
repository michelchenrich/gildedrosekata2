package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void normalItemAgesByOne(){
        Item[] items = new Item[] { new Item("Normal", 1, 1)};
        GildedRose shop = new GildedRose(items);
        shop.updateQuality();
        assertEquals(0, items[0].sellIn);
    }

    @Test
    public void normalDecreasesQualityByOne(){
        Item[] items = new Item[] { new Item("Normal", 1, 1)};
        GildedRose shop = new GildedRose(items);
        shop.updateQuality();
        assertEquals(0, items[0].quality);
    }

}