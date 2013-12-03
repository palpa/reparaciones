package com.amp.domain;

import javax.validation.constraints.Size;

public class ClientDTO {
	
	private String id;

	@Size(min = 1)
	private String name;

	@Size(min = 1)
	private String surName;

	@Size(min = 1)
	private String adress;

	@Size(min = 7)
	private String dni;
	private String phone;
	private String cel;
	private String email;
	
	public ClientDTO(){
		name = "";
		surName = "";
		adress = "";
		dni = "";
		phone = "";
		cel = "";
		email = "";
	}

	public ClientDTO(String id, String name, String surName, String adress, String dni,
			String phone, String cel, String email) {
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.adress = adress;
		this.dni = dni;
		this.phone = phone;
		this.cel = cel;
		this.email = email;
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

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
