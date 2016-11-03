package ques;

import java.util.Scanner;

public class CATM {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int t=scanner.nextInt();
		while(t>0){
			t--;
			int m1=scanner.nextInt();
			int m2=scanner.nextInt();
			int c1=scanner.nextInt();
			int c2=scanner.nextInt();
			int d1=scanner.nextInt();
			int d2=scanner.nextInt();
			
			if(Math.abs(c1-d1)==Math.abs(c2-d2)){
				if(Math.abs(c1-m1)==Math.abs(c2-m2) && Math.abs(d1-m1)==Math.abs(d2-m2)){
					if(Math.abs(c1-m1)<=Math.abs(c1-d1) && Math.abs(d1-m1)<=Math.abs(c1-d1)){
						System.out.println("NO");
					}
					else
						System.out.println("YES");
				}
				else
					System.out.println("YES");
			}
			else
				System.out.println("YES");
		}
	}
}
