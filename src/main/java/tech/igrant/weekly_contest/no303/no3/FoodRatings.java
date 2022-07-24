package tech.igrant.weekly_contest.no303.no3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodRatings {

    private final Map<String, String> indexByCuisine;
    private final Map<String, FoodAndRating> indexByFood;
    private final Map<String, TreeSet<FoodAndRating>> groupByCuisine;

    private static class FoodAndRating {
        private final String food;
        private final int rating;

        public FoodAndRating(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.indexByCuisine = new HashMap<>();
        this.indexByFood = new HashMap<>();
        this.groupByCuisine = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            indexByCuisine.put(food, cuisine);
            indexByFood.put(food, new FoodAndRating(food, ratings[i]));
            groupByCuisine.computeIfAbsent(
                    cuisine,
                    c -> new TreeSet<>(
                            (o1, o2) -> o1.rating == o2.rating ? o1.food.compareTo(o2.food) : o2.rating - o1.rating
                    )
            ).add(indexByFood.get(food));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = indexByCuisine.get(food);
        TreeSet<FoodAndRating> treeSet = groupByCuisine.get(cuisine);
        treeSet.remove(indexByFood.get(food));
        indexByFood.put(food, new FoodAndRating(food, newRating));
        treeSet.add(indexByFood.get(food));
    }

    public String highestRated(String cuisine) {
        TreeSet<FoodAndRating> foods = groupByCuisine.get(cuisine);
        return foods.first().food;
    }

}
