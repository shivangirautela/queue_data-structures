import java.util.*;

public class myqueue{
    public static void main(String[] args)
    {
       myqueue s =new myqueue();
       for(int i=0;i<10;i++)
       {
           s.push(i+10);
       }
      System.out.println(s.pop());
      s.print();
    }
    private int st,end,size;
    private int []arr;
    myqueue()
    {
        this.arr=new int[10];
    }
    myqueue(int size)
    {
        this.arr=new int[size];
    }
    public boolean isEmpty()
    {
        return this.size==0;
    }
    public int front()
    {
        if(this.size==0)
        {
            System.err.println("queue_isempty");
            return -1;
        }
        return this.arr[this.st];
    }
    public void push(int data)
    {
        if(this.size==this.arr.length)
        {
            System.err.println("queue_is_overflow");
        }
        this.arr[this.end]=data;
        this.end=(this.end+1)%arr.length;
        this.size++;
    }
    public int pop()
    {
        if(this.size==0)
        {
            System.err.println("queue_underflow");
            return -1;
        }
        int rv=this.arr[this.st];
        this.arr[this.st]=0;
        this.size--;
        this.st=(this.st+1)%arr.length;
        return rv;
    }
    public void print()
    {
        System.out.print("[");
        for(int i=0;i<this.size;i++)
        {
            int idx = (this.st + i) % arr.length;
            System.out.print(arr[idx] + ",");
        }
        System.out.println("]");
    }
}