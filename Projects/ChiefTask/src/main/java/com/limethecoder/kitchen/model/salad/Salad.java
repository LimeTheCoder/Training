package com.limethecoder.kitchen.model.salad;

import com.limethecoder.kitchen.model.vegetable.SortOrder;
import com.limethecoder.kitchen.model.vegetable.Vegetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class describes common features of salad entity.
 * Salad contains list of vegetable.
 *
 * @version 1.0 18 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see Vegetable
 */
public class Salad implements VegetarianDish {

    /** Default comparator for sorting in ascending order */
    private final static Comparator<Vegetable> DEFAULT_COMPARATOR =
            (o1, o2) -> Double.compare(o1.getTotalCalories(),
                    o2.getTotalCalories());

    /** Ingredients of salad */
    private List<Vegetable> ingredients;

    /** Salad name */
    private String name;

    /**
     * Initialize salad with given parameters
     *
     * @param ingredients ingredients of salad
     * @param name salad name
     */
    public Salad(String name, List<Vegetable> ingredients) {
        this.ingredients = ingredients;
        this.name = name;

        prepareIngredients();
    }

    /**
     * Add given ingredient to list of ingredients of the current salad.
     * If ingredients list is {@code null},
     * then creates new list of ingredients
     *
     * @param ingredient ingredient, which need to add to the salad
     */
    @Override
    public void addIngredient(Vegetable ingredient) {
        if (ingredient == null) {
            return;
        }

        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }

        ingredient.prepareVegetable();
        ingredients.add(ingredient);
    }

    @Override
    public void sortIngredients(SortOrder order) {
        if (ingredients == null || ingredients.isEmpty()) {
            return;
        }

        Comparator<Vegetable> comparator = DEFAULT_COMPARATOR;

        if (order == SortOrder.DESCENDING) {
            comparator = Collections.reverseOrder(comparator);
        }

        Collections.sort(ingredients, comparator);
    }

    @Override
    public List<Vegetable> findByPredicate(Predicate<Vegetable> predicate) {
        if (ingredients == null || ingredients.isEmpty()) {
            return null;
        }

        return ingredients.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public void prepareIngredients() {
        if(ingredients == null || ingredients.isEmpty()) {
            return;
        }

        ingredients.forEach(Vegetable::prepareVegetable);
    }

    @Override
    public List<Vegetable> findByCalories(double minCalories, double maxCalories) {
        return findByPredicate((x) -> x.getTotalCalories() >= minCalories
                && x.getTotalCalories() <= maxCalories);
    }

    @Override
    public double getTotalCalories() {
        if (ingredients == null || ingredients.isEmpty()) {
            return 0.0;
        }

        return ingredients.stream().map(Vegetable::getTotalCalories)
                .reduce(0.0, (x, y) -> x + y);
    }

    @Override
    public List<Vegetable> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Vegetable> ingredients) {
        this.ingredients = ingredients;
        prepareIngredients();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
