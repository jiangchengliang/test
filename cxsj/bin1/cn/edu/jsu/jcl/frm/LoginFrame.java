package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;
import cn.edu.jsu.jcl.dbc.Operate;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame {
	private JPanel contentPane;
	private JTextField loginIdTextField;
	private JPasswordField loginCodeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 285);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(28, 49, 69, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(SystemColor.menu);
		lblNewLabel_1.setBounds(28, 108, 69, 21);
		contentPane.add(lblNewLabel_1);
		
		/**
		 * 注册
		 */
		JButton register = new JButton("\u6CE8\u518C");
		register.setForeground(Color.BLACK);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterJframe rjframe=new RegisterJframe();
				rjframe.setLocationRelativeTo(null);//窗体居中
				rjframe.setVisible(true); 
			}
		});
		register.setBounds(42, 191, 93, 35);
		contentPane.add(register);
		JButton loginButton = new JButton("\u767B\u5165");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID=loginIdTextField.getText();
                String psd=loginCodeTextField.getText();
              //判断输入的密码是否正确
                if(ID.compareTo("2019401416")==0&& psd.compareTo("jcl2019401416")==0) {//管理员账号
                	dispose();
                	GmainFrame mainFG= new GmainFrame();
                	mainFG.setLocationRelativeTo(null);//窗体居中
                	 mainFG.setVisible(true);
                }
                else if(Operate.checkZhangHaoBiao(ID, psd)) {//注册的账号
                	dispose();
                    JOptionPane.showMessageDialog(null,  "登陆成功！");
                    YmainFrame mainF=new YmainFrame(ID);
                    mainF.setLocationRelativeTo(null);//窗体居中
                    mainF.setVisible(true);
                 }
                else {
                    JOptionPane.showMessageDialog(null, "账户或密码错误");
                }
			}
		});
		loginButton.setForeground(Color.BLACK);
		loginButton.setBounds(227, 191, 93, 35);
		contentPane.add(loginButton);
		
		loginIdTextField = new JTextField();
		loginIdTextField.setBounds(107, 49, 213, 21);
		contentPane.add(loginIdTextField);
		loginIdTextField.setColumns(10);
		
		JLabel idlbl = new JLabel("");
		idlbl.setForeground(Color.RED);
		idlbl.setBounds(359, 49, 58, 15);
		contentPane.add(idlbl);
		
		loginCodeTextField = new JPasswordField();
		loginCodeTextField.setBounds(107, 108, 213, 21);
		contentPane.add(loginCodeTextField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\c3cd216ff14271bc6925b31299bd7795.gif"));
		lblNewLabel_2.setBounds(0, 0, 461, 248);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
