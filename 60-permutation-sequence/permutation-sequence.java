class Solution {
    public static int fact(int n)
    {
        if(n<=1)
        {
            return 1;
        }
        return n*fact(n-1);
    }
    public String getPermutation(int n, int k) {
        k--;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        String result="";
        for(int i=1;i<=n;i++)
        {
            int fg=fact(list.size()-1);
            int index=k/fg;
            result=result+list.get(index);
            list.remove(index);
            k=k%fg;
        }
        return result;
    }
}