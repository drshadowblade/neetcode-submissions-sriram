class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> visited=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int level=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String word=q.poll();
                if(word.equals(endWord))
                    return level;
                char[] arr=word.toCharArray();
                for(int j=0;j<arr.length;j++)
                {
                    char original=arr[j];
                    for(char c='a';c<='z';c++)
                    {
                        arr[j]=c;
                        String n=new String(arr);
                        if(visited.contains(n))
                        {
                            q.offer(n);
                            visited.remove(n);
                        }
                    }
                    arr[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}
