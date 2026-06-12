class Solution {
    public boolean f(String s,String p,int i,int j,HashMap<String,Boolean> map)
    {
        if(i>=s.length() && j>=p.length()) return true;

        if(j>=p.length()) return false;

        if(map.containsKey(i+""+j)) return map.get(i+""+j);

        boolean match= i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');

        if(j+1<p.length() && p.charAt(j+1)=='*')
        {
            boolean one=f(s,p,i,j+2,map);
            boolean two=false;
            if(match)
            {
                two=f(s,p,i+1,j,map);
            }
            map.put(i+""+j,one || two);
            return one || two;
        }
        if(match)
        {
            boolean one=f(s,p,i+1,j+1,map);
            map.put(i+""+j,one);
            return one;
        }
        map.put(i+""+j,false);
        return false;
    }
    public boolean isMatch(String s, String p) {
        HashMap<String,Boolean> map=new HashMap<>();
        return f(s,p,0,0,map);
    }
}
