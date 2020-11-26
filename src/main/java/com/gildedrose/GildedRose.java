package com.gildedrose;

import com.gildedrose.strategies.AgedBrieStrategy;
import com.gildedrose.strategies.BackstagePassStrategy;
import com.gildedrose.strategies.ItemStrategy;
import com.gildedrose.strategies.SulfurasStrategy;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategy strategy = chooseStrategy(item);
            strategy.updateOneItem(item);
        }
    }

    private ItemStrategy chooseStrategy(Item item) {
        if (item.name.equals(ItemConstants.SULFURAS)) {
            return new SulfurasStrategy();
        }
        if (item.name.equals(ItemConstants.BACKSTAGE_PASSES)) {
            return new BackstagePassStrategy();
        }
        if (item.name.equals(ItemConstants.AGED_BRIE)) {
            return new AgedBrieStrategy();
        }
        return new ItemStrategy();
    }

}
