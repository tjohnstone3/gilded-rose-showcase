package com.gildedrose.strategies;

import com.gildedrose.Item;

public class ItemStrategy {

    public void updateOneItem(Item item) {
        updateItemQuality(item);

        updateItemSellIn(item);

        if (hasExpired(item)) {
            updateExpired(item);
        }
    }

    protected void updateExpired(Item item) {
        decrementQuality(item);
    }

    protected void updateItemSellIn(Item item) {
        item.sellIn -= 1;
    }

    protected void updateItemQuality(Item item) {
        decrementQuality(item);
    }

    protected void incrementQuality(Item item) {
        if (isItemQualityBelowMax(item)) {
            item.quality += 1;
        }
    }

    protected void decrementQuality(Item item) {
        if (isItemQualityBelowZero(item)) {
            item.quality -= 1;
        }
    }

    private boolean isItemQualityBelowMax(Item item) {
        return item.quality < 50;
    }

    private boolean isItemQualityBelowZero(Item item) {
        return item.quality > 0;
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }
}
