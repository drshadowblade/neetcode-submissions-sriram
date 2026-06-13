class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:hand)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(map.keySet());
        while(!pq.isEmpty())
        {
            int first=pq.poll();

            if(map.get(first)==0) continue;

            for(int i=first;i<first+groupSize;i++)
            {
                if(!map.containsKey(i) || map.get(i)==0) return false;
                map.put(i,map.get(i)-1);
            }

            if(map.get(first)>0) pq.add(first);
        }
        return true;
    }
}
