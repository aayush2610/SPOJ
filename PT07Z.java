package ques;
import java.util.*;
class graph{
	int n;
	ArrayList<Integer>[] adj;
	public graph(int n){
		this.n=n;
		adj=new ArrayList[n];
	}
}

public class PT07Z {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		if(n==1||n==2 ){
			System.out.println(n);
			return;
		}
		graph g=new graph(n);
		for(int i=0;i<n;i++){
			g.adj[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<n-1;i++){
			int s=scanner.nextInt();
			int d=scanner.nextInt();
			g.adj[s-1].add(d-1);
			g.adj[d-1].add(s-1);
		}
		int[] dis=new int[1];
		int[] max=new int[1];
		dfs(-1,0,0,dis,max,g);
		int maxi=max[0];
		max[0]=0;
		int[] gg=new int[1];
		dfs(-1,dis[0],0,gg,max,g);
		System.out.println(Math.max(maxi,max[0]));
	}
	public static void dfs(int parent, int x,int t, int[] dis, int[] max, graph g){
		for(int i=0;i<g.adj[x].size();i++){
			if(g.adj[x].get(i)!=parent){
				dfs(x,g.adj[x].get(i),t+1,dis,max,g);
			}
			if(max[0]<t){
				max[0]=t;
				dis[0]=x;
			}
		}
	}
}
