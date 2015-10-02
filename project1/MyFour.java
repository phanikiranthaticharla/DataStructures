public class MyFour<T> {
    T item1 = null;
    T item2 = null;
    T item3 = null;
    T item4 = null;

    MyFour(T item1, T item2, T item3, T item4) {
	this.item1 = item1;     //Initialize the items 
	this.item2 = item2;
	this.item3 = item3;
	this.item4 = item4;
    }

    boolean AllEqual() {		//Method to check if the given items of type T are equal
	if (item1.equals(item2) && item2.equals(item3) && item3.equals(item4))
	    return true;
	else
	    return false;

    }

    void shiftLeft() {			//Method to shift items left once
	T temp = item1;
	item1 = item2;
	item2 = item3;
	item3 = item4;
	item4 = temp;
    }

    public String toString() {
	return "(" + item1 + "," + item2 + "," + item3 + "," + item4 + ")";

    }

    public static void main(String[] args) {
	MyFour<Integer> t = new MyFour<Integer>(1, 2, 3, 4);
	MyFour<String> t1 = new MyFour<String>("first", "second", "third", "fourth");
	if (t.AllEqual()) {
	    System.out.println("The four integers are equal");
	} else {
	    System.out.println("The four integers are not equal");
	}

	if (t1.AllEqual()) {
	    System.out.println("The four strings are equal");
	} else {
	    System.out.println("The four strings are not equal");
	}

	t.shiftLeft(); // Shift the integers left once
	t1.shiftLeft(); // Shift the strings left once
	System.out.println(t.toString()); //print the shifted integers
	System.out.println(t1.toString()); // print the shifted strings
    }
}
