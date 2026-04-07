class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        int n=nums.length;
        int freq=n/3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > freq)
                result.add(entry.getKey());  
        }
        return result;
    }
}