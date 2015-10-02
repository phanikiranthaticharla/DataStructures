import java.util.Scanner;

public class EvaluateTemperature {

    public static void main(String[] args) {
	Double fah;
	Integer temperature;
	String unit;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter an integer value for temperature\n");
	temperature = scanner.nextInt();
	System.out.println("Enter the unit: C for Celsius and F for Fahrenheit");
	unit = scanner.next();

	if(unit.equals("C")) {
	    fah = temperature*1.8 + 32 ;
	} else {
	    fah = (double) temperature;
	}
				
	if (fah < 0) {
	    System.out.println("Extremely Cold");
	} else if (fah >= 0 && fah <= 32) {
	    System.out.println("Very Cold");
	} else if (fah >= 33 && fah <= 50) {
	    System.out.println("Cold");
	} else if (fah >= 51 && fah <= 70) {
	    System.out.println("Mild");
	} else if (fah >= 71 && fah <= 90) {
	    System.out.println("Warm");
	} else if (fah >= 91 && fah <= 100) {
	    System.out.println("Hot");
	} else {
	    System.out.println("Very hot");
	}
	scanner.close();
    }
}
