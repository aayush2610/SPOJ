package ques;
import java.util.*;
public class CZ_PROB1 {
	public static void main(String[] args) {
		HashSet<Integer> square=new HashSet<Integer>();
		for(int i=0;i<90;i++){
			square.add(i*i);
		}
		ArrayList<Integer> ar=new ArrayList<Integer>();
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=2;i<7994;i++){
			int x=(int)Math.sqrt(i);
			int y=2;
			while(y<=x){
				if(i%y==0)
					break;
				y++;
			}
			if(y==x+1){
				x=i;
				int j=1;
				while(j*j<x){
					if(square.contains(x-(j*j))){
						ar.add(x);
						break;
					}
					else
						j++;
				}
			}
		}
		System.out.println(ar);
		while(t>0){
			t--;
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			int x=ar.get(n-1);
			if(k==1){
				System.out.println(1);
				continue;
			}
			int[][] dp=new int[x+1][3];
			for(int i=0;i<=x;i++)
				dp[i][0]=1;
			for(int i=0;i<3;i++)
				dp[0][i]=1;
			for(int i=1;i<=x;i++){
				for(int j=1;j<3;j++){
					if(i>=j+1){
						dp[i][j]+=dp[i-j-1][j];
					}
					dp[i][j]+=dp[i][j-1];
				}
			}
			System.out.println(dp[x][k-1]);
		}
	}
}
