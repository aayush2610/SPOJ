package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MoveToInvert {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			long n=Long.parseLong(br.readLine());
			if(n==0 || n==1){
				System.out.println(0);
				continue;
			}
			long x=n/3;
			long sum=x*(x+1)/2;
			x=n-x-1;
			if(x%2==0){
				x=x/2;
				sum+=x*(x+1);
			}
			else{
				x=x/2+1;
				sum+=x*x;
			}
			System.out.println(sum);
		}
	}
}
