package com.ocado.basket;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class is responsible for splitting the basket into deliveries based on the configuration file.
 * @author Bartosz Janusz
 */

public class BasketSplitter {
    private JsonObject jsonObject = null;

    /**
     * @param absolutePathToConfigFile - path to the configuration file with the products and their delivery types
     */
    public BasketSplitter(String absolutePathToConfigFile) {
        try(FileReader fileReader = new FileReader(absolutePathToConfigFile)) {
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            jsonObject = jsonElement.getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException("Error reading configuration file " + absolutePathToConfigFile, e);
        }
    }
    /**
     * @param items list of products in the basket
     * @return map of deliveries with delivery type as a key and list of products as a value
     */
    public Map<String, List<String>> split(List<String> items) {
        Map<String, List<String>> deliveries = new HashMap<>();
        Map<String, List<String>> deliveriesReadyToShip = new HashMap<>();

        if(items == null) throw new IllegalArgumentException("Null basket provided"); //returning empty map if there are no items in the basket
        if(jsonObject == null) throw new IllegalStateException("Configuration file is not loaded"); //throwing exception if configuration file is not loaded
        else
        {
            Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet(); //dividing json object into key value pairs
            for(Map.Entry<String, JsonElement> entry : entries) //iterating over records in json object
            {
                String productName = entry.getKey();
                JsonArray deliveryTypes = entry.getValue().getAsJsonArray();
                if(!items.contains(productName)) continue; //if the product is not in the basket, skip it
                else
                {
                    for(String deliveryType : getDeliveryTypes(deliveryTypes)) //grouping products by delivery type with repetitions
                    {
                        deliveries.computeIfAbsent(deliveryType, k -> new ArrayList<>()).add(productName);
                    }
                }
            }
            while(deliveries.size()>0) //looping until there is something to deliver
            {
                Map.Entry<String, List<String>> shippedDelivery = getBiggestDelivery(deliveries); //taking the biggest delivery and shipping it
                deliveriesReadyToShip.put(shippedDelivery.getKey(), shippedDelivery.getValue());
                deliveries.remove(shippedDelivery.getKey());//removing shipped delivery from the list
                for(Map.Entry<String, List<String>> delivery : deliveries.entrySet()) { //removing products that are already shipped from other deliveries
                    delivery.getValue().removeAll(shippedDelivery.getValue());
                }
            }
        }
        deliveriesReadyToShip.entrySet().removeIf(entry -> entry.getValue().isEmpty()); // removing empty deliveries
        return  deliveriesReadyToShip;
    }
    private List<String> getDeliveryTypes(JsonArray jsonArray) //extracting delivery types of a product
    {
        List<String> deliveryTypes = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            deliveryTypes.add(jsonElement.getAsString());
        }
        return deliveryTypes;
    }
    private Map.Entry<String,List<String>> getBiggestDelivery(Map<String, List<String>> deliveries) {
        return deliveries.entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .orElse(null);
    }
}
