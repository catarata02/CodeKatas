/*
 * Copyright 2023 The Bank of New York Mellon.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bnymellon.codekatas.coffeeshopkata;

import bnymellon.codekatas.coffeeshopkata.beverage.*;
import bnymellon.codekatas.coffeeshopkata.food.*;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShopOrder {
    private final String customerName;
    private final List<Item> orderItems;

    public CoffeeShopOrder(String customerName, List<Item> orderItems) {
        this.customerName = customerName;
        this.orderItems = orderItems;
    }

    /**
     * Generate a receipt for a customer's food items.
     * If the item is a Donut: Print Donut: [donutType] $Price
     * If the item is a Cookie: Print Cookie: [cookieType] $Price
     * If the item is a Bagel: Print Bagel: [bagelType] $Price
     * Total: $Total Price
     * <p>
     * NOTE: The method highlights the usage of a record deconstruction pattern
     *
     * @see <a href="https://openjdk.org/jeps/440">...</a>
     */
    public String generateReceiptForFoodItems() {
        double total = 0.0;
        List<String> receiptItems = new ArrayList<>();

        for (Item item : this.orderItems) {
            switch (item) {
                case Donut(DonutType donutType) -> {
                    receiptItems.add("Donut: " + donutType + " $" + item.getPrice());
                    total += item.getPrice();
                }
                case Bagel(BagelType bagelType, SpreadType spreadType, boolean toasted) -> {
                    receiptItems.add("Bagel: " + bagelType + " $" + item.getPrice());
                    total += item.getPrice();
                }
                case Cookie(CookieType cookieType, boolean warmed) -> {
                    receiptItems.add("Cookie: " + cookieType + " $" + item.getPrice());
                    total += item.getPrice();
                }
                default -> {
                }
            }
        }

        receiptItems.add("Total: $" + total);
        return String.join("\n", receiptItems);
    }

    /**
     * Return a list of custom strings for the customer's food items!
     * The string format for each food item is as follows:
     * If the item is a Bagel: "[bagelType] with [spreadType]"
     * If the item is a Cookie: "[cookieType] cookie"
     * If the item is a Donut: "[donutType] donut"
     * Otherwise: it is a beverage and should not be added to the list!
     * <p>
     * NOTE: This method show-cases a switch-case pattern matching.
     *
     * @see <a href="https://openjdk.org/jeps/441">...</a>
     */
    public List<String> getFoodItemsForOrder() {
        List<String> foodItems = new ArrayList<>();
        for (Item item : this.orderItems) {
            switch (item) {
                case Bagel(BagelType bagelType, SpreadType spreadType, boolean toasted) ->
                        foodItems.add(bagelType + " bagel with " + spreadType);
                case Cookie(CookieType cookieType, boolean warmed) ->
                        foodItems.add(cookieType + " cookie");
                case Donut(DonutType donutType) ->
                        foodItems.add(donutType + " donut");
                default -> {}
            }
        }
        return foodItems;
    }

    /**
     * Return a list of custom strings for the customer's drinks!
     * First drink: Hot Americano
     * Second drink: Hot Caramel Latte with Almond Milk
     * Third drink: Hot Vanilla Macchiato with Whole Milk
     * Fourth drink: Matcha Tea
     * <p>
     * NOTE: This method utilize sealed classes and permit to define coffee drink types
     * (e.g., Americano, Latte, Macchiato) are allowed within a hierarchy.
     * However, Tea is not part of this hierarchy.
     */
    public List<String> getDrinksForOrder() {
        List<String> drinkItems = new ArrayList<>();

        drinkItems.add(((CoffeeDrink) new Americano(DrinkTemperature.HOT)).toString());
        drinkItems.add(((CoffeeDrink) new Latte(FlavorSyrup.CARAMEL, MilkType.ALMOND_MILK, false, DrinkTemperature.HOT)).toString());
        drinkItems.add(((CoffeeDrink) new Macchiato(MilkType.WHOLE_MILK, FlavorSyrup.VANILLA, DrinkTemperature.HOT)).toString());
        drinkItems.add(new Tea(TeaType.MATCHA).toString());

        return drinkItems;
    }
}
