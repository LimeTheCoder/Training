package com.limethecoder.kitchen.model.factory;


import com.limethecoder.kitchen.model.factory.greek.GreekRestaurant;
import com.limethecoder.kitchen.model.factory.russian.RussianRestaurant;
import com.limethecoder.kitchen.model.salad.VegetarianDish;

/**
 * Interface for factory of vegetarian dishes
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 */
public interface VegetarianRestaurant {
    /**
     * Return dish, that client ordered
     *
     * @param name name of dish, that client wants
     * @return ordered dish
     */
    VegetarianDish orderDish(String name);

    /**
     * Return menu of that restaurant.
     *
     * @return list of dishes in that restaurant
     */
    String[] getMenu();


    static VegetarianRestaurant getRestaurant(RestaurantsList restaurant) {
        switch (restaurant) {
            case RUSSIAN:
                return new RussianRestaurant();
            case GREEK:
            default:
                return new GreekRestaurant();
        }
    }
}
