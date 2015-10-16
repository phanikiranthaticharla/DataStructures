public class GenBinTree<AnyType> {

    Node<AnyType> root;  // root node
    Node<AnyType> p ;   // pointer to go to the leaf node for adding Node
    static boolean flag;

    public GenBinTree() {  // Construct the tree
       root = null;
    }

    public void add( AnyType x )
    {
        root = addNode(x);
    }

    public void add(String dir, AnyType x) {
        
        p = root; // pointer required to traverse

        for (int i = 0 ;i < dir.length() ; i++) {
            if((dir.charAt(i)) == 'L' && (p.left != null) ) {
                p = p.left;
            } else if ((dir.charAt(i)) == 'R' && (p.right != null)) {
                p = p.right;
            } else {
                // Unknown command
            }
        }
        
        if(dir.charAt(dir.length() - 1) == 'L'){
            p.left = addNode(x);
        } else {
            p.right = addNode(x);
        }

    }
    
    public void print(){
        printTree(root);
    }
    public void printTree(Node<AnyType> t){
 
        if(t != null) {
            printTree(t.left);
            System.out.println(t.data);
            printTree(t.right);
        }

    }

    public boolean find(AnyType x){           //Method to check if data passed is equal to root's data, if not check child nodes
        if(root.data == x) 
            return true; 
        else 
            return findChild(root,x);
    }

    public boolean findChild(Node<AnyType> t, AnyType x) {    //Method to check if data passed is present in child nodes
        
        if(t != null) {
            if(t.data == x) 
                return true;
            else if(findChild(t.left,x))
                return true;
            else if(findChild(t.right,x))
                return true;
            else 
                flag = false;
        } 
        if(flag == false)
            return false;   //Element not found
        else 
            return true;
    }

    public Node<AnyType> addNode(AnyType x)
    {
        return new Node<>( x, null, null );

    }

    public static class Node<AnyType> {
        AnyType data;
        Node<AnyType> left;
        Node<AnyType> right;

        Node(AnyType x){
            this(x, null, null);
        }
        
        Node(AnyType x, Node<AnyType> l, Node<AnyType> r) {
            data = x;
            left = l;
            right = r;
        }
    }

    public static void main(String[] args) {
        GenBinTree g = new GenBinTree();
        g.add("100");
        g.add("L", "50");
        g.add("R", "150");
        g.add("LL", "40");
        g.add("LLR", "45");
        g.add("RL", "60");
        g.add("RLL", 101);
        g.print();
        
        boolean value = g.find("70");
        System.out.println(value);
    }
    
}
