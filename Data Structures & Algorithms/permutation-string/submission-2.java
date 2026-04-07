class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] temp=s1.toCharArray();
        int n=s1.length();
        Arrays.sort(temp);
        String per=new String(temp);
        System.out.println(per);
        for(int i=0;i<s2.length()-n+1;i++)
        {
            String t=s2.substring(i,i+n);
            char[] check=t.toCharArray();
            Arrays.sort(check);
            String perC=new String(check);
            System.out.println(perC);
            if(per.equals(perC))
                return true;
        }
        return false;
    }
}
