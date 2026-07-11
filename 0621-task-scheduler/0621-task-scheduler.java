class Solution {
      static class Pair {
        int freq;
        int availableTime;

        Pair(int freq, int availableTime) {
            this.freq = freq;
            this.availableTime = availableTime;
        }
    }

    public static int leastInterval(char[] tasks, int n) {

        // Count frequency
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : map.values()) {
            maxHeap.offer(freq);
        }

        Queue<Pair> queue = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            time++;

            // Execute task
            if (!maxHeap.isEmpty()) {

                int freq = maxHeap.poll();

                freq--;

                if (freq > 0) {
                    queue.offer(new Pair(freq, time + n));
                }
            }

            // Cooldown completed
            if (!queue.isEmpty() &&
                    queue.peek().availableTime == time) {

                maxHeap.offer(queue.poll().freq);
            }
        }

        return time;
    }
}