package toobject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 判断一个int数组中的元素是否存在重复，方法声明如下：
 * boolean isRepeat(int[] m){ }
 */
public class IntegerRepeat {
	public  static void main(String[] args) {
		System.out.println(isRepeat(new int[]{3,4,3}));
	}
	static boolean isRepeat(int[] m){
		Arrays.sort(m);
		Set<Integer> a =new HashSet<Integer>();
		for(int i=0;i<m.length;i++){
			a.add(new Integer(m[i]));
		}
		if(a.size()<m.length){
			return true;
		}
		return false;
	}
}