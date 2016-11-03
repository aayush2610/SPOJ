package ques;

import java.util.Scanner;

public class Relax {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			int x,y;
			x=scanner.nextInt();
			y=scanner.nextInt();
			if(x==-1 || y==-1)
				break;
			else if(x==1 || y==1)
				System.out.println(x+"+"+y+"="+(x+y));
			else 
				System.out.println(x+"+"+y+"!="+(x+y));
		}
	}
}
