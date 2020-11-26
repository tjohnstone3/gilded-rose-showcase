package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateOneItem(item);
        }
    }

    private void updateOneItem(Item item) {
        updateItemQuality(item);

        updateItemSellIn(item);

        if (hasExpired(item)) {
            updateExpired(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            incrementQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            incrementQuality(item);
            if (item.sellIn < 11) {
                incrementQuality(item);
            }
            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        } else if (item.name.equals(SULFURAS)) {
        } else decrementQuality(item);
    }

    private void updateItemSellIn(Item item) {
        if (item.name.equals(SULFURAS)) {
        } else {
            item.sellIn -= 1;
        }
    }

    private void updateExpired(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            incrementQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else if (item.name.equals(SULFURAS)) {
        } else {
            decrementQuality(item);
        }
    }

    private void decrementQuality(Item item) {
        if (isItemQualityBelowZero(item)) {
            item.quality -= 1;
        }
    }

    private void incrementQuality(Item item) {
        if (isItemQualityBelowMax(item)) {
            item.quality += 1;
        }
    }

    private boolean isItemQualityBelowZero(Item item) {
        return item.quality > 0;
    }

    private boolean isItemQualityBelowMax(Item item) {
        return item.quality < 50;
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

}
