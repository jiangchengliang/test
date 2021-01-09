package cn.edu.jsu.jcl.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Operate {
	
	/**
	 * 
	 * @param ID	账号	
	 * @param psd	密码
	 * @return		存在相同的账号返回true 不存在返回false
	 */
	//判断账号密码是否存在
	public static boolean checkZhangHaoBiao(String ID,String psd){
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		String sql="select ID,psd from textY";
    	try(Connection conn=dbcs1.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			if(ID.equals(rs.getString(1))&&psd.equals(rs.getString(2)))
    				return true;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return false;
    	    }
	
	/**
	 * 
	 * @param id ID
	 */
	//删除一条数据
	public static void delete(String id) {
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		String sql = "delete  from textY where id='"+id+"'";
		Connection conn=dbcs1.getConnection();//获取数据库接)
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);// 执行修改操作
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//实例化Statement对象
		
	}
	/**
	 * 
	 * @param id	ID
	 * @return
	 */
	//查询记录并储存在集合中
	public static Vector<String> checkInfor(String id) {
		Vector<String> rows=new Vector<String>();
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		String sql="select id,name,phone,money,psd from textY";
    	try(Connection conn=dbcs1.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			if(id.equals(rs.getString(1))) {
        			Vector<String> row=new Vector<String>();//定义行数据
        			row.add(rs.getString(1));//获取第一个字段编号
        			row.add(rs.getString(2));//获取第二个字段姓名
        			row.add(rs.getString(3));//获取第三个字段电话
        			row.add(rs.getString(4));//获取第四个字段余额
        			row.add(rs.getString(5));//获取第五个字段密码
        			rows.addAll(row);//将行数据添加到记录集合中
    			}
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    	    return rows;
	}
	
	/**
	 * 
	 * @param ID	ID
	 * @return
	 */
	//遍历 数据库 是否存在相同的账号
	public static boolean checkZhangHaoBiao(String ID){
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		String sql="select ID from textY";
    	try(Connection conn=dbcs1.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			if(ID.equals(rs.getString(1)))return true;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return false;
    	    }
	
	/**
	 * 将注册的信息插入到数据库中
	 * @param ID	账号
	 * @param psd	密码
	 */
	public static void setUser(String ID,String name,String phone,String money,String psd) {
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		String sql="insert into textY(id,name,phone,money,psd) values(?,?,?,?,?)";
    	try(Connection conn=dbcs.getConnection();//获取数据库接
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    					pstmt.setString(1, ID);//定义第1个占位符的内容
        	    		pstmt.setString(2, name);//定义第2个占位符的内容
        	    		pstmt.setString(3, phone);//定义第3个占位符的内容
        	    		int a=Integer.parseInt(money);
        	    		pstmt.setInt(4, a);//定义第4个占位符的内容
        	    		pstmt.setString(5, psd);//定义第5个占位符的内容
        	    		pstmt.addBatch();
        		pstmt.executeBatch();//批量执行插入操作
        		JOptionPane.showMessageDialog(null, "sucess");
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
	}
	/**
	 * checkID 判断ID是否存在
	 * @param ID 
	 * @return
	 */
	public static boolean checkID(String ID){
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		String sql="select ID from textY";
    	try(Connection conn=dbcs1.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			if(ID.equals(rs.getString(1)))return false;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return true;
    	    }
	
	
	
	
	
	
	
}
	
