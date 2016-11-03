package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ORDERS {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=Integer.parseInt(s[i]);
			}
			int[] ar=new int[n];
			for(int i=0;i<n;i++){
				ar[i]=i+1;
			}
			for(int i=0;i<n;i++){
				ar[i]=ar[i]-arr[i];
			}
			int count=0;
			int x=ar[n-1];
			HashSet<Integer> hs=new HashSet<Integer>();
			for(int i=n-2;i>=0;i--){
				if(ar[i]==x){
					count++;
					while(hs.contains(ar[i]+count))
						count++;
					ar[i]+=count;
					hs.add(ar[i]);
				}
				else{
					x=ar[i];
					count=0;
				}
			}
			for(int i=0;i<n;i++){
				System.out.print(ar[i]+" ");
			}
			System.out.println();
		}
	}		
}
