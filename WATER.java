package ques;

import java.util.Scanner;

public class WATER {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			t--;
			int rows=scanner.nextInt();
			int cols=scanner.nextInt();
			int[][] arr=new int[rows][cols];
			for(int i=0;i<rows;i++){
				for(int j=0;j<cols;j++){
					arr[i][j]=scanner.nextInt();
				}
			}
			int[][] left=new int[rows][cols];
			int[][] right=new int[rows][cols];
			int[][] up=new int[rows][cols];
			int[][] down=new int[rows][cols];
			for(int i=0;i<rows;i++){
				int max=arr[i][0];
				left[i][0]=arr[i][0];
				for(int j=1;j<cols;j++){
					if(max>=arr[i][j]){
						left[i][j]=max;
					}
					else{
						left[i][j]=arr[i][j];
						max=arr[i][j];
					}
				}
			}
			for(int i=0;i<rows;i++){
				int max=arr[i][cols-1];
				right[i][cols-1]=arr[i][cols-1];
				for(int j=cols-2;j>=0;j--){
					if(max>=arr[i][j]){
						right[i][j]=max;
					}
					else{
						right[i][j]=arr[i][j];
						max=arr[i][j];
					}
				}
			}
			for(int j=0;j<cols;j++){
				int max=arr[0][j];
				up[0][j]=arr[0][j];
				for(int i=1;i<rows;i++){
					if(max>=arr[i][j]){
						up[i][j]=max;
					}
					else{
						up[i][j]=arr[i][j];
						max=arr[i][j];
					}
				}
			}
			for(int j=0;j<cols;j++){
				int max=arr[rows-1][j];
				down[rows-1][j]=arr[rows-1][j];
				for(int i=rows-2;i>=0;i--){
					if(max>=arr[i][j]){
						down[i][j]=max;
					}
					else{
						down[i][j]=arr[i][j];
						max=arr[i][j];
					}
				}
			}
			int result=0;
			for(int i=0;i<rows;i++){
				for(int j=0;j<cols;j++){
					int min=Math.min(left[i][j]-arr[i][j], right[i][j]-arr[i][j]);
					int min2=Math.min(up[i][j]-arr[i][j], down[i][j]-arr[i][j]);
					result+=Math.min(min,min2);
				}
			}
			System.out.println(result);
		}
	}
}
