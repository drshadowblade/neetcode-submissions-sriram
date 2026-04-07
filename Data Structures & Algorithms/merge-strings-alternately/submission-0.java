class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        StringBuilder result=new StringBuilder();
        int i=0;
        while(i<l1 && i<l2)
        {
            result.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }
        while(i<l1) 
        {
            result.append(word1.charAt(i));
            i++;
        }
        while(i<l2) 
        {
            result.append(word2.charAt(i));
            i++;
        }
        return result.toString();
    }
}