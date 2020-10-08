package com.zuul.apigayway.zullapigatway.model;

public class Vendors {
	private long id;

	private String name;

	private String item;
	private int price;

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