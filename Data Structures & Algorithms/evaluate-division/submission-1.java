class Solution {
    class Pair
    {
        String node;
        double weight;
        Pair(String n,double w)
        {
            node=n;
            weight=w;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> graph=new HashMap<>();
        for(int i=0;i<equations.size();i++)
        {
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            double val=values[i];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.putIfAbsent(b,new ArrayList<>());
            graph.get(a).add(new Pair(b,val));
            graph.get(b).add(new Pair(a,1.0/val));
        }

        double[] result=new double[queries.size()];
        for(int i=0;i<queries.size();i++)
        {
            String src=queries.get(i).get(0);
            String dest=queries.get(i).get(1);
            if(!graph.containsKey(src) || !graph.containsKey(dest))
                result[i]=-1.0;
            else if(src.equals(dest))
                result[i]=1.0;
            else
            {
                Set<String> visited=new HashSet<>();
                result[i]=dfs(graph,src,dest,1.0,visited);
            }
        }
        return result;
    }
    private double dfs(HashMap<String,List<Pair>> graph,String curr,String target,double product,Set<String> visited)
    {
        visited.add(curr);
        if(curr.equals(target))
            return product;
        for(Pair nei:graph.get(curr))
        {
            double result;
            if(!visited.contains(nei.node)){
                result=dfs(graph,nei.node,target,product*nei.weight,visited);
                if(result!=-1.0)
                    return result;
            }
        }
        return -1.0;
    }
}