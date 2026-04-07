class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] pre=new boolean[numCourses][numCourses];
        for(int[] p:prerequisites)
            pre[p[0]][p[1]]=true;
        for(int k=0;k<numCourses;k++)
        {
            for(int i=0;i<numCourses;i++)
            {
                for(int j=0;j<numCourses;j++)
                {
                    if(pre[i][k] && pre[k][j])
                        pre[i][j]=true;
                }
            }
        }
        List<Boolean> result=new ArrayList<>();
        for(int[] q:queries)
        {
            if(pre[q[0]][q[1]])
                result.add(true);
            else
                result.add(false);
        }
        return result;

    }
}