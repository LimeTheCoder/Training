package com.limethecoder.kitchen.model.entities;


import com.limethecoder.kitchen.model.Vegetable;

/**
 * Class describes common features of onions
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 *
 */
public class Onion extends Vegetable {

    /**
     * Initialize onion with default options for that kind of vegetable
     *
     * @param weight weight of onion
     */
    public Onion(double weight) {
        super(1.1, 9, 0.1, 40, weight);
    }

    @Override
    public void prepareVegetable() {
        System.out.println("Preparing onion");
    }
}
