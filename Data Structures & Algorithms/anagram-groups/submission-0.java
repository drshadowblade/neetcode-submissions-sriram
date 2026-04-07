class Solution 
{
    public boolean isAnagram(String s1,String s2)
    {
        char[] temp1=s1.toCharArray();
        char[] temp2=s2.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        return Arrays.equals(temp1, temp2);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<> ();
        int n=strs.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]) continue;
            visited[i]=true;
            List<String> l=new ArrayList<>();
            l.add(strs[i]);
            for(int j=0;j<n;j++)
            {
                if(j!=i)
                {
                    if(!visited[j] && isAnagram(strs[i],strs[j]))
                    {
                        l.add(strs[j]);
                        visited[j]=true;
                    }
                }
            }
            result.add(l);
        }
        return result;
    }
}
