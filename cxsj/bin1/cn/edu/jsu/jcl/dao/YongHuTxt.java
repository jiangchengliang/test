package cn.edu.jsu.jcl.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import cn.edu.jsu.jcl.vo.YongHu;


public class YongHuTxt {
	public void exportTxt(List<YongHu> listyonghu) {
		File file = new File("E:/eclipse/cxsj/YongHu.txt");// 定位要操作的excel文件
		try(FileWriter fos = new FileWriter(file);
				BufferedWriter bw=new BufferedWriter(fos)) {
			int i=0;
			for(YongHu scj:listyonghu) {
				bw.write(scj.toString());
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}
