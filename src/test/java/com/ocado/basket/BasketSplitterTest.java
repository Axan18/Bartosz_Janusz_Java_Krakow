package com.ocado.basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static com.ocado.basket.Generator.generator;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is responsible for testing the BasketSplitter class.
 * @author Bartosz Janusz
 */

class BasketSplitterTest {
    BasketSplitter basketSplitter = null;
    /**
     * Setting up the BasketSplitter object before each test.
     */

    @BeforeEach
    void setUp() {
        basketSplitter = new BasketSplitter("src/main/resources/config.json");
    }
    /**
     * Testing the split method with an empty list of items.
     */
    @Test
    void emptyList() {
        assertEquals("{}",
                basketSplitter.split(List.of(
                )).toString(), "BasketSplitter.split() should return empty map when no products are in the basket");
    }
    /**
     * Testing the split method with a null list of items.
     */
    @Test
    void nullList() {
        assertThrows(IllegalArgumentException.class, () -> basketSplitter.split(null));
    }
    /**
     * Testing the split method with a null BasketSplitter object.
     */
    @Test
    void basketSplitterNull() {
        basketSplitter=null;
        assertThrows(NullPointerException.class, () -> basketSplitter.split(List.of()));
    }
    /**
     * Testing the split method with wrong path to the configuration file.
     */
    @Test
    void wrongPath() {
        String wrongPath = "src/nonexistent/path/config.json";
        assertThrows(RuntimeException.class, () -> new BasketSplitter(wrongPath));
    }
    /**
     * Testing the split method with a list of products out of offer.
     */
    @Test
    void productsOutOfTheOffer() {
        assertEquals("{}",
                basketSplitter.split(List.of(
                        "Steak (300g)",
                        "Carrots (1kg)",
                        "Cold Beer (330ml)",
                        "AA Battery (4 Pcs.)",
                        "Espresso Machine",
                        "Garden Chair"
                )).toString(), "BasketSplitter.split() should return empty map when no products are in the offer");
    }
    /**
     * Testing the split method with a list of products in the offer.
     */
    @Test
    void splitItems() {
        Map<String, List<String>> expectedDeliveries = new HashMap<>();
        expectedDeliveries.put("Pick-up point", List.of("Cheese Cloth", "Flower - Daisies", "Cookies Oatmeal Raisin"));
        List<String> items = new ArrayList<>();
        //creating basket
        items.add("Cheese Cloth");
        items.add("Flower - Daisies");
        items.add("Cookies Oatmeal Raisin");

        Map<String,List<String>> result = basketSplitter.split(items);
        for(Map.Entry<String, List<String>> entry : expectedDeliveries.entrySet()) {
            List<String> expected = new ArrayList<>(entry.getValue());
            List<String> actual = result.get(entry.getKey());
            Collections.sort(expected);
            Collections.sort(actual);
            assertEquals(expected, actual);
        }
    }
    /**
     * Testing performance of the split method with a generated data of 1000 products in the shop with 1 to 10 delivery types and bucket containing 100 products.
     */
    @Test
    void performanceTest() {
        generator();
        String syntheticConfigPath = "syntheticConfig.json"; // Path to the synthetic configuration file with 1000 "items"
        BasketSplitter basketSplitter = new BasketSplitter(syntheticConfigPath);

        // Generate a large list of items
        List<String> items = List.of(
                "a",
                "abandon",
                "ability",
                "able",
                "abortion",
                "about",
                "above",
                "abroad",
                "absence",
                "absolute",
                "absolutely",
                "absorb",
                "abuse",
                "academic",
                "accept",
                "access",
                "accident",
                "accompany",
                "accomplish",
                "according",
                "account",
                "accurate",
                "accuse",
                "achieve",
                "achievement",
                "acid",
                "acknowledge",
                "acquire",
                "across",
                "act",
                "action",
                "active",
                "activist",
                "activity",
                "actor",
                "actress",
                "actual",
                "actually",
                "ad",
                "adapt",
                "add",
                "addition",
                "additional",
                "address",
                "adequate",
                "adjust",
                "adjustment",
                "administration",
                "administrator",
                "admire",
                "admission",
                "admit",
                "adolescent",
                "adopt",
                "adult",
                "advance",
                "advanced",
                "advantage",
                "adventure",
                "advertising",
                "advice",
                "advise",
                "adviser",
                "advocate",
                "affair",
                "affect",
                "afford",
                "afraid",
                "African",
                "African-American",
                "after",
                "afternoon",
                "again",
                "against",
                "age",
                "agency",
                "agenda",
                "agent",
                "aggressive",
                "ago",
                "agree",
                "agreement",
                "agricultural",
                "ah",
                "ahead",
                "aid",
                "aide",
                "AIDS",
                "aim",
                "air",
                "aircraft",
                "airline",
                "airport",
                "album",
                "alcohol",
                "alive",
                "all",
                "alliance",
                "allow",
                "ally"
        );
        long startTime = System.currentTimeMillis();
        basketSplitter.split(items);
        long endTime = System.currentTimeMillis();

        long timeTaken = endTime - startTime;
        System.out.println("Time taken to split the items: " + timeTaken + " milliseconds");
        assertTrue(timeTaken < 10, "The operation took too long");
    }
}