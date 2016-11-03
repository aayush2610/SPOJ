package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OLOLO {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int x=0;
		while(n>0){
			n--;
			int k=Integer.parseInt(br.readLine());
			x=x^k;
		}
		System.out.println(x);
	}
}