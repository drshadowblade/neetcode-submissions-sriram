class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // meetings.sort() -> Sorts meetings by start time by default
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        // available = [i for i in range(n)] -> Min-heap for available room indices
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }
        
        // used = [] -> Min-heap storing tuples of (end_time, room_number)
        // Python's heapq automatically compares tuples element by element.
        // We replicate this with a custom comparator using long to prevent overflow.
        PriorityQueue<long[]> used = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]); // Sort by end_time first
            }
            return Long.compare(a[1], b[1]); // Tie-breaker: sort by room_number
        });
        
        // count = [0] * n -> Array tracking how many times each room was booked
        int[] count = new int[n];
        
        // for start, end in meetings:
        for (int[] meet : meetings) {
            long start = meet[0];
            long end = meet[1];
            
            // # Finish meetings
            // while used and start >= used[0][0]:
            while (!used.isEmpty() && start >= used.peek()[0]) {
                // _, room = heapq.heappop(used)
                long[] finished = used.poll();
                int room = (int) finished[1];
                // heapq.heappush(available, room)
                available.offer(room);
            }
            
            // if not available:
            if (available.isEmpty()) {
                // end_time, room = heapq.heappop(used)
                long[] earliest = used.poll();
                long endTime = earliest[0];
                int room = (int) earliest[1];
                
                // end = end_time + (end - start)
                end = endTime + (end - start);
                
                // heapq.heappush(available, room)
                available.offer(room);
            }
            
            // room = heapq.heappop(available)
            int room = available.poll();
            
            // heapq.heappush(used, (end, room))
            used.offer(new long[]{end, room});
            
            // count[room] += 1
            count[room]++;
        }
        
        // return count.index(max(count))
        // Finds the index of the maximum count (first one on a tie)
        int maxVal = -1;
        int resultIndex = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxVal) {
                maxVal = count[i];
                resultIndex = i;
            }
        }
        
        return resultIndex;
    }
}
