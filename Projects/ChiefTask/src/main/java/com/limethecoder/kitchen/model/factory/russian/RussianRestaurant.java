package com.limethecoder.kitchen.model.factory.russian;

import com.limethecoder.kitchen.model.factory.VegetarianRestaurant;
import com.limethecoder.kitchen.model.salad.Salad;
import com.limethecoder.kitchen.model.salad.VegetarianDish;
import com.limethecoder.kitchen.model.vegetable.entities.*;

import java.util.ArrayList;
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
        switch (name) {
            case RussianMenu.VINAIGRETTE:
                return new Salad(RussianMenu.VINAIGRETTE,
                        Arrays.asList(new Potato(140),
                                new Cucumber(75),
                                new Carrot(15)));
            case RussianMenu.SUMMER:
                return new Salad(RussianMenu.SUMMER,
                        Arrays.asList(new Broccoli(30),
                                new Onion(62),
                                new Carrot(45)));
            case RussianMenu.ORIGINAL:
            default:
                return new Salad(RussianMenu.ORIGINAL,
                        Arrays.asList(new Tomato(213),
                                new Potato(123),
                                new Carrot(15),
                                new Onion(48),
                                new Carrot(25)));
        }
    }
}
