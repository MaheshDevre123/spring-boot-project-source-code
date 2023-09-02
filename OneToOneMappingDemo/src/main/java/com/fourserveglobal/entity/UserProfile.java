package com.fourserveglobal.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "user_profile_table")
public class UserProfile {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String phonenumber;
    
     private String address;
     
    
		
		/*
		 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
		 * "userProfile") private User user;
		 */
     
		public UserProfile(String phonenumber, String address) {
		super();
		this.phonenumber = phonenumber;
		this.address = address;
		
	}

	public UserProfile() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
     
     
}
