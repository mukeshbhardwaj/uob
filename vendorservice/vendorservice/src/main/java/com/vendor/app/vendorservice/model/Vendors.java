package com.vendor.app.vendorservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "food_item")
	private String item;
	@Column(name = "price")
	private int price;
//	@Column(name = "account_no")
//	private long accountNo;
//	@Column(name = "balance")
//	private double balance;
 
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}

	public Vendors() {
	}

	public Vendors(long id, String name, String item, int price) {
	super();
	this.id = id;
	this.name = name;
	this.item = item;
	this.price = price;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vendors [id=" + id + ", name=" + name + ", item=" + item + ", price=" + price + "]";
	}

	
}