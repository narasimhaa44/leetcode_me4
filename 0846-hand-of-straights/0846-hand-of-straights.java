class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
                if (hand.length % groupSize != 0)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int key : map.keySet()) {
            minHeap.offer(key);
        }

        while (!minHeap.isEmpty()) {

            int first = minHeap.peek();

            for (int i = 0; i < groupSize; i++) {

                int curr = first + i;

                if (!map.containsKey(curr))
                    return false;

                map.put(curr, map.get(curr) - 1);

                if (map.get(curr) == 0) {

                    map.remove(curr);

                    // It must be the smallest remaining card
                    if (!minHeap.isEmpty() && minHeap.peek() == curr)
                        minHeap.poll();
                }
            }
        }

        return true;
    }
}