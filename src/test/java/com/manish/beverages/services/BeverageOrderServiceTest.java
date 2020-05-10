package com.manish.beverages.services;

import com.manish.beverages.exceptions.BeverageOrderException;
import com.manish.beverages.repositories.BeverageRepo;
import com.manish.beverages.repositories.IngredientsRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 *
 * @author Manish Tiwari
 *
 */

@SpringBootTest
class BeverageOrderServiceTest {

    @Autowired
    BeverageOrderService beverageOrderService;

    @Autowired
    BeverageRepo beverageRepo;

    @Autowired
    IngredientsRepo ingredientsRepo;


    @Test
    void contextLoads() {
    }

    @Test
    public void assertLoadBeverages() {
        Assert.assertEquals(5, beverageRepo.loadBeverages());
    }

    @Test
    public void assertLoadIngredients() {
        Assert.assertEquals(5, ingredientsRepo.loadBeverages());
    }

    @Test
    public void assertSimpleOrder() {
        Assert.assertEquals((Double) 7.0, beverageOrderService.getBeveragePrice("strawberry shake"));
    }

    @Test
    public void assertCustomOrders() {
        Assert.assertEquals((Double) 3.5, beverageOrderService.getBeveragePrice("Chai, -Water"));
    }

    @Test
    public void assertRemoveAllIngredients() {
        Assertions.assertThrows(BeverageOrderException.class, () -> {
            beverageOrderService.getBeveragePrice("strawberry shake, -Water, -Sugar, -Milk");
        });
    }

    @Test
    public void assertInvalidOrders() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            beverageOrderService.getBeveragePrice("strawberry shake, -Namak, -Sugar, -Milk");
        });

        Assertions.assertThrows(BeverageOrderException.class, () -> {
            beverageOrderService.getBeveragePrice("strawberry shake-Namak-Sugar -Milk");
        });

        Assertions.assertThrows(BeverageOrderException.class, () -> {
            beverageOrderService.getBeveragePrice("Chai-Milk");
        });

        Assertions.assertThrows(BeverageOrderException.class, () -> {
            beverageOrderService.getBeveragePrice(" , - ");
        });

        Assertions.assertThrows(BeverageOrderException.class, () -> {
            beverageOrderService.getBeveragePrice(" ");
        });


    }




}
