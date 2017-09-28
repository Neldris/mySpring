package com.amisti.pojo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pop implements Serializable{
	
	private String name;
	private static Pop instance;
	
	public static Pop getInstance(){
		if(instance == null){
			instance = new Pop();
		}
		return instance;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Pop(){userMoster = new ArrayList<>();}
	private static final long serialVersionUID = 1L;
	List<User> userMoster;

	public List<User> getUserMoster() {
		return userMoster;
	}

	public void setUserMoster(List<User> userMoster) {
		this.userMoster.addAll(userMoster);
	}
	

}
