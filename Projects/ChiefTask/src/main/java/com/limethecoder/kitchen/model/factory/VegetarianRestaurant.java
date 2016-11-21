package com.limethecoder.kitchen.model.factory;


import com.limethecoder.kitchen.model.factory.greek.GreekRestaurant;
import com.limethecoder.kitchen.model.factory.russian.RussianRestaurant;
import com.limethecoder.kitchen.model.entity.VegetarianDish;

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

    /**
     * Based on argument created appropriate
     * implementation of {@link VegetarianRestaurant} interface
     *
     * @param restaurant restaurant type, which object need to being created
     * @return instantiated appropriate restaurant object
     */
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
