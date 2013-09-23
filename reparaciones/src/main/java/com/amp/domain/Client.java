package com.amp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLIENT_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	public Client() {
		this.id = -1;
		this.name = "";
	}

	public Client(int id, String name) {
		this.id = id;
		this.name = name;
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

}
