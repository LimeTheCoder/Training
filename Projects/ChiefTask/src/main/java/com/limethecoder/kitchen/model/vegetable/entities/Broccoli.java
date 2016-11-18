package com.limethecoder.kitchen.model.vegetable.entities;

import com.limethecoder.kitchen.model.vegetable.Vegetable;

/**
 * Class describes common features of broccoli
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 *
 */
public class Broccoli extends Vegetable {
    /**
     * Initialize broccoli with default options for that kind of vegetable
     *
     * @param weight weight of broccoli
     */
    public Broccoli(double weight) {
        super(2.8, 7, 0.4, 34, weight);
    }

    @Override
    public void prepareVegetable() {
        System.out.println("Preparing broccoli");
    }
}
