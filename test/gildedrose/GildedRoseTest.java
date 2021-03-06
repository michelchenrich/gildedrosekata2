package gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    private Item item;

    private GildedRoseTest givenNormalItem(int sellIn, int quality) {
        item = new NormalItem("Normal", sellIn, quality);
        return this;
    }

    private GildedRoseTest givenAgedItem(int sellIn, int quality) {
        item = new AgedItem("Aged", sellIn, quality);
        return this;
    }

    private GildedRoseTest givenLegendaryItem(int quality) {
        item = new LegendaryItem("Legendary", quality);
        return this;
    }

    private GildedRoseTest givenTicket(int sellIn, int quality) {
        item = new Ticket("Ticket", sellIn, quality);
        return this;
    }

    private GildedRoseTest givenConjuredItem(int sellIn, int quality) {
        item = new Conjured("Conjured", sellIn, quality);
        return this;
    }

    private GildedRoseTest afterUpdatingShop() {
        GildedRose shop = new GildedRose(new Item[]{item});
        shop.updateQuality();
        return this;
    }

    private GildedRoseTest sellInShouldBe(int sellIn) {
        ExpirableItem expirable = (ExpirableItem) item;
        assertEquals(sellIn, expirable.getSellIn());
        return this;
    }

    private GildedRoseTest qualityShouldBe(int quality) {
        assertEquals(quality, item.getQuality());
        return this;
    }

    private void shouldPrint(String itemString) {
        assertEquals(itemString, item.toString());
    }

    @Test
    public void sellInDecreasesByOne() {
        givenNormalItem(1, 1).afterUpdatingShop().sellInShouldBe(0);
        givenAgedItem(1, 0).afterUpdatingShop().sellInShouldBe(0);
        givenConjuredItem(1, 1).afterUpdatingShop().sellInShouldBe(0);
    }

    @Test
    public void sellInDoesNotBecomeNegative() {
        givenNormalItem(0, 1).afterUpdatingShop().sellInShouldBe(0);
        givenAgedItem(0, 50).afterUpdatingShop().sellInShouldBe(0);
        givenTicket(0, 0).afterUpdatingShop().sellInShouldBe(0);
        givenConjuredItem(0, 1).afterUpdatingShop().sellInShouldBe(0);
    }

    @Test
    public void normalDecreasesQualityByOne() {
        givenNormalItem(1, 1).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void expiredNormalDecreasesQualityByTwo() {
        givenNormalItem(0, 2).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void qualityDoesNotBecomeNegative() {
        givenNormalItem(1, 0).afterUpdatingShop().qualityShouldBe(0);
        givenTicket(0, 0).afterUpdatingShop().qualityShouldBe(0);
        givenConjuredItem(0, 0).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void agedIncreasesQualityByOne() {
        givenAgedItem(1, 49).afterUpdatingShop().qualityShouldBe(50);
    }

    @Test
    public void expiredAgedIncreasesQualityByTwo() {
        givenAgedItem(0, 0).afterUpdatingShop().qualityShouldBe(2);
    }

    @Test
    public void qualityMaxesAtFifty() {
        givenAgedItem(1, 50).afterUpdatingShop().qualityShouldBe(50);
        givenAgedItem(0, 49).afterUpdatingShop().qualityShouldBe(50);
        givenTicket(5, 48).afterUpdatingShop().qualityShouldBe(50);
        givenTicket(10, 49).afterUpdatingShop().qualityShouldBe(50);
        givenTicket(11, 50).afterUpdatingShop().qualityShouldBe(50);
    }

    @Test
    public void legendaryQualityNeverDecreases() {
        givenLegendaryItem(30).afterUpdatingShop().qualityShouldBe(30);
    }

    @Test
    public void legendaryQualityCanBeOverFifty() {
        givenLegendaryItem(51).afterUpdatingShop().qualityShouldBe(51);
    }

    @Test
    public void ticketIncreasesQualityByOneBeforeTenDaysFromExpiration() {
        givenTicket(11, 0).afterUpdatingShop().qualityShouldBe(1);
    }

    @Test
    public void ticketIncreasesQualityByTwoTenDaysFromExpiration() {
        givenTicket(10, 0).afterUpdatingShop().qualityShouldBe(2);
    }

    @Test
    public void ticketIncreasesQualityByThreeFiveDaysFromExpiration() {
        givenTicket(5, 0).afterUpdatingShop().qualityShouldBe(3);
    }

    @Test
    public void ticketDropsToZeroAfterExpiration() {
        givenTicket(0, 10).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void conjuredDecreasesQualityByTwo() {
        givenConjuredItem(1, 2).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void expiredConjuredDecreasesQualityByFour() {
        givenConjuredItem(0, 4).afterUpdatingShop().qualityShouldBe(0);
    }

    @Test
    public void printDataToString() {
        givenNormalItem(10, 10).shouldPrint("Name: Normal, Quality: 10, Sell in: 10");
        givenAgedItem(10, 10).shouldPrint("Name: Aged, Quality: 10, Sell in: 10");
        givenTicket(10, 10).shouldPrint("Name: Ticket, Quality: 10, Sell in: 10");
        givenLegendaryItem(10).shouldPrint("Name: Legendary, Quality: 10");
    }
}