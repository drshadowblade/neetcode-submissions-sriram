class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded=new StringBuilder();
        for(String str:strs)
        {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decode=new ArrayList<>();
        int i=0;

        while(i<str.length())
        {
            int j=i;

            while(str.charAt(j)!='#')
                j++;
            int length=Integer.parseInt(str.substring(i,j));
            j++;
            String s=str.substring(j,j+length);
            decode.add(s);
            i=j+length;
        }
        return decode;
    }
}
