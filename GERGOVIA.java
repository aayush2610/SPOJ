package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GERGOVIA {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(br.readLine());
			if(n==0)
				break;
			int[] arr=new int[n];
			String[] s=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				arr[i]=Integer.parseInt(s[i]);
			}
			long sum=arr[0];
			long ans=0;
			for(int i=1;i<n;i++){
				ans+=Math.abs(sum);
				sum+=arr[i];
			}
			System.out.println(ans);
		}
	}
}
