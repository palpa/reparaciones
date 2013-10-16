package com.apm.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name="CLIENTS")
public class Client {
	
	@Id
	@Column(name="CLIENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="CLIENT_NAME")
	private String name;
	
	@Column(name="CLIENT_SURNAME")
	private String surName;

	@Column(name="CLIENT_ADRESS")
	private String adress;	
	
	@Column(name="CLIENT_DNI")
	private String dni ;
	
	@Column(name="CLIENT_PHONE")
	private String phone;
	
	@Column(name="CLIENT_CEL")
	private String cel;
	
	@Column(name="CLIENT_EMAIL")
	private String email;
	
	public Client(){
		
	}


	public Client(String name, String surName, String adress, String dni, String phone, String cel, String email ) {		
		this.name = name;
		this.surName = surName;
		this.adress = adress;
		this.email = email;
		this.dni = dni;
		this.phone = phone;
		this.cel = cel;
				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adres) {
		this.adress = adres;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
