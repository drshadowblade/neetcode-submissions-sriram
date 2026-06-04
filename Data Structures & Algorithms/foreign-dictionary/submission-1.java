class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character,Set<Character>> map=new HashMap<>();
        HashMap<Character,Integer> indegree=new HashMap<>();

        for(String word:words)
        {
            for(char c:word.toCharArray())
            {
                map.putIfAbsent(c,new HashSet<>());
                indegree.putIfAbsent(c,0);
            }
        }

        for(int i=0;i<words.length-1;i++)
        {
            String word1=words[i];
            String word2=words[i+1];

            if(word1.length()>word2.length() && word1.indexOf(word2)==0)
                return "";
            
            int len=Math.min(word1.length(),word2.length());
            for(int j=0;j<len;j++)
            {
                char c1=word1.charAt(j);
                char c2=word2.charAt(j);
                if(c1!=c2)
                {
                    if(!map.get(c1).contains(c2))
                    {
                        map.get(c1).add(c2);
                        indegree.put(c2,indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q=new LinkedList<>();
        for(char c:indegree.keySet())
        {
            if(indegree.get(c)==0)
                q.add(c);
        }
        String ans="";
        while(!q.isEmpty())
        {
            char c=q.poll();
            ans+=c;
            for(char next:map.get(c))
            {
                indegree.put(next,indegree.get(next)-1);
                if(indegree.get(next)==0)
                    q.offer(next);
            }
        }
        if(ans.length()!=indegree.size())
            return "";
        return ans;
    }
}
