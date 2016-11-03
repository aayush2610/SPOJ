package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Alien {
public static void main(String[] args) throws Exception{
	BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(br.readLine());
	while(t>0){
		String[] s=new String[2];
		s=br.readLine().split(" ");
		int station=Integer.parseInt(s[0]);
		int people=Integer.parseInt(s[1]);
		String[] ss=new String[station];
		int[] arr=new int[station];
		ss=br.readLine().split(" ");
		for(int i=0;i<station;i++)
			arr[i]=Integer.parseInt(ss[i]);
		int max=0,sum=0,i=0;
		int maxi=0,sumi=0;
		int p=0;
		while(i<station){
				people-=arr[i];
				sum+=arr[i];
				max++;
			if(people<0){
				while(people<0){
					people+=arr[p];
					sum-=arr[p];
					max--;
					p++;
				}
			}
			if(max>maxi){
				maxi=max;
				sumi=sum;
			}
			else if(max==maxi){
				if(sumi>sum)
					sumi=sum;
			}
			i++;
		}
		System.out.println(sumi+" "+maxi);
		t--;
	}
}
}
