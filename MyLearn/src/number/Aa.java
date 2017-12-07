package number;

import java.io.IOException;
import java.text.DecimalFormat;

public class Aa {
	public static void main(String[] args) throws IOException {
		
		String rxSimFlow = "1-1-1-3-0";
		
		String txSimFlow = "110";
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(3);
		String aa = decimalFormat.format(Double.parseDouble(txSimFlow)/1024.0);
		System.out.println(aa);
		double curTx = Double.parseDouble(aa.replace(",", ""));
		System.out.println(curTx);
		System.out.println(rxSimFlow.replaceAll("-", ":"));
		String aa1="16,687.25";
		String ip ="1.1.11/222";
		ip=ip.substring(0, ip.indexOf("/"));
		double curTx1 = Double.parseDouble(aa);
		if(aa.contains("16,687.25")){
			System.out.println(ip);
				}
//			System.out.println("aa");
	}
		
		    
}
