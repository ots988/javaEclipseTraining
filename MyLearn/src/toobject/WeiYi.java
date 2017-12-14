package toobject;

public class WeiYi {

	    public static void main(String[] args) {
	        int number = 10;
	        //原始数二进制
	        printInfo(number);
	        number = number << 1;
	        //左移一位：丢弃最高位(符号位同样丢弃)，0补最低位
	        printInfo(number);
	        number = number >> 1;
	        //右移一位：符号位不变，左边补上符号位
	        printInfo(number);
	        number = number >>> 1;
	        //无符号右移一位
	        printInfo(number);
	        System.out.println(011&0111);
	    }
	    
	    /**
	     * 输出一个int的二进制数
	     * @param num
	     */
	    private static void printInfo(int num){
	        System.out.println(Integer.toBinaryString(num));
	    }
	}