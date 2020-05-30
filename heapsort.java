public class heapsort{
    public static void main(String[] args)
    {
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        heapsort_0(arr,true);
    }
    public static void heapsort_0(int[] arr, boolean ismax)
    {
        for(int i=arr.length-1;i>=0;i--)
        {
            downheapify(arr,i,arr.length-1,ismax);
        }
        for(int i=0;i<arr.length;i++)
        { 
            for(int ele:arr)
            {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
    public static void swap(int[] arr,int x,int y)
    {
             Integer val1=arr[x];
             Integer val2=arr[y];
             arr[x]=val2;
             arr[y]=val1;
    }
    public static int compareTo(int val1,int val2,boolean ismax)
    {
            if(ismax)
                 return val1-val2;
            else
                 return val2-val1;
    }
    public static void downheapify(int[] arr,int idx,int n,boolean ismax)
    {
             int maxidx=idx;
             int lci=2*idx+1;
             int rci=2*idx+2;

             if(lci<=n  && compareTo(arr[lci],arr[maxidx],ismax)>0)
             {
                maxidx=lci;
             }
             if(rci<=n  && compareTo(arr[lci],arr[maxidx],ismax)>0)
             {
                maxidx=rci;
             }
             if(maxidx != idx)
             {
                swap(arr,maxidx,idx);
                downheapify(arr,maxidx,n,ismax);
             }
    }
}