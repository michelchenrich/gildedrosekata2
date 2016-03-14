package gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    private Item[] items = new Item[1];

    private GildedRoseTest givenNormalItem(int sellIn, int quality) {
        return givenItem("Normal", sellIn, quality, Type.NORMAL);
    }

    private GildedRoseTest givenAgedItem(int sellIn, int quality) {
        return givenItem("Aged", sellIn, quality, Type.AGED);
    }

    private GildedRoseTest givenLegendaryItem(int quality) {
        return givenItem("Legendary", 0, quality, Type.LEGENDARY);
    }

    private GildedRoseTest givenTicket(int sellIn, int quality) {
        return givenItem("Ticket", sellIn, quality, Type.TICKET);
    }

    private GildedRoseTest givenItem(String name, int sellIn, int quality, Type type) {
        items[0] = new Item(name, sellIn, quality, type);
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
        givenNormalItem(1, 1).afterUpdatingShop().sellInShouldBe(0);
        givenAgedItem(1, 0).afterUpdatingShop().sellInShouldBe(0);
    }

    @Ignore
    @Test
    public void sellInDoesNotBecomeNegative() {
        givenNormalItem(0, 1).afterUpdatingShop().sellInShouldBe(0);
        givenAgedItem(0, 50).afterUpdatingShop().sellInShouldBe(0);
        givenTicket(0, 0).afterUpdatingShop().sellInShouldBe(0);
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
    public void normalQualityDoesNotBecomeNegative() {
        givenNormalItem(1, 0).afterUpdatingShop().qualityShouldBe(0);
        givenTicket(0, 0).afterUpdatingShop().qualityShouldBe(0);
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
    public void agedQualityMaxesAtFifty() {
        givenAgedItem(1, 50).afterUpdatingShop().qualityShouldBe(50);
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

    @Ignore
    @Test
    public void ticketDropsToZeroOnExpiration() {
        givenTicket(1, 10).afterUpdatingShop().qualityShouldBe(0);
    }
}