package cn.edu.jsu.jcl.vo;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import cn.edu.jsu.jcl.dbc.DatabaseConnectionSql;
/**
 * 
 * @author ������
 *
 */
public class YongHuInput {
	
	private static final String StringBuilder = null;
	//��������
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    
    public static void main(String[] args) {
    	addPlayer();
    	System.out.println("OK");
    }
    
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    public static float getNum(float start,float end) {
    	return (float)(Math.random()*(end-start+1)+start);
    }
    /**
     * 
     * @return	pno1 �˺�
     */
    //��������˺�
    public static StringBuilder getId() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder Pno1=new StringBuilder(String.valueOf(getNum(1,99999)));//���ȡ��4λ
    	if(Pno1.length()==1) {
    		Pno1=Pno1.insert(0, "0000");//�����1λ����ǰ������3��0
    		//Pno=Pno.append(Pno1);//ǰ6λ���3λƴ�ӳ�ѧ��
    	}else if(Pno1.length()==2) {
    		Pno1=Pno1.insert(0, "000");//�����2λ����ǰ������3��0
    		//Pno=Pno.append(Pno1);
    	}else if(Pno1.length()==3) {
    		Pno1=Pno1.insert(0, "00");//�����3λ����ǰ������2��0
    		//Pno=Pno.append(Pno1);
    	}else if(Pno1.length()==4) {
    		Pno1=Pno1.insert(0, "0");//�����4λ����ǰ������1��0
    		//Pno=Pno.append(Pno1);
    	}
    	return Pno1;
    }
    /**
     * 
     * @return name ����
     */
    //��������������� 
    public static String getName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    /**
     * 
     * @return phone �绰
     */
    //�����õ绰
    public static StringBuilder getPhone() {
        	StringBuilder phone=new StringBuilder("138");//�绰��ǰ3λ��ͬ
        	StringBuilder phone1=new StringBuilder(String.valueOf(getNum(1,99999999)));//���ȡ��8λ
        	if(phone1.length()==1) {
        		phone1=phone1.insert(0, "0000000");//�����1λ����ǰ������7��0
        		phone=phone.append(phone1);//ǰ6λ���3λƴ�ӳ�ѧ��
        	}else if(phone1.length()==2) {
        		phone1=phone1.insert(0, "000000");//�����2λ����ǰ������6��0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==3) {
        		phone1=phone1.insert(0, "00000");//�����3λ����ǰ������5��0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==4) {
        		phone1=phone1.insert(0, "0000");//�����4λ����ǰ������4��0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==5) {
        		phone1=phone1.insert(0, "000");//�����5λ����ǰ������3��0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==6) {
        		phone1=phone1.insert(0, "00");//�����6λ����ǰ������2��0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==7) {
        		phone1=phone1.insert(0, "0");//�����7λ����ǰ������1��0
        		phone=phone.append(phone1);
        	}else {
        		phone=phone.append(phone1);
        	}
        	return phone;
        }
	/**
	 * 
	 * @return	money ���
	 */
	//�����ý��
    public static int getMoney(){
    	int money=getNum(0, 99999);
    	return money;
    }
    /**
     * 
     * @return psd ����
     */
    //����������
    public static StringBuilder getPsd(){
    	StringBuilder phone=new StringBuilder("jcl");//����ǰ3λ��ͬ
    	StringBuilder phone1=new StringBuilder(String.valueOf(getNum(1,99999999)));//���ȡ��8λ
    	if(phone1.length()==1) {
    		phone1=phone1.insert(0, "0000000");//�����1λ����ǰ������7��0
    		phone=phone.append(phone1);//ǰ6λ���3λƴ�ӳ�ѧ��
    	}else if(phone1.length()==2) {
    		phone1=phone1.insert(0, "000000");//�����2λ����ǰ������6��0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==3) {
    		phone1=phone1.insert(0, "00000");//�����3λ����ǰ������5��0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==4) {
    		phone1=phone1.insert(0, "0000");//�����4λ����ǰ������4��0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==5) {
    		phone1=phone1.insert(0, "000");//�����5λ����ǰ������3��0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==6) {
    		phone1=phone1.insert(0, "00");//�����6λ����ǰ������2��0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==7) {
    		phone1=phone1.insert(0, "0");//�����7λ����ǰ������1��0
    		phone=phone.append(phone1);
    	}else {
    		phone=phone.append(phone1);
    	}
    	return phone;
    	
    }
    /**
     * 
     * @param sql sql���
     * @return	��ѯ�õ������ݼ���
     */
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
    			row.add(rs.getString(3));//��ȡ�������ֶε绰
    			row.add(rs.getInt(4));//��ȡ���ĸ��ֶν��
    			row.add(rs.getString(5));//��ȡ������ֶ�����
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
   /**
    * ��������
    */
    public static void addPlayer() {//���ӳɼ�
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="insert into textY(id,name,money,phone,psd) values(?,?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    		for(int i=0;i<=9999;) {
    			String id=getId().toString();//�����ȡѧ��
    			if(!alist.contains(id)) {//�ж�ѧ���Ƿ�Ψһ
    				alist.add(id);//��ѧ�ż��뼯��
    				String name=getName();//�����ȡ����
    				Integer money=getMoney();//�����ȡ�ɼ�
    				String phone=getPhone().toString();
    				String psd=getPsd().toString();
    				pstmt.setString(1, id);//�����1��ռλ��������
    	    		pstmt.setString(2, name);//�����2��ռλ��������
    	    		pstmt.setInt(3, money);//�����3��ռλ��������
    	    		pstmt.setString(4, phone);//�����4��ռλ��������
    	    		pstmt.setString(5, psd);//�����5��ռλ��������
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//ѧ��Ψһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    

}