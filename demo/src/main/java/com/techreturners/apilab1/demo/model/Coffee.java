package com.techreturners.apilab1.demo.model;

public class Coffee {
	private long id;
	private String name;

	public Coffee(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

}
