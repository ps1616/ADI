class bst{
        class node{
                int data;
                node left,right;
                public node(int d)
                {
                        data=d;
                        left=right=null;
                }
        }
        node root;

        public bst()
        {
        root=null;
        }
        void insert(int d)
        {
                root=insertr(root,d);
        }
        node insertr(node root,int d)
        {
                if(root==null)
                {
                        root=new node(d);
                        return root;
                }
                 if(d<root.data)
                        root.left=insertr(root.left,d);
                else if(d>root.data)
                        root.right=insertr(root.right,d);
                return root;
        }
        void search(int d)
        {
                if(searchr(root,d)!=null)
                        System.out.println("1");
                else
                        System.out.println("0");
        }
        node searchr(node root,int d)
        {
                if(root==null || root.data==d)
                        return root;
                if(d<root.data)
                        return searchr(root.left,d);
                else
                        return searchr(root.right,d);
     }
        void inorder()
        {
                inorderr(root);
        }
        void inorderr(node root)
        {
                if(root==null)
                        return;
                inorderr(root.left);
                System.out.println(root.data);
                inorderr(root.right);
        }
        public static void main(String[] args)
        {
                bst tree=new bst();
                tree.insert(1);
                tree.insert(4);
                tree.insert(3);
                tree.insert(5);
                tree.inorder();
                tree.search(2);
        }
}
                                                         