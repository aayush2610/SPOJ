package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CHOCOLA {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			br.readLine();
			String[] s=br.readLine().split(" ");
			int m=Integer.parseInt(s[0]);
			int n=Integer.parseInt(s[1]);
			int[] mw=new int[m-1];
			int[] nw=new int[n-1];
			for(int i=0;i<m-1;i++){
				mw[i]=Integer.parseInt(br.readLine());
			}
			for(int i=0;i<n-1;i++){
				nw[i]=Integer.parseInt(br.readLine());
			}
			int countm=1;
			int countn=1;
			Arrays.sort(mw);
			Arrays.sort(nw);
			int i=mw.length-1;
			int j=nw.length-1;
			int count=0;
			int cost=0;
			while(i>=0 && j>=0 && count<m*n){
				if(mw[i]>nw[j]){
					cost+=mw[i]*countn;
					countm++;
					i--;
				}
				else{
					cost+=nw[j]*countm;
					countn++;
					j--;
				}
			}
			while(i>=0){
				cost+=mw[i]*countn;
				countm++;
				i--;
			}
			while(j>=0){
				cost+=nw[j]*countm;
				countn++;
				j--;
			}
			System.out.println(cost);
		}
	}
}
