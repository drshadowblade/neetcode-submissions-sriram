class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tMap=new HashMap<>();
        for(char c:t.toCharArray())
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        int minlen=Integer.MAX_VALUE;
        int formed=0;
        int required=tMap.size();
        int start=0;
        int left=0;
        int right=0;
        HashMap<Character,Integer> window=new HashMap<>();
        while(right<s.length())
        {
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);

            if(tMap.containsKey(c) && tMap.get(c).intValue()==window.get(c).intValue())
                formed++;

            while(left<=right && formed==required)
            {
                if(right-left+1<minlen)
                {
                    minlen=right-left+1;
                    start=left;
                }
                char leftchar=s.charAt(left);
                window.put(leftchar,window.get(leftchar)-1);
                if(tMap.containsKey(leftchar) && window.get(leftchar).intValue()<tMap.get(leftchar).intValue())
                    formed--;
                left++;
            }
            right++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);    }
}
