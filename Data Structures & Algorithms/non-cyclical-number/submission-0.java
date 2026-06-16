class Solution {
    public boolean isHappy(int n) {
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        while(n>1)
        {
            sum=0;
            while(n>0)
            {
                int dig=n%10;
                sum+=(dig*dig);
                n=n/10;
            }
            if(set.contains(sum))
                return false;
            set.add(sum);
            n=sum;
        }
        return true;
    }
}
