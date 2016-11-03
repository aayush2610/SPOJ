package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AmbitiousManager {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			long n,k;
			String[] s=br.readLine().split(" ");
			n=Long.parseLong(s[0]);
			k=Long.parseLong(s[1]);
			long[] arr=new long[(int)k];
			s=br.readLine().split(" ");
			arr[0]=Long.parseLong(s[0]);
			for(int i=1;i<(int)k;i++){
				arr[i]=Long.parseLong(s[i])+2*arr[i-1];
			}
			ArrayList<Integer> res=new ArrayList<Integer>();
			for(int x=(int)k-1;x>=0;x--){
				long sum=0;
				ArrayList<Integer> aa=new ArrayList<Integer>(); 
				int flag=0;
				for(int i=x;i>=0;i--){
					sum+=arr[i];
					if(sum<n){
						aa.add(i+1);
					}
					else if(sum==n){
						aa.add(i+1);
						break;
					}
					else{
						sum-=arr[i];
						flag=1;
					}
				}
				if(flag==0 && sum!=n)
					break;
				if(sum==n){
					if(res.size()==0 || res.size()>aa.size()){
						res.clear();
						res.addAll(aa);
					}
				}
			}
			if(res.size()==0)
				System.out.println(-1);
			else{
				for(int p=res.size()-1;p>=0;p--){
					System.out.print(res.get(p)+" ");
				}
				System.out.println();
			}
		}
	}
}
