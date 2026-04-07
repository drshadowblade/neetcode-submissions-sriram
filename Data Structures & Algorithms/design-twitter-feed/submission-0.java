class Twitter {
    class Tweet
    {
        int id;
        int time;

        Tweet(int id,int time)
        {
            this.id=id;
            this.time=time;
        }
    }

    private HashMap<Integer,List<Tweet>> tweetmap;
    private HashMap<Integer,Set<Integer>> followmap;
    int time;
    public Twitter() {
        tweetmap=new HashMap<>();
        followmap=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetmap.putIfAbsent(userId,new ArrayList<>());
        tweetmap.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->b.time-a.time);

        if(tweetmap.containsKey(userId))
        {
            for(Tweet t:tweetmap.get(userId))
                pq.add(t);
        }

        if(followmap.containsKey(userId))
        {
            for(int t:followmap.get(userId))
            {
                if(tweetmap.containsKey(t))
                {
                    for(Tweet tw:tweetmap.get(t))
                        pq.add(tw);
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<10 && !pq.isEmpty();i++)
        {
            res.add(pq.poll().id);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;

        followmap.putIfAbsent(followerId,new HashSet<>());
        followmap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followmap.containsKey(followerId)) return;

        followmap.get(followerId).remove(followeeId);
    }
}
