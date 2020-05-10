package com.manish.beverages.repositories;

import com.manish.beverages.models.Ingredient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Manish Tiwari
 *
 */
@Repository
public class IngredientsRepo extends BeverageRepo {

    private Map<Ingredient, Double> ingredientsPriceMap;

    @PostConstruct
    public int loadIngredients() {
        Object obj = null;
        try {
            obj = new JSONParser().parse(new String(
                    Files.readAllBytes(ResourceUtils.getFile("classpath:ingredientsPrice.json").toPath())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject ingredientsJsonObj = (JSONObject) obj;
        ingredientsPriceMap = new HashMap<>();
        Iterator keysIter = ingredientsJsonObj.keySet().iterator();
        while (keysIter.hasNext()) {
            String key = (String) keysIter.next();
            Double value = ((Number) ingredientsJsonObj.get(key)).doubleValue();
            System.out.println(key + ":" + value);
            ingredientsPriceMap.put(Ingredient.valueOf(key.toUpperCase()), value);

        }
        System.out.println("Loaded " + ingredientsPriceMap.size() + " customizable ingredients.");
        return ingredientsPriceMap.size();
    }


    public Map<Ingredient, Double> getIngredientsPriceMap() {
        return ingredientsPriceMap;
    }

}
