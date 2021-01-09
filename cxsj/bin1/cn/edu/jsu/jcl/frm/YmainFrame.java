package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.jcl.dao.operateT;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class YmainFrame extends JFrame {

	private JPanel contentPane;
	private static	String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YmainFrame frame = new YmainFrame(id);
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
	public YmainFrame(String id) {
		this.id=id;
		setTitle("\u94F6\u884C\u5B58\u53D6\u6B3E\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * 存款
		 */
		//存款
		JButton depositButton = new JButton("\u5B58\u6B3E");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				YdepositJframe framede = new YdepositJframe(id);
				framede.setLocationRelativeTo(null);//窗体居中
				framede.setVisible(true);
			}
		});
		depositButton.setBounds(287, 38, 121, 53);
		contentPane.add(depositButton);
		/**
		 * 取款
		 */
		//取款
		JButton drawButton = new JButton("\u53D6\u6B3E");
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YdrawJframe framedr = new YdrawJframe(id);
				framedr.setLocationRelativeTo(null);//窗体居中
				framedr.setVisible(true);
			}
		});
		drawButton.setBounds(287, 102, 121, 53);
		contentPane.add(drawButton);
		/**
		 * 查询
		 */
		//查询按钮
		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YqueryFrame f2=new YqueryFrame(id);
				f2.setLocationRelativeTo(null);
				f2.setVisible(true);
			}
		});
		queryButton.setBounds(10, 38, 121, 53);
		contentPane.add(queryButton);
		/**
		 * 打印
		 */
		//打印按钮
		JButton printButton = new JButton("\u6253\u5370");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operateT.Input(id);
				JOptionPane.showMessageDialog(null, "导入文本成功！");
			}
		});
		printButton.setBounds(10, 180, 121, 53);
		contentPane.add(printButton);
		/**
		 * 返回
		 */
		//返回按钮
		JButton existButton = new JButton("\u8FD4\u56DE");
		existButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginFrame f1=new LoginFrame();
				f1.setLocationRelativeTo(null);
				f1.setVisible(true);
			}
		});
		existButton.setBounds(287, 180, 121, 53);
		contentPane.add(existButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u64CD\u4F5C");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 99, 156, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\\u6444\u56FE\u7F51_500636268_\u9AD8\u6E05\u6D77\u6E7E\u5927\u6865\u5915\u9633\u5168\u666F\u56FE\u7247\u7D20\u6750\uFF08\u975E\u4F01\u4E1A\u5546\u7528\uFF09.jpg"));
		lblNewLabel_1.setBounds(-13, 0, 461, 274);
		contentPane.add(lblNewLabel_1);
	}

}
