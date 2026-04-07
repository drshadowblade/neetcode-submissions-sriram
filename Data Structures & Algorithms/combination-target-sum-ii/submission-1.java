class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int[] nums,int index,int target,List<Integer> current,List<List<Integer>> result)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0) return;
        for(int i=index;i<nums.length;i++)
        {
            if(i>index && nums[i]==nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(nums,i+1,target-nums[i],current,result);
            current.remove(current.size()-1);
        }
    }
}
