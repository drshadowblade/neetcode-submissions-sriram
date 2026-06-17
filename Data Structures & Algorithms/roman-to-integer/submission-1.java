class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        if(s.length()==1) return map.get(s.charAt(0));
        int sum=0;
        int i=0;
        while(i<s.length()-1)
        {
            char r=s.charAt(i+1);
            char l=s.charAt(i);
            if(map.get(l)<map.get(r))
            {
                sum+=(map.get(r)-map.get(l));
                System.out.print(sum+" ");
                i+=2;
            }
            else
            {
                sum+=map.get(l);
                i++;
            }
        }
        int r=s.length()-1;
        if(map.get(s.charAt(r-1))>=map.get(s.charAt(r)))
            sum+=map.get(s.charAt(r));
        return sum;
    }
}