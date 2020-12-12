package model;

public class Room {
	private Integer id;
	private Integer number_floor;
	private Integer floor;
	private Integer status;
	private Long price;
	
	public Room() {
	}

	public Room(Integer id, Integer number_floor, Integer floor, Integer status, Long price) {
		this.id = id;
		this.number_floor = number_floor;
		this.floor = floor;
		this.status = status;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber_floor() {
		return number_floor;
	}

	public void setNumber_floor(Integer number_floor) {
		this.number_floor = number_floor;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
}
