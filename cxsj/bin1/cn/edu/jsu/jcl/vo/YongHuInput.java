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
 * @author 蒋承良
 *
 */
public class YongHuInput {
	
	private static final String StringBuilder = null;
	//定义姓氏
	private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
	//定义女生的名
	private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	//定义男生的名
    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    
    public static void main(String[] args) {
    	addPlayer();
    	System.out.println("OK");
    }
    
    public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
    public static float getNum(float start,float end) {
    	return (float)(Math.random()*(end-start+1)+start);
    }
    /**
     * 
     * @return	pno1 账号
     */
    //随机返回账号
    public static StringBuilder getId() {//不使用String，因为需要大量拼接字符串
    	StringBuilder Pno1=new StringBuilder(String.valueOf(getNum(1,99999)));//随机取后4位
    	if(Pno1.length()==1) {
    		Pno1=Pno1.insert(0, "0000");//如果是1位数，前面增加3个0
    		//Pno=Pno.append(Pno1);//前6位与后3位拼接成学号
    	}else if(Pno1.length()==2) {
    		Pno1=Pno1.insert(0, "000");//如果是2位数，前面增加3个0
    		//Pno=Pno.append(Pno1);
    	}else if(Pno1.length()==3) {
    		Pno1=Pno1.insert(0, "00");//如果是3位数，前面增加2个0
    		//Pno=Pno.append(Pno1);
    	}else if(Pno1.length()==4) {
    		Pno1=Pno1.insert(0, "0");//如果是4位数，前面增加1个0
    		//Pno=Pno.append(Pno1);
    	}
    	return Pno1;
    }
    /**
     * 
     * @return name 姓名
     */
    //随机返回中文姓名 
    public static String getName() {
        int index=getNum(0, firstName.length()-1);//随机取姓氏字符串中的任意位置
        String first=firstName.substring(index, index+1);//获取该位置的姓氏
        int sex=getNum(0,1);//随机取性别，例如1为男生，0为女生
        String str=boy;//定义名字为男生字符串
        int length=boy.length();//获取男生字符串的长度
        if(sex==0){//如果随机获取为0，则名字改为女生
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//随机获取名字的位置
        String second=str.substring(index, index+1);//获取该位置中的名字
        int hasThird=getNum(0,1);//随机获取名字是否有第三个字
        String third="";//默认没有第三个字
        if(hasThird==1){//如果随机获取为1，则有第三个字
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//返回姓名
    }
    /**
     * 
     * @return phone 电话
     */
    //随机获得电话
    public static StringBuilder getPhone() {
        	StringBuilder phone=new StringBuilder("138");//电话号前3位相同
        	StringBuilder phone1=new StringBuilder(String.valueOf(getNum(1,99999999)));//随机取后8位
        	if(phone1.length()==1) {
        		phone1=phone1.insert(0, "0000000");//如果是1位数，前面增加7个0
        		phone=phone.append(phone1);//前6位与后3位拼接成学号
        	}else if(phone1.length()==2) {
        		phone1=phone1.insert(0, "000000");//如果是2位数，前面增加6个0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==3) {
        		phone1=phone1.insert(0, "00000");//如果是3位数，前面增加5个0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==4) {
        		phone1=phone1.insert(0, "0000");//如果是4位数，前面增加4个0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==5) {
        		phone1=phone1.insert(0, "000");//如果是5位数，前面增加3个0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==6) {
        		phone1=phone1.insert(0, "00");//如果是6位数，前面增加2个0
        		phone=phone.append(phone1);
        	}else if(phone1.length()==7) {
        		phone1=phone1.insert(0, "0");//如果是7位数，前面增加1个0
        		phone=phone.append(phone1);
        	}else {
        		phone=phone.append(phone1);
        	}
        	return phone;
        }
	/**
	 * 
	 * @return	money 金额
	 */
	//随机获得金额
    public static int getMoney(){
    	int money=getNum(0, 99999);
    	return money;
    }
    /**
     * 
     * @return psd 密码
     */
    //随机获得密码
    public static StringBuilder getPsd(){
    	StringBuilder phone=new StringBuilder("jcl");//密码前3位相同
    	StringBuilder phone1=new StringBuilder(String.valueOf(getNum(1,99999999)));//随机取后8位
    	if(phone1.length()==1) {
    		phone1=phone1.insert(0, "0000000");//如果是1位数，前面增加7个0
    		phone=phone.append(phone1);//前6位与后3位拼接成学号
    	}else if(phone1.length()==2) {
    		phone1=phone1.insert(0, "000000");//如果是2位数，前面增加6个0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==3) {
    		phone1=phone1.insert(0, "00000");//如果是3位数，前面增加5个0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==4) {
    		phone1=phone1.insert(0, "0000");//如果是4位数，前面增加4个0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==5) {
    		phone1=phone1.insert(0, "000");//如果是5位数，前面增加3个0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==6) {
    		phone1=phone1.insert(0, "00");//如果是6位数，前面增加2个0
    		phone=phone.append(phone1);
    	}else if(phone1.length()==7) {
    		phone1=phone1.insert(0, "0");//如果是7位数，前面增加1个0
    		phone=phone.append(phone1);
    	}else {
    		phone=phone.append(phone1);
    	}
    	return phone;
    	
    }
    /**
     * 
     * @param sql sql语句
     * @return	查询得到的数据集合
     */
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段学号
    			row.add(rs.getString(2));//获取第二个字段姓名
    			row.add(rs.getString(3));//获取第三个字段电话
    			row.add(rs.getInt(4));//获取第四个字段金额
    			row.add(rs.getString(5));//获取第五个字段密码
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
    }
   /**
    * 增加数据
    */
    public static void addPlayer() {//增加成绩
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	String sql="insert into textY(id,name,money,phone,psd) values(?,?,?,?,?)";//使用占位符定义插入语句
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//定义集合
    		for(int i=0;i<=9999;) {
    			String id=getId().toString();//随机获取学号
    			if(!alist.contains(id)) {//判断学号是否唯一
    				alist.add(id);//将学号加入集合
    				String name=getName();//随机获取姓名
    				Integer money=getMoney();//随机获取成绩
    				String phone=getPhone().toString();
    				String psd=getPsd().toString();
    				pstmt.setString(1, id);//定义第1个占位符的内容
    	    		pstmt.setString(2, name);//定义第2个占位符的内容
    	    		pstmt.setInt(3, money);//定义第3个占位符的内容
    	    		pstmt.setString(4, phone);//定义第4个占位符的内容
    	    		pstmt.setString(5, psd);//定义第5个占位符的内容
    	    		pstmt.addBatch();//加入批处理等待执行
    				i++;//学号唯一，循环继续往下执行
    			}
    		}
    		pstmt.executeBatch();//批量执行插入操作
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    

}