package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class YdrawJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private static String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YdrawJframe frame = new YdrawJframe(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YdrawJframe(String id) {
		setTitle("\u53D6\u6B3E\u754C\u9762");
		this.id=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u53D6\u7684\u91D1\u989D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(36, 36, 208, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(36, 82, 233, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		/**
		 * 确认按钮
		 */
		//确认按钮
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().isEmpty())
		        {
		            JOptionPane.showMessageDialog(null, "金额为空，请重新输入！");
		        }
		        else 
		        {
		        	DatabaseConnectionSql dbcs1=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		        	String money1 = textField.getText();
		        	String sql2="select money from textY where id='"+id+"'";
		    		Connection conn=dbcs1.getConnection();
		    		Statement stmt;
		    		int b=0;
		    		int a=Integer.parseInt(money1);	
		    		try {
		    			stmt = conn.createStatement();
		    			stmt.executeQuery(sql2);
		    			ResultSet rs=stmt.executeQuery(sql2);
		    			while(rs.next()) {//遍历数据集
		    				 b=Integer.parseInt(rs.getString(1));
		            		}
		    			
		    			int c=b-a;
		        	    String sql="update textY set money='"+c+"' where id='"+id+"'";
		    			stmt.executeUpdate(sql);
			        	JOptionPane.showMessageDialog(null, "取款成功");
			        	String arr=Integer.toString(c);
			        	textField2.setText(arr);
			        	
		    		} catch (SQLException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}//实例化Statement对象
		    }

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton.setBounds(298, 82, 109, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u4F59\u989D\u4E3A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(36, 138, 208, 26);
		contentPane.add(lblNewLabel_1);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(36, 179, 233, 46);
		contentPane.add(textField2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\55ee751a29522.jpg"));
		lblNewLabel_2.setBounds(0, 0, 449, 274);
		contentPane.add(lblNewLabel_2);
	}
}
