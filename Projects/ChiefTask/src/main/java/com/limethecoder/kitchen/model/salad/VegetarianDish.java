package com.limethecoder.kitchen.model.salad;


import com.limethecoder.kitchen.model.vegetable.SortOrder;
import com.limethecoder.kitchen.model.vegetable.Vegetable;

import java.util.List;
import java.util.function.Predicate;

/**
 * Class describes common features of vegetarian dish.
 * Dish contains list of ingredients.
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 */
public interface VegetarianDish {

    /**
     * Returns total amount of calories of all ingredients,
     * that dish contains
     *
     * @return total amount of calories in the vegetarian dish
     */
    double getTotalCalories();

    /**
     * Returns all ingredients, that dish contains
     *
     * @return list of ingredients
     */
    List<Vegetable> getIngredients();

    /**
     * Add new ingredient to the dish
     *
     * @param ingredient ingredient to add
     */
    void addIngredient(Vegetable ingredient);

    /**
     * Based on sort order sorts list of ingredients
     *
     * @param order sorting order
     */
    void sortIngredients(SortOrder order);

    /**
     * Filtered out all ingredients, which not in the given range of calories
     *
     * @param minCalories min possible calories in ingredient
     * @param maxCalories max possible calories in ingredient
     *
     * @return list with ingredients, that matches given input range
     */
    List<Vegetable> findByCalories(double minCalories,
                                          double maxCalories);

    /**
     * Filtered all ingredients based on given predicate
     *
     * @param predicate predicate to perform filtering
     *
     * @return list with ingredients, that matches given predicate
     */
    List<Vegetable> findByPredicate(Predicate<Vegetable> predicate);

    /**
     * Prepare all ingredients for being ready to consuming.
     */
    void prepareIngredients();
}
