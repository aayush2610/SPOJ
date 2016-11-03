package ques;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BEADS {
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t>0){
			String s=br.readLine();
			int l =s.length();
			char sw=s.charAt(0);
			for(int i=1;i<l;i++){
				if(s.charAt(i)<sw)
					sw=s.charAt(i);
			}
			ArrayList<Integer> arr=new ArrayList<Integer>();
			for(int i=0;i<l;i++){
				if(s.charAt(i)==sw)
					arr.add(i);
			}
			s=s+s;
			int min=arr.get(0);
			for(int i=1;i<arr.size();i++){
				for(int j=1;j<s.length()/2;j++){
					if(s.charAt((min+j))>s.charAt((arr.get(i)+j))){
						min=arr.get(i);
						break;
					}
					else if(s.charAt((min+j))<s.charAt((arr.get(i)+j))){
						break;
					}
				}
			}
			System.out.println(min+1);
			t--;
		}
	}
}
