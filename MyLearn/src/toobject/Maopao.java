package toobject;
/*
 * 输出最大的树
 */
import java.util.Scanner;

public class Maopao {
	public static void main(String[] args){
		System.out.println("请输入数字 ");
		Scanner input = new Scanner(System.in);
		int a =0;
		for(int i =0 ;i<5;i++){
			int b = input.nextInt();
			if(a<b) a=b;
		}
		System.out.println(a);
	}
}
