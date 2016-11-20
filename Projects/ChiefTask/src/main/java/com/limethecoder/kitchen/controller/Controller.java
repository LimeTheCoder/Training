package com.limethecoder.kitchen.controller;

import com.limethecoder.kitchen.model.factory.VegetarianRestaurant;
import com.limethecoder.kitchen.model.salad.VegetarianDish;
import com.limethecoder.kitchen.model.vegetable.SortOrder;
import com.limethecoder.kitchen.model.vegetable.Vegetable;
import com.limethecoder.kitchen.view.View;

import java.util.List;

/**
 * Part of MVC pattern that accepts input and converts it
 * into commands for the Model or View.
 *
 * @version 1.0 29 Oct 2016
 * @author Taras Sakharchuk
 */
public class Controller {
    /** Restaurant that represents factory for salad entities */
    private VegetarianRestaurant restaurant;
    /** view, to display information for user */
    private View view;

    /**
     * Initialize controller with given arguments
     *
     * @param restaurant model
     * @param view view, to display information for user
     */
    public Controller(VegetarianRestaurant restaurant, View view) {
        this.restaurant = restaurant;
        this.view = view;
    }

    /**
     * Demonstrate work with {@link #restaurant}
     */
    public void process() {
        VegetarianDish dish = restaurant.orderDish(restaurant.getMenu()[2]);

        view.printMessage(View.INGREDIENTS);
        view.printList(dish.getIngredients());

        dish.sortIngredients(SortOrder.DESCENDING);
        view.printMessage(View.SORTED_INGREDIENTS);
        view.printList(dish.getIngredients());

        view.printMessage(View.TOTAL_CALORIES);
        view.printMessage(String.valueOf(dish.getTotalCalories()));

        List<Vegetable> lst = dish.findByCalories(10, 50);
        view.printRangeMessage(10, 50);
        view.printList(lst);
    }
}
