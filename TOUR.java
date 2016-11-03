package ques;

import java.util.Scanner;

public class TOUR {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++){
			int n=scanner.nextInt();
			int x=0;
			for(int j=0;j<n;j++){
				int m=scanner.nextInt();
				if(m==0){
					x=1;
					break;
				}
				if(n-m-1>=Math.ceil(Math.log(n)))
					x++;
				while(m>0){
					int c=scanner.nextInt();
					m--;
				}
			}
			System.out.println(x);
		}
	}
}
