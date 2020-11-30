package com.gildedrose;

import com.gildedrose.strategies.*;

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
        if (item.name.equals(ItemConstants.CONJURED)) {
            return new ConjuredItemStrategy();
        }
        return new ItemStrategy();
    }

}
