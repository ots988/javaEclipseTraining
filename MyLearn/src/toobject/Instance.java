package toobject;

public class Instance {
	public static void main(String[] args){
		String ip ="1.1.11/222";
		ip=ip.substring(0, ip.indexOf("/"));
		System.out.println(ip);
	}
}
