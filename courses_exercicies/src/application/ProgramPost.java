package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Comment;
import entities.PostWithStringBuilder;

public class ProgramPost {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		
		Scanner sc = new Scanner(System.in);
		
		
		
		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("Wow that's awesome!");
		
		PostWithStringBuilder p1 = new PostWithStringBuilder(
				sdf.parse("21/06/2018 13:05:44"),
				"Traveling to New Zealand", 
				"I'm  going to visit this wonderful country!", 
				12);
		p1.addComments(c1);
		p1.addComments(c2);
		
		System.out.println(p1);
		
		
		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the Force be with you");
		
		PostWithStringBuilder p2 = new PostWithStringBuilder(
				sdf.parse("28/07/2018 23:14:19"),
				"Good night guys", 
				"See you tomorrow", 
				5);
		p2.addComments(c3);
		p2.addComments(c4);
		
		System.out.println(p2);
		
		
		sc.close();
	}

}
