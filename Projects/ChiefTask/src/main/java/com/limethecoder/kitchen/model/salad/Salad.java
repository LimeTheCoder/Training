package com.limethecoder.kitchen.model.salad;

import com.limethecoder.kitchen.model.vegetable.Vegetable;

import java.util.*;
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
    private final static Comparator<Ingredient> DEFAULT_COMPARATOR =
            (o1, o2) -> Double.compare(o1.getTotalCalories(),
                    o2.getTotalCalories());

    /** Ingredients of salad */
    private List<Ingredient> ingredients = new ArrayList<>();

    /** Salad name */
    private String name;

    /**
     * Initialize salad with given parameters
     *
     * @param ingredients ingredients of salad
     * @param name salad name
     */
    public Salad(String name, List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        this.name = name;
    }

    /**
     * Add given ingredient to list of ingredients of the current salad.
     *
     * @param ingredient ingredient, which need to add to the salad
     * @throws NullPointerException if argument is null
     */
    @Override
    public void addIngredient(Ingredient ingredient) {
        Objects.requireNonNull(ingredient);
        ingredients.add(ingredient);
    }

    @Override
    public void sortIngredients(SortOrder order) {
        if (ingredients.isEmpty()) {
            return;
        }

        Comparator<Ingredient> comparator = DEFAULT_COMPARATOR;

        if (order == SortOrder.DESCENDING) {
            comparator = Collections.reverseOrder(comparator);
        }

        Collections.sort(ingredients, comparator);
    }

    @Override
    public List<Ingredient> findByPredicate(Predicate<Ingredient> predicate) {
        if (ingredients.isEmpty()) {
            return null;
        }

        return ingredients.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }


    @Override
    public List<Ingredient> findByCalories(double minCalories, double maxCalories) {
        return findByPredicate((x) -> x.getTotalCalories() >= minCalories
                && x.getTotalCalories() <= maxCalories);
    }

    @Override
    public double getTotalCalories() {
        if (ingredients.isEmpty()) {
            return 0.0;
        }

        return ingredients.stream().map(Ingredient::getTotalCalories)
                .reduce(0.0, (x, y) -> x + y);
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;

        if(this.ingredients == null) {
            this.ingredients = new ArrayList<>();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
