import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.PrintWriter;

public class LLP {

    Node head;
    int size;
    public static StringBuffer output = new StringBuffer(); 
    public void sortAndInsert(int x) {

        Node p =  head ;
        if ( head == null) {  // when there are no elements in list
            head = new Node(x,  head);
            size++;
        } else if( head.next == null) { //when there is only one element in list
            if(x >  head.data){     // if given element is greater than first element, insert to right
                head.next = new Node(x,null);
            } else {
                head = new Node(x, head);
            }
            size++;

        } else {   // when there are two or more elements, iterate through them and insert the next element at the correct position
            Node p1;
            if(x <= head.data) {     //if the new element is less than the first element, new element becomes the first element         
                head = new Node(x,head);
                size++;
                return;
            }
            while(true) {
                if( (x > p.data) && (p.next == null) ) {  // if x is greater than all other elements, insert at the end 
                    p1 = new Node(x,null);
                    p.next = p1;
                    size++;
                    return;
                } else if( (x>p.data) && (x < p.next.data) ) { 
                    p1 = new Node(x,p.next);
                    p.next = p1;
                    size++;
                    return;
                } else {
                    p = p.next ;
                }
            }
        }
    }


    public static void addToList(LLP a, LLP b, LLP c, int x) {

        if (a.size <= b.size && a.size <= c.size) {    // if size(a) < (size(b) && size(c)) , insert into list a
            a.sortAndInsert(x);
            System.out.println("Added "+x+" to queue L1");
            output.append("Added "+x+" to queue L1\n");
        } else if (b.size < a.size && b.size <= c.size) {  //if size(b) < (size(a) && size(c)), insert into list b
            b.sortAndInsert(x);
            System.out.println("Added "+x+" to queue L2");
            output.append("Added "+x+" to queue L2\n");
        } else {
            c.sortAndInsert(x);                           // size(c) < (size(a) && size(b)), insert into listc
            System.out.println("Added "+x+" to queue L3");
            output.append("Added "+x+" to queue L3\n");
        }
    }

    public int searchAndDelete(int x, int... flag) {
        //Search the first list, if the element is present delete it else go to next list
        Node p = head;

        if(p == null) { //no element in list 
            System.out.println("List is empty");
            return 0;
        } else if(head.data == x) { //if x = first element, remove the first element
            head = head.next;
            size--;
            if(flag.length>0) {       // required to check if the sortAndDelete method is called from cancel or remove method.
                System.out.println("Deleted "+x);        
                output.append("Deleted"+x+"\n");
                return 1;
            } else {
                System.out.println("Removed "+x);
                output.append("Removed "+x+"\n");
                return 1;
            }
        } else {
            while(p.next != null){  // if x is in between, find the element and delete it
                if(p.next.data == x){
                    p.next = p.next.next;
                    size--;
                    if(flag.length>0) {
                        System.out.println("Deleted "+x);
                        output.append("Deleted "+x+"\n");
                        return 1;
                    } else {
                        System.out.println("Removed "+x);
                        output.append("Removed "+x+"\n");
                        return 1;
                    }
                }
                p = p.next;
            }
        }
        return 0;
    }

    public static void cancel(LLP a, LLP b, LLP c, int x) {

        if(a.searchAndDelete(x,1) == 0){ //If the element is not present in first list, check in 2nd list
            if(b.searchAndDelete(x,1) == 0){ //if the element is not present in 2nd list, check in last list
                if(c.searchAndDelete(x,1) == 0) { // if element is not present in 3rd list, element not present anywhere.. unable to delete
                }
            }
        }
    }

    public static void remove(LLP lista, LLP listb, LLP listc) {

        if(lista.head == null ) {
            if(listb.head == null) {
                if(listc.head == null){
                    System.out.println("Remove called on empty queues");
                    output.append("Remove called on empty queues");
                    return;
                } else {
                    listc.searchAndDelete(listc.head.data);  // lista and listb are empty. remove from listc
                    return;
                }
            } else if(listc.head == null) {
                listb.searchAndDelete(listb.head.data);     // lista and listc are empty. remove from listb
                return;
            } else {
                if(listb.head.data <listc.head.data) {     // headnode of listb is less than head node of listc. remove headnode of b
                    listb.searchAndDelete(listb.head.data); 
                    return;
                } else {
                    listc.searchAndDelete(listc.head.data); // headnode of listc is less than head node of listb. remove headnode of c
                    return;
                }
            }
        } else {
            if(listb.head == null) {                  // listb is empty
                if(listc.head == null) {
                    lista.searchAndDelete(lista.head.data);  // listb and listc is empty. remove head node of lista
                    return;
                } else {
                    if(lista.head.data < listc.head.data){  // head(a) < head(c) , remove head(a)
                        lista.searchAndDelete(lista.head.data);
                        return;
                    }
                    else {
                        listc.searchAndDelete(listc.head.data);  // head(c) < head(a) , remove head(c)
                        return;
                    }
                }
            } else {
                if(listc.head == null){             //listc is empty
                    if(lista.head.data < listb.head.data){       // head(a) < head(c), remove head(a)  
                        lista.searchAndDelete(lista.head.data);
                        return;
                    } else {                        // head(b) < list(a), remove head(b) 
                        listb.searchAndDelete(listb.head.data);
                        return;
                    }
                } else {
                    if ((lista.head.data < listb.head.data) && // head(a) < head(b) && head(a) < head(c). remove head(a)
                        (lista.head.data < listc.head.data) ) {
                        lista.searchAndDelete(lista.head.data);
                        return;
                    } else if ((listb.head.data < lista.head.data) 
                               && (listb.head.data < listc.head.data)) {  // head(b) < head(a) && head(b) < head(c). remove head(b)
                        listb.searchAndDelete(listb.head.data);
                        return;
                    } else {
                        listc.searchAndDelete(listc.head.data);           // head(c) < head(b) && head(c) < head(a). remove head(c)
                        return;
                    }
                }
            }
        }
        
    }

    public static void print(LLP a, LLP b, LLP c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        output.append(a+"\n");
        output.append(b+"\n");
        output.append(c+"\n");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        while (p != null) {
            if(p.next == null) {
                sb.append(p.data);
                break;
            }
            sb.append(p.data + " ");
            p = p.next;
        }
        
        sb.append("]");
        return new String(sb);
    }

    public static class Node {
        int data;
        Node next;

        Node(int x, Node n) {
            data = x;
            next = n;
        }
    }

    public static void main(String[] args) {
        LLP lista = new LLP();
        LLP listb = new LLP();
        LLP listc = new LLP();
        
        String fileName;
        if(args.length >0){
            fileName = args[0];
        } else {
            fileName = "input.txt";            //The input file should be in the path where this java file is run
        }
        
        File ip = new File(fileName);          
  
        try {
            Reader fileReader = new FileReader(ip);
            BufferedReader bufferRead = new BufferedReader(fileReader);
            String line = null;
            String cmd = null;
            String val = null;
            while((line = bufferRead.readLine()) != null){
                cmd = line.split(" ")[0];
                if(line.length()>1)
                    val = line.split(" ")[1];
                                
                if (cmd.equals("A")){
                    addToList(lista, listb, listc, Integer.parseInt(val));
                }
                else if(cmd.equals("P")){
                    print(lista,listb,listc);
                }
                else if(cmd.equals("C")){
                    cancel(lista,listb,listc,Integer.parseInt(val));
                }
                else if (cmd.equals("R")){
                    remove(lista,listb,listc);
                }
                                        
            }
            PrintWriter printwriter = new PrintWriter("output.txt");
            printwriter.println(output);
            printwriter.close();
            bufferRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("File input.txt is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
