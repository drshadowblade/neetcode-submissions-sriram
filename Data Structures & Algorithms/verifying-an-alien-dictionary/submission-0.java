class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank=new int[26];
        for(int i=0;i<26;i++)
        {
            rank[order.charAt(i)-'a']=i;
        }

        for(int i=0;i<words.length-1;i++)
        {
            if(!isIncorrect(words[i],words[i+1],rank))
                return false;
        }
        return true;
    }
    private boolean isIncorrect(String w1,String w2,int[] rank)
    {
        int len=Math.min(w1.length(),w2.length());
        for(int i=0;i<len;i++)
        {
            char c1=w1.charAt(i);
            char c2=w2.charAt(i);
            if(c1!=c2)
                return rank[c1-'a']<rank[c2-'a'];
        }
        return w1.length()<=w2.length();
    }
}