package com.limethecoder.pos.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Sale {
    private Date date;
    private Set<SalesLineItem> items = new HashSet<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addItemToSale(SalesLineItem item) {
        items.add(item);
    }

    public Set<SalesLineItem> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return items
                .stream()
                .mapToInt(SalesLineItem::getTotalPrice)
                .sum();
    }
}
