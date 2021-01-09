package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;
import cn.edu.jsu.jcl.vo.YongHuInput;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GmainFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GmainFrame frame = new GmainFrame();
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
	public GmainFrame() {
		setTitle("\u7BA1\u7406\u5458\u64CD\u4F5C\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u7BA1\u7406\u5458\u9009\u62E9\u64CD\u4F5C");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(100, 110, 204, 75);
		contentPane.add(lblNewLabel);
		/**
		 * 查询
		 */
		//查询按钮
		JButton input = new JButton("\u67E5\u8BE2");
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GqueryFrame FG=new GqueryFrame();
				FG.setLocationRelativeTo(null);
				FG.setVisible(true);
			}
		});
		input.setForeground(Color.BLACK);
		input.setFont(new Font("宋体", Font.PLAIN, 25));
		input.setBounds(25, 58, 114, 43);
		contentPane.add(input);
		/**
		 * 返回
		 */
		//返回按钮
		JButton exit = new JButton("\u9000\u51FA");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginFrame f1=new LoginFrame();
				f1.setLocationRelativeTo(null);
				f1.setVisible(true);
			}
		});
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("宋体", Font.PLAIN, 25));
		exit.setBounds(288, 195, 114, 43);
		contentPane.add(exit);
		/**
		 * 打印
		 */
		//打印按钮
		JButton register_2_1 = new JButton("\u6253\u5370");
		register_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GprintFrame f2=new GprintFrame();
				f2.setLocationRelativeTo(null);
				f2.setVisible(true);
			}
		});
		register_2_1.setForeground(Color.BLACK);
		register_2_1.setFont(new Font("宋体", Font.PLAIN, 25));
		register_2_1.setBounds(288, 58, 114, 43);
		contentPane.add(register_2_1);
		/**
		 * 删除
		 */
		//删除按钮
		JButton input_1 = new JButton("\u5220\u9664");
		input_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteJframeG djg=new DeleteJframeG();
				djg.setLocationRelativeTo(null);
				djg.setVisible(true);
			}
		});
		input_1.setForeground(Color.BLACK);
		input_1.setFont(new Font("宋体", Font.PLAIN, 25));
		input_1.setBounds(25, 195, 114, 43);
		contentPane.add(input_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\7cabc28ab07bfcc3f43ba3151ed1d3b7.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_1);
	}
	
	
}
