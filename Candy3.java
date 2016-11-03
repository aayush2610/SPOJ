package ques;

import java.util.Scanner;

public class Candy3 {
	public static void main(String[] args) {
		long t,n;
		Scanner scanner=new Scanner(System.in);
		t=scanner.nextLong();
		for(int i=0;i<t;i++){
			long sum=0,p;
			n=scanner.nextLong();
			
			for(int j=0;j<n;j++){
				p=scanner.nextLong();
				sum+=p;
				sum=sum%n;
			}
			if((sum%n)==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
