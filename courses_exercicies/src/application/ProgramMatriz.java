package application;

import java.util.Scanner;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

public class ProgramMatriz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter quantity line: ");
		int nLine = sc.nextInt();
		System.out.print("Enter quantity column: ");
		int nColumn = sc.nextInt();
		
		int mat[][] = new int[nLine][nColumn];
		
		for(int line=0; line<mat.length; line++) {
			System.out.println("Line: " + (line+1));
			for (int column=0; column<mat[line].length; column++) {
				mat[line][column] = sc.nextInt();
			}
		}
		
		System.out.print("Enter position: ");
		int position = sc.nextInt();
		
		find_positin(position, mat);
		
		sc.close();

	}

	private static void find_positin(int position, int[][] mat) {
		
		for(int line=0; line<mat.length; line++) {
			for(int column=0; column<mat[line].length; column++) {
				if (mat[line][column] == position){
					System.out.println("Position: "+ line + ", " + column);
	
					if (line > 0) {
						System.out.println("Up: " + mat[line -1][column]);
					}
					if (line > 0) {
						System.out.println("Left: " + mat[line][column - 1]);
					}
					if (column < mat[line].length -1) {
						System.out.println("Rigth" + mat[line][column + 1]);
					}
					if (line < mat.length - 1) {
						System.out.println("Down: " + mat[line +1][column]);
					}
				}
			}
		}
	}

}
