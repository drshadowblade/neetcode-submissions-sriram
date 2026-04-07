class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Set<String>> graph=new HashMap<>();
        HashMap<String,String> emailToName=new HashMap<>();
        for(List<String> acc:accounts)
        {
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++)
            {
                String email=acc.get(i);
                graph.putIfAbsent(email,new HashSet<>());
                emailToName.put(email,name);
                if(i==1) continue;
                String prev=acc.get(i-1);
                graph.get(email).add(prev);
                graph.get(prev).add(email);
            }
        }
        Set<String> visited=new HashSet<>();
        List<List<String>> result=new ArrayList<>();
        for(String email:graph.keySet())
        {
            if(visited.contains(email)) continue;
            List<String> temp=new ArrayList<>();
            dfs(email,graph,visited,temp);
            temp.add(0,emailToName.get(email));
            Collections.sort(temp);
            result.add(temp);
        }
        return result;
    }
    private void dfs(String email,HashMap<String,Set<String>> graph,Set<String> visited,List<String> temp)
    {
        visited.add(email);
        temp.add(email);
        for(String nei:graph.get(email))
        {
            if(!visited.contains(nei))
                dfs(nei,graph,visited,temp);
        }
    }
}