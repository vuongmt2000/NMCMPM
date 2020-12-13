package model;

public class Room_Device {
	private Integer room_id;
	private Integer device_id;
	private Integer quantity;
	private Integer broken_quantity;
	
	public Room_Device() {
	}

	public Room_Device(Integer room_id, Integer device_id, Integer quantity, Integer broken_quantity) {
		this.room_id = room_id;
		this.device_id = device_id;
		this.quantity = quantity;
		this.broken_quantity = broken_quantity;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public Integer getDevice_id() {
		return device_id;
	}

	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getBroken_quantity() {
		return broken_quantity;
	}

	public void setBroken_quantity(Integer broken_quantity) {
		this.broken_quantity = broken_quantity;
	}
	
}
