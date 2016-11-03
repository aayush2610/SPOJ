package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JillRidesAgain {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int x=1;
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			int[] arr=new int[n-1];
			for(int i=0;i<n-1;i++){
				arr[i]=Integer.parseInt(br.readLine());
			}
			int start=0;
			int end=-1;
			int fstart=-1;
			int max=0;
			int gmax=0;
			for(int i=0;i<n-1;i++){
				max+=arr[i];
				if(gmax<max){
					end=i;
					gmax=max;
					fstart=start;
				}
				else if(gmax==max){
					if(fstart==start){
						end=i;
					}
					else if(end-fstart<(i-start)){
						fstart=start;
						end=i;
					}
				}
				else if(max<0){
					start=i+1;
					max=0;
				}
			}
			if(end==-1){
				System.out.println("Route "+x+" has no nice parts");
			}
			else{
				System.out.println("The nicest part of route "+x+" is between stops "+(fstart+1)+" and "+(end+2));
			}
			x++;
		}
	}
}
