package model;

import java.util.Date;

public class FormInfo {
	private Integer id;
	private String fullname;
	private String address;
	private String credit_card;
	private Date birthday;
	private String gender;
	private String resident;
	private String reason;
	private Integer deposit;
	private Integer status;
	private Integer status_pay;
	private Date date_of_allocation;
	private String nation;
	private String religion;
	private String address_of_allocation;
	private String phone;
	private String permanent_address;
	private Long sum_price;
	private Integer chair;
	private Integer table;
	private Integer speaker;
	private Integer radio;
	private Integer projector;
	private String room;
	
	public FormInfo() {
	}

	public FormInfo(Integer id, String fullname, String address, String credit_card, Date birthday, String gender,
					String resident, String reason, Integer deposit, Integer status, Integer status_pay,
					Date date_of_allocation, String nation, String religion, String address_of_allocation, String phone,
					String permanent_address, Long sum_price) {
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.credit_card = credit_card;
		this.birthday = birthday;
		this.gender = gender;
		this.resident = resident;
		this.reason = reason;
		this.deposit = deposit;
		this.status = status;
		this.status_pay = status_pay;
		this.date_of_allocation = date_of_allocation;
		this.nation = nation;
		this.religion = religion;
		this.address_of_allocation = address_of_allocation;
		this.phone = phone;
		this.permanent_address = permanent_address;
		this.sum_price = sum_price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus_pay() {
		return status_pay;
	}

	public void setStatus_pay(Integer status_pay) {
		this.status_pay = status_pay;
	}

	public Date getDate_of_allocation() {
		return date_of_allocation;
	}

	public void setDate_of_allocation(Date date_of_allocation) {
		this.date_of_allocation = date_of_allocation;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getAddress_of_allocation() {
		return address_of_allocation;
	}

	public void setAddress_of_allocation(String address_of_allocation) {
		this.address_of_allocation = address_of_allocation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public Long getSum_price() {
		return sum_price;
	}

	public void setSum_price(Long sum_price) {
		this.sum_price = sum_price;
	}

	public Integer getChair() {
		return chair;
	}

	public void setChair(Integer chair) {
		this.chair = chair;
	}

	public Integer getTable() {
		return table;
	}

	public void setTable(Integer table) {
		this.table = table;
	}

	public Integer getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Integer speaker) {
		this.speaker = speaker;
	}

	public Integer getRadio() {
		return radio;
	}

	public void setRadio(Integer radio) {
		this.radio = radio;
	}

	public Integer getProjector() {
		return projector;
	}

	public void setProjector(Integer projector) {
		this.projector = projector;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
        
        public Integer getQuantity(int i) {
		switch (i) {
		case 0: return getTable();
		case 1: return getChair();
		case 2: return getSpeaker();
		case 3: return getProjector();
		case 4: return getRadio();
		default: return 0;
		}
	}
}
