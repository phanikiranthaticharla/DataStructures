public class Square {
    int length;

    Square() { // Constructor without any parameter
	length = 1;
    }

    Square(int length) { // Constructor with length as a parameter
	this.length = length;

    }

    int getArea() { // method to calculate the area of square
	return length * length;
    }

}
