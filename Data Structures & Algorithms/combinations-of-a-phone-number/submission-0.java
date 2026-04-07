class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] map={
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        combination(result,map,"",0,digits);
        return result;
    }
    private void combination(List<String> result,String[] map,String current,int index,String digits)
    {
        if(index==digits.length())
        {
            result.add(current);
            return;
        }

        int digit=digits.charAt(index)-'0';
        String str=map[digit];

        for(char ch:str.toCharArray())
        {
            combination(result,map,current+ch,index+1,digits);
        }
    }
}
