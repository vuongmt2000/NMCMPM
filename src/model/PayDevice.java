package model;

import utils.Format;

public class PayDevice{
	private String device;
	private Integer quantity;
	private String price;
	
	public PayDevice() {
	}

	public PayDevice(String device, Integer quantity, String price) {
		this.device = device;
		this.quantity = quantity;
		this.price = price;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = Format.formatMoney(price);
	}
}
