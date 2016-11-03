package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class POLEVAL {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int count=1;
		while(true){
			int n=Integer.parseInt(br.readLine());
			if(n==-1)
				break;
			int[] coeff=new int[n+1];
			String[] s=br.readLine().split(" ");
			coeff[0]=Integer.parseInt(s[0]);
			for(int i=1;i<s.length;i++){
				coeff[i]=Integer.parseInt(s[i]);
			}
			int p=Integer.parseInt(br.readLine());
			System.out.println("Case "+count+":");
			s=br.readLine().split(" ");
			for(int i=0;i<p;i++){
				int x=Integer.parseInt(s[i]);
				long sum=0;
				for(int j=0;j<=n;j++){
					sum=(long)sum*x;
					sum+=(long)coeff[j];
				}
				System.out.println(sum);
			}
			count++;
		}
	}
}
