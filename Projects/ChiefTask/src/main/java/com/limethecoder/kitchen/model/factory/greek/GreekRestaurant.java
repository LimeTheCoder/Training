package com.limethecoder.kitchen.model.factory.greek;

import com.limethecoder.kitchen.model.factory.VegetarianRestaurant;
import com.limethecoder.kitchen.model.salad.Ingredient;
import com.limethecoder.kitchen.model.salad.Salad;
import com.limethecoder.kitchen.model.salad.VegetarianDish;
import com.limethecoder.kitchen.model.vegetable.Vegetable;

import java.util.Arrays;

/**
 * Restaurant, that contains only greek dishes for vegetarians
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 */
public class GreekRestaurant implements VegetarianRestaurant {
    @Override
    public VegetarianDish orderDish(String name) {
        GreekMenu choice = GreekMenu.valueOf(name);
        switch (choice) {
            case SUNNY:
                return new Salad(GreekMenu.SUNNY.name(),
                        Arrays.asList(new Ingredient(Vegetable.POTATO, 15),
                                new Ingredient(Vegetable.ONION, 75),
                                new Ingredient(Vegetable.CARROT, 35),
                                new Ingredient(Vegetable.TOMATO, 27),
                                new Ingredient(Vegetable.ONION, 25),
                                new Ingredient(Vegetable.CARROT, 13)));
            case GREEK:
            default:
                return new Salad(GreekMenu.GREEK.name(),
                        Arrays.asList(new Ingredient(Vegetable.TOMATO, 37),
                                new Ingredient(Vegetable.BROCCOLI, 115),
                                new Ingredient(Vegetable.CARROT, 48),
                                new Ingredient(Vegetable.ONION, 29)));
        }
    }

    @Override
    public String[] getMenu() {
        return Arrays.stream(GreekMenu.values())
                .map(GreekMenu::name)
                .toArray(String[]::new);
    }
}
