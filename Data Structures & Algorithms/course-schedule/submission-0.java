class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];

            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }
        int count=0;
        while(!q.isEmpty())
        {
            int course=q.poll();
            count++;
            for(int next:graph.get(course))
            {
                indegree[next]--;
                if(indegree[next]==0)
                    q.offer(next);
            }
        }
        return count==numCourses;
    }
}
