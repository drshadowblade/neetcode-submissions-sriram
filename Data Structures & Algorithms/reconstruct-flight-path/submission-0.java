class Solution {
    List<String> result=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> map=new HashMap<>();
        for(List<String> l:tickets)
        {
            String from=l.get(0);
            String to=l.get(1);
            map.putIfAbsent(from,new PriorityQueue<>());
            map.get(from).offer(to);
        }
        dfs("JFK",map);
        Collections.reverse(result);
        return result;
    }
    public void dfs(String air,HashMap<String,PriorityQueue<String>> map)
    {
        PriorityQueue<String> pq=map.get(air);
        while(pq!=null && !pq.isEmpty())
        {
            dfs(pq.poll(),map);
        }
        result.add(air);
    }
}
