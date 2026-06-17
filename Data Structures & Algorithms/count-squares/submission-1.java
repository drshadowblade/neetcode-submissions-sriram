class CountSquares {
    private HashMap<String,Integer> map;
    private List<int[]> list;
    public CountSquares() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public void add(int[] point) {
        String key=point[0]+" "+point[1];
        map.put(key,map.getOrDefault(key,0)+1);
        list.add(point);
    }
    
    public int count(int[] point) {
        int res=0;
        int px=point[0];
        int py=point[1];

        for(int[] arr:list)
        {
            int x=arr[0];
            int y=arr[1];
            if(!(Math.abs(px-x)==Math.abs(py-y)) || x==px || y==py)
                continue;
            int count1=map.getOrDefault(x+" "+py,0);
            int count2=map.getOrDefault(px+" "+y,0);
            res+=(count1*count2);
        }
        return res;
    }
}
