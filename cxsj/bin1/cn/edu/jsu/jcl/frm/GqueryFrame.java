package cn.edu.jsu.jcl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.jcl.dao.PageController;
import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;
import cn.edu.jsu.jcl.dbc.Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowSorter;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GqueryFrame extends JFrame {

	private JTable table;// ������
	private JTextField txtKey;// ������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;// ����������
	private ArrayList<RowSorter.SortKey> sortKeys;// �����������

	private Vector<String> titles;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YqueryFrame frame = new YqueryFrame(id);
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
	public GqueryFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * ��ѯ
		 */
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "�˺�", "����", "�Ա�", "����");
		Vector<Vector> stuInfo = new PageController().getPaegData();// ��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {// ��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		table.setAutoCreateRowSorter(true);
		;// ���ñ���Զ�����

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ

		JLabel lblKey = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
		lblKey.setBounds(22, 21, 95, 15);
		contentPane.add(lblKey);

		txtKey = new JTextField();
		txtKey.setBounds(117, 18, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		// ������Ұ�ť
		JButton btnFind = new JButton("����");
		String sql1="select *from Athlete ";
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtKey.getText().trim();// ��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					String sql="select * from Athlete where id="+key;
					model=new DefaultTableModel(new UserMatch().Find(sql),titles);//��������ģ��
					table.setModel(model);											
				}else {
					model=new DefaultTableModel(new UserMatch().getSelectAll(sql1),titles);//��������ģ��
					table.setModel(model);
				}

			}
		});
		btnFind.setBounds(246, 16, 95, 25);
		contentPane.add(btnFind);

		JButton btnPre = new JButton("��һҳ");
		btnPre.addActionListener(new ActionListener() {// ��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().prePage(), titles);// ��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);// ���ñ�������ģ��

			}
		});
		btnPre.setBounds(44, 302, 95, 25);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("��һҳ");
		btnNext.addActionListener(new ActionListener() {// ��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().nextPage(), titles);// ��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);// ���ñ�������ģ��
			}
		});
		btnNext.setBounds(149, 302, 95, 25);
		contentPane.add(btnNext);

		JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
		lblMsg.setBounds(254, 307, 87, 15);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] { 3, 5, 10, 15, 20 });
		comboBox.addItemListener(new ItemListener() {// ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize = Integer.valueOf(comboBox.getSelectedItem().toString());// ��ȡ��������ѡ��ֵ
				PageController pcl = new PageController();
				pcl.setCountPerpage(pageSize);// ����ÿҳ��ʾ��¼����
				model = new DefaultTableModel(pcl.getPaegData(), titles);// ��������ģ��
				table.setModel(model);// ���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);// ����������Ĭ��ֵ
		comboBox.setBounds(318, 303, 55, 23);
		contentPane.add(comboBox);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\942.jpg"));
		lblNewLabel_1.setBounds(0, 0, 456, 302);
		contentPane.add(lblNewLabel_1);
	}
	
	
	
}
