class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        String t1=new String(s1);
        String t2=new String(s2);
        return t1.equals(t2);
    }
}
