package cn.edu.jsu.jcl.vo;

import java.io.Serializable;

public class YongHu implements Serializable {
	/**
ID
姓名
密码
客户电话
金额
	 */
	private String id;
	private String name;
	private Integer phone;
	private Integer money;
	private String psd;
	public YongHu() {
	}
	public YongHu(String id, String name, Integer phone,Integer money,String psd) {
		this.id = id;
		this.name = name;
		this.psd = psd;
		this.phone = phone;
		this.money = money;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return id+'\t'+name+'\t'+phone+'\t'+money+'\t'+psd+'\t'+"\r\n";
	}
}
