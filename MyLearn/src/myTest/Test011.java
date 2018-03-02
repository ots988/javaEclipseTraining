package myTest;

import java.util.HashMap;
import java.util.Scanner;

public  class Test011 {
	public Test011(){
		String aaa="aaaa";
	}
	static {
		String old ="aa";
		String newkey ="aa";
		String k;
		System.out.println((k = old));

	}

	private static int a =5;

	@Override
	public int hashCode() {
		return 123456;
	}

	//	static int a =3;
//	final private String  name  ="ss";
////	Test011 test = new Test011();
	public static void main(String[] args){
//		Test011 aa = new Test011();
//		System.out.println(aa.toString());
//		System.out.println((int)(Math.random()*100));
//		Scanner input = new Scanner(System.in);
//		System.out.println(input.nextInt());
 		Test011 ne = new Test011();
 		Test011 nu =new Test011();
		Test011 old = new Test011();
		Object o;
		o=old;
//		System.out.println(o.hashCode());
// 		System.out.println((nu=old).hashCode());
//		System.out.println(old.hashCode());
//		System.out.println(ne.hashCode());
		int i=9;
		System.out.println(Integer.valueOf(1000).equals(Integer.valueOf(1000)));
	}
}

