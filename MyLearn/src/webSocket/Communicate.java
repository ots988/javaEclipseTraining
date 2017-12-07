package webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/*
 * a)客户端发起socket通讯，报文结构为报文号（3位）+用户名（5位）+密码（8位）+ 结束符（固定为END）。
 * 此处报文号为100
 * b)服务端收到后返回应答报文，报文结构为报文号（3位）+验证结果（2位）+结束符（固定为END）。此处报文号为101
 * c)Socket服务器ip为192.168.0.2，端口号为9999
 */
public class Communicate {
	public static void main() throws UnknownHostException, IOException{
	//客户端代码：

	Socket sk1 = new Socket("192.168.0.2",9999);

	OutputStream os1 = sk1.getOutputStream();

	PrintWriter pw = new PrintWriter(os1,true);

	pw.write("100stone888888END");

	pw.close();

	sk1.close();

	//服务器端代码：

	ServerSocket vk = new ServerSocket(9999);

	Socket sk = vk.accept();

	OutputStream os = sk1.getOutputStream();

	PrintWriter pw1 = new PrintWriter(os1,true);

	pw1.write("101oldEND");

	pw1.close();

	sk.close();
	
	List<String>  aa = new ArrayList<String>();
	}
}
