import java.util.*;
class graph_time{
   public int n;
   public LinkedList<Integer> a[];
   public int visited[];
   public int timein[];
   public int timeout[];
   public int in,out;
   public graph_time(int n)
   {
       this.n=n;
       a=new LinkedList[n];
       for(int i=0;i<n;i++)
       a[i]=new LinkedList<>();

        visited=new int[n];
       for(int i=0;i<n;i++)
       visited[i]=0;

       timeout=new int[n];
        in=0;
        timein=new int[n];
        out=0;
   }
   void add(int s,int d)
   {
       a[s].add(d);
   }
   void dfs(int u)
   {
       visited[u]=1;
       timein[u]=++in;
       System.out.print(u+" ");
       for(int i=0;i<a[u].size();i++)
       {
           int v=a[u].get(i);
           if(visited[v]!=0)
           continue;
           dfs(v);
       }
       visited[u]=2;
       timeout[u]=++in;
   }
   void printtime()
   {
       System.out.println();
       for(int i=0;i<n;i++)
       System.out.println(timein[i]+"<->"+timeout[i]);
   }
   public static void main(String[] args)
   {
       int n=8;
       graph_time g=new graph_time(n);
         g.add(0, 1); 
        g.add( 0, 2); 
        g.add( 1, 3); 
        g.add( 1, 4);  
        g.add( 3, 5); 
        g.add( 2, 6);
        g.add( 2, 7);
        g.dfs(0);
        g.printtime();
   }
}