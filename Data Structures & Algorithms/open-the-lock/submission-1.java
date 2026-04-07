class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> list=new HashSet<>(Arrays.asList(deadends));
        if(list.contains("0000")) return -1;
        String start="0000";
        Queue<String> q=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int moves=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String curr=q.poll();
                if(curr.equals(target))
                    return moves;
                for(String str:neighbors(curr))
                {
                    if(!visited.contains(str) && !list.contains(str))
                    {
                        q.offer(str);
                        visited.add(str);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private List<String> neighbors(String str)
    {
        List<String> result=new ArrayList<>();
        char[] arr=str.toCharArray();
        for(int i=0;i<4;i++)
        {
            char c=arr[i];
            arr[i]=(char)((c-'0'+1)%10+'0');
            result.add(new String(arr));

            arr[i]=(char)((c-'0'+9)%10+'0');
            result.add(new String(arr));

            arr[i]=c;
        }
        return result;
    }
}