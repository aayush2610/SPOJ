package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CopyBooks {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		while(n>0){
			long high=500*10000000;
			long low=0;
			n--;
			long m,k;
			String[] a=br.readLine().split(" ");
			m=Long.parseLong(a[0]);
			k=Long.parseLong(a[1]);
			String[] str=br.readLine().split(" ");
			long[] arr=new long[(int)m];
			for(int i=0;i<m;i++){
				arr[i]=Long.parseLong(str[i]);
			}
			long mid=binary(arr,high,low,k);
			System.out.println(mid);
			long []axe=new long[(int)k];
			int p=0,i=0;
			while(i<m && p<k){
				if(axe[p]+arr[i]<=mid){
					axe[p]+=arr[i];
					i++;
				}
				else{
					p++;
				}
			}
			int flag=(int)m;
			if(i<m){
				flag=i-1;
			}
			int j=(int)m-2;
			long sum=0;
			StringBuilder sb = new StringBuilder();
			sb.append( arr[(int)m - 1] );
			sum = arr[(int)m - 1];
			k--;
			while(j>=0){
				List<List<Integer>> asd=new ArrayList<List<Integer>>();
				if(j>=flag){
					if(sum+arr[j]<=mid+1 && j+1>k){
						sb.insert(0, " ");
						sum+=arr[j];
					}
					else{
						sum=arr[j];
						sb.insert(0, " / ");
						k--;
					}
				}
				else{
					if(sum+arr[j]<=mid && j+1>k){
						sb.insert(0, " ");
						sum+=arr[j];
					}
					else{
						sum=arr[j];
						sb.insert(0, " / ");
						k--;
					}				
				}
				sb.insert(0, arr[j]);
				j--;
			}
			System.out.println(sb.toString());
		}
	}
	public static long binary(long[] arr, long high, long low, long k){
		long mid=0;
		while(low<=high){
			long p=0;
			mid=(high+low)/2;
			int i=0;
			long sum=0;
			while(i<arr.length && p<k){
				if(sum+arr[i]<=mid){
					sum+=arr[i];
					i++;
				}
				else{
					sum=0;
					p++;
				}
			}
			if(i<arr.length){
				low=mid+1;
			}
			else{
				high=mid-1;
			}
		}
		return low;
	}
}
