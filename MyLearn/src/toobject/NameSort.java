package toobject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 *从类似如下的文本文件中读取出所有的姓名，并打印出重复的姓名和重复的次数，并按重复次数排序：
 */
public class NameSort {
	public static void main(String[] args){
		try {
			InputStream ips = NameSort.class.getResourceAsStream("./name.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(ips));
			Map<String,Integer> reads =new HashMap<String,Integer>();
			String read;
			String regex = ",(.*),";
			Pattern pattern = Pattern.compile(regex);
			while((read= in.readLine())!=null){
				Matcher matcher =pattern.matcher(read);
				if(matcher.find()){
					String result = matcher.group(1);
					if(reads.keySet().contains(result)){
						reads.put(result, reads.get(result)+1);
					}else{
						reads.put(result, 1);
					}
				}
			}
			
			//对Map的value排序
			List<Map.Entry<String, Integer>> cityInfoList = new ArrayList<Map.Entry<String, Integer>>(reads.entrySet()); 
			Collections.sort(cityInfoList, new Comparator<Map.Entry<String, Integer>>() {  
	            @Override  
	            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {  
	                return o2.getValue().compareTo(o1.getValue());  
	            }  
	        });    
			System.out.println(cityInfoList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
