package com.limethecoder.kitchen.model.vegetable.entities;

import com.limethecoder.kitchen.model.vegetable.Vegetable;

/**
 * Class describes common features of carrot
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 *
 */
public class Carrot extends Vegetable {
    /**
     * Initialize carrot with default options for that kind of vegetable
     *
     * @param weight weight of carrot
     */
    public Carrot(double weight) {
        super(0.9, 10, 0.2, 41, weight);
    }

    @Override
    public void prepareVegetable() {
        System.out.println("Preparing carrot");
    }
}
