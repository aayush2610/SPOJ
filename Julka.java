package ques;

import java.math.BigInteger;
import java.util.Scanner;

public class Julka {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<10;i++){
			BigInteger b1=scanner.nextBigInteger();
			BigInteger b2=scanner.nextBigInteger();
			BigInteger b3=(b1.add(b2)).divide(BigInteger.valueOf(2));
			System.out.println(b3);
			System.out.println(b1.subtract(b3));
		}
	}
}
