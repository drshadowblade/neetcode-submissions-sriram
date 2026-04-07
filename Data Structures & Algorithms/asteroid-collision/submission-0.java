class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroid=new Stack<>();
        int[] result;
        for(int a:asteroids)
        {
            boolean destroy=false;
            while(!asteroid.isEmpty() && a<0 && asteroid.peek()>0)
            {
                int top=asteroid.peek();
                if(Math.abs(a)==Math.abs(top))
                    asteroid.pop();
                else if(Math.abs(a)>Math.abs(top))
                {
                    asteroid.pop();
                    continue;
                }
                destroy=true;
                break;
            }
            if(!destroy)
                asteroid.push(a);
        }
        result=new int[asteroid.size()];
        for(int i=asteroid.size()-1;i>=0;i--)
        {
            result[i]=asteroid.pop();
        }
        return result;
    }
}