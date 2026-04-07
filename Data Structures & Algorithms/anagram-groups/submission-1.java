class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hash=new HashMap<>();
        for(String str:strs)
        {
            char[] a=str.toCharArray();
            Arrays.sort(a);
            String b=new String(a);
            if(hash.containsKey(b))
                hash.get(b).add(str);
            else
            {
                List<String> l=new ArrayList<>();
                l.add(str);
                hash.put(b,l);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(List<String> a:hash.values())
        {
            result.add(a);
        }
        return result;
    }
}
