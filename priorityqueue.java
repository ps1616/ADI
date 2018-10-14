class priorityQueuemin{

        private int[] pq;
        private int n;

        public priorityQueuemin(int capacity)
        {
                 this.pq=new int[capacity];
                this.n=0;
        }

        public boolean isEmpty()
        {
                if(n==0)
                return true;
          return false;
        }

        public int size()
        {
                return n;
        }

        public void insert(int k)
        {
                pq[++n]=k;
                swim(n);
        }

        public int delMin()
        {
                int min=pq[1];
                exch(1,n--);
                sink(1);

                return min;
        }

        public void swim(int k)
        {
                while(k>1 && pq[k/2] > pq[k])
                {
                        exch(k,k/2);
                        k=k/2;
                }
        }
      public void sink(int k)
        {
                while(2*k <=n )
                {
                        int j=2*k;
                        if(j < n && this.pq[j] > this.pq[j+1]) j++;
                        if  (!(this.pq[k] > this.pq[j])) break;
                        exch(k,j);
                        k=j;
                }
        }

        public void exch(int x,int y)
        {
                int t=pq[x];
                pq[x]=pq[y];
                pq[y]=t;
        }

}

class priorityQueuemax{

        private int[] pq;
        private int n;

        public priorityQueuemax(int capacity)
        {
                 this.pq=new int[capacity];
                this.n=0;
        }

        public boolean isEmpty()
        {
                if(n==0)
                return true;
          return false;
        }

        public int size()
        {
                return n;
        }

        public void insert(int k)
        {
                pq[++n]=k;
                swim(n);
        }
                                              public int delMax()
        {
                int max=pq[1];
                exch(1,n--);
                sink(1);

                return max;
        }

        public void swim(int k)
        {
                while(k>1 && pq[k/2] < pq[k])
                {
                        exch(k,k/2);
                        k=k/2;
                }
        }

        public void sink(int k)
        {
                while(2*k <=n )
                {
                        int j=2*k;
                        if(j < n && this.pq[j] < this.pq[j+1]) j++;
                        if  (!(this.pq[k] < this.pq[j])) break;
                        exch(k,j);
                        k=j;
                }
        }

        public void exch(int x,int y)
        {
       int t=pq[x];
                pq[x]=pq[y];
                pq[y]=t;
        }

}
public class priorityqueue{
        public static void main(String[] args){

                priorityQueuemin p=new priorityQueuemin(7);
                p.insert(10);
                p.insert(2);
                p.insert(5);
                p.insert(4);
                p.insert(3);
                p.insert(6);
                System.out.println(p.delMin());

                priorityQueuemax m=new priorityQueuemax(7);
                m.insert(1);
                m.insert(4);
                m.insert(5);
                m.insert(3);
                System.out.println(m.delMax());
        }
}
                                                                      