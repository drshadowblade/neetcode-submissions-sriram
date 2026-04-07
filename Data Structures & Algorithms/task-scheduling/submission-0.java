class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int maxfreq=0;
        int count=0;
        for(char c:tasks)
            freq[c-'A']++;
        for(int f:freq)
            maxfreq=Math.max(f,maxfreq);
        for(int f:freq)
        {
            if(f==maxfreq) count++;
        }

        int part=(maxfreq-1)*(n+1)+count;
        return Math.max(part,tasks.length);
    }
}
