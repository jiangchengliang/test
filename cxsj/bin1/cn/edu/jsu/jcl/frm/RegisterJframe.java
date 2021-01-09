package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;
import cn.edu.jsu.jcl.dbc.Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class RegisterJframe extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private JTextField textFieldname;
	private JTextField textFieldmoney;
	private JTextField textFieldphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterJframe frame = new RegisterJframe();
					frame.setLocationRelativeTo(null);//窗体居中
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
	public RegisterJframe() {
		setTitle("\u6CE8\u518C\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("\u8D26\u53F7");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		idLabel.setBounds(44, 74, 63, 29);
		contentPane.add(idLabel);
		
		JLabel codelbl1 = new JLabel("\u5BC6\u7801");
		codelbl1.setHorizontalAlignment(SwingConstants.CENTER);
		codelbl1.setFont(new Font("宋体", Font.PLAIN, 25));
		codelbl1.setBounds(44, 125, 63, 29);
		contentPane.add(codelbl1);
		
		idtextField = new JTextField();
		idtextField.setBounds(129, 74, 237, 29);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addActionListener(new ActionListener() {
			//注册按钮
			/**
			 * 注册
			 */
			public void actionPerformed(ActionEvent arg0) {
			
				//先判断账号是否有重复
				//判断两次输入的密码是否相同
				//提示输入成功，并保存在客户账号的数据库
				String ID=idtextField.getText();
				String psd1=String.valueOf(passwordField.getPassword());
				String psd2=String.valueOf(passwordField2.getPassword());
				String name=textFieldname.getText();
				String phone=textFieldphone.getText();
				String money=textFieldmoney.getText();
				
				if(Operate.checkID(ID)) {
					if(psd1.equals(psd2)) {
						Operate.setUser(ID,name,phone,money,psd1);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "两次密码不同，请重新输入");
						passwordField.setText("");
						passwordField2.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "ID已经存在，请重新输入");
					passwordField.setText("");
					passwordField2.setText("");
				}
			}
		});
		registerButton.setFont(new Font("宋体", Font.PLAIN, 25));
		registerButton.setBounds(392, 347, 100, 45);
		contentPane.add(registerButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7\u5BC6\u7801\u5B8C\u6210\u6CE8\u518C");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel.setBounds(26, 32, 340, 32);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField.setBounds(129, 125, 237, 29);
		contentPane.add(passwordField);
		
		JLabel codelbl2_1 = new JLabel("\u59D3\u540D");
		codelbl2_1.setHorizontalAlignment(SwingConstants.CENTER);
		codelbl2_1.setFont(new Font("宋体", Font.PLAIN, 25));
		codelbl2_1.setBounds(44, 267, 63, 29);
		contentPane.add(codelbl2_1);
		
		JLabel codelbl2_2 = new JLabel("\u4F59\u989D");
		codelbl2_2.setHorizontalAlignment(SwingConstants.CENTER);
		codelbl2_2.setFont(new Font("宋体", Font.PLAIN, 25));
		codelbl2_2.setBounds(44, 313, 63, 29);
		contentPane.add(codelbl2_2);
		
		JLabel codelbl2_5 = new JLabel("\u5BC6\u7801");
		codelbl2_5.setHorizontalAlignment(SwingConstants.CENTER);
		codelbl2_5.setFont(new Font("宋体", Font.PLAIN, 25));
		codelbl2_5.setBounds(44, 175, 63, 29);
		contentPane.add(codelbl2_5);
		
		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField2.setBounds(129, 175, 237, 29);
		contentPane.add(passwordField2);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u57FA\u672C\u4FE1\u606F");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(26, 225, 340, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel codelbl2_1_1 = new JLabel("\u7535\u8BDD");
		codelbl2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		codelbl2_1_1.setFont(new Font("宋体", Font.PLAIN, 25));
		codelbl2_1_1.setBounds(44, 363, 63, 29);
		contentPane.add(codelbl2_1_1);
		
		textFieldname = new JTextField();
		textFieldname.setColumns(10);
		textFieldname.setBounds(129, 267, 237, 29);
		contentPane.add(textFieldname);
		
		textFieldmoney = new JTextField();
		textFieldmoney.setColumns(10);
		textFieldmoney.setBounds(129, 313, 237, 29);
		contentPane.add(textFieldmoney);
		
		textFieldphone = new JTextField();
		textFieldphone.setColumns(10);
		textFieldphone.setBounds(129, 363, 237, 29);
		contentPane.add(textFieldphone);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\942.jpg"));
		lblNewLabel_2.setBounds(0, 0, 546, 454);
		contentPane.add(lblNewLabel_2);
	}
	
	
	
}



