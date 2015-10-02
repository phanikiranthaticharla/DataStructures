import java.util.Scanner;

class Scores {
    public static void main(String[] args) {
	String[] names = new String[10];
	int[][] scores = new int[10][5];
	int i, j, sum = 0;
	double avg = 0;
	String[] suffix = {"st","nd","rd","th","th","th","th","th","th","th"};
	System.out.println("Enter names of ten different students\n");
	Scanner scanner = new Scanner(System.in);
	for (i = 0; i < 10; i++) {
	    System.out.println("Enter name of " + (i+1)+suffix[i]+ " student\n"); // Store the names of the students in a 1D array
	    names[i] = scanner.nextLine();
	}
	for (i = 0; i < 10; i++) {
	    System.out.println("Enter the 5 quiz scores of " + names[i]); // Store the quiz scores of the students in 2D array
	    for (j = 0; j < 5; j++) {
		scores[i][j] = scanner.nextInt();
	    }
	}
	for (i = 0; i < 10; i++) {
	    sum = 0;
	    for (j = 0; j < 5; j++) {
		sum = sum + scores[i][j]; //Calculate the total score for each student
	    }
	    avg = sum / 5; // Calculate the average quiz score
	    System.out.println("Average score of " + names[i] + " = " + avg);
	}
	scanner.close();
    }

}
