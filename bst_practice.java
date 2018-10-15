class bst_practice{
    
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
    public bst_practice()
    {
        root=null;
    }

    node insert(node n,int d)
    {
        if(n==null)
        {
            node t=new node(d);
            return t;
        }
        if(d<n.data)
        n.left=insert(n.left,d);
        else if(d>n.data)
        n.right=insert(n.right,d);
        return n;
    }
    void inorder(node n)
    {
        if(n==null)
        return;
        inorder(n.left);    
        System.out.println(n.data+" ");
        inorder(n.right);
    }

    void max(node n)
    {
        while(n.right!=null)
        {
            n=n.right;
        }
        System.out.println("Max:"+n.data);
    }

    void min(node n)
    {
        while(n.left!=null)
        {
            n=n.left;
        }
        System.out.println("Min:"+n.data);
    }

    boolean valid(node n,int max,int min)
    {
        if(n==null)
        return true;
        if(n.data<min || n.data>max)
        return false;
        return (valid(n.left,n.data-1,min) && valid(n.right,max,n.data+1));
    }

    node delete(node n,int d)
    {
        if(n==null)
        return n;
        if(n.data>d)
        n.left= delete(n.left,d);
        else if(n.data<d)
        n.right=delete(n.right,d);
        else
        {
            if(n.right==null)
            return n.left;
            else if(n.left==null)
            return n.right;
            n.data=minVal(n.right);
         //   System.out.println(n.data);
            n.right=delete(n.right,n.data);
        }
        return n;
    }
    int minVal(node n)
    {
        int m=n.data;
        while(n.left!=null)
        {
            m=n.left.data;
            n=n.left;
        }
        return m;
    }

    node lca(node n,int n1,int n2)
    {
        if(n==null)
        return n;

        if(n.data==n1||n.data==n2)
        return n;

        node l=lca(n.left,n1,n2);
        node r=lca(n.right,n1,n2);

        if(l!=null && r!=null)
        return n;

        if(l!=null)
        return l;
        else
        return r;
    }
    node createBalancedbst(int[] a,int start,int end)
    {
        if(start>end)
        return null;

        int mid=(start+end)/2;
        node n=new node(a[mid]);

        n.left=createBalancedbst(a,start,mid-1);
        n.right=createBalancedbst(a,mid+1,end);

        return n;
    }
    int ceil(node n,int d)
    {
        if(n==null)
        return -1;

        if(n.data==d)
        return n.data;

        if(n.data<d)
        return ceil(n.right,d);

        int c=ceil(n.left,d);
        return c>=d?c:n.data;
    }
    int floor(node n,int d)
    {
        if(n==null)
        return Integer.MAX_VALUE;
    
        if(n.data==d)
        return n.data;

        if(n.data>d)
        return floor(n.left,d);

        int f=floor(n.right,d);
        return f<=d?f:n.data;
    }
    int count=0;
    void kthsmallest(node n,int k)
    {
        if(n==null)
        return ;
        kthsmallest(n.left,k);
        ++count;
        if(count==k)
        {
            System.out.println(n.data);
            return;
        }
        kthsmallest(n.right,k);
    }
    public static void main(String[] args)
    {
        bst_practice tree=new bst_practice();
        tree.root=tree.insert(tree.root,1);
        tree.root=tree.insert(tree.root,6);
        tree.root=tree.insert(tree.root,4);
        tree.root=tree.insert(tree.root,-1);
        tree.root=tree.insert(tree.root,5);
        tree.root=tree.insert(tree.root,8);
        tree.inorder(tree.root);
        tree.max(tree.root);
        tree.min(tree.root);
        System.out.println(tree.valid(tree.root,8,-1));
        tree.root=tree.delete(tree.root,1);
        tree.inorder(tree.root);
        node x=tree.lca(tree.root,5,8);
        System.out.println(x.data);

        int[] a=new int[]{1,2,4,5,6,7};
        tree.root=tree.createBalancedbst(a,0,5);
        tree.inorder(tree.root);

        System.out.println(tree.ceil(tree.root,3));
        System.out.println(tree.floor(tree.root,5));

        tree.kthsmallest(tree.root,5);
    }
}
