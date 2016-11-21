package com.limethecoder.kitchen.model.factory.russian;

import com.limethecoder.kitchen.model.factory.VegetarianRestaurant;
import com.limethecoder.kitchen.model.salad.Ingredient;
import com.limethecoder.kitchen.model.salad.Salad;
import com.limethecoder.kitchen.model.salad.VegetarianDish;
import com.limethecoder.kitchen.model.vegetable.Vegetable;

import java.util.Arrays;


/**
 * Restaurant, that contains only russian dishes for vegetarians
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 */
public class RussianRestaurant implements VegetarianRestaurant {
    @Override
    public VegetarianDish orderDish(String name) {
        RussianMenu choice = RussianMenu.valueOf(name);

        switch (choice) {
            case VINAIGRETTE:
                return new Salad(RussianMenu.VINAIGRETTE.name(),
                        Arrays.asList(new Ingredient(Vegetable.BROCCOLI, 140),
                                new Ingredient(Vegetable.CUCUMBER, 75),
                                new Ingredient(Vegetable.CARROT, 15)));
            case SUMMER:
                return new Salad(RussianMenu.SUMMER.name(),
                        Arrays.asList(new Ingredient(Vegetable.BROCCOLI, 30),
                                new Ingredient(Vegetable.ONION, 62),
                                new Ingredient(Vegetable.CARROT, 45)));
            case ORIGINAL:
            default:
                return new Salad(RussianMenu.ORIGINAL.name(),
                        Arrays.asList(new Ingredient(Vegetable.TOMATO, 213),
                                new Ingredient(Vegetable.POTATO, 123),
                                new Ingredient(Vegetable.CUCUMBER,15),
                                new Ingredient(Vegetable.ONION, 48),
                                new Ingredient(Vegetable.CARROT, (25))));
        }
    }

    @Override
    public String[] getMenu() {
        return Arrays.stream(RussianMenu.values())
                .map(RussianMenu::name)
                .toArray(String[]::new);
    }
}
