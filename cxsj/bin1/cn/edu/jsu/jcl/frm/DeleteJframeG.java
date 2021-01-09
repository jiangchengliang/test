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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DeleteJframeG extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteJframeG frame = new DeleteJframeG();
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
	public DeleteJframeG() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u8981\u5220\u9664\u7528\u6237\u7684ID");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 22));
		lblNewLabel.setBounds(35, 21, 264, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(35, 69, 297, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		/**
		 * É¾³ý°´Å¥
		 */
		//É¾³ý°´Å¥
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID=textField.getText();
				Operate.delete(ID);
				JOptionPane.showMessageDialog(null, "É¾³ý²Ù×÷³É¹¦£¡");
			}
		});
		btnNewButton.setBounds(220, 162, 110, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\105c6ac2481327c.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_1);
	}

}
