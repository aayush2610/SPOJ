package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BytelandianCoin {
	static int []a=new int[1000001];
	public static long r(int n){
		if(n<=1000000){
			return a[n];
		}
		else{
			return Math.max((long)n, r(n/2)+r(n/3)+r(n/4));
		}
	}
	public static void main(String[] args) throws IOException {
		String n;
		long ans=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=br.readLine();
		a[0]=0;
		a[1]=1;
		a[2]=2;
		a[3]=3;
		a[4]=4;
		a[5]=5;
		for(int i=0;i<=1000000;i++){
			a[i]=Math.max(i, a[i/2]+a[i/3]+a[i/4]);
		}
		while(n!=null && !n.equalsIgnoreCase("")){
			int l;
			l = Integer.parseInt(n);
			ans=r(l);
			System.out.println(ans);
			n=br.readLine();
		}	
			
		}
	}

	
	
	