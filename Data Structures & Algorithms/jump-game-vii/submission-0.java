class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)=='1') return false;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int farthest=0;
        while(!q.isEmpty())
        {
            int i=q.poll();
            int start=Math.max(i+minJump,farthest+1);
            int end=Math.min(i+maxJump,s.length()-1);
            for(int j=start;j<=end;j++)
            {
                if(s.charAt(j)=='0')
                {
                    q.add(j);
                    if(j==s.length()-1)
                        return true;
                }
            }
            farthest=i+maxJump;
        }
        return false;
    }
}