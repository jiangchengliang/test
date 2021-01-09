package cn.edu.jsu.jcl.vo;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class guanLiYuan implements Serializable {
	/**
id
Name
typle
Money
People
Time
	 */
	private String id;
	private String name;
	private String typle;
	private Integer phone;
	private Integer money;
	private String People;
	private Data time;
	public guanLiYuan() {
	}
	public guanLiYuan(String id, String name, String typle, Integer phone,Integer money,String People,Data time) {
		this.id = id;
		this.name = name;
		this.typle = typle;
		this.phone = phone;
		this.money = money;
		this.People = People;
		this.time = time;
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
	public String getTyple() {
		return typle;
	}
	public void setTyple(String typle) {
		this.typle = typle;
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
	public String getPeople() {
		return People;
	}
	public void setPeople(String people) {
		People = people;
	}
	public Data getTime() {
		return time;
	}
	public void setTime(Data time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return id+'\t'+name+'\t'+typle+'\t'+phone+'\t'+money+'\t'+People+'\t'+time+'\t';
	}
}
