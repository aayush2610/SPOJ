package ques;

import java.util.Stack;

public class MaxHistogram {
	public static int area(int[] a){
		Stack<Integer> st=new Stack<Integer>();
		int maxarea=0;
		int top=0;
		int area=0;
		int i=0;
		for(i=0;i<a.length;){
			if(st.isEmpty() || a[st.peek()]<=a[i]){
				st.add(i);
				i++;
			}
			else{
				top=st.pop();
				if(st.isEmpty())
					area=a[top]*i;
				else
					area=a[top]*(i-st.peek()-1);
				if(area>maxarea)
					maxarea=area;
			}
		}
		while(!st.isEmpty()){
			top=st.pop();
			if(st.isEmpty())
				area=a[top]*i;
			else
				area=a[top]*(i-st.peek()-1);
			if(area>maxarea)
				maxarea=area;
		}
		return maxarea;
	}
	
}
