package tech.igrant.weekly_contest.no303.no3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

class FoodRatings {

    private final Map<String, Integer> foodToRating;
    private final Map<String, String> foodToCuisine;
    private final Map<String, TreeSet<String>> groupByCuisine;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodToRating = new HashMap<>();
        this.foodToCuisine = new HashMap<>();

        this.groupByCuisine = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
            groupByCuisine.computeIfAbsent(
                    cuisines[i],
                    c -> new TreeSet<>(
                            (food1, food2) -> {
                                Integer r1 = foodToRating.get(food1);
                                Integer r2 = foodToRating.get(food2);
                                return Objects.equals(r1, r2) ? food1.compareTo(food2) : r2.compareTo(r1);
                            }
                    )
            ).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        TreeSet<String> treeSet = groupByCuisine.get(foodToCuisine.get(food));
        treeSet.remove(food);
        foodToRating.put(food, newRating);
        treeSet.add(food);
    }

    public String highestRated(String cuisine) {
        TreeSet<String> foods = groupByCuisine.get(cuisine);
        return foods.first();
    }

}
