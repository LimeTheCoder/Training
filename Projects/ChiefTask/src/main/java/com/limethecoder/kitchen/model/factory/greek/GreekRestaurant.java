package com.limethecoder.kitchen.model.factory.greek;

import com.limethecoder.kitchen.model.factory.VegetarianRestaurant;
import com.limethecoder.kitchen.model.salad.Salad;
import com.limethecoder.kitchen.model.salad.VegetarianDish;
import com.limethecoder.kitchen.model.vegetable.entities.*;

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
                        Arrays.asList(new Potato(15),
                                new Onion(75),
                                new Carrot(35),
                                new Tomato(27),
                                new Onion(25),
                                new Carrot(13)));
            case GREEK:
            default:
                return new Salad(GreekMenu.GREEK.name(),
                        Arrays.asList(new Tomato(37),
                                new Broccoli(115),
                                new Carrot(48),
                                new Potato(29)));
        }
    }

    @Override
    public String[] getMenu() {
        return Arrays.stream(GreekMenu.values())
                .map(GreekMenu::name)
                .toArray(String[]::new);
    }
}
