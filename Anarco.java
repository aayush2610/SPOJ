package ques;

import java.util.Scanner;

public class Anarco {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int k=1;
		while(true){
			String s=scanner.next();
			char[] ch=s.toCharArray(); 
			if(s.charAt(0)=='-')
				break;
			int l=s.length();
			int[] dp=new int[l+1];
			for(int i=0;i<l;i++){
				if(ch[i]=='{')
					dp[i]=1;
				else 
					dp[i]=-1;
			}
			int count=0;
			if(dp[0]==-1){
				dp[0]=1;
				ch[0]='{';
				count++;
			}
			
			for(int i=1;i<l;i++){
				dp[i]=dp[i-1]+dp[i];
				if(dp[i]<0){
					dp[i]=1;
					ch[i]='{';
					count++;
				}
			}
			/*if(dp[l-1]>=1){
				dp[l-1]=-1;
				ch[0]='}';
				count++;
			}
			for(int i=l-2;i>=0;i--){
				//dp[i]=dp[i-1]+dp[i];
				if(dp[i+1]+dp[i]>0){
					dp[i]=-1;
					ch[i]='}';
					count++;
				}
			}*/
			System.out.println(k+". "+(count+dp[l-1]/2));
			k++;
		}
	}
}
