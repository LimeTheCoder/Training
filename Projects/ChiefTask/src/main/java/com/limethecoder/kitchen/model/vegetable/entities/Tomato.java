package com.limethecoder.kitchen.model.vegetable.entities;

import com.limethecoder.kitchen.model.vegetable.Vegetable;

/**
 * Class describes common features of tomatoes
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 *
 */
public class Tomato extends Vegetable {

    /**
     * Initialize tomato with default options for that kind of vegetable
     *
     * @param weight weight of tomato
     */
    public Tomato(double weight) {
        super(0.6, 3.6, 0.1, 16, weight);
    }

    @Override
    public void prepareVegetable() {
        System.out.println("Preparing tomato");
    }
}
