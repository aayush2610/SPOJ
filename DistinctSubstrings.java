package ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DistinctSubstrings {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			t--;
			String s=scanner.next();
			ArrayList<String> arr=new ArrayList<String>();
			for(int i=s.length()-1;i>=0;i--){
				arr.add(s.substring(i));
			}
			Collections.sort(arr);
			int sum=0;
			sum+=arr.get(0).length();
			for(int i=1;i<arr.size();i++){
				int x=pre(arr.get(i-1),arr.get(i));
				sum+=arr.get(i).length()-x;
			}
			System.out.println(sum);
		}
	}
	public static int pre(String a, String b){
		int count=0;
		int i=0;
		while(i<a.length() && i<b.length()){
			if(a.charAt(i)==b.charAt(i))
				count++;
			else
				break;
			i++;
		}
		return count;
	}
}
