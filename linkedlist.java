import java.util.*;
public class linkedlist<T> implements Iterable<T>{
        private class node{
                private T data;
                private node next;
                public node(T d)
                {
                        data=d;
                        next=null;
                }
        }
        private node head;
        public void add(T data)
        {
                if(head==null)
                        head=new node(data);
                else
                {
                        node t=head;
                        while(t.next!=null)
                                t=t.next;
                        t.next=new node(data);
                }
        }
        public Iterator<T> iterator()
        {
                return new customIterator();
        }
        private class customIterator implements Iterator<T>
        {
                private node t=head;
                public boolean hasNext()
                {
                        return t!=null;
                }
                public T next()
                {
                        T x=t.data;
                        t=t.next;
                        return x;
                }
        }
        public static void main(String[] args)
        {
                linkedlist<Integer> l=new linkedlist<>();
                l.add(3);
                l.add(4);
                l.add(5);
                l.add(6);
        print(l);
        }
        public static void print(Iterable<Integer> i)
        {
                Iterator<Integer> ite=i.iterator();
                //while(ite.hasNext())
                        System.out.println(ite.next());
        }
}
                                                               