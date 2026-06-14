class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer> R=new LinkedList<>();
        Queue<Integer> D=new LinkedList<>();
        for(int i=0;i<senate.length();i++)
        {
            if(senate.charAt(i)=='R')
                R.offer(i);
            else
                D.offer(i);
        }
        while(!R.isEmpty() && !D.isEmpty())
        {
            int r=R.poll();
            int d=D.poll();
            if(r<d) R.add(r+n);
            else D.add(d+n);
        }
        if(R.isEmpty())
            return "Dire";
        else
            return "Radiant";
    }
}