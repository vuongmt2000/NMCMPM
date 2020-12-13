package model;

public class FormTable{
	private Integer ID;
	private String name;
	private String phone;
	private String room;
	private Integer deposit;
	private String reason;
	private Long sumPrice;
	
	public FormTable() {
	}

	public FormTable(FormInfo form) {
		this.ID = form.getId();
		this.name = form.getFullname();
		this.phone = form.getPhone();
		this.room = form.getRoom();
		this.deposit = form.getDeposit();
		this.reason = form.getReason();
		this.sumPrice = form.getSum_price();
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Long sumPrice) {
		this.sumPrice = sumPrice;
	}
}