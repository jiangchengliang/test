package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.jcl.dao.Exceloperate;
import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;
import cn.edu.jsu.jcl.dbc.Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class GprintFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GprintFrame frame = new GprintFrame();
					frame.setLocationRelativeTo(null);//�������
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
	public GprintFrame() {
		setTitle("\u6253\u5370\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * ��ӡ���ļ�
		 */
		//��ӡ���ļ�
				JButton btnNewButton_1 = new JButton("\u6253\u5370\u5230\u6587\u4EF6");
				btnNewButton_1.setForeground(Color.MAGENTA);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String id=textFieldid.getText();
						Vector<String> infor=Operate.checkInfor(id);
						String[] array = infor.toArray(new String[infor.size()]);
						String pathname = "E:/eclipse/cxsj/YongHu.txt";
						File file =new File(pathname);
						FileWriter fw;
						try {
							fw = new FileWriter(file,true);
							for(int i=0;i<array.length;i++)
								fw.write(array[i]+"\t");//д���ַ������س�����
								fw.write("\r\n");
								fw.close();//�ر������
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//�����ַ��ļ������Ϊ׷�ӷ�ʽ
						JOptionPane.showMessageDialog(null, "�����ı��ɹ���");

					}
				});
		btnNewButton_1.setBounds(317, 61, 119, 71);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165id");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(10, 10, 165, 56);
		contentPane.add(lblNewLabel_1);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(10, 61, 302, 71);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		/**
		 * ��ӡȫ�����ݵ�Excel
		 */
		JButton btnexcel_2 = new JButton("\u6253\u5370\u5168\u90E8\u6570\u636E\u5230Excel");
		btnexcel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Exceloperate.excelInputAll();
				JOptionPane.showMessageDialog(null, "����Excel�ɹ���");
			}
		});
		btnexcel_2.setForeground(Color.RED);
		btnexcel_2.setBounds(10, 171, 149, 71);
		contentPane.add(btnexcel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\105c6ac2481327c.jpg"));
		lblNewLabel.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel);
	}
}
