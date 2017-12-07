package toobject;

import java.util.Random;

/*
 * 二分搜索算法
 */
public class BinarySearch {
	private final static int size =10000;
	
	public static void main(String[] args){
		long[] data = new long[size];
		for (int k=0 ;k<data.length;k++){
			data[k]=k;
		}
		long i = (long)(Math.random()*size);
		System.out.println("要查找的随机数"+i);
		int sum = findRandom(i);
		System.out.println("查找的随机次数"+sum);
		binaryFindTest(data,i);
	}

	private static void binaryFindTest(long[] data, long i) {
		// TODO Auto-generated method stub
		
	}

	private static int findRandom(long i) {
		// TODO Auto-generated method stub
		int min =0;
		int max =size;
		int mid;
		int j=0;
		while(true){
			j++;
			mid =(int)((max+min)/2);
			if(mid>i){
				max=mid-1;
			}else if(mid<i){
				min =mid+1;
			}else{
				return j;
			}
		}
		
	}
}
