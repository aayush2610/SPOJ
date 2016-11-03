package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FASHION {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			int[] a1=new int[n];
			for(int i=0;i<n;i++){
				a1[i]=Integer.parseInt(s[i]);
			}
			s=br.readLine().split(" ");
			int[] a2=new int[n];
			for(int i=0;i<n;i++){
				a2[i]=Integer.parseInt(s[i]);
			}
			Arrays.sort(a1);
			Arrays.sort(a2);
			long sum=0;
			for(int i=0;i<n;i++){
				sum+=(long)a1[i]*a2[i];
			}
			System.out.println(sum);
		}
	}
}
