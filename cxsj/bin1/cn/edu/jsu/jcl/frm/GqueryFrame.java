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

	private JTable table;// 定义表格
	private JTextField txtKey;// 定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;// 定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;// 设置排序规则

	private Vector<String> titles;
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
	public GqueryFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * 查询
		 */
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "账号", "姓名", "性别", "年龄");
		Vector<Vector> stuInfo = new PageController().getPaegData();// 获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {// 获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		table.setAutoCreateRowSorter(true);
		;// 设置表格自动排序

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示

		JLabel lblKey = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
		lblKey.setBounds(22, 21, 95, 15);
		contentPane.add(lblKey);

		txtKey = new JTextField();
		txtKey.setBounds(117, 18, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		// 定义查找按钮
		JButton btnFind = new JButton("查找");
		String sql1="select *from Athlete ";
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtKey.getText().trim();// 获取输入关键字文本框的值
				if(key.length()!=0) {
					String sql="select * from Athlete where id="+key;
					model=new DefaultTableModel(new UserMatch().Find(sql),titles);//设置数据模型
					table.setModel(model);											
				}else {
					model=new DefaultTableModel(new UserMatch().getSelectAll(sql1),titles);//设置数据模型
					table.setModel(model);
				}

			}
		});
		btnFind.setBounds(246, 16, 95, 25);
		contentPane.add(btnFind);

		JButton btnPre = new JButton("上一页");
		btnPre.addActionListener(new ActionListener() {// 上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().prePage(), titles);// 设置数据模型中的数据为上一页内容
				table.setModel(model);// 设置表格的数据模型

			}
		});
		btnPre.setBounds(44, 302, 95, 25);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("下一页");
		btnNext.addActionListener(new ActionListener() {// 下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().nextPage(), titles);// 设置数据模型中的数据为下一页内容
				table.setModel(model);// 设置表格的数据模型
			}
		});
		btnNext.setBounds(149, 302, 95, 25);
		contentPane.add(btnNext);

		JLabel lblMsg = new JLabel("每页显示：");
		lblMsg.setBounds(254, 307, 87, 15);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] { 3, 5, 10, 15, 20 });
		comboBox.addItemListener(new ItemListener() {// 页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize = Integer.valueOf(comboBox.getSelectedItem().toString());// 获取下拉框所选的值
				PageController pcl = new PageController();
				pcl.setCountPerpage(pageSize);// 设置每页显示记录条数
				model = new DefaultTableModel(pcl.getPaegData(), titles);// 设置数据模型
				table.setModel(model);// 设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);// 设置下拉框默认值
		comboBox.setBounds(318, 303, 55, 23);
		contentPane.add(comboBox);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\eclipse\\cxsj\\photo\\942.jpg"));
		lblNewLabel_1.setBounds(0, 0, 456, 302);
		contentPane.add(lblNewLabel_1);
	}
	
	
	
}
