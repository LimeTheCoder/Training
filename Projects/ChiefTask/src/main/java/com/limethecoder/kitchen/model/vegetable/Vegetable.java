package com.limethecoder.kitchen.model.vegetable;

import com.limethecoder.kitchen.model.salad.Salad;

/**
 * Class describes common functionality for vegetable entities.
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see Salad
 */
public abstract class Vegetable {

    /** Default weight of vegetable */
    private final static double DEFAULT_WEIGHT = 100.0;

    /** Amount of proteins in vegetable per 100 grammes */
    private double proteins;

    /** Amount of carbohydrates in vegetable per 100 grammes */
    private double carbohydrates;

    /** Amount of fats in vegetable per 100 grammes */
    private double fats;

    /** Amount of calories in vegetable per 100 grammes */
    private double calories;

    /** Weight of vegetable in grammes(g) */
    private double weight;

    /**
     * Constructor that performs fields initialization
     *
     * @param proteins amount of proteins in vegetable per 100 grammes
     * @param carbohydrates amount of carbohydrates in vegetable per 100 grammes
     * @param fats amount of fats in vegetable per 100 grammes
     * @param calories amount of calories in vegetable per 100 grammes
     * @param weight weight of vegetable in grammes
     */
    public Vegetable(double proteins, double carbohydrates, double fats,
                     double calories, double weight) {
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.calories = calories;
        this.weight = weight;
    }

    /**
     * Create vegetable object with weight
     * initialized as {@link #DEFAULT_WEIGHT}
     *
     * @param proteins amount of proteins in vegetable per 100 grammes
     * @param carbohydrates amount of carbohydrates in vegetable per 100 grammes
     * @param fats amount of fats in vegetable per 100 grammes
     * @param calories amount of calories in vegetable per 100 grammes
     */
    public Vegetable(double proteins, double carbohydrates,
                     double fats, double calories) {
        this(proteins, carbohydrates, fats, calories, DEFAULT_WEIGHT);
    }

    /**
     * Method, that need to call for preparing vegetable
     * for adding in salad
     */
    public abstract void prepareVegetable();

    /**
     * Returns total amount of calories in vegetable
     *
     * @return total amount of calories in vegetable
     */
    public double getTotalCalories() {
        return calories / DEFAULT_WEIGHT * weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vegetable vegetable = (Vegetable) o;

        if (Double.compare(vegetable.proteins, proteins) != 0) return false;
        if (Double.compare(vegetable.carbohydrates, carbohydrates) != 0) return false;
        if (Double.compare(vegetable.fats, fats) != 0) return false;
        if (Double.compare(vegetable.calories, calories) != 0) return false;
        return Double.compare(vegetable.weight, weight) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(proteins);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(carbohydrates);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fats);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(calories);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "proteins per 100 grammes =" + proteins +
                ", carbohydrates per 100 grammes =" + carbohydrates +
                ", fats per 100 grammes =" + fats +
                ", calories per 100 grammes =" + calories +
                ", weight=" + weight +
                ", total_cal=" + getTotalCalories() +
                '}';
    }
}
