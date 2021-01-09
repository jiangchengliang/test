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
	 * @param ID	�˺�	
	 * @param psd	����
	 * @return		������ͬ���˺ŷ���true �����ڷ���false
	 */
	//�ж��˺������Ƿ����
	public static boolean checkZhangHaoBiao(String ID,String psd){
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		String sql="select ID,psd from textY";
    	try(Connection conn=dbcs1.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
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
	//ɾ��һ������
	public static void delete(String id) {
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		String sql = "delete  from textY where id='"+id+"'";
		Connection conn=dbcs1.getConnection();//��ȡ���ݿ��)
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);// ִ���޸Ĳ���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ʵ����Statement����
		
	}
	/**
	 * 
	 * @param id	ID
	 * @return
	 */
	//��ѯ��¼�������ڼ�����
	public static Vector<String> checkInfor(String id) {
		Vector<String> rows=new Vector<String>();
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		String sql="select id,name,phone,money,psd from textY";
    	try(Connection conn=dbcs1.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			if(id.equals(rs.getString(1))) {
        			Vector<String> row=new Vector<String>();//����������
        			row.add(rs.getString(1));//��ȡ��һ���ֶα��
        			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
        			row.add(rs.getString(3));//��ȡ�������ֶε绰
        			row.add(rs.getString(4));//��ȡ���ĸ��ֶ����
        			row.add(rs.getString(5));//��ȡ������ֶ�����
        			rows.addAll(row);//����������ӵ���¼������
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
	//���� ���ݿ� �Ƿ������ͬ���˺�
	public static boolean checkZhangHaoBiao(String ID){
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		String sql="select ID from textY";
    	try(Connection conn=dbcs1.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			if(ID.equals(rs.getString(1)))return true;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return false;
    	    }
	
	/**
	 * ��ע�����Ϣ���뵽���ݿ���
	 * @param ID	�˺�
	 * @param psd	����
	 */
	public static void setUser(String ID,String name,String phone,String money,String psd) {
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		String sql="insert into textY(id,name,phone,money,psd) values(?,?,?,?,?)";
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    					pstmt.setString(1, ID);//�����1��ռλ��������
        	    		pstmt.setString(2, name);//�����2��ռλ��������
        	    		pstmt.setString(3, phone);//�����3��ռλ��������
        	    		int a=Integer.parseInt(money);
        	    		pstmt.setInt(4, a);//�����4��ռλ��������
        	    		pstmt.setString(5, psd);//�����5��ռλ��������
        	    		pstmt.addBatch();
        		pstmt.executeBatch();//����ִ�в������
        		JOptionPane.showMessageDialog(null, "sucess");
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
	}
	/**
	 * checkID �ж�ID�Ƿ����
	 * @param ID 
	 * @return
	 */
	public static boolean checkID(String ID){
		DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		String sql="select ID from textY";
    	try(Connection conn=dbcs1.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			if(ID.equals(rs.getString(1)))return false;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return true;
    	    }
	
	
	
	
	
	
	
}
	
