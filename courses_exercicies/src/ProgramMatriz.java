import java.util.Scanner;

public class ProgramMatriz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter quantity the Matriz: ");
		int n = sc.nextInt();
		int[][] mat = new int[n][n];
		int count = 0;
		
		for (int line=0; line<mat.length; line++) {
			System.out.println("Line: " + (line +1));
			for (int column=0; column<mat[line].length; column++) {
				System.out.print("Column - " + (column + 1) + ": ");
				mat[line][column] = sc.nextInt();
				if (mat[line][column] < 0) {
					count ++;
				}
			}
		}
		System.out.println("Main diagonal");
		
		for (int i=0; i<mat.length; i++) {
			System.out.println(mat[i][i] + "");
		}
		
		System.out.println("Negative numbers: " + count);
		
		
		sc.close();
	}

}
