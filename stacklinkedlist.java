
import java.util.Iterator;
import java.util.NoSuchElementException;
class stacklinkedlist<Item> implements Iterable<Item>{

        private node first; //top of the stack;
        private int n;
        private int capacity;
        private class node{
                private Item item;
                private node next;
        }
        public stacklinkedlist(int x)
        {
                first=null;
                capacity=x;
                n=0;
        }
        public boolean isempty()
        {
                return first==null;
        }
        public void push(Item d)
        {
                node old=first;
                first=new node();
                first.item=d;
                first.next=old;
        }
        public Item pop()
        {
                Item x=first.item;
                first=first.next;
                return x;
        }

         public Iterator<Item> iterator(){
                return new stackit();}


        class stackit implements Iterator<Item>{

                  node cur=first;
                  public boolean hasNext(){
                         return cur != null;
                 }

                   public Item next(){
           if(!hasNext())
                                throw new NoSuchElementException();
                        Item i=cur.item;
                        cur=cur.next;
                        return i;
                 }

                 public void remove(){
                         throw new UnsupportedOperationException();
                 }
         }

        public static void main(String[] args)
        {
                stacklinkedlist<Integer> s=new stacklinkedlist<Integer>(10);
                s.push(1);
                s.push(3);
                s.push(4);
                s.push(5);
                s.push(7);
                System.out.println(s.pop());
                for(int i:s)
                {
                        System.out.println(i);
                }

        }
}
                                                                       