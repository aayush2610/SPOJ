package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayOnWords {
	public static int[] in;
	public static int[] out;
	public static int[][] edge;
	public static int[] visited;
	public static int[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			in=new int[26];
			out=new int[26];
			edge=new int[26][26];
			visited=new int[26];
			v=new int[26];
			while(n>0){
				n--;
				String s=br.readLine();
				out[s.charAt(0)-'a']++;
				in[s.charAt(s.length()-1)-'a']++;
				edge[s.charAt(0)-'a'][s.charAt(s.length()-1)-'a']=1;
				edge[s.charAt(s.length()-1)-'a'][s.charAt(0)-'a']=1;
				v[s.charAt(0)-'a']=1;
				v[s.charAt(s.length()-1)-'a']=1;
			}
			int i=0;
			while(v[i]==0){
				i++;
			}
			visit(i);
			int flag1=0;
			for(i=0;i<26;i++){
				if(v[i]==1 && visited[i]==0){
					flag1=1;
					break;
				}
			}
			int v1=-1,v2=-1,exist=-1;
			if(flag1==0){
				for(i=0;i<26;i++){
					if(in[i]!=out[i]){
						if(v1==-1){
							v1=i;
						}
						else if(v2==-1){
							v2=i;
						}
						else{
							exist=0;
							break;
						}
					}
				}
			}
			if(flag1==1 || exist==0){
				System.out.println("The door cannot be opened.");
				continue;
			}
			else{
				if(v1==-1){
					System.out.println("Ordering is possible.");
					exist=1;
				}
				else if(in[v1]==out[v1]+1 && in[v2]+1==out[v2]){
					System.out.println("Ordering is possible.");
					exist=1;
				}
				else if(in[v2]==out[v2]+1 && in[v1]+1==out[v1]){
					System.out.println("Ordering is possible.");
					exist=1;
				}
				else
					System.out.println("The door cannot be opened.");
			}
		}
	}
	public static void visit(int x){
		visited[x]=1;
		for(int i=0;i<26;i++){
			if((edge[x][i]==1||edge[i][x]==1)&& visited[i]==0){
				visit(i);
			}
		}
	}
}
