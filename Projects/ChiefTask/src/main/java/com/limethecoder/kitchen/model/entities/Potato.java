package com.limethecoder.kitchen.model.entities;

import com.limethecoder.kitchen.model.Vegetable;

/**
 * Class describes common features of potatoes
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 *
 */
public class Potato extends Vegetable {

    /**
     * Initialize potato with default options for that kind of vegetable
     *
     * @param weight weight of potato
     */
    public Potato(double weight) {
        super(2, 17, 0.1, 77, weight);
    }

    @Override
    public void prepareVegetable() {
        System.out.println("Preparing potato");
    }
}
