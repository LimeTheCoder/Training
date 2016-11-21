package com.limethecoder.kitchen;


import com.limethecoder.kitchen.model.factory.russian.RussianMenu;
import com.limethecoder.kitchen.model.entity.Ingredient;
import com.limethecoder.kitchen.model.entity.Salad;
import com.limethecoder.kitchen.model.entity.VegetarianDish;
import com.limethecoder.kitchen.model.entity.SortOrder;
import com.limethecoder.kitchen.model.entity.Vegetable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class VegetarianDishTest {
    private VegetarianDish vegetarianDish;

    @Before
    public void init() {
        vegetarianDish = new Salad(RussianMenu.ORIGINAL.name(),
                Arrays.asList(
                        new Ingredient(Vegetable.CARROT, 100), // Total calories = 41
                        new Ingredient(Vegetable.ONION, 50), // Total calories = 20
                        new Ingredient(Vegetable.TOMATO, 25))); // Total calories = 4
    }

    @Test
    public void testTotalCalories() {
        double totalCalories = 41.0 + 20.0 + 4.0;
        assertEquals(vegetarianDish.getTotalCalories(), totalCalories, 0.01);
    }

    @Test
    public void testCaloriesRange() {
        List<Ingredient> vegetables = vegetarianDish.findByCalories(15, 40);
        assertEquals(vegetables.size(), 1);
        double cal = vegetables.get(0).getTotalCalories();
        assertTrue(cal >= 15 && cal <= 40);
    }

    @Test
    public void testSort() {
        vegetarianDish.sortIngredients(SortOrder.DESCENDING);
        List<Ingredient> vegetables = vegetarianDish.getIngredients();

        for(int i = 0; i < vegetables.size() - 1; i++) {
            assertTrue(vegetables.get(i).getTotalCalories() >=
                    vegetables.get(i + 1).getTotalCalories());
        }

        vegetarianDish.sortIngredients(SortOrder.ASCENDING);
        vegetables = vegetarianDish.getIngredients();

        for(int i = 0; i < vegetables.size() - 1; i++) {
            assertTrue(vegetables.get(i).getTotalCalories() <=
                    vegetables.get(i + 1).getTotalCalories());
        }
    }
}
