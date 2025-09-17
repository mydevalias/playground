package playground.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class FoodRatings {
    private Map<String, Holder> foodToHoler;
    private Map<String, PriorityQueue<Holder>> cuisinesToPQ;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToHoler = new HashMap<>();
        cuisinesToPQ = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Holder h = new Holder();
            h.food = foods[i];
            h.rating = ratings[i];
            h.cuisine = cuisines[i];
            foodToHoler.put(h.food, h);
            String cuisine = h.cuisine;
            PriorityQueue<Holder> pq = getHolders(cuisine);
            pq.add(h);
        }
    }

    private PriorityQueue<Holder> getHolders(String cuisine) {
        PriorityQueue<Holder> pq = cuisinesToPQ.get(cuisine);
        if (pq == null) {
            pq = new PriorityQueue<>();
            cuisinesToPQ.put(cuisine, pq);
        }
        return pq;
    }

    public void changeRating(String food, int newRating) {
        Holder h = foodToHoler.get(food);
        String cuisine = h.cuisine;
        PriorityQueue<Holder> pq = getHolders(cuisine);
        pq.remove(h);
        h.rating = newRating;
        pq.add(h);

    }

    public String highestRated(String cuisine) {
        return cuisinesToPQ.get(cuisine).peek().food;
    }

    static class Holder implements Comparable<Holder> {
        private String food;
        private int rating;
        private String cuisine;

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
