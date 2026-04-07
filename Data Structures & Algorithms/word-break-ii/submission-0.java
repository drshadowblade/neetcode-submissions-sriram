class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        return backtrack(s,set,0);
    }
    private List<String> backtrack(String s,HashSet<String> set,int start)
    {
        List<String> result=new ArrayList<>();
        if(start==s.length())
        {
            result.add("");
            return result;
        }
        for(int end=start+1;end<=s.length();end++)
        {
            String word=s.substring(start,end);
            if(!set.contains(word))
                continue;
            List<String> subset=backtrack(s,set,end);
            for(String sub:subset)
            {
                if(sub.isEmpty())
                    result.add(word);
                else
                    result.add(word+" "+sub);
            }
        }
        return result;
    }
}