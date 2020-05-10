package com.manish.beverages.services;

import com.manish.beverages.exceptions.BeverageOrderException;
import com.manish.beverages.models.*;
import com.manish.beverages.repositories.BeverageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Manish Tiwari
 *
 */

@Service
public class BeverageOrderService {

    Beverage beverage;
    @Autowired
    Chai chai;
    @Autowired
    Mojito mojito;
    @Autowired
    StrawberryShake strawberryShake;
    @Autowired
    BananaSmoothie bananaSmoothie;
    @Autowired
    Coffee coffee;
    @Autowired
    BeverageRepo beverageRepo;


    public Double getBeveragePrice(String beverageOrder) {
        Beverage beverage = getMyCustomizedBeverage(beverageOrder);

        return beverage.getPrice();
    }

    private Beverage getMyCustomizedBeverage(String beverageOrder) {

        String ingredients[] = beverageOrder.toLowerCase().split(", -");
        String beverageName = ingredients[0];
        switch (beverageName) {
            case "chai":
                beverage = chai;
                break;
            case "coffee":
                beverage = coffee;
                break;
            case "mojito":
                beverage = mojito;
                break;
            case "strawberry shake":
                beverage = strawberryShake;
                break;
            case "banana smoothie":
                beverage = bananaSmoothie;
                break;
            default:
                throw new BeverageOrderException("Invalid order, please retry.");

        }
        beverage.setPrice(beverageRepo.getBeveragePriceMap().get(beverageName));
        List<Ingredient> removeIngredients = Arrays.asList(Arrays.copyOfRange(ingredients, 1, ingredients.length)).stream().map(i -> Ingredient.valueOf(i.toUpperCase())).collect(Collectors.toList());
        beverage.removeIngredients(removeIngredients);
        return beverage;
    }


}
