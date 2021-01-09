package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;
import cn.edu.jsu.jcl.dbc.Operate;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.Identity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class YqueryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldid;
	private JTextField textFieldname;
	private JTextField textFieldphone;
	private JTextField textFieldmoney;
	private JButton btnNewButton;
	private JLabel lblPsd;
	private JTextField textFieldpsd;
	private static String id;
	private JLabel lblPhone_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YqueryFrame frame = new YqueryFrame(id);
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
	public YqueryFrame(String id) {
		setTitle("\u67E5\u8BE2\u754C\u9762");
		this.id=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("\u59D3\u540D");
		lblName.setFont(new Font("宋体", Font.PLAIN, 25));
		lblName.setBounds(26, 86, 70, 29);
		contentPane.add(lblName);
		
		JLabel lblPhone = new JLabel("\u7535\u8BDD");
		lblPhone.setFont(new Font("宋体", Font.PLAIN, 25));
		lblPhone.setBounds(26, 125, 70, 29);
		contentPane.add(lblPhone);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(84, 43, 259, 29);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		
		textFieldname = new JTextField();
		textFieldname.setColumns(10);
		textFieldname.setBounds(84, 82, 259, 29);
		contentPane.add(textFieldname);
		
		textFieldphone = new JTextField();
		textFieldphone.setColumns(10);
		textFieldphone.setBounds(84, 125, 259, 29);
		contentPane.add(textFieldphone);
		
		textFieldmoney = new JTextField();
		textFieldmoney.setColumns(10);
		textFieldmoney.setBounds(84, 164, 259, 29);
		contentPane.add(textFieldmoney);
		/**
		 * 查询
		 */
		btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector<String> infor=Operate.checkInfor(id);
				String[] array = infor.toArray(new String[infor.size()]);
				textFieldid.setText(array[0]);
				textFieldname.setText(array[1]);
				textFieldphone.setText(array[2]);
				textFieldmoney.setText(array[3]);
				textFieldpsd.setText(array[4]);
			}
		});
		btnNewButton.setBounds(243, 239, 103, 28);
		contentPane.add(btnNewButton);
		
		lblPsd = new JLabel("\u5BC6\u7801");
		lblPsd.setFont(new Font("宋体", Font.PLAIN, 25));
		lblPsd.setBounds(26, 203, 70, 29);
		contentPane.add(lblPsd);
		
		textFieldpsd = new JTextField();
		textFieldpsd.setColumns(10);
		textFieldpsd.setBounds(84, 203, 259, 29);
		contentPane.add(textFieldpsd);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("宋体", Font.PLAIN, 25));
		lblId.setBounds(26, 47, 70, 29);
		contentPane.add(lblId);
		
		lblPhone_1 = new JLabel("\u4F59\u989D");
		lblPhone_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblPhone_1.setBounds(26, 164, 70, 29);
		contentPane.add(lblPhone_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\55ee751a29522.jpg"));
		lblNewLabel.setBounds(0, 0, 398, 288);
		contentPane.add(lblNewLabel);
	}
	
	
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		YqueryFrame.id = id;
	}
}
