package com.limethecoder.kitchen.model.entity;


/**
 * Enum describes common functionality of vegetable entities.
 *
 * @version 1.1 21 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see com.limethecoder.kitchen.model.entity.Ingredient
 */
public enum Vegetable {
    BROCCOLI(2.8, 7, 0.4, 34), CARROT(0.9, 10, 0.2, 41),
    CUCUMBER(0.6, 3.6, 0.1, 16), ONION(1.1, 9, 0.1, 40),
    POTATO(2, 17, 0.1, 77), TOMATO(0.6, 3.6, 0.1, 16);

    /** Amount of proteins in vegetable per 100 grammes */
    private double proteins;

    /** Amount of carbohydrates in vegetable per 100 grammes */
    private double carbohydrates;

    /** Amount of fats in vegetable per 100 grammes */
    private double fats;

    /** Amount of calories in vegetable per 100 grammes */
    private double calories;

    /**
     * Constructor that performs fields initialization
     *
     * @param proteins amount of proteins in vegetable per 100 grammes
     * @param carbohydrates amount of carbohydrates in vegetable per 100 grammes
     * @param fats amount of fats in vegetable per 100 grammes
     * @param calories amount of calories in vegetable per 100 grammes
     */
    Vegetable(double proteins, double carbohydrates, double fats,
                     double calories) {
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.calories = calories;
    }


    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "proteins per 100 grammes =" + proteins +
                ", carbohydrates per 100 grammes =" + carbohydrates +
                ", fats per 100 grammes =" + fats +
                ", calories per 100 grammes =" + calories +
                '}';
    }
}
