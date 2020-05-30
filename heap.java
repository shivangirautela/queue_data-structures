import java.util.*;
public class heap{
    public static void main(String[] args)
    {
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        priorityqueue pq=new priorityqueue(arr,false);
        
        while(pq.size()!=0)
        {
            System.out.print(pq.remove()+" ");
        }
    }
    public static class priorityqueue{
        ArrayList<Integer> arr=new  ArrayList<>();
        boolean ismax=true;
        priorityqueue(boolean ismax)
        {
            this.ismax=ismax;
        }
        priorityqueue(int[] arr1,boolean ismax)
        {
            this.ismax=ismax;
            for(int i=0;i<arr1.length;i++)
            {
              arr.add(arr1[i]);
            }
            for(int i=arr.size()-1;i>=0;i--)
            {
                downheapify(i);
            }
        }
        public void add(int val){
             arr.add(val);
             upheapify(arr.size()-1);
        }
        public int top()
        {
            return arr.get(0);
        }
        public int size()
        {
            return arr.size();
        }
        public int remove()
        {
            swap(0,arr.size()-1);

            int remove_ele=arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            downheapify(0);
             return remove_ele;
        }
        public void update(int preval,int newval)
        {
            int idx=-1;
            for(int i=0 ;i<arr.size();i++)
            {
                if(arr.get(i)==preval)
                {
                    idx=i;
                    break;
                }
            }
            if(idx==-1)
            {
                return ;
            }
            arr.set(idx,newval);
            upheapify(idx);
            downheapify(idx);
        }
    
        public void swap(int x,int y)
        {
             Integer val1=arr.get(x);
             Integer val2=arr.get(y);
             arr.set(x,val2);
             arr.set(y,val1);
        }
        public int compareTo(int val1,int val2)
        {
            if(ismax)
                 return val1-val2;
            else
                 return val2-val1;
        }
        public void upheapify(int ci)
        {
            int pi= (ci-1) /2; //(ci-1)>>1
            if( pi>=0 && compareTo((int) arr.get(ci),(int) arr.get(pi))>0)
            {
              swap(pi,ci);
              upheapify(pi);
             }
        }
        public void downheapify(int idx)
        {
             int maxidx=idx;
             int lci=2*idx+1;
             int rci=2*idx+2;

             if(lci< arr.size()  && compareTo((int) arr.get(lci),(int)arr.get(maxidx))>0)
             {
                maxidx=lci;
             }
             if(rci< arr.size()  && compareTo((int) arr.get(rci),(int)arr.get(maxidx))>0)
             {
                maxidx=rci;
             }
             if(maxidx != idx)
             {
                swap(maxidx,idx);
                downheapify(maxidx);
             }
        }
    }
}
    