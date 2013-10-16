package com.amp.domain;
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
	
	@Size(min=1)
	@Column(name="CLIENT_NAME")
	private String name;
	
	@Size(min=1)
	@Column(name="CLIENT_SURNAME")
	private String surName;
	
	@Size(min=1)
	@Column(name="CLIENT_ADRESS")
	private String adress;	
	
	@Digits(integer=7,fraction=0)
	@Column(name="CLIENT_DNI")
	private int dni ;
	
	@Column(name="CLIENT_PHONE")
	private int phone;
	
	@Column(name="CLIENT_CEL")
	private int cel;
	
	@Column(name="CLIENT_EMAIL")
	private String email;	

	public Client() {
		this.id = -1;
		this.name = "";
	}

	public Client(int id, String name, String surName, String adress, int dni, int phone, int cel, String email ) {		
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.adress = adress;
		this.dni = dni;
		this.phone = phone;
		this.cel = cel;
		this.email = email;		
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCel() {
		return cel;
	}

	public void setCel(int cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
