import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // Step 1: Count the frequency of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Step 2: Use a priority queue to process cards in ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(countMap.keySet());

        // Step 3: Try to form groups
        while (!pq.isEmpty()) {
            int start = pq.poll();  // Get the smallest card

            // Step 4: Check if the current card can be the start of a valid group
            if (countMap.getOrDefault(start, 0) == 0) continue;  // Skip if all this card is used up

            int freq = countMap.get(start);  // Frequency of the current card
            for (int i = 0; i < groupSize; i++) {
                int currentCard = start + i;

                // If there aren't enough cards to complete the group, return false
                if (countMap.getOrDefault(currentCard, 0) < freq) {
                    return false;
                }

                // Decrease the frequency of the current card
                countMap.put(currentCard, countMap.get(currentCard) - freq);

                // Remove the card from the map if its frequency becomes zero
                if (countMap.get(currentCard) == 0) {
                    countMap.remove(currentCard);
                }
            }
        }

        return true;
    }
}
