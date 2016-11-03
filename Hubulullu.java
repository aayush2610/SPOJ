package ques;

import java.util.Scanner;

public class Hubulullu {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			t--;
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			if(k==0)
				System.out.println("Airborne wins.");
			else
				System.out.println("Pagfloyd wins.");
		}
	}
}
