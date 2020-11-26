package com.gildedrose.strategies;

import com.gildedrose.Item;

public class AgedBrieStrategy extends ItemStrategy {

    protected void updateExpired(Item item) {
        incrementQuality(item);
    }

    protected void updateItemSellIn(Item item) {
        item.sellIn -= 1;
    }

    protected void updateItemQuality(Item item) {
        incrementQuality(item);
    }
}
