package cn.edu.jsu.jcl.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import cn.edu.jsu.jcl.dbc.Operate;

public class operateT {
	/**
	 * ���뵽�ı�
	 * @param id ID
	 */
	public static void Input(String id) {
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
	}
	
}	
