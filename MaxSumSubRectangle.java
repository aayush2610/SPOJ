package ques;

public class MaxSumSubRectangle {
	public static int[] func(int [][] a){
		int left=0;
		int right=0;
		int sum=Integer.MIN_VALUE;
		int maxup=0;
		int maxdown=0;
		for(int i=0;i<a[0].length;i++){
			int[] temp=new int[a.length];
			for(int j=i;j<a[0].length;j++){
				for(int t=0;t<a.length;t++)
					temp[t]+=a[t][j];
				int max_so_far=0;
				for(int t=0;t<a.length;t++)
					System.out.print(temp[t]+" ");
				System.out.println();
				int max_temp=0;
				int k=0,up=0,down=0;
				for(int x=0;x<temp.length;x++){
					max_temp+=temp[x];
					if(max_temp<0){
						max_temp=0;
						k=x+1;
					}
					else if(max_temp>max_so_far){
						max_so_far=max_temp;
						up=k;
						down=x;
					}
				}
				if(max_so_far>sum){
					sum=max_so_far;
					maxup=up;
					maxdown=down;
					left=i;
					right=j;
				}
			}
		}
		int []cc=new int[4];
		cc[0]=maxup;
		cc[1]=maxdown;
		cc[2]=left;
		cc[3]=right;
		return cc;
	}
	public static void main(String[] args) {
		int[][] x={{2,1,-3,-4,5},{0,6,3,4,1},{2,-2,-1,4,-5},{-3,3,1,0,3}};
		int[] d=func(x);
		for(int i=0;i<d.length;i++){
			System.out.println(d[i]);
		}
	}
}
