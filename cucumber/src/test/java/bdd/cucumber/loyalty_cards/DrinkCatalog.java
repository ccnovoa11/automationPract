package bdd.cucumber.loyalty_cards;

import java.util.HashMap;
import java.util.Map;

public class DrinkCatalog {

    Map<String, String> drinkCategories = new HashMap<>();
    public void addDrink(String drink, String category) {
        drinkCategories.put(drink, category);
    }

    public String getCategory(String drink) {
        return drinkCategories.get(drink);
    }
}
