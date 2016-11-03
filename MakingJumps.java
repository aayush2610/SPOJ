package ques;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class two{
	int i,j;
	public two(int i, int j){
		this.i=i;
		this.j=j;
	}
}
public class MakingJumps {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int count=1;
		while(true){
			boolean[][] mat=new boolean[11][11];
			int m=scanner.nextInt();
			if(m==0)
				break;
			int flag=0;
			int sr=0;
			int sc=0;
			for(int i=0;i<m;i++){
				int offset=scanner.nextInt();
				int cell=scanner.nextInt();
				if(flag==0 && cell!=0){
					sr=i;
					sc=offset;
					flag=1;
				}
				while(cell>0){
					mat[i][offset]=true;
					offset++;
					cell--;
				}
			}
			boolean[][] visited=new boolean[11][11];
			Queue<two> q=new LinkedList<two>();
			q.add(new two(sr,sc));
			visited[sr][sc]=true;
			int[] a={1,-1,1,-1,2,2,-2,-2};
			int[] b={2,2,-2,-2,1,-1,1,-1};
			while(!q.isEmpty()){
				two tt=q.poll();
				for(int x=0;x<8;x++){
					int ni=tt.i+a[x];
					int nj=tt.j+b[x];
					if(ni>=0 && nj>=0 && ni<11 && nj<11 && mat[ni][nj] && !visited[ni][nj]){
						q.add(new two(ni,nj));
						System.out.println(ni+" "+nj);
						visited[ni][nj]=true;
					}
				}
			}
			int pp=0;
			for(int x=0;x<11;x++){
				for(int y=0;y<11;y++){
					if(mat[x][y] && !visited[x][y])
						pp++;
				}
			}
			if(pp==1){
				System.out.println("Case "+count+", 1 square can not be reached.");
			}
			else{
				System.out.println("Case "+count+", "+pp+" squares can not be reached.");
			}
			count++;
		}
	}
}
