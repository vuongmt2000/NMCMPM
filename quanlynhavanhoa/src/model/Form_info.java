package model;

import java.util.Date;

public class Form_info {
	private Integer id;
	private String fullname;
	private String adress;
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
	
	public Form_info() {
	}

	public Form_info(Integer id, String fullname, String adress, String credit_card, Date birthday, String gender,
			String resident, String reason, Integer deposit, Integer status, Integer status_pay,
			Date date_of_allocation, String nation, String religion, String address_of_allocation, String phone,
			String permanent_address, Long sum_price) {
		this.id = id;
		this.fullname = fullname;
		this.adress = adress;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
}
