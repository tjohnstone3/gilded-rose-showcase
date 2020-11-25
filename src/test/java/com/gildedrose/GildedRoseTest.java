package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item item = createAndUpdate("foo", 0, 0);
        assertEquals("foo", item.name);
    }

    @Test
    void systemLowersValues() {
        Item item = createAndUpdate("foo", 15, 25);
        assertEquals(14, item.sellIn);
        assertEquals(24, item.quality);
    }

    @Test
    void qualityDegradesTwiceAsFastAfterSellByPasses() {
        Item item = createAndUpdate("foo", 0, 17);
        assertEquals(15, item.quality);
    }

    @Test
    void qualityIsNeverNegative() {
        Item item = createAndUpdate("foo", 0, 0);
        assertEquals(0, item.quality);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        Item item = createAndUpdate("Aged Brie", 13, 25);
        assertEquals(26, item.quality);
    }

    @Test
    void qualityNeverMoreThanFifty() {
        Item item = createAndUpdate("Aged Brie", 8, 50);
        assertEquals(50, item.quality);
    }

    @Test
    void sulfurasNeverChange() {
        Item item = createAndUpdate("Sulfuras, Hand of Ragnaros", 25, 80);
        assertEquals(25, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void backstagePassesIncraseInQuality() {
        Item item = createAndUpdate("Backstage passes to a TAFKAL80ETC concert", 25, 30);
        assertEquals(31, item.quality);
    }

    @Test
    void backstagePassesIncraseByTwo() {
        Item item = createAndUpdate("Backstage passes to a TAFKAL80ETC concert", 10, 30);
        assertEquals(32, item.quality);
    }

    @Test
    void backstagePassesIncraseByThree() {
        Item item = createAndUpdate("Backstage passes to a TAFKAL80ETC concert", 5, 30);
        assertEquals(33, item.quality);
    }

    @Test
    void backstagePassesQualityToZero() {
        Item item = createAndUpdate("Backstage passes to a TAFKAL80ETC concert", 0, 30);
        assertEquals(0, item.quality);
    }

    @Test
    void agedBrieNeverExpires() {
        Item item = createAndUpdate("Aged Brie", 0, 42);
        assertEquals(-1, item.sellIn);
        assertEquals(44, item.quality);
    }

    @Test
    void backstagePassMaxQuality() {
        Item item = createAndUpdate("Backstage passes to a TAFKAL80ETC concert", 10, 48);
        assertEquals(50, item.quality);

        item = createAndUpdate("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        assertEquals(50, item.quality);

        item = createAndUpdate("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        assertEquals(50, item.quality);
    }

    @Test
    void degradeQualityUnlessSulfuras() {
        Item item = createAndUpdate("foo", -1, 1);
        assertEquals(0, item.quality);

        item = createAndUpdate("Sulfuras, Hand of Ragnaros", -1, 1);
        assertEquals(1, item.quality);
    }

    @Test
    void agedBrieMaxQualityFifty() {
        Item item = createAndUpdate("Aged Brie", 0, 49);
        assertEquals(50, item.quality);
    }

    private Item createAndUpdate(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }

}
