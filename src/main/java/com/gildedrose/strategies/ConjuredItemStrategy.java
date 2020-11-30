package com.gildedrose.strategies;

import com.gildedrose.Item;

public class ConjuredItemStrategy extends ItemStrategy {

    protected void updateExpired(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }

    protected void updateItemSellIn(Item item) {
        item.sellIn -= 1;
    }

    protected void updateItemQuality(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
