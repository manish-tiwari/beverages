package com.manish.beverages.models;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Manish Tiwari
 *
 */
@Component
public class Mojito extends Beverage {

    private List<Ingredient> ingredients = Arrays.asList(Ingredient.SUGAR, Ingredient.WATER, Ingredient.SODA, Ingredient.MINT);

    @Override
    protected List<Ingredient> getValidIngredients() {
        return ingredients;
    }
}
