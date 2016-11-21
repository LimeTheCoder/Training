package com.limethecoder.kitchen.model.salad;

import com.limethecoder.kitchen.model.vegetable.Vegetable;

import java.util.Objects;


/**
 * Ingredient is building part of salad class.
 *
 * @version 1.1 21 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see Salad
 */
public class Ingredient {
    /** Default weight of vegetable */
    private static final double DEFAULT_WEIGHT = 100.0;

    /** Weight of vegetable in grammes(g) */
    private double weight;

    /** Vegetable that current ingredient object describes */
    private Vegetable vegetable;


    /**
     * Constructor that performs fields initialization
     *
     * @param weight weight of vegetable in grammes(g)
     * @param vegetable vegetable, that current ingredient object describes
     */
    public Ingredient(Vegetable vegetable, double weight) {
        Objects.requireNonNull(vegetable);

        this.vegetable = vegetable;
        this.weight = weight;
    }

    public Ingredient(Vegetable vegetable) {
        this(vegetable, DEFAULT_WEIGHT);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        Objects.requireNonNull(vegetable);
        this.vegetable = vegetable;
    }

    /**
     * Returns total amount of calories in vegetable
     *
     * @return total amount of calories in vegetable
     */
    public double getTotalCalories() {
        return vegetable.getCalories() / DEFAULT_WEIGHT * weight;
    }
}
