package com.gildedrose.strategies;

import com.gildedrose.Item;

public class BackstagePassStrategy extends ItemStrategy {

    protected void updateExpired(Item item) {
        item.quality = 0;
    }

    protected void updateItemQuality(Item item) {
        incrementQuality(item);
        if (item.sellIn <= 10) {
            incrementQuality(item);
        }
        if (item.sellIn <= 5) {
            incrementQuality(item);
        }
    }
}
