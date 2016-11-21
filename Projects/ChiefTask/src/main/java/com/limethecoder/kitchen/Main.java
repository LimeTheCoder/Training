package com.limethecoder.kitchen;


import com.limethecoder.kitchen.controller.Controller;
import com.limethecoder.kitchen.model.factory.RestaurantsList;
import com.limethecoder.kitchen.model.factory.VegetarianRestaurant;
import com.limethecoder.kitchen.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View(System.out);
        VegetarianRestaurant restaurant =
                VegetarianRestaurant.getRestaurant(RestaurantsList.RUSSIAN);

        Controller controller = new Controller(restaurant, view);
        controller.process();
    }
}
