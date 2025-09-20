package playground.leetcode;

import java.util.*;

public class FoodRatings {
    private Map<String, Holder> foodToHolder;
    private Map<String, TreeSet<Holder>> cuisinesToSet;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToHolder = new HashMap<>();
        cuisinesToSet = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Holder h = new Holder(foods[i], ratings[i], cuisines[i]);
            foodToHolder.put(foods[i], h);
            cuisinesToSet.computeIfAbsent(cuisines[i], k -> new TreeSet<>()).add(h);
        }
    }

    public void changeRating(String food, int newRating) {
        Holder h = foodToHolder.get(food);
        TreeSet<Holder> set = cuisinesToSet.get(h.cuisine);
        set.remove(h);
        h.rating = newRating;
        set.add(h);
    }

    public String highestRated(String cuisine) {
        return cuisinesToSet.get(cuisine).first().food;
    }


    static class Holder implements Comparable<Holder> {
        private String food;
        private int rating;
        private String cuisine;

        public Holder(String food, int rating, String cuisine) {
            this.food = food;
            this.rating = rating;
            this.cuisine = cuisine;
        }

        @Override
        public int compareTo(Holder other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating);
            }
            return this.food.compareTo(other.food);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Holder holder = (Holder) obj;
            return Objects.equals(food, holder.food);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food);
        }
    }
}
