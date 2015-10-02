public class TestSquare {

    public static void main(String[] args) {
	Square s = new Square();			//creating a square of default length 1
	Square s2 = new Square(5);			//creating a square of length 5
	System.out.println("Area of first square = " + s.getArea());
	System.out.println("Area of second square = " + s2.getArea());
    }

}
