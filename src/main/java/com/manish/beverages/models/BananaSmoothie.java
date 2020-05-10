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
public class BananaSmoothie extends Beverage {

    private List<Ingredient> ingredients = Arrays.asList(Ingredient.SUGAR, Ingredient.MILK, Ingredient.WATER);

    @Override
    protected List<Ingredient> getValidIngredients() {
        return ingredients;
    }

}
