package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FossilinIce {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int x=0;x<t;x++){
			int n=scanner.nextInt();
			ArrayList<Integer> a1=new ArrayList<Integer>();
			ArrayList<Integer> a2=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				a1.add(scanner.nextInt());
				a2.add(scanner.nextInt());
			}
			long max=0;
			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++){
					long p1=a1.get(i)-a1.get(j);
					long p2=a2.get(i)-a2.get(j);
					max=Math.max(p1*p1+p2*p2, max);
				}
			}
			System.out.println(max);
		}
	}
}
