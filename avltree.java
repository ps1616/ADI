class avltree{

        class Node{
                int key,height;
                Node left,right;

                Node(int d)
                {
                key=d;
                height=1;
                }
        }

        Node root;
        int height(Node n)
        {
                if(n== null)
                        return 0;
                return n.height;
        }
        int max(int a,int b)
        {
                return a>b?a:b;
        }
        Node rightRotate(Node y)
        {
                Node x= y.left;
                Node t=x.right;
                x.right=y;
                y.left=t;
                y.height=1+max(height(y.left),height(y.right));
                x.height=1+max(height(x.left),height(x.right));

                return x;
        }
        Node leftRotate(Node x)
        {
                Node y= x.right;
                Node t=y.left;
                y.left=x;
                x.right=t;
                y.height=1+max(height(y.left),height(y.right));
                x.height=1+max(height(x.left),height(x.right));

                return y;
        }
        int getBalance(Node n)
        {
  if(n==null)
                        return 0;
                return height(n.left) - height(n.right);
        }
        Node insert(Node n,int key)
        {
                if(n==null)
                        return (new Node(key));

                if(key<n.key)
                        n.left=insert(n.left,key);
                else if(key>n.key)
                        n.right=insert(n.right,key);
                else
                        return n;

                n.height=1+max(height(n.left),height(n.right));

                int balance=getBalance(n);
                //left left case
                if(balance>1 && key<n.left.key)
                        return rightRotate(n);
                //right right case
                if(balance<-1 && key>n.right.key)
                        return leftRotate(n);
                //left right case
                if(balance>1 && key> n.left.key)
                {
                        n.left=leftRotate(n.left);
                        return rightRotate(n);
                }
                //right left case
                if(balance<-1 && key<n.right.key)
                {
                        n.right=rightRotate(n.right);
                        return leftRotate(n);
                }
                return n;
        }
        void preOrder(Node n)
        {
                if(n==null)
                        return ;
                System.out.print(n.key+" ");
                preOrder(n.left);
                preOrder(n.right);
        }
        public static void main(String[] args)
                                                                     {
                avltree tree=new avltree();
                tree.root=tree.insert(tree.root,10);
                tree.root=tree.insert(tree.root,20);
                tree.root=tree.insert(tree.root,40);
                tree.root=tree.insert(tree.root,30);
                tree.preOrder(tree.root);
        }
}
                                  