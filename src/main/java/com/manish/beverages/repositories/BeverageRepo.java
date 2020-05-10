package com.manish.beverages.repositories;

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
public class BeverageRepo {

    private Map<String, Double> beveragePriceMap;

    @PostConstruct
    public int loadBeverages() {
        Object obj = null;
        try {
            obj = new JSONParser().parse(new String(
                    Files.readAllBytes(ResourceUtils.getFile("classpath:beveragesPrice.json").toPath())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject beveragesJsonObj = (JSONObject) obj;
        beveragePriceMap = new HashMap<>();
        Iterator keysIter = beveragesJsonObj.keySet().iterator();
        while (keysIter.hasNext()) {
            String key = (String) keysIter.next();
            Double value = ((Number) beveragesJsonObj.get(key)).doubleValue();
            System.out.println(key + ":" + value);
            beveragePriceMap.put(key, value);

        }
        System.out.println("Loaded " + beveragePriceMap.size() + " beverages.");
        return beveragePriceMap.size();


    }

    public Map<String, Double> getBeveragePriceMap() {
        return beveragePriceMap;
    }
}
