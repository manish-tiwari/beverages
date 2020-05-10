package com.manish.beverages.models;

import com.manish.beverages.exceptions.BeverageOrderException;
import com.manish.beverages.repositories.IngredientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 *
 * @author Manish Tiwari
 *
 */
@Component
public abstract class Beverage {

    @Autowired
    IngredientsRepo ingredientsRepo;
    private Double price;

    protected abstract List<Ingredient> getValidIngredients();

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    protected boolean isValidIngredient(Ingredient ingredient) {
        return getValidIngredients().contains(ingredient);
    }

    public void removeIngredients(List<Ingredient> removeIngredients) {

        if (getValidIngredients().size() == (removeIngredients.size()) && getValidIngredients().containsAll(removeIngredients)) {
            throw new BeverageOrderException("Invalid Order, please retry.");
        }
        removeIngredients.stream().forEach(ingredient -> {
            if (!isValidIngredient(ingredient)) {
                throw new BeverageOrderException("Invalid Order, please retry.");
            }
            this.setPrice(getPrice() - ingredientsRepo.getIngredientsPriceMap().get(ingredient));
        });
    }
}
