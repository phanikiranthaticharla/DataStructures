public class GenBinTree<AnyType> {

    Node root;
    
    public GenBinTree() {  // Construct the tree
        root = null;
    }

    public void add(AnyType data) {
        root.data = data ;
        root.left = null;
        root.right = null;
        
    }

    public void add(String dir, AnyType data) {
        
    }

    public Node createNode(AnyType data, Node l, Node r){
        Node x = new Node(data, l , r);
        return x;
    }

    public static class Node<AnyType> {
        AnyType data;
        Node<AnyType> left;
        Node<AnyType> right;
        
        Node(AnyType x, Node<AnyType> l, Node<AnyType> r) {
            data = x;
            left = l;
            right = r;
        }
    }

    public static void main(String[] args) {
        GenBinTree g = new GenBinTree();
        g.add("50");
        g.add("LL", "50");
    }
    
}
