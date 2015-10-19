public class GenBinTree<AnyType> {
    
    Node<AnyType> root;  // root node
    Node<AnyType> p ;   
    static boolean flag;
    static int count;

    public GenBinTree() {  // Construct the tree
       root = null;
    }

    public void add( AnyType x )   //Method to add a root node
    {
        root = addNode(x);
        System.out.println("Added root node: "+root.data);
    }

    public void add(String dir, AnyType x) {   //Method to add a child nodes to the root node
        
        p = root; // pointer required to traverse

        if(find(x)) {
            System.out.println("Node "+x+" already present. Not adding");   // Ignore duplicates
            return;
        }
        if(count(root) > 1) { 
            for (int i = 0 ;i < dir.length() ; i++) {
                if((dir.charAt(i)) == 'L' ) {
                    if(p.left != null) {
                        p = p.left;
                    } else if( i != (dir.length() - 1)) {
                        System.out.println(dir+" Not a valid path to insert");
                        return;
                    }  
                } else if ((dir.charAt(i)) == 'R') {
                    if(p.right != null) {
                        p = p.right;
                    } else if( i != (dir.length() - 1)) {
                        System.out.println(dir+"Not a valid path to insert");
                        return;
                    } 
                } else {
                    System.out.println("Not a valid command. Please enter 'L' for left and 'R' for right "+dir.charAt(i));
                    return;
                }
            }
        }
        if(dir.charAt(dir.length() - 1) == 'L'){
            p.left = addNode(x);
            System.out.println("Added node: "+x);
        } else {
            p.right = addNode(x);
            System.out.println("Added node: "+x);
        }

    }
    
    public void print(){                //Method to call printTree method which prints the actual tree
        print(root);
    }
    public void print(Node<AnyType> t){
 
        if(t != null) {
            print(t.left);
            System.out.println(t.data);
            print(t.right);
        }

    }

    public boolean find(AnyType x){           //Method to check if data passed is equal to root's data, if not check child nodes
        if(root.data == x) 
            return true; 
        else 
            return find(root,x);
    }

    public boolean find(Node<AnyType> t, AnyType x) {    //Method to check if data passed is present in child nodes
        
        if(t != null) {
            if(t.data == x) 
                return true;
            else if(find(t.left,x))
                return true;
            else if(find(t.right,x))
                return true;
            else 
                flag = false;
        } 
        return flag;
    }

    public void remove(AnyType x) {
        
        if(root.data == x && root.left ==null && root.right == null) {
            root = null;
            return;
        }
        flag = false;
        remove(root,x);

    }

    public void remove(Node<AnyType> t, AnyType x) {

        if(t == null) 
            return;

        if(t.left != null) {
            if(t.left.data == x) {
                if(t.left.left == null && t.left.right == null) {
                    t.left = null;
                    flag = true;
                    System.out.println("Removed node "+x+" successfully");
                    return;
                } else {
                    System.out.println("Cannot remove node "+x+" as it is not a leaf node");
                    return;
                }
            }
        }

        if(t.right != null) {
            if(t.right.data == x) {
                if(t.right.left == null && t.right.right == null) {
                    t.right = null;
                    flag = true;
                    System.out.println("Removed node "+x+" successfully");
                    return;
                } else {
                    System.out.println("Cannot remove node "+x+" as it is not a leaf node");
                    return;
                }
            }
        }
        
        if(flag == false) 
            remove(t.left, x);
        if(flag == false)
            remove(t.right,x);
        
    }

    public void swap(AnyType x) {                  //Method which calls swap on a given node
        swap(root, x);
    }

    public boolean swap(Node<AnyType> t, AnyType x) {
        
        Node<AnyType> temp;

        if(t != null) {
            if(t.data == x) {
                temp = t.left;
                t.left = t.right;
                t.right = temp;
                return true;
            }
            if(swap(t.left, x))
                return true;
            if(swap(t.right,x))
                return true;
        }
        System.out.println("Cannot perform swap on the given node");
        return false;
    }

    public void mirror(){
        System.out.println("Performing mirror rotation");
        mirror(root);
    }
    
    public void mirror(Node<AnyType> t) {
        
        Node<AnyType> temp;
        if(t == null) 
            return;

        temp = t.left;
        t.left = t.right;
        t.right = temp;

        mirror(t.left);
        mirror(t.right);
    }

    public void rotateRight(AnyType x) {
        flag = false;
        rotateRight(root, x) ;
        return;
    }

    public Node<AnyType> rotateRight(Node<AnyType> t, AnyType x) {
        /*Find the node which has to be rotated */

        Node<AnyType> temp;

        if(t != null && t.left != null) {
            
            if(t.data == x) {
                /* Code which does the rotate is here */
                System.out.println("Performing rotation on node "+x);
                temp = t.left;
                t.left = temp.right;
                temp.right = t;
                flag = true;
                System.out.println("Right Rotation of node "+x+" successful");
                return temp; //Success
            }
        } else {
            if(t != null && t.left == null) {
                if(t.data == x) {
                    System.out.println("Right Rotation not possible on node "+x);
                    flag = true;
                    return t;
                }
            }
        }
        if(flag == true)
            return t;
        
        t.left = rotateRight(t.left,x);
        if(flag == true)
            return t;
        
        t.right = rotateRight(t.right,x);
                        
        return root;
    }

    public void rotateLeft(AnyType x) {
        flag = false;
        root = rotateLeft(root, x) ;
        if(flag == true) {
            System.out.println("Left Rotation of node "+x+" successful");
        }
        return;
    }

    public Node<AnyType> rotateLeft(Node<AnyType> t, AnyType x) {
        /*Find the node which has to be rotated */
        
        Node<AnyType> temp;
        Node<AnyType> temp1;

        if(t != null && t.right != null) {
            if(t.data == x) {
                /* Code which does the rotate left is here */
                temp1 = t;
                temp = t.right;
                t.right = t.right.left;
                t = temp;
                t.left = temp1;
                flag = true;
                System.out.println("Left Rotation of node "+x+" successful");
                return t; //Success
            }
        } else {
            if(t != null && t.right == null) {
                if(t.data == x) {
                    System.out.println("Left Rotation of node "+x+" not possible");
                    flag = true;
                    return t;
                }
            }
        }
        
        if(flag = true) 
            return t;
        
        t.left = rotateLeft(t.left,x);
        
        if(flag = true) 
            return t;
        t.right = rotateLeft(t.right,x);

        return root;        // Dummy return        
    }
    
    public void count() {
        count = 0;
        int count = count(root);
        System.out.println("Count "+count);
    }
    
    public int count(Node <AnyType> t) {
  
        if(t != null) {
            count(t.left);
            count++;
            count(t.right);
        }
        return count;
    }

    public Node<AnyType> addNode(AnyType x)            //Method that creates a new node and returns it 
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
        GenBinTree<String> myTree = new GenBinTree<>();
        myTree.add("100");
        myTree.add("L", "50");
        myTree.add("R", "150");
        
        myTree.add("R", "200");
        myTree.add("LL", "40");
        myTree.add("LLR", "45");
        myTree.add("LLRL", "50");
        myTree.add("LLLLL", "500");
        myTree.print();
        myTree.count();
        // boolean value = myTree.find("45");
        // System.out.println(value);
        // myTree.swap("50");
        // myTree.print();
        // myTree.rotateRight("50");
        // myTree.print();
        // myTree.rotateLeft("40");
        // myTree.print();
        // myTree.count();
        
        // myTree.rotateLeft("50");
        // myTree.print();
        // myTree.remove("150");
        // myTree.print();
        
        // myTree.remove("100");
        // myTree.print();
        // System.out.println("mirror");
        // myTree.mirror();
        // myTree.print();
    }
    
}
