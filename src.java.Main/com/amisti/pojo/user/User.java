package com.amisti.pojo.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonFormat;


@XmlRootElement
public class User implements Serializable{

	private static final long serialVersionUID = 5382422565146341382L;
	
	private int age;
	private String fullName;
	private Date date;
	
	public User(int age, String fullName, Date date) {
		this.age = age;
		this.fullName = fullName;
		this.date = date;
	}

	public User(){}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}


