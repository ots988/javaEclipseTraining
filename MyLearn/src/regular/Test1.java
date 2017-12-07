package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
	    // 要验证的字符串
	    String str = "baike.xsoftlabnet";
	    //str="2342256";
	    str="ots988aa@163.com.cn11.1aaaa";
	    // 正则表达式规则
	    String regEx = "baike.*";
	    //regEx = "^[1-9]*\\d{5}$";
	    regEx = "^bai([a-z]|\\.)*net$";
	    String EmailRegEx = "^[a-zA-Z0-9]{1,}@(([a-zA-z0-9]*){1,}\\.){1,3}[a-zA-z]{1,}$";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(EmailRegEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 查找字符串中是否有匹配正则表达式的字符/字符串
	    boolean rs = matcher.find();
	    System.out.println(rs);
	}

}
