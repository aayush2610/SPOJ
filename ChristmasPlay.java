package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChristmasPlay {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int k=Integer.parseInt(s[1]);
			s=br.readLine().split(" ");
			int[] arr=new int[s.length];
			for(int i=0;i<s.length;i++){
				arr[i]=Integer.parseInt(s[i]);
			}
			Arrays.sort(arr);
			int min=Integer.MAX_VALUE;
			for(int i=0;i<=arr.length-k;i++){
				if(min>arr[i+k-1]-arr[i]){
					min=arr[i+k-1]-arr[i];
				}
			}
			System.out.println(min);
		}
	}
}
