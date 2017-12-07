package toobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 请简单写出用JAVA连接Oracle数据库，并执行一条/SQL语句。
 * （只需要写关键几条语句即可，/SQL语句：SELECT*FROM t_users WHERE users_id=‘1111’）
 */

public class Jdbc {
	
	public static void main(String[] args){
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT*FROM t_users WHERE users_id='1111'");
			while (rs.next()) {
			// 取值
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
