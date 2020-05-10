package com.manish.beverages.controllers;


import com.manish.beverages.services.BeverageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Manish Tiwari
 *
 */

@RestController
@RequestMapping("/beverage")
public class BevergeController {

    @Autowired
    BeverageOrderService beverageOrderService;

    @GetMapping("/order")
    public String getBeveragePrice(@RequestParam(value = "customization", required = true) String customization) {
        return "Price: "+beverageOrderService.getBeveragePrice(customization).toString() + " $";
    }


}
